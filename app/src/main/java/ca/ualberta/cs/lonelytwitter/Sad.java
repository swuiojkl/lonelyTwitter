package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Administrator on 2015/9/14 0014.
 */
public class Sad extends CurrentMood{
    public Sad(Date date) {
        super(date);
    }

    public String mood(){
        return "Sad!";
    }
}
