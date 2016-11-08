package org.esiea.tassevil_mierzynski.app;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.ToastButton);
        // Show toast message when button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),getString(R.string.toast),Toast.LENGTH_LONG).show();
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

        }

        return super.onOptionsItemSelected(item);
    }
}
