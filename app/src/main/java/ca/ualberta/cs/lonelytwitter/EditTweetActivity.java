package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTweetActivity extends Activity {
    private Tweet tweet;
    private Button saveButton;
    private EditText bodyText;
    private EditTweetActivity activity = this;


    public Tweet getTweet() {
        return tweet;
    }

    public EditText getBodyText() {
        return bodyText;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        tweet = Temp.getInstance().getTweet();
        saveButton = (Button) findViewById(R.id.bSave);
        bodyText = (EditText) findViewById(R.id.etEdit);
        bodyText.setText(tweet.getText());
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                tweet = new NormalTweet(bodyText.getText().toString());
                Temp.getInstance().setTweet(tweet);
                activity.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_tweet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
