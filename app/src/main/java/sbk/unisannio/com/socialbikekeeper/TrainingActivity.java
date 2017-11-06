package sbk.unisannio.com.socialbikekeeper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import com.google.android.gms.location.LocationListener;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
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

public class TrainingActivity extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    /*variabili d'istanza relative a mappa e posizione*/
    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mPreviousLocation = null;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    GeoCor gc;
    private LatLng STARTING_POINT;
    private LatLng MOVING_POINT;
    private String latitudine;
    private String longitudine;

    Button start, stop,pause;

    /*variabili relative al calcolo di calorie bruciate e chilometri percorsi*/
    TextView KM_value, calorie_value, timerValue;
    DecimalFormat df;
    String time, distance;
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
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    private static String emailLog;
    private boolean pausa = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        emailLog=getIntent().getStringExtra("email");

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.training_map);
        mapFragment.getMapAsync(this);

        KM_value=(TextView) findViewById(R.id.KM_value);
        calorie_value=(TextView) findViewById(R.id.calorie_value);
        timerValue = (TextView) findViewById(R.id.timerValue);

        calorie_value.setVisibility(View.INVISIBLE);
        KM_value.setVisibility(View.INVISIBLE);
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

    /*
    * Metodo che restituisce l'email dell'utente loggato
    */
    public static String getEmail() {
        return emailLog;
    }

    /**
     * Metodo chiamato quando la mappa è pronta per essere usato
     */
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
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    /*
    * Metodo chiamato ogni volta che il dispositivo si connette e disconnette*/
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
        Toast.makeText(getApplicationContext(),"onConnected: "+latitudine+" "+longitudine,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    /*Metodo che calcola la distanza tra due punti sulla mappa*/
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

    /* Tale metodo sarà chiamato ogni volta che c'è un cambiamento nella posizione del dispositivo
    *  Calcola e aggiorna i campi (e le relative TextView) kcal e Km_percorsi*/
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

        /* Controllo fatto per evitare di memorizzare la posizione di un utente non loggato*/
        if(!emailLog.equals("null")){
            Invia in=new Invia("http://socialbikeeper.altervista.org/setuserposition.php?email="+emailLog+"&latitudine="+mPreviousLocation.getLatitude()+"&longitudine="+mPreviousLocation.getLongitude());
            in.doInBackground();
        }

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()),16));

        GeoCor geoCore= currentLocation(location.getLatitude(),location.getLongitude());

        time = geoCore.getValue1();
        distance = geoCore.getValue2();

        df = new DecimalFormat("###.##");
        df.setRoundingMode(RoundingMode.DOWN);

        float min=Float.parseFloat(time)/60;
        float dist=Float.parseFloat(distance)/1000;
        Km_percorsi+=dist;
        speed= (Float.parseFloat(distance)/Float.parseFloat(time))*CONV;
        potenza=(P*(H+A) + K*speed*speed) * speed * G;
        kcal = (potenza*min/1000) / 1.11631;
        calorie_value.setText("" + df.format(kcal));
        KM_value.setText("" + df.format(Km_percorsi));
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onResume() {
        super.onResume();

        start = (Button) findViewById(R.id.start_button);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pausa=true;
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread, 0);
                if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                    Location movingPoint = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                    MOVING_POINT = new LatLng(movingPoint.getLatitude(),movingPoint.getLongitude());
                }
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MOVING_POINT,16));
                currentLocation(MOVING_POINT.latitude,MOVING_POINT.longitude);

                calorie_value.setVisibility(View.VISIBLE);
                KM_value.setVisibility(View.VISIBLE);
            }
        });

        pause = (Button) findViewById(R.id.pause_button);
        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pausa = false;
                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);
            }
        });

        stop = (Button) findViewById(R.id.stop_button);
        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopTimerThread();
                timeSwapBuff =0L;
                customHandler.removeCallbacks(updateTimerThread);

                if(Km_percorsi==0.0 && kcal==0.0 && timeInMilliseconds/1000==0.0){
                    Toast.makeText(getApplicationContext(), "Devi premere start per iniziare l'allenamento!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //Cronometro
    private Runnable updateTimerThread = new Runnable() {
        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 100);
            timerValue.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%02d", milliseconds));
            customHandler.postDelayed(this, 0);
        }
    };

    private void stopTimerThread() {
        timerValue.setText("" + 00 + ":"
                + String.format("%02d", 00) + ":"
                + String.format("%02d", 00));
        KM_value.setText(""+0.0);
        calorie_value.setText(""+0.0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.training,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id) {
            case R.id.item_menu_storico:
                Toast.makeText(getApplicationContext(),"Activity da implementare",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_menu_logout:
                Toast.makeText(getApplicationContext(), "Logout: "+emailLog, Toast.LENGTH_LONG).show();
                Invia deletePosition = new Invia("http://socialbikeeper.altervista.org/deleteposition.php?email="+emailLog);
                deletePosition.doInBackground();
                Intent toMainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(toMainActivity);
                finish();
                System.exit(0);
                break;
            case R.id.item_menu_sfida:
                Toast.makeText(getApplicationContext(),"Activity da implementare",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}