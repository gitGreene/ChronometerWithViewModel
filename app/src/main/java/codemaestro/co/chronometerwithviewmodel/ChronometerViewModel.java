package codemaestro.co.chronometerwithviewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class ChronometerViewModel extends AndroidViewModel {
    private Long startTime;


    public ChronometerViewModel(@NonNull Application application) {
        super(application);
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}
