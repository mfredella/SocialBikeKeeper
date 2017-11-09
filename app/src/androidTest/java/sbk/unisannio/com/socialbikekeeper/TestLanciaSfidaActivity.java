package sbk.unisannio.com.socialbikekeeper;

import android.content.Intent;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;


/**
 * Created by Marianna on 09/11/2017.
 */

public class TestLanciaSfidaActivity extends ActivityInstrumentationTestCase2<LanciaSfidaActivity> {
    private LanciaSfidaActivity lActivity;
    public TestLanciaSfidaActivity()  {
        super(LanciaSfidaActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        /*passaggio di parametri a ViciniActivity*/
        setActivityIntent(new Intent().putExtra("myLat", "41.1310307")
                .putExtra("myLon", "14.7772019")
                .putExtra("emailLog", "sara@gmail.com"));
        Thread.sleep(2000);
        lActivity = getActivity();
        Thread.sleep(2000);
    }

    @Test
    public void testMarker() throws InterruptedException, UiObjectNotFoundException {
        onView(withText("Scegli il tuo sfidante")).inRoot(withDecorView(not(is(getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

        UiDevice device = UiDevice.getInstance(getInstrumentation());

        UiObject markerSfidante = device.findObject(new UiSelector().descriptionContains("Sei qui"));
        assertNotNull(markerSfidante);
        markerSfidante.click();
        Thread.sleep(2000);

        UiObject marker = device.findObject(new UiSelector().descriptionContains("Sfidami"));
        assertNotNull(marker);
        marker.click();
        Thread.sleep(2000);




    }

}