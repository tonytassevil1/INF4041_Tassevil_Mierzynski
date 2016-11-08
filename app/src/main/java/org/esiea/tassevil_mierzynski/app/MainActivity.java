package org.esiea.tassevil_mierzynski.app;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.widget.EditText;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;

        Button button = (Button)findViewById(R.id.ToastButton);
        // Show toast message and launch new activity when button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Affichage du toast
                Toast.makeText(getApplicationContext(),getString(R.string.toast),Toast.LENGTH_LONG).show();

                //lancement d'une nouvelle activité
                Intent intent = new Intent(context, ListRecycler.class);
                //EditText editText = (EditText) findViewById(R.id.edit_message);
                //String message = editText.getText().toString();
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu) {
            //new AlertDialog.Builder(this).setMessage("WOW").create().show();

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setView(R.layout.dialog).setMessage("WOW").setTitle("Titre").create().show();
        }
        else if (id == R.id.notif) {
            showNotification();
        }

        return super.onOptionsItemSelected(item);
    }

    public void showNotification() {

        Resources r = getResources();
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_menu_report_image)
                        .setContentTitle(r.getString(R.string.notification_title))
                        .setContentText(r.getString(R.string.notification_text));

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
