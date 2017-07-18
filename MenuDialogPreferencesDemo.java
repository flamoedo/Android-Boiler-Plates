package com.amoedo.languagepreferences;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    static String lang;

    TextView langText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.portugues:
                setLang("Portugues");

                return true;
            case R.id.english:
                setLang("English");

                return true;
            default:
                return false;
        }
    }

    public void setLang(String lang) {
        sharedPreferences.edit().putString("lang", lang).apply();
        langText.setText(lang);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        langText = (TextView) findViewById(R.id.langText);

        sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);

        lang = sharedPreferences.getString("lang", "");

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Language preference")
                .setMessage("Choose your language")
                .setPositiveButton("Portugues", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setLang("Portugues");
                    }
                })
                .setNegativeButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setLang("English");
                    }
                });

        if (lang == "") {

            alertDialog.show();

        } else {
            langText.setText(lang);

        }

    }
}
