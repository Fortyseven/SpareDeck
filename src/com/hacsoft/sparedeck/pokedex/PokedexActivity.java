package com.hacsoft.sparedeck.pokedex;

import android.app.Activity;
import android.os.Bundle;

import com.hacsoft.sparedeck.R;

public class PokedexActivity extends Activity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.pokedex_main );

    }
}
