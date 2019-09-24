package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.beantownloner.androidjokelibrary.JokeActivity;
import com.beantownloner.jokelibrary.MyJokes;


public class MainActivity extends AppCompatActivity implements EndpointAsyncTask.Callback{


    String joke = "";
    public static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchJokeActivity(View view) {

        new EndpointAsyncTask(this).execute();



    }


    @Override
    public void onFinished(String result) {
        Intent intent = new Intent(this, JokeActivity.class);


        intent.putExtra(JokeActivity.JOKE_KEY, result);
        Log.d(TAG," joke is : "+result);
        startActivity(intent);
    }
}
