package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.beantownloner.androidjokelibrary.JokeActivity;

import static android.view.View.VISIBLE;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    Button button;
    ProgressBar pgBar;
    public static String TAG = MainActivityFragment.class.getSimpleName();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        pgBar = (ProgressBar) root.findViewById(R.id.progressBar1);

        button = (Button) root.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                pgBar.setVisibility(VISIBLE);
                button.setEnabled(false);
                launchJokeActivity();
            }
        });
        return root;
    }

    private void launchJokeActivity() {


        new EndpointAsyncTask(new EndpointAsyncTask.Callback() {
            @Override
            public void onFinished(String result) {
                Intent intent = new Intent(getActivity(), JokeActivity.class);


                intent.putExtra(JokeActivity.JOKE_KEY, result);
                Log.d(TAG, " joke is : " + result);
                button.setEnabled(true);
                pgBar.setVisibility(View.GONE);
                startActivity(intent);
            }


        }).execute();

    }


}
