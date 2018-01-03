package watchdog.videorecordingbackground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean serviceStarted = false;
    Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!serviceStarted == true) {
                    startServiceFront();
                    serviceStarted = true;
                } else {
                    stopServiceFront();
                    serviceStarted = false;
                }

            }
        });

    }

    public void startService(){
        Intent serviceIntent = new Intent(this, VideoRecordingService.class);
        startService(serviceIntent);
    }

    public void stopService(){
        stopService(new Intent(this, VideoRecordingService.class));
    }

    public void startServiceFront(){
        Intent serviceIntent = new Intent(this, VideoRecordingFront.class);
        startService(serviceIntent);
    }

    public void stopServiceFront(){
        stopService(new Intent(this, VideoRecordingFront.class));
    }
}
