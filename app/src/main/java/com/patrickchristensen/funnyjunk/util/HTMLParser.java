package com.patrickchristensen.funnyjunk.util;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class HTMLParser {

    public static Document loadDocument(URL url){
        try {
            return Jsoup.connect(url.toString())
                    .userAgent("Mozilla")
                    .get();
        }catch (IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }

}
