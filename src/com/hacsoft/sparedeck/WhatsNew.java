package com.hacsoft.sparedeck;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

public class WhatsNew extends Activity implements OnClickListener
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.whatsnew );
        setTitle( R.string.about_whatsnewtext );
        getWindow().setLayout( LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT );
        ( (Button) findViewById( R.id.OK ) ).setOnClickListener( this );
    }

    @Override
    public void onClick( View v )
    {
        finish();
    }
}
