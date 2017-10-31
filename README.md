[![GitHub license](https://img.shields.io/github/license/dcendents/android-maven-gradle-plugin.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![](https://jitpack.io/v/nicola-amatucci/android-monkey.svg)](https://jitpack.io/#nicola-amatucci/android-monkey)

# android-monkey

Android Monkey Library - imported from https://code.google.com/archive/p/androidmonkey/

Based on the Android ActivityInstrumentation Sample - https://github.com/googlesamples/android-ActivityInstrumentation/

# Usage

To use the Android Monkey Library, just apply the plugin in your project.

Add it in your root build.gradle at the end of repositories:

``Groovy
allprojects {
    repositories {
	...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

``Groovy
dependencies {
	...
        compile 'com.github.nicola-amatucci:android-monkey:0.1'
	...
}
```

Write a new Android Test Case (see the application module source code):


``Java
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
```

# License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


