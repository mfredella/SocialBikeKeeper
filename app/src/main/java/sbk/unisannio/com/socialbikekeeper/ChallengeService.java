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
            /*Il service controlla la tabella challenge e verifica se è presente una sfida per l'utente loggato*/
            if (!ris.contains("inesistente")) {
                String sfida = ris.split("\\\n")[0];

                String[] mysfida = sfida.split("\\*");
                String sfidante = mysfida[1];
                String sfidato = mysfida[2];
                String id = mysfida[0];
                Sfida newSfida = new Sfida(sfidante, sfidato, id);
                int statosfida = Integer.parseInt(mysfida[4]);
                int durata = Integer.parseInt(mysfida[3]);

                /*Lo sfidato riceve la notifica di una nuova sfida*/
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
                /*Lo sfidante riceve la notifica che la sfida che ha lanciato è stata accettata*/
                else if(statosfida==1){
                    Intent toStart= new Intent(this, SfidaActivity.class);
                    PendingIntent toStartPi= PendingIntent.getActivity(this,0, toStart,0);
                    if(TrainingActivity.getEmail().equals(sfidante)){
                        NotificationCompat.Builder n  = new NotificationCompat.Builder(this)
                                .setContentTitle("La tua sfida è stata accettata da")
                                .setContentText(sfidato)
                                .setSmallIcon(android.R.drawable.ic_dialog_email)
                                .setContentIntent(toStartPi)
                                .setAutoCancel(true)
                                .setSound(sound)
                                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n.build());
                        Invia rifiutaSfida = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+sfidante+"&sfidato="+sfidato+"&stato="+5);
                        rifiutaSfida.doInBackground();
                    }
                }
                /*Lo sfidante riceve la notifica che la sfida che ha lanciato è stata rifiutata*/
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
                /*La sfida viene cancellata dalla tabella challange e dalla tabella challenge_result*/
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
                /*Con lo stato a 4 la sfida è completa e il service controlla i km percorsi da entrambi i ciclisti e li informa
                * con una notifica del risultato della sfida*/
                else if(statosfida==4){
                    Intent pe2=new Intent(this,TrainingActivity.class);
                    PendingIntent pi2=PendingIntent.getActivity(this, 0, pe2, 0);
                    Invia result =new Invia("http://socialbikeeper.altervista.org/getchallengeresult.php?sfidante="+sfidante+"&sfidato="+sfidato);
                    String r=result.doInBackground();

                    String [] km=r.split("\\*");
                    Double kmsfidante = null;
                    Double kmsfidato = null;

                    kmsfidante = Double.parseDouble(km[0]);
                    /*Il service controlla il campo dei km dello sfidato, se non ci sono significa che lo sfidato non ha
                    * portato a termine la sfida*/
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
                    else if(kmsfidante==kmsfidato){
                        NotificationCompat.Builder n1  = new NotificationCompat.Builder(this)
                                .setContentTitle("La sfida è finita in pareggio!")
                                .setContentText("Avete percorso lo stesso numero di chilometri: "+kmsfidante)
                                .setSmallIcon(android.R.drawable.ic_dialog_email)
                                .setAutoCancel(true)
                                .setSound(sound).
                                        setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n1.build());
                    }
                }
                /*Lo stato può essere ugiale a 6 solo nel caso in cui lo sfidante non porta a termine la sfida.
                * In questo caso lo sfidato viene informato di aver vinto la sfida a tavolino*/
                else if(statosfida==6){
//					Intent pe2=new Intent(this,TrainingActivity.class);
//					PendingIntent pi2=PendingIntent.getActivity(this, 0, pe2, 0);
                    if(TrainingActivity.getEmail().equals(sfidato)){
                        NotificationCompat.Builder n1  = new NotificationCompat.Builder(this)
                                .setContentTitle("Hai vinto la sfida a tavolino con")
                                .setContentText(sfidante)
                                .setSmallIcon(android.R.drawable.ic_dialog_email)
                                .setAutoCancel(true)
//								.setContentIntent(pi2)
                                .setSound(sound)
                                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n1.build());


                        Invia setStato = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+sfidante+"&sfidato="+sfidato+"&stato="+3);
                        setStato.doInBackground();
//						Intent toTraining= new Intent(this,TrainingActivity.class).putExtra("email", sfidato);
//						startActivity(toTraining);
                    }
                    else{
                        NotificationCompat.Builder n1  = new NotificationCompat.Builder(this)
                                .setContentTitle("Hai perso la sfida a tavolino con")
                                .setContentText(sfidato)
                                .setSmallIcon(android.R.drawable.ic_dialog_email)
                                .setAutoCancel(true)
//								.setContentIntent(pi2)
                                .setSound(sound)
                                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n1.build());


                        Invia setStato = new Invia("http://socialbikeeper.altervista.org/dochallenge.php?sfidante="+sfidante+"&sfidato="+sfidato+"&stato="+3);
                        setStato.doInBackground();
                        Intent toTraining= new Intent(this,TrainingActivity.class).putExtra("email", sfidante);
                        startActivity(toTraining);
                    }
                }
                try {
                    Thread.sleep(30000);
                }
                catch (InterruptedException e) { }
            }
            else{
                try {
                    Thread.sleep(30000);
                }
                catch (InterruptedException e) { }
            }
        }
    }
}
