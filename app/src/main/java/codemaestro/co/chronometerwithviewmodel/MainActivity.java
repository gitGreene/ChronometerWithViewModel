package codemaestro.co.chronometerwithviewmodel;


import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    ChronometerViewModel chronometerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel.class);

        Chronometer chronometer = findViewById(R.id.chronometer);

        if (chronometerViewModel.getStartTime() == null) {
            // If the start date is not defined, it's a new ViewModel so set it.
            long startTime = SystemClock.elapsedRealtime();
            chronometerViewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
            // starting time.
            chronometer.setBase(chronometerViewModel.getStartTime());
        }

        chronometer.start();
    }
}
