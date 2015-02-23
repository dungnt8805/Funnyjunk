package com.patrickchristensen.funnyjunk.task;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.patrickchristensen.funnyjunk.MainActivity;
import com.patrickchristensen.funnyjunk.util.HTMLParser;

import org.jsoup.nodes.Document;

import java.net.URL;

/**
 * Created by Patrick on 23-02-2015.
 */
public class LoadPageTask extends AsyncTask<URL, Integer, Document>{

    private Handler handler;
    private HTMLParser parser;

    public LoadPageTask(Handler handler){
        this.handler = handler;
        parser = new HTMLParser();
    }

    protected Document doInBackground(URL ... urls) {
        return parser.loadDocument(urls[0]);
    }

    protected void onProgressUpdate(Integer... progress){
        //TODO: set loading percentage
    }

    protected void onPostExecute(Document result){
        Message msg = Message.obtain();
        msg.obj = result;
        msg.what = MainActivity.LOAD_FRONTPAGE;
        handler.sendMessage(msg);
    }

}
