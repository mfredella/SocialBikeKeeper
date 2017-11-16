package sbk.unisannio.com.socialbikekeeper;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class ChallengeService extends IntentService {

    public ChallengeService() {
        super("ChallengeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        while (true) {

            Invia a = new Invia("http://socialbikeeper.altervista.org/getmychallenge.php?email=" + TrainingActivity.getEmail());
            String ris = a.doInBackground();

            if (!ris.contains("inesistente")) {
                String sfida = ris.split("\\\n")[0];

                String[] mysfida = sfida.split("\\*");
                String sfidante = mysfida[1];
                String sfidato = mysfida[2];
                String id = mysfida[0];
                Sfida newSfida = new Sfida(sfidante, sfidato, id);
                int statosfida = Integer.parseInt(mysfida[4]);
                int durata = Integer.parseInt(mysfida[3]);


                if (statosfida == 0) {
                    Intent pe = new Intent(this, NotificaActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(this, 0, pe, 0);

                    if (!TrainingActivity.getEmail().equals(sfidante) && TrainingActivity.getEmail().equals(sfidato)) {

                        NotificationCompat.Builder n = new NotificationCompat.Builder(this)
                                .setContentTitle("Hai una nuova sfida di " + durata + " minuti da:")
                                .setContentText(sfidante)
                                .setSmallIcon(android.R.drawable.ic_dialog_email)
                                .setContentIntent(pi)
                                .setAutoCancel(true)
                                .setSound(sound)
                                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n.build());
                    }

                }
                else if(statosfida==1){
                    if(TrainingActivity.getEmail().equals(sfidante)){
                        NotificationCompat.Builder n  = new NotificationCompat.Builder(this)
                                .setContentTitle("La tua sfida è stata accettata da")
                                .setContentText(sfidato)
                                .setSmallIcon(android.R.drawable.ic_dialog_email)
                                .setAutoCancel(true)
                                .setSound(sound)
                                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n.build());
                        Invia rifiutaSfida = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+sfidante+"&sfidato="+sfidato+"&stato="+5);
                        rifiutaSfida.doInBackground();
                    }
                }
                else if(statosfida==2){
                    if(TrainingActivity.getEmail().equals(sfidante)){

                        NotificationCompat.Builder n  = new NotificationCompat.Builder(this)
                                .setContentTitle("La tua sfida non è stata accettata da")
                                .setContentText(sfidato)
                                .setSmallIcon(android.R.drawable.ic_dialog_email)
                                .setAutoCancel(true)
                                .setSound(sound)
                                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n.build());

                        Invia sfidar1 = new Invia("http://socialbikeeper.altervista.org/getchallenge.php?sfidante="+sfidante+"&sfidato="+sfidato);
                        String idr1=sfidar1.doInBackground();
                        idr1=idr1.split("\\\n")[0];
                        Sfida.setId(idr1);
                        Invia rifiutaSfida = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+sfidante+"&sfidato="+sfidato+"&stato="+3);
                        rifiutaSfida.doInBackground();
                    }
                }
                else if(statosfida==3){
                    Invia cancella = new Invia("http://socialbikeeper.altervista.org/deletechallenge.php?id="+id);
                    cancella.doInBackground();
                    Invia result =new Invia("http://socialbikeeper.altervista.org/getchallengeresult.php?sfidante="+sfidante+"&sfidato="+sfidato);
                    String r=result.doInBackground();

                    if(!r.contains("vuoto")){
                        Invia cancellaris= new Invia("http://socialbikeeper.altervista.org/deletechallengeresult.php?sfidante="+sfidante+"&sfidato="+sfidato);
                        cancellaris.doInBackground();
                    }

                }
                else if(statosfida==4){
                    Intent pe2=new Intent(this,TrainingActivity.class);
                    PendingIntent pi2=PendingIntent.getActivity(this, 0, pe2, 0);
                    Invia result =new Invia("http://socialbikeeper.altervista.org/getchallengeresult.php?sfidante="+sfidante+"&sfidato="+sfidato);
                    String r=result.doInBackground();

                    String [] km=r.split("\\*");
                    Double kmsfidante = null;
                    Double kmsfidato = null;

                    kmsfidante = Double.parseDouble(km[0]);

                    if(km[1].split("\\\n")[0].equals("_"))
                        kmsfidato=0.0;
                    else
                        kmsfidato = Double.parseDouble(km[1].split("_")[0]);


                    if((TrainingActivity.getEmail()).equals(sfidante)){
                        if(kmsfidante>kmsfidato){

                            Double diffKm = kmsfidante-kmsfidato;

                            NotificationCompat.Builder n  = new NotificationCompat.Builder(this)
                                    .setContentTitle("Hai vinto la sfida!")
                                    .setContentText("Tu hai percorso "+diffKm+" km in più di "+sfidato)
                                    .setSmallIcon(android.R.drawable.ic_dialog_email)
                                    .setAutoCancel(true)
                                    .setSound(sound).
                                            setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            notificationManager.notify(0, n.build());
                            Invia setStato = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+sfidante+"&sfidato="+sfidato+"&stato="+3);
                            setStato.doInBackground();
                        }
                        else{
                            Double diffKm = kmsfidato-kmsfidante;
                            NotificationCompat.Builder n  = new NotificationCompat.Builder(this)
                                    .setContentTitle("Hai perso la sfida!")
                                    .setContentText("Tu hai percorso "+diffKm+" km in meno di "+sfidato)
                                    .setSmallIcon(android.R.drawable.ic_dialog_email)
                                    .setAutoCancel(true)
                                    .setSound(sound).
                                            setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            notificationManager.notify(0, n.build());
                            Invia setStato = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+sfidante+"&sfidato="+sfidato+"&stato="+3);
                            setStato.doInBackground();
                        }
                    }
                    else if(!(TrainingActivity.getEmail()).equals(sfidante)){
                        if(kmsfidato>kmsfidante){
                            Double diffKm = kmsfidato-kmsfidante;
                            NotificationCompat.Builder n1  = new NotificationCompat.Builder(this)
                                    .setContentTitle("Hai vinto la sfida!")
                                    .setContentText("Tu hai percorso "+diffKm+" km in più di "+sfidante)
                                    .setSmallIcon(android.R.drawable.ic_dialog_email)
                                    .setAutoCancel(true)
                                    .setSound(sound).
                                            setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            notificationManager.notify(0, n1.build());
                        }
                        else{
                            Double diffKm = kmsfidante-kmsfidato;
                            NotificationCompat.Builder n1  = new NotificationCompat.Builder(this)
                                    .setContentTitle("Hai perso la sfida!")
                                    .setContentText("Tu hai percorso "+diffKm+" km in meno di "+sfidante)
                                    .setSmallIcon(android.R.drawable.ic_dialog_email)
                                    .setAutoCancel(true)
                                    .setSound(sound).
                                            setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            notificationManager.notify(0, n1.build());
                        }
                    }
                }
            }
        }
    }
}
