package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by wsong1 on 2015/9/28 0028.
 */

public class TweetList implements MyObservable, MyObserver {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void myNotify(MyObservable myObserverable) {
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (MyObserver myObserver : observers) {
            myObserver.myNotify(this);
        }
    }

    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
        tweet.addObserver(this);
        notifyAllObservers();
    }

    public Boolean hasTweet(Tweet tweet) {
        for (Tweet t : tweets) {
            if (t.equals(tweet)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public int getCount() {
        return tweets.size();
    }

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }
}
