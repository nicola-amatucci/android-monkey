package com.example.android.activityinstrumentation;

import android.app.Instrumentation;
import android.content.pm.PackageManager;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.Display;

import org.junit.Test;

import eu.fbk.se.androidmonkey.Monkey;

@SmallTest
public class SampleTests extends ActivityInstrumentationTestCase2<MainActivity> {

    public SampleTests() {
        super("com.example.android.activityinstrumentation", MainActivity.class);
    }

    @Test
    public void runMonkey() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Instrumentation inst = getInstrumentation();
        PackageManager pm = getActivity().getPackageManager();

        Monkey monkey = new Monkey(display,"com.example.android.activityinstrumentation", inst, pm);

        // Generate and fire a random event.
        for (int i = 0; i < 1000; i++) {
            monkey.nextRandomEvent();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
