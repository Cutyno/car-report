/*
 * Copyright 2012 Jan Kühle
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.kuehle.carreport.gui;

import android.os.Build;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import me.kuehle.carreport.R;
import me.kuehle.carreport.gui.util.AbstractPreferenceActivity;

public class PreferencesActivity extends AbstractPreferenceActivity implements
        ActivityCompat.OnRequestPermissionsResultCallback {
    @Override
    protected int getTitleResourceId() {
        return R.string.title_settings;
    }

    @Override
    protected int getHeadersResourceId() {
        return R.xml.preference_headers;
    }

    @Override
    protected Class[] getFragmentClasses() {
        return new Class[]{
                PreferencesGeneralFragment.class,
                PreferencesCarsFragment.class,
                PreferencesFuelTypesFragment.class,
                PreferencesRemindersFragment.class,
                PreferencesReportOrderFragment.class,
                PreferencesBackupFragment.class,
                PreferencesAboutFragment.class
        };
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (PreferenceFragment pf : getAttachedFragments()) {
                if (pf.isVisible()) {
                    Log.d("PrefAct", "Sending to "+ pf.getClass().getCanonicalName());
                    pf.onRequestPermissionsResult(requestCode, permissions, grantResults);
                }
            }
        }
    }
}
