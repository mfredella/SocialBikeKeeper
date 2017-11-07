package sbk.unisannio.com.socialbikekeeper;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;

import org.junit.Test;

import java.util.Collection;


import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static org.hamcrest.Matchers.not;
import static android.support.test.espresso.Espresso.onView;


/**
 * Created by michele on 02/11/2017.
 */

public class TestMainActivity extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mActivity;
    private Button login;
//    private Button registrati;

    public TestMainActivity() {

        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        mActivity = getActivity();
        Thread.sleep(2000);

    }

    @Test
    public void testAlertDialogNoConnection() throws InterruptedException {
        onView(withText("Abilita la connessione")).check(matches(isDisplayed()));
        Thread.sleep(3000);
    }

    @Test
    public void testAlertDialogNoGps() throws InterruptedException {
        onView(withText("Consenti l'accesso al GPS?")).check(matches(isDisplayed()));
        Thread.sleep(3000);
    }

    @Test
    public void testLogin() throws InterruptedException{

        Thread.sleep(1000);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_S);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_A);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_R);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_A);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_AT);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_G);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_M);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_A);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_I);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_PERIOD);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_C);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_O);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_M);
        Thread.sleep(2000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_S);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_A);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_R);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_A);
        Thread.sleep(2000);

        login= (Button)mActivity.findViewById(R.id.login);
        mActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                login.performClick();
            }
        });

    }

    @Test
    public void testLogNull() throws InterruptedException{

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        login= (Button)mActivity.findViewById(R.id.login);
//		View mActivityView= mActivity.getWindow().getDecorView();
//        assertNotNull(buttonInviaDati);
        mActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                login.performClick();
            }
        });
       onView(withText("ATTENZIONE login errato")).inRoot(withDecorView(not(getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
        
    }

    @Test
    public void testAtRegistration() throws InterruptedException {
        onView(withId(R.id.registration)).perform(click());
        Thread.sleep(2000);
        Activity activity = getActivityInstance();
        boolean b = (activity instanceof  RegistrationActivity);
        assertTrue(b);
    }

    public Activity getActivityInstance() {
        final Activity[] activity = new Activity[1];
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable( ) {
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