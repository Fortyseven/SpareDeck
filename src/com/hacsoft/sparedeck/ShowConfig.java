package com.hacsoft.sparedeck;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class ShowConfig extends PreferenceActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        addPreferencesFromResource( R.xml.prefs );
    }
}
