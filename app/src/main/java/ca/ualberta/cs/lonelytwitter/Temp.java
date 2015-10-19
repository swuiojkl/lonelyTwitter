package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Administrator on 2015/10/19 0019.
 */
public class Temp {
    private Tweet tweet;
    private static Temp instance;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private Temp() {}

    public static boolean hasTemp(){ return instance != null;}

    public static void destroy(){
        instance = null;
    }

    public static Temp getInstance() {
        if (instance==null) instance = new Temp();
        return instance;
    }

    public Tweet getTweet() { return tweet; }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}
