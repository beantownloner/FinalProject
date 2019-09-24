package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {
    private String joke;

    @Test
    public void doInBackground() {
        try {
            MainActivityFragment mainActivity = new MainActivityFragment();
            EndpointAsyncTask endpointsAsyncTask = new EndpointAsyncTask(new EndpointAsyncTask.Callback() {
                @Override
                public void onFinished(String result) {

                }
            });
            endpointsAsyncTask.execute();
            String result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);

            try {
                Thread.sleep(10000);
                joke = endpointsAsyncTask.get();
                assertNotNull(joke);
                assertTrue(joke.length() > 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            Log.e("EndpointsAsyncTaskTest", "testDoInBackground: Timed out");
        }
    }


}