package com.example.pacappthemeengine.customizers;

import android.support.annotation.ColorInt;

import com.example.pacappthemeengine.Config;

public interface ATEToolbarCustomizer {
    @Config.LightToolbarMode
    int getLightToolbarMode();

    @ColorInt
    int getToolbarColor();
}
