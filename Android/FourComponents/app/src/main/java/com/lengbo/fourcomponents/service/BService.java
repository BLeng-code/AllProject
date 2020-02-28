package com.lengbo.fourcomponents.service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

/**
 * date            2020-02-24
 * author          lengbo
 * description
 */
public class BService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
