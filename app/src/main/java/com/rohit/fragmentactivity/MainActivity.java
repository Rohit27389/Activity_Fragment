package com.rohit.fragmentactivity;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    public static final String TAG="Activity";

    private Button button1, button2;
    //FragmentCalled fragmentCalled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        click1();
        click2();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart:Activity ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume:Activity ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause:Activity ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop:Activity ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart:Activity ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity");
    }

    /* Adding fragment */
    public void click1() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentCalled fragmentCalled = new FragmentCalled();
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, fragmentCalled)
                        .commit();
            }
        });
    }

    /*Fragment remove but once you change your configuration then its wn't work */
    /*public void click2() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(fragmentCalled!=null){
                 getFragmentManager().beginTransaction()
                         .remove(fragmentCalled).commit();

             }

            }
        });

    }
*/

/*Fragment remove but once you change your configuration then its will work */
    public void click2() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentCalled mFragmentCalled= (FragmentCalled) getFragmentManager().findFragmentById(R.id.fragment_container);

                if(mFragmentCalled!=null){
                    getFragmentManager().beginTransaction()
                            .remove(mFragmentCalled).commit();

                }

            }
        });

    }

}
