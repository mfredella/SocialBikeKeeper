package sbk.unisannio.com.socialbikekeeper;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class NotificaActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifica);

        setUpNotifica();
    }

    public void setUpNotifica(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nuova Sfida!");
        builder.setMessage("Accetti la sfida?");
        builder.setPositiveButton("Si", this);
        builder.setNegativeButton("No", this);
        builder.create().show();
    }

    @Override
    public void onClick(DialogInterface arg0, int arg1) {
        switch(arg1){
            case -1:
                Invia accettaSfida = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+Sfida.getSfidante()+"&sfidato="+Sfida.getSfidato()+"&stato="+1);
                accettaSfida.doInBackground();
                Invia sfidar = new Invia("http://socialbikeeper.altervista.org/getchallenge.php?sfidante="+Sfida.getSfidante()+"&sfidato="+Sfida.getSfidato());
                String idr=sfidar.doInBackground();
                idr=idr.split("\\\n")[0];
                Sfida.setId(idr);
                Intent toStart=new Intent(this, SfidaActivity.class);
                startActivity(toStart);
                break;
            case -2:

                Invia rifiutaSfida = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+Sfida.getSfidante()+"&sfidato="+Sfida.getSfidato()+"&stato="+2);
                rifiutaSfida.doInBackground();
                Invia sfidar1 = new Invia("http://socialbikeeper.altervista.org/getchallenge.php?sfidante="+Sfida.getSfidante()+"&sfidato="+Sfida.getSfidato());
                String idr1=sfidar1.doInBackground();
                idr1=idr1.split("\\\n")[0];
                Sfida.setId(idr1);

                Intent toStart1=new Intent(this, TrainingActivity.class);
                toStart1.putExtra("email", Sfida.getSfidato());
                startActivity(toStart1);
                break;
        }
    }
}