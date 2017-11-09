package sbk.unisannio.com.socialbikekeeper;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class LanciaSfidaActivity extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnInfoWindowClickListener, DialogInterface.OnClickListener {


    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    MarkerOptions myMarker;
    Marker mCurrLocationMarker;
    String emailpossSfidato;
    static String emailSfidato;
    static String emailSfidante;
    String durataSfida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanciasfida);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapSfida);
        mapFragment.getMapAsync(this);
    }
/*
* Mostra la mia posizione sulla mappa con un marcatore rosso
* */
    public void setUpVicini(){
        Double latitude = Double.parseDouble(getIntent().getStringExtra("myLat"));
        Double longitude = Double.parseDouble(getIntent().getStringExtra("myLon"));
        LatLng myPosition= new LatLng(latitude, longitude);
        myMarker = new MarkerOptions();
        myMarker.position(myPosition);
        myMarker.title("Sei qui");
        myMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mCurrLocationMarker = mMap.addMarker(myMarker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition,16));
        emailSfidante=getIntent().getStringExtra("emailLog");
        mostraVicini();
    }
/*
* Mostra la posizione dei possibili sfidanti sulla mappa con un marcatore blu
* */
    private void mostraVicini() {
        Toast.makeText(getApplicationContext(),"Scegli il tuo sfidante", Toast.LENGTH_LONG).show();
//        Invia invia=new Invia("http://socialbikeeper.altervista.org/getneighbors.php");
//        String a=invia.doInBackground();
        String a = ("sara@gmail.com*41.1310415*14.7772164_mariannafucci@gmail.com*41.1325694*14.7791458_");
        String [] vicini=a.split("_");

        for (int i=0;i<=vicini.length-1;i++){
            emailpossSfidato=vicini[i].split("\\*")[0];
            double latitudine=Double.parseDouble(vicini[i].split("\\*")[1]);
            double longitudine=Double.parseDouble(vicini[i].split("\\*")[2]);
            if(!emailpossSfidato.equals(emailSfidante)){
                LatLng vicino= new LatLng(latitudine,longitudine);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(vicino);
                markerOptions.title("Sfidami");
                markerOptions.snippet(emailpossSfidato);
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mCurrLocationMarker = mMap.addMarker(markerOptions);
                mMap.setOnInfoWindowClickListener(this);

            }
        }
    }
/*
* Scegli la durata della sfida
* */
    @Override
    public void onInfoWindowClick(Marker m) {

        emailSfidato = m.getSnippet();

        if(!m.equals(myMarker)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Sfida");
            builder.setMessage("Scegli la durata della sfida in minuti."+"\n"+"Vincerà chi farà più km nel tempo scelto.");
            builder.setPositiveButton("60", this);
            builder.setNegativeButton("90", this);
            builder.create().show();
        }
    }

    @Override
    public void onClick(DialogInterface arg0, int arg1) {
        switch(arg1){
            case -1:
                durataSfida = ""+60;
                Toast.makeText(getApplicationContext(), "Sfida di "+durataSfida+" minuti lanciata", Toast.LENGTH_LONG).show();
                break;
            case -2:
                durataSfida = ""+90;
                Toast.makeText(getApplicationContext(), "Sfida di "+durataSfida+" minuti lanciata", Toast.LENGTH_LONG).show();
                break;
        }
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
        setUpVicini();
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
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}