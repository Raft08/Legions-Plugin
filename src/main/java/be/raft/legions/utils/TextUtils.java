package be.raft.legions.utils;

import com.google.gson.GsonBuilder;

public class TextUtils {
    public static String toJson(Object obj) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(obj);
    }
}
