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
                    startService();
                    serviceStarted = true;
                } else {
                    stopService();
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
}
