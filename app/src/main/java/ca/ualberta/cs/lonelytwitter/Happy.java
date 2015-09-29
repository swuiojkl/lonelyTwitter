package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Administrator on 2015/9/14 0014.
 */
public class Happy extends CurrentMood{
    public Happy(Date date) {
        super(date);
    }

    public String mood(){
        return "Happy!";
    }
}
