package sbk.unisannio.com.socialbikekeeper;

import android.app.Activity;
import android.content.Intent;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;

import java.util.Collection;

import static android.support.test.runner.lifecycle.Stage.RESUMED;

/**
 * Created by carusosara on 07/11/2017.
 */

public class TestTrainingActivity extends ActivityInstrumentationTestCase2<TrainingActivity> {
    private TrainingActivity tActivity;
    private TextView KM_value, cal_value, timer_value;
    private Button start_button, stop_button;

    public TestTrainingActivity() {
        super(TrainingActivity.class);
    }

    /*
    * SetUp iniziale di TrainingActivity con passaggio dell'extra "email"
    * che corrisponde all'email dell'utente loggato
    */
    @Override
    protected void setUp() throws Exception{
        super.setUp();
        setActivityIntent(new Intent().putExtra("email", "sara@gmail.com"));
        tActivity = getActivity();
        Thread.sleep(2000);
    }

    /*
    * Controllo se le TextView sono inizializzate correttamente
     * se sono invisibili alla creazione dell'activity
     * se sono visibili alla selezione dello Start
     * se la selezione di Stop prima di Start mostra un Toast di errore
    */
    @Test
    public void testTextView() throws InterruptedException {
        KM_value=(TextView)tActivity.findViewById(R.id.KM_value);
        cal_value=(TextView)tActivity.findViewById(R.id.calorie_value);
        timer_value=(TextView)tActivity.findViewById(R.id.timerValue);

        assertNotNull(KM_value);
        assertNotNull(cal_value);
        assertNotNull(timer_value);

        assertEquals(KM_value.getVisibility(), View.INVISIBLE);
        assertEquals(cal_value.getVisibility(), View.INVISIBLE);

        start_button= (Button)tActivity.findViewById(R.id.start_button);
        tActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                start_button.performClick();
            }
        });
        Thread.sleep(1000);

        assertEquals(KM_value.getVisibility(), View.VISIBLE);
        assertEquals(cal_value.getVisibility(), View.VISIBLE);

        stop_button= (Button)tActivity.findViewById(R.id.stop_button);
        tActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                stop_button.performClick();
            }
        });
        Thread.sleep(2000);
        Activity activity = getActivityInstance();
        boolean b = (activity instanceof  RisultatiActivity);
        assertTrue(b);

    }

    public Activity getActivityInstance() {
        final Activity[] activity = new Activity[1];
        getInstrumentation().runOnMainSync(new Runnable( ) {
            public void run() {
                Activity currentActivity = null;
                Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
                if (resumedActivities.iterator().hasNext()){
                    currentActivity = (Activity) resumedActivities.iterator().next();
                    activity[0] = currentActivity;
                }
            }
        });

        return activity[0];
    }
}
