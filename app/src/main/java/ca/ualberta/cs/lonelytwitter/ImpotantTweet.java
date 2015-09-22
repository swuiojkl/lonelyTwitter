package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Wei Song on 2015/9/14 0014.
 */
public class ImpotantTweet extends Tweet {
    public ImpotantTweet(String tweet, Date date) {
        super(tweet, date);
    }

    public ImpotantTweet(String text) {
        super(text);
        this.text = text;
    }

    public String extraMethod(){
        return "important";
    }

    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
