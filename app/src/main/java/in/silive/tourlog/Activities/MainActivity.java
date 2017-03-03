package in.silive.tourlog.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import in.silive.tourlog.R;

public class MainActivity extends AppCompatActivity {
    EditText user_location;
    ListView list_places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_location = (EditText) findViewById(R.id.user_location);
        list_places = (ListView) findViewById(R.id.list_places);
    }
}
