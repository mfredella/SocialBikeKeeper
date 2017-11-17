package sbk.unisannio.com.socialbikekeeper;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

import java.util.Collection;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static com.google.android.gms.common.api.CommonStatusCodes.TIMEOUT;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by Marianna on 14/11/2017.
 */

public class Test4Challenge extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public Test4Challenge() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        mActivity = getActivity();
        Thread.sleep(2000);

    }
    /*Testa il caso in cui la sfida viene accetata*/
    @Test
    public void testSfida1() throws InterruptedException{

        Thread.sleep(1000);
        String email="sara@gmail.com";
        String password="sara";

        onView(withId(R.id.etEmail)).perform(typeText(email));
        closeSoftKeyboard();
        Thread.sleep(1000);
        onView(withId(R.id.etPassword)).perform(typeText(password));
        closeSoftKeyboard();
        Thread.sleep(2000);

        onView(withId(R.id.login)).perform(click());
        Thread.sleep(8000);

        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.openNotification();
        mDevice.wait(Until.hasObject(By.text("Hai una nuova sfida di 60 minuti da:")), TIMEOUT);
        UiObject2 notificationTitle = mDevice.findObject(By.text("Hai una nuova sfida di 60 minuti da:"));
        assertEquals(notificationTitle.getText(), "Hai una nuova sfida di 60 minuti da:");
        Thread.sleep(2000);

        notificationTitle.click();
        Thread.sleep(3000);

        Activity activity = getActivityInstance();
        boolean b = (activity instanceof  NotificaActivity);
        assertTrue(b);

        onView(withText("Accetti la sfida?")).check(matches(isDisplayed()));
        Thread.sleep(1000);

        onView(withText("Si")).perform(click());
        Thread.sleep(2000);

        Activity activitySfida = getActivityInstance();
        boolean boo = (activitySfida instanceof  SfidaActivity);
        assertTrue(boo);

        onView(withId(R.id.timerValue)).check(matches(isDisplayed()));
        onView(withId(R.id.KM_value)).check(matches(isDisplayed()));
        onView(withId(R.id.calorie_value)).check(matches(isDisplayed()));
        Thread.sleep(1000);

    }


    /*testa se la notifica della sfida lanciata arriva,
    se è cliccabile, se mostra l'alert dialog per accetare o meno la sfida
     * e se la sfida viene rifiuata */
    @Test
    public void testSfida0() throws InterruptedException{

        Thread.sleep(1000);
        String email2="mariannafucci@gmail.com";
        String password2="rafanadal";
        Thread.sleep(1000);
        onView(withId(R.id.etEmail)).perform(typeText(email2));
        closeSoftKeyboard();
        Thread.sleep(1000);
        onView(withId(R.id.etPassword)).perform(typeText(password2));
        closeSoftKeyboard();
        Thread.sleep(2000);

        onView(withId(R.id.login)).perform(click());
        Thread.sleep(5000);

        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.openNotification();
        mDevice.wait(Until.hasObject(By.text("Hai una nuova sfida di 60 minuti da:")), TIMEOUT);
        UiObject2 notificationTitle = mDevice.findObject(By.text("Hai una nuova sfida di 60 minuti da:"));
        assertEquals(notificationTitle.getText(), "Hai una nuova sfida di 60 minuti da:");
        Thread.sleep(2000);

        notificationTitle.click();
        Thread.sleep(3000);

        Activity activity = getActivityInstance();
        boolean b = (activity instanceof  NotificaActivity);
        assertTrue(b);

        onView(withText("Accetti la sfida?")).check(matches(isDisplayed()));
        Thread.sleep(1000);

        onView(withText("No")).perform(click());
        Thread.sleep(2000);

        Activity activitySfida = getActivityInstance();
        boolean boo = (activitySfida instanceof TrainingActivity);
        assertTrue(boo);

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
