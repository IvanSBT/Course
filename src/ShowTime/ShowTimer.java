package ShowTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowTimer implements Runnable {
    int sec;

    public ShowTimer(int sec){
        this.sec=sec;
    }

    @Override
    public void run() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")) + " Прошло " + sec + " сек");
    }
}
