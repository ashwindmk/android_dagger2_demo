package com.ashwin.android.dagger2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ashwin.android.dagger2demo.di.components.DaggerSharedPrefsComponent;
import com.ashwin.android.dagger2demo.di.components.SharedPrefsComponent;
import com.ashwin.android.dagger2demo.di.modules.SharedPrefsModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPrefsComponent component = DaggerSharedPrefsComponent.builder().sharedPrefsModule(new SharedPrefsModule(getBaseContext())).build();
        component.inject(this);

        initValue();
    }

    private void initValue() {
        String value = sharedPreferences.getString("value", "");
        ((EditText) findViewById(R.id.value_textview)).setText(value);
    }

    public void save(View v) {
        String value = ((EditText) findViewById(R.id.value_textview)).getText().toString();
        sharedPreferences.edit().putString("value", value).apply();
    }
}
