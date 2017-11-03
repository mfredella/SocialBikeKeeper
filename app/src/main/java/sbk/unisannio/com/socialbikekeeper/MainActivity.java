package sbk.unisannio.com.socialbikekeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
    private EditText email, password;
    private Button login, registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.
                ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            Toast toast = Toast.makeText(getApplicationContext(),"Benvenuto", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),"ATTENZIONE login errato",Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
