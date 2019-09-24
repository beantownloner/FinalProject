package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService = null;

    private Callback callback;

    public interface Callback {
        void onFinished(String result);
    }


    public EndpointAsyncTask(Callback callback) {
        this.callback = callback;
    }


    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://beantownloner-final-project.appspot.com/_ah/api/");

            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getData();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            callback.onFinished(result);
        }
    }


}