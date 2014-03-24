package com.hacsoft.sparedeck;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class About extends Activity implements OnClickListener
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.about );

        Button btnOK = (Button) findViewById( R.id.OK );
        if ( btnOK != null ) {
            btnOK.setOnClickListener( this );
        }
    }

    @Override
    public void onClick( View v )
    {
        finish();
    }
}
