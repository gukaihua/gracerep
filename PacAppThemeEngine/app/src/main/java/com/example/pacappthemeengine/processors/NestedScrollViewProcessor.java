package com.example.pacappthemeengine.processors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;

import com.example.pacappthemeengine.Config;
import com.example.pacappthemeengine.util.EdgeGlowUtil;

public class NestedScrollViewProcessor implements Processor<NestedScrollView, Void> {

    @Override
    public void process(@NonNull Context context, @Nullable String key, @Nullable NestedScrollView target, @Nullable Void extra) {
        if (target == null) return;
        EdgeGlowUtil.setEdgeGlowColor(target, Config.accentColor(context, key));
    }
}
