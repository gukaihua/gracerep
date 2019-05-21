package com.example.pacappthemeengine.customizers;

import android.support.annotation.ColorInt;

import com.example.pacappthemeengine.Config;

public interface ATEStatusBarCustomizer {
    @ColorInt
    int getStatusBarColor();

    @Config.LightStatusBarMode
    int getLightStatusBarMode();
}
