package com.patrickchristensen.funnyjunk.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.patrickchristensen.funnyjunk.fragment.ThumbnailFragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Patrick on 23-02-2015.
 */
public class LoadImageTask extends AsyncTask<URL, Integer, Bitmap>{

    private Handler handler;

    public LoadImageTask(Handler handler){
        this.handler = handler;
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {
        return downloadImage(urls[0]);
    }

    private Bitmap downloadImage(URL url){
        Bitmap image = null;
        try {
            InputStream in = url.openStream();
            image = BitmapFactory.decodeStream(in);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onPostExecute(Bitmap image) {
        Message msg = Message.obtain();
        msg.what = ThumbnailFragment.LOAD_IMAGE;
        msg.obj = image;
        super.onPostExecute(image);
    }
}
