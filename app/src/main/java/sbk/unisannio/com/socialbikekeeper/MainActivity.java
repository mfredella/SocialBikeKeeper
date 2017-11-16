package sbk.unisannio.com.socialbikekeeper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.os.Bundle;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener, DialogInterface.OnClickListener {
    private EditText email, password;
    private Button login, registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.
                ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        // Controlla se la connessione è abilitata
        if(ni==null){
            AlertDialog.Builder builderNet = new AlertDialog.Builder(this);
            builderNet.setTitle("Network Manager");
            builderNet.setMessage("Abilita la connessione");
            builderNet.create().show();
        }
        // Controlla se il GPS è abilitato
        if(!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Location Manager");
            builder.setMessage("Consenti l'accesso al GPS?");
            builder.setPositiveButton("Si", this);
            builder.setNegativeButton("No", this);
            builder.create().show();
        }

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        registration = (Button) findViewById(R.id.registration);
        registration.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.login:
                email = (EditText) findViewById(R.id.etEmail);
                password = (EditText) findViewById(R.id.etPassword);
                Invia checkCredentials=new Invia("http://socialbikeeper.altervista.org/login.php"+"?email="+email.getText().toString()+"&password="+password.getText().toString());
                String output=checkCredentials.doInBackground();
                check(output);
                break;
            case R.id.registration:
                Intent openPage1 = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(openPage1);
                break;
        }
    }

    public void check(String a) {
        if(a.compareTo("trovato")>0) {
            Intent toTraining = new Intent (MainActivity.this, TrainingActivity.class)
                    .putExtra("email",email.getText().toString());
            startActivity(toTraining);
            Toast.makeText(getApplicationContext(),"Benvenuto", Toast.LENGTH_LONG).show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),"ATTENZIONE login errato",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch(which){
            case -1:
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
                break;
            case -2:
                finish();
                break;
        }
    }
}
