package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by wsong1 on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver {

    private Boolean wasNotified = Boolean.FALSE;

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }


    public void myNotify(MyObservable observable) {
        wasNotified = Boolean.TRUE;
    }

    public void testAddTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        try {
            list.addTweet(tweet);
            assertTrue("TweetList cannot have redundant entries!", false);
        } catch (IllegalArgumentException e) {
            assertTrue("TweetList redundant entries test passed!", true);
        }
    }

    public void testAddObserver() {
        TweetList list = new TweetList();
        list.addObserver(this);
        wasNotified = Boolean.FALSE;
        list.addTweet(new NormalTweet("test"));
        assertTrue(wasNotified);
    }


    public void testTweetObserver() {
        TweetList list = new TweetList();
        list.addObserver(this);
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        wasNotified = Boolean.FALSE;
        tweet.setText("different");
        assertTrue(wasNotified);

    }
    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        assertTrue("TweetList hasTweet() test failed!", list.hasTweet(tweet));
    }
    public void testRemoveTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        list.removeTweet(tweet);
        assertFalse(list.contains(tweet));
    }

    public void testContains() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.addTweet(tweet);
        assertTrue(list.contains(tweet));
    }

    public void testGetCount() {
        TweetList list = new TweetList();

        for (int i = 0; i < 32; ++i) {
            list.addTweet(new NormalTweet("test" + i));
        }

        assertTrue("TweetList getCount() test failed!", 32 == list.getCount());
    }
}