package beans;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private int id;
    private String msg;
    private Date date;

    private static Random randomizer = new Random(1);
    private DateFormat dateFormat;

    public Event (Date date, DateFormat dateFormat) {
        this.id = randomizer.nextInt();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return "Event ID: " + id + " Date: " + dateFormat.format(date) + "\nMessage: " + msg;
    }

    public static boolean isDay(int start, int end) {
        LocalTime time = LocalTime.now();
        return time.getHour() > start && time.getHour() < end;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }
}
