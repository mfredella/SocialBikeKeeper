package sbk.unisannio.com.socialbikekeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends Activity implements OnClickListener {

    private EditText email, nome, cognome, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button registrati = (Button) findViewById(R.id.invia);
        registrati.setOnClickListener(this);

        email = (EditText) findViewById(R.id.email);
        nome = (EditText) findViewById(R.id.nome);
        cognome = (EditText) findViewById(R.id.cognome);
        password = (EditText) findViewById(R.id.password);

    }

    @Override
    public void onClick(View v) {
        String email1 = email.getText().toString();
        String nome1= nome.getText().toString();
        String cognome1= cognome.getText().toString();
        String password1= password.getText().toString();

        if(!email.getText().toString().contains("@")
                || nome.getText().toString().matches("")
                || cognome.getText().toString().matches("")
                || password.getText().toString().matches(""))
            Toast.makeText(getApplicationContext(), "Dati inseriti non validi", Toast.LENGTH_LONG).show();
        else if(email.getText().toString().contains("null")
                || nome.getText().toString().contains("null")
                || cognome.getText().toString().contains("null")
                || password.getText().toString().contains("null"))
            Toast.makeText(getApplicationContext(), "Dati inseriti non validi", Toast.LENGTH_LONG).show();
        else {
            Invia vb=new Invia("http://socialbikeeper.altervista.org/registration.php?email="+email1+"&nome="+nome1+"&cognome="+cognome1+"&password="+password1);
            String a=vb.doInBackground();

            if(a.contains("Registrazione")) {

                Intent openPage1 = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(openPage1);
                Toast to = Toast.makeText(getApplicationContext(),"Registrazione avvenuta",Toast.LENGTH_LONG);
                to.show();

            }
            else {
                Intent openPage1 = new Intent(RegistrationActivity.this,RegistrationActivity.class);
                startActivity(openPage1);
                Toast to = Toast.makeText(getApplicationContext(),"Utente esistente",Toast.LENGTH_LONG);
                to.show();

            }
        }
    }
}