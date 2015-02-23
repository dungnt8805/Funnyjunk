package com.patrickchristensen.funnyjunk.model;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ThumbnailContent {

    public static List<Thumbnail> ITEMS = new ArrayList<Thumbnail>();
    public static Map<String, Thumbnail> ITEM_MAP = new HashMap<String, Thumbnail>();

    static {
        // Add 3 sample items.
        addItem(new Thumbnail("1", "Item 1", null));
        addItem(new Thumbnail("2", "Item 2", null));
        addItem(new Thumbnail("3", "Item 3", null));
    }

    public static void addItem(Thumbnail item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A Thumbnail item representing a Thumbnail on the frontpage.
     */
    public static class Thumbnail {

        public String id;
        public String content;
        public Bitmap image;

        public Thumbnail(String id, String content, Bitmap image) {
            this.id = id;
            this.content = content;
            this.image = image;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
