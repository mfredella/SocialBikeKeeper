package sbk.unisannio.com.socialbikekeeper;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by carusosara on 07/11/2017.
 */

public class TestTrainingActivity extends ActivityInstrumentationTestCase2<TrainingActivity> {
    private TrainingActivity tActivity;
    private TextView KM_value, cal_value, timer_value;

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
    }
}
