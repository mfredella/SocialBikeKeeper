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

                    if (!TrainingActivity.getEmail().equals(sfidante) && TrainingActivity.getEmail().equals(sfidato)) {

                        NotificationCompat.Builder n = new NotificationCompat.Builder(this)
                                .setContentTitle("Hai una nuova sfida di " + durata + " minuti da:")
                                .setContentText(sfidante)
                                .setSmallIcon(android.R.drawable.ic_dialog_email)
                                .setAutoCancel(true)
                                .setSound(sound)
                                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});

                        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n.build());
                    }

                }
            }
        }
    }
}
