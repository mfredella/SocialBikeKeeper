package sbk.unisannio.com.socialbikekeeper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

public class SfidaActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mPreviousLocation = null;
    Location mLastLocation;
    GeoCor gc;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    private float Km_percorsi=0;
    private float speed;
    private static float CONV=(float) 3.6;
    private static float G= (float)9.81;
    private static float A= (float)0.01;
    private static float K= (float)0.021;
    private static float P= (float)65.0;
    private static float H= (float)1.0;
    private float potenza;
    private double kcal;
    TextView KM_value;
    TextView calorie_value;
    DecimalFormat df;
    TextView timerValue;
    private LatLng STARTING_POINT;
    private String latitudine;
    private String longitudine;

    double latitude;
    double longitude;
    String sfidante, sfidato;
    int statosfida;
    int durata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfida);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapChallenge);
        mapFragment.getMapAsync(this);
    }

    public void setUpSfidaActivity(){
        Invia getDurata=new Invia("http://socialbikeeper.altervista.org/getchallengeduration.php?sfidante="+Sfida.getSfidante()+"&sfidato="+Sfida.getSfidato());
        String d = getDurata.doInBackground();

        Long.parseLong(d.split("\\\n")[0]);

        timerValue = (TextView) findViewById(R.id.timerValue);

        new CountDownTimer((1*60)*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerValue.setText(formatTime(millisUntilFinished));
            }
            public void onFinish() {
                /*
                * Appena il cronometro va a zero:
                *   la textview diventa visibile
                *   cambia lo stato della sfida nella rispettiva tabella del database
                * */

                timerValue.setText("Sfida completata!");

                KM_value.setVisibility(View.INVISIBLE);
                calorie_value.setVisibility(View.INVISIBLE);
                Invia aa =new Invia("http://socialbikeeper.altervista.org/getmychallenge.php?email="+TrainingActivity.getEmail());
                String ris=aa.doInBackground();
                if(!ris.contains("inesistente")){
                    String sfida=ris.split("\\\n")[0];
                    String []mysfida= sfida.split("\\*");
                    sfidante=mysfida[1];
                    sfidato=mysfida[2];
                    statosfida=Integer.parseInt(mysfida[4]);
                    durata= Integer.parseInt(mysfida[3]);

                    if(String.valueOf(kcal).equals("NaN"))
                        kcal=0.000000;

                    if(statosfida==5){
                        if((TrainingActivity.getEmail()).equals(sfidante)){

                            Invia cr = new Invia("http://socialbikeeper.altervista.org/updatechallengeresult.php?sfidante="+sfidante+"&sfidato="+sfidato+"&km="+String.valueOf(Km_percorsi)+"&flag=0");
                            cr.doInBackground();
                            Invia sfidafinita = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+Sfida.getSfidante()+"&sfidato="+Sfida.getSfidato()+"&stato="+4);
                            sfidafinita.doInBackground();
                        }
                        else {

                            Invia cr = new Invia("http://socialbikeeper.altervista.org/updatechallengeresult.php?sfidante="+sfidante+"&sfidato="+sfidato+"&km="+String.valueOf(Km_percorsi)+"&flag=1");
                            cr.doInBackground();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Attendi il risultato...", Toast.LENGTH_LONG).show();
                        Intent toTraining = new Intent(getApplicationContext(), TrainingActivity.class);
                        startActivity(toTraining);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Il tuo sfidante si è ritirato!", Toast.LENGTH_LONG).show();
                }
            }
        }.start();
    }

    public String formatTime(long millis) {
        String output = "00:00";
        long seconds = millis / 1000;
        long minutes = seconds / 60;

        seconds = seconds % 60;
        minutes = minutes % 60;

        String sec = String.valueOf(seconds);
        String min = String.valueOf(minutes);

        if (seconds < 10)
            sec = "0" + seconds;
        if (minutes < 10)
            min= "0" + minutes;

        output = min + " : " + sec;
        return output;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        setUpSfidaActivity();
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
        Location startingPoint = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        STARTING_POINT=new LatLng(startingPoint.getLatitude(), startingPoint.getLongitude());
        latitudine= ""+startingPoint.getLatitude();
        longitudine=""+startingPoint.getLongitude();
        Toast.makeText(getApplicationContext(),"SfidaActivity onConnected: "+latitudine+" "+longitudine,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    public GeoCor currentLocation(double lat,double log) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + STARTING_POINT.latitude+","+STARTING_POINT.longitude+ "&destinations="  + lat+ ","+ log  + "&mode=driving&language=fr-FR&avoid=tolls&key=AIzaSyBN3Oxw-68go2aaDGMRTKNZphbyjaup21A";
        gc=new GeoCor("","");
        AsyncTask<String,Void,String> cd=gc.execute(url);
        try {
            String result =cd.get();
            Log.d("result", result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return gc;
    }

    @Override
    public void onLocationChanged(Location location) {
        if(mPreviousLocation == null)
            mPreviousLocation = location;

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mCurrLocationMarker = mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()),16));

        latitude=location.getLatitude();
        longitude=location.getLongitude();
        GeoCor geoCore= currentLocation(latitude,longitude);

        String a =geoCore.getValue1();
        String b=geoCore.getValue2();

        df = new DecimalFormat("###.##");
        df.setRoundingMode(RoundingMode.DOWN);

        KM_value=(TextView) findViewById(R.id.KM_value);
        calorie_value=(TextView) findViewById(R.id.calorie_value);
        float min=Float.parseFloat(a)/60;
        float dist=Float.parseFloat(b)/1000;
        Km_percorsi+=dist;
        speed= (Float.parseFloat(b)/Float.parseFloat(a))*CONV;
        potenza=(P*(H+A) + K*speed*speed) * speed * G;
        kcal = (potenza*min/1000) / 1.11631;
        calorie_value.setText("" + df.format(kcal));
        KM_value.setText(" " + df.format(Km_percorsi));

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }


    @Override
    public void onResume() {
        super.onResume();

        Intent toService = new Intent(this, ChallengeService.class);
        startService(toService);
    }
}