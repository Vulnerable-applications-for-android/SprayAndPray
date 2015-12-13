package com.rotlogix.sprayandspray.services;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FileParserService extends Service {

    static {
        System.loadLibrary("nativeImageParser");
    }
    public FileParserService() {}

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        /**
         * Get Intent extras
         */
        String path = intent.getStringExtra("testImagePath");
        String generate = intent.getStringExtra("generate");

        if(path != null) {
            parseFile(path);
        } else if(generate != null) {
            SprayClass sprayClass = new SprayClass(generate);
            Log.d("SprayAndPray", sprayClass.randomString);
        } else {
            Log.d("SprayAndPray", "Did not find an Intent extra!");
        }

        return Service.START_STICKY;
    }

    public class SprayClass {
        /**
         * Our ROP payload will go here
         */
        private String randomString;

        public SprayClass(String s) {
            this.randomString = s;
        }

        public void setRandomString(String randomString) {
            this.randomString = randomString;
        }

        public String getRandomString() {
            return randomString;
        }
    }

    public native void parseFile(String s);
}
