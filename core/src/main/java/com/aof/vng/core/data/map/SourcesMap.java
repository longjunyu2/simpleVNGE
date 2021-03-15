package com.aof.vng.core.data.map;

import android.util.Log;

import java.util.HashMap;

public class SourcesMap implements Map{

    private HashMap<String, String> sourcesMap;
    private static final String TAG = "SourcesMap";

    @Override
    public String getSourcePath(String sourceId) {
        try {
            return sourcesMap.get(sourceId);
        } catch (NullPointerException e) {
            e.printStackTrace();
            if (sourceId == null)
                Log.e(TAG, "SourceId is null.");
            if (sourcesMap == null)
                Log.e(TAG, "SourcesMap is null.");
        }
        return null;
    }
}
