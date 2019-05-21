package com.example.pacappthemeengine.processors;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.View;

import com.example.pacappthemeengine.ATE;
import com.example.pacappthemeengine.Config;
import com.example.pacappthemeengine.util.Util;

/**
 *
 */
public class NavigationViewProcessor implements Processor<NavigationView, Void> {

    @Override
    public void process(@NonNull Context context, @Nullable String key, @Nullable NavigationView view, @Nullable Void extra) {
        if (view == null || !Config.navigationViewThemed(context, key))
            return;

        boolean darkTheme = false;
        if (view.getBackground() != null && view.getBackground() instanceof ColorDrawable) {
            final ColorDrawable cd = (ColorDrawable) view.getBackground();
            darkTheme = !Util.isColorLight(cd.getColor());
        }

        final ColorStateList iconSl = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        Config.navigationViewNormalIcon(context, key, darkTheme),
                        Config.navigationViewSelectedIcon(context, key)
                });
        final ColorStateList textSl = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        Config.navigationViewNormalText(context, key, darkTheme),
                        Config.navigationViewSelectedText(context, key)
                });
        view.setItemTextColor(textSl);
        view.setItemIconTintList(iconSl);

        StateListDrawable bgDrawable = new StateListDrawable();
        bgDrawable.addState(new int[]{android.R.attr.state_checked}, new ColorDrawable(
                Config.navigationViewSelectedBg(context, key, darkTheme)));
        view.setItemBackground(bgDrawable);

        final View headerView = view.getHeaderView(0);
        if (headerView != null) ATE.apply(context, headerView, key);
    }
}
