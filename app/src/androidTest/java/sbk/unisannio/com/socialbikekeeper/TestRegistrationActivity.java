package sbk.unisannio.com.socialbikekeeper;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by michele on 02/11/2017.
 */

public class TestRegistrationActivity extends ActivityInstrumentationTestCase2<RegistrationActivity> {
    private RegistrationActivity rActivity;
    private Button registrati;
    private EditText email, nome, cognome, password;

    public TestRegistrationActivity() {
        super(RegistrationActivity.class);
    }
    @Override
    public void setUp() throws Exception {
        super.setUp();
        rActivity= getActivity();
        Thread.sleep(2000);
    }
    @Test
    public void testRegWithoutAt() throws InterruptedException {
        registrati = (Button) rActivity.findViewById(R.id.invia);
        assertNotNull(registrati);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_J);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_I);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_M);
        Thread.sleep(2000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        rActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                registrati.performClick();
            }
        });
        onView(withText("Dati inseriti non validi")).inRoot(withDecorView(not(is(getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

    }
    public void testRegNullWithAt() throws InterruptedException {
        registrati = (Button) rActivity.findViewById(R.id.invia);
        assertNotNull(registrati);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_N);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_U);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_AT);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_N);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_U);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        Thread.sleep(2000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_N);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_U);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        Thread.sleep(2000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_N);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_U);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        Thread.sleep(2000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_N);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_U);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_L);
        Thread.sleep(2000);

        rActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                registrati.performClick();
            }
        });
        onView(withText("Dati inseriti non validi")).inRoot(withDecorView(not(is(getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }


    @Test
    public void testRegistration() throws InterruptedException {
        Thread.sleep(1000);
        formReg();
        registrati= (Button)rActivity.findViewById(R.id.invia);
//        assertNotNull(registrati);

        rActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                registrati.performClick();
            }
        });
        onView(withText("Registrazione avvenuta")).inRoot(withDecorView(not((getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void testExistingUser() throws InterruptedException {
        Thread.sleep(1000);
        formNewReg();
        registrati= (Button)rActivity.findViewById(R.id.invia);
//        assertNotNull(registrati);

        rActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                registrati.performClick();
            }
        });
        onView(withText("Utente esistente")).inRoot(withDecorView(not((getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    public void formReg() throws InterruptedException {
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_J);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_I);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_M);
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
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_J);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_I);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_M);
        Thread.sleep(1000);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_J);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_I);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_M);
        Thread.sleep(1000);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_J);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_I);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_M);
        Thread.sleep(2000);
    }

    public void formNewReg() throws InterruptedException {
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

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_C);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_A);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_R);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_U);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_S);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_O);
        Thread.sleep(2000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_TAB);
        Thread.sleep(1000);

        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_S);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_A);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_R);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_A);
        Thread.sleep(2000);
    }

}