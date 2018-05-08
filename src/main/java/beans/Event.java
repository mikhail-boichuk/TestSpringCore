package beans;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

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
