package com.example.pacappthemeengine.processors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.pacappthemeengine.Config;
import com.example.pacappthemeengine.util.EdgeGlowUtil;

public class ListViewProcessor implements Processor<ListView, Void> {

    @Override
    public void process(@NonNull Context context, @Nullable String key, @Nullable ListView target, @Nullable Void extra) {
        if (target == null) return;
        EdgeGlowUtil.setEdgeGlowColor(target, Config.accentColor(context, key));
    }
}