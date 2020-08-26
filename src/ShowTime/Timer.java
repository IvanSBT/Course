package ShowTime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer {

    int[] seconds;
    public Timer(int[] seconds){
        this.seconds=seconds;
    }

    public void show(){

        for (int second: seconds) {
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            service.scheduleWithFixedDelay(new ShowTimer(second), second,second, TimeUnit.SECONDS);
        }

    }
}

