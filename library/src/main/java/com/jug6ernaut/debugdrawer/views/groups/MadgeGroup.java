package com.jug6ernaut.debugdrawer.views.groups;

import android.app.Activity;
import android.widget.GridLayout;
import com.jakewharton.madge.MadgeFrameLayout;
import com.jug6ernaut.debugdrawer.R;
import com.jug6ernaut.debugdrawer.preference.BooleanPreference;
import com.jug6ernaut.debugdrawer.views.DebugGroup;
import com.jug6ernaut.debugdrawer.views.ToggleElement;
import timber.log.Timber;

import static butterknife.ButterKnife.findById;

/**
 * Created by williamwebb on 7/2/14.
 */
public class MadgeGroup extends DebugGroup {

    BooleanPreference pixelGridEnabled;
    BooleanPreference pixelRatioEnabled;
    MadgeFrameLayout madgeFrameLayout;
    ToggleElement uiPixelGridElement;
    ToggleElement uiPixelRatioElement;

    public MadgeGroup(Activity activity) {
        super("Madge", activity);

        pixelGridEnabled = new BooleanPreference(prefs,"pixelGridEnabled");
        pixelRatioEnabled = new BooleanPreference(prefs,"pixelRatioEnabled");

        uiPixelGridElement = new ToggleElement("Pixel Grid",activity) {
            @Override
            public void onAction(Boolean isChecked) {
                Timber.d("Setting pixel grid overlay enabled to " + isChecked);
                pixelGridEnabled.set(isChecked);
                madgeFrameLayout.setOverlayEnabled(isChecked);
                uiPixelRatioElement.setEnabled(isChecked);
            }
        };
        addElement(uiPixelGridElement);

        uiPixelRatioElement = new ToggleElement("Pixel Scale",activity) {
            @Override
            public void onAction(Boolean isChecked) {
                Timber.d("Setting pixel scale overlay enabled to " + isChecked);
                pixelRatioEnabled.set(isChecked);
                madgeFrameLayout.setOverlayRatioEnabled(isChecked);
            }
        };
        addElement(uiPixelRatioElement);
    }

    @Override
    public void onAttach(GridLayout gridLayout){
        madgeFrameLayout = findById(activity, R.id.madge_container);

        boolean gridEnabled = pixelGridEnabled.get();
        madgeFrameLayout.setOverlayEnabled(gridEnabled);
        uiPixelGridElement.setChecked(gridEnabled);
        uiPixelRatioElement.setEnabled(gridEnabled);

        boolean ratioEnabled = pixelRatioEnabled.get();
        madgeFrameLayout.setOverlayRatioEnabled(ratioEnabled);
        uiPixelRatioElement.setChecked(ratioEnabled);
    }
}
