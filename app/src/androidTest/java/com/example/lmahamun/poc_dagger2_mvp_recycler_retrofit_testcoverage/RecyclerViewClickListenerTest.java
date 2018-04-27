package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Laxmikant Mahamuni on 29-03-2018.
 */

@RunWith(AndroidJUnit4.class)
public class RecyclerViewClickListenerTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void RecyclerViewItemClickTest() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Espresso.onView(withId(R.id.recyclerView)).perform(RecyclerViewActions
                .actionOnItemAtPosition(0, CustomViewAction.clickChildViewWithID(R.id.new_item)));
    }
}
