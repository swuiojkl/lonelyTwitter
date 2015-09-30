package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by wsong1 on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(Class activityClass) {
        super(activityClass);
    }

    public void testAdd() throws Exception {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
    }

    public void testDelete() throws Exception {

    }

    public void testContains() throws Exception {

    }

    public void testCount() throws Exception {

    }

    public void testClear() throws Exception {

    }

    public void testGet() throws Exception {

    }
}