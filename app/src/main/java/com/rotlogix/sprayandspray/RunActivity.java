package com.rotlogix.sprayandspray;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.rotlogix.sprayandspray.services.FileParserService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class RunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        /**
         * Load test.png and convert to byte array
         */
        String testImagePath = new File(Environment.getExternalStorageDirectory(),
                "/Download/test.png").getAbsolutePath();

        /**
         *  Add byte array as Intent extra, and start the FileParserService
         */
        if(!testImagePath.isEmpty()) {
            Intent intent = new Intent(this, FileParserService.class);
            intent.putExtra("testImagePath", testImagePath);
            Log.d("SprayAndPray", "Starting FileParserService : " + testImagePath);
            startService(intent);
        }
    }
}
