package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.Matcher;

/**
 * Created by Laxmikant Mahamuni on 29-03-2018.
 */

public class CustomViewAction {
    public static ViewAction clickChildViewWithID(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {

                view.performClick();
//                View itemView= view.findViewById(id);
//                itemView.performClick();
            }
        };
    }
}
