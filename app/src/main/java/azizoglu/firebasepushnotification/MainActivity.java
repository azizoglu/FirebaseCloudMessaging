package azizoglu.firebasepushnotification;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        definations();
        setSupportActionBar(toolbar);
        FirebaseMessaging.getInstance().subscribeToTopic("NotificationGroup");
        FirebaseInstanceId.getInstance().getToken();
        clickEvents();
    }

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private EditText inputMessage;
    private void definations() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        inputMessage=(EditText) findViewById(R.id.input_message);
    }

    private String NOTIF_URL = "http://.../FCM/sendNotification.php"; //replace with your notification url
    private String notificationMessage="";

    private void clickEvents() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationMessage=inputMessage.getText().toString();
                Toast.makeText(MainActivity.this, "Notification "+notificationMessage, Toast.LENGTH_SHORT).show();
                new sendNotificaiton().execute();
            }
        });
    }

    private class sendNotificaiton extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                OkHttpClient client = new OkHttpClient();
                RequestBody body = new FormBody.Builder()
                        .add("messageData", notificationMessage)
                        .build();

                Request request = new Request.Builder()
                        .url(NOTIF_URL)
                        .post(body)
                        .build();
                client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
        }
    }
}
