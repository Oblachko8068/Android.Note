package com.example.justnote;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "Account";
    private static final String PREF_NAME = "Name";
    EditText nameBox;
    SharedPreferences settings;
    SharedPreferences.Editor prefEditor;
    TextView nameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameView = findViewById(R.id.nameView);
        nameView.setText("");
        nameBox = findViewById(R.id.nameBox);
        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);

        // получаем настройки
        String name = settings.getString(PREF_NAME,"");
        nameBox.setText(name);


    }
    // сохранение введенного текста
    @Override
    protected void onPause(){
        super.onPause();

        String name = nameBox.getText().toString();
        prefEditor = settings.edit();
        prefEditor.putString(PREF_NAME, name);
        prefEditor.apply();
    }
    // нажатие на кнопку (удаление EditText, запись текста в поле текста)
    public void saveName(View view) {
        String name = nameBox.getText().toString();
        nameView = findViewById(R.id.nameView);
        nameView.setText(name);
        nameBox.setText("");
    }

}