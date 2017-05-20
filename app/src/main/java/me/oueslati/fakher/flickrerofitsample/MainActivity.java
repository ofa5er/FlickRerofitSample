package me.oueslati.fakher.flickrerofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.oueslati.fakher.flickrerofitsample.dataprovider.Controller;

public class MainActivity extends AppCompatActivity {
    private Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller();
        controller.start();
    }

    public void getPhotos(View v) {

    }
}
