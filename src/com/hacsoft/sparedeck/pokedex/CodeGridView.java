package com.hacsoft.sparedeck.pokedex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class CodeGridView extends View
{
    private static final int GRID_SIZE   = 8;
    private static final int BITS_WIDTH  = 4;
    private static final int BITS_HEIGHT = 4;

    private final Paint paint = new Paint();

    private Display display      = null;
    private float   width        = (float) 1.0;
    private float   height       = (float) 1.0;
    private String  mCode        = "";
    private float   mBlockWidth  = 0;
    private float   mBlockHeight = 0;

    public CodeGridView( Context context, AttributeSet attrs )
    {
        super( context, attrs );

        display = ( (WindowManager) getContext().getSystemService( Context.WINDOW_SERVICE ) ).getDefaultDisplay();

        invalidate();
        setCode( 7520 );
        setCode( 26830 );

    }

    /*********************************************************************/
    // @Override
    // protected void onSizeChanged( int w, int h, int oldw, int oldh )
    // {
    // // mBlockWidth = width / GRID_SIZE;
    // // mBlockHeight = height / GRID_SIZE;
    // //
    // // invalidate();
    // super.onSizeChanged( w, h, oldw, oldh );
    // }
    //

    float z = 0;

    @Override
    protected void onDraw( Canvas canvas )
    {

        int val;
        RectF r = new RectF();

        z += 0.5;

        mBlockWidth = (float) ( 1.0 / GRID_SIZE );
        mBlockHeight = (float) ( 1.0 / GRID_SIZE );

        width = (float) 1.0;
        height = (float) 1.0;

        float scale = getWidth();
        canvas.save( Canvas.MATRIX_SAVE_FLAG );
        canvas.scale( scale, scale );
        canvas.rotate( z, 0.5f, 0.5f );

        // Paint the outer border
        paint.setColor( Color.WHITE );
        r.top = 0;
        r.bottom = height;
        r.left = 0;
        r.right = width;
        canvas.drawRect( r, paint );

        // Paint the inner border
        paint.setColor( Color.BLACK );
        r.top = mBlockHeight;
        r.bottom = height - mBlockHeight;
        r.left = mBlockWidth;
        r.right = width - mBlockWidth;
        canvas.drawRect( r, paint );

        // Paint the bits
        int bit_position = 0;
        float BIT_DRAW_OFFSET_X = 0 + ( mBlockWidth * 2 );
        float BIT_DRAW_OFFSET_Y = 0 + ( mBlockHeight * 2 );

        for ( int y = 0; y < BITS_HEIGHT; y++ ) {
            for ( int x = 0; x < BITS_WIDTH; x++ ) {
                val = 0;

                if ( bit_position < mCode.length() ) {
                    val = mCode.charAt( bit_position ) == '0' ? 0 : 1;
                }
                else {
                    val = 0;
                }

                if ( val == 0 ) {
                    paint.setColor( Color.WHITE );
                }
                else {
                    paint.setColor( Color.BLACK );
                }

                r.top = BIT_DRAW_OFFSET_Y + ( y * mBlockHeight );
                r.left = BIT_DRAW_OFFSET_X + ( x * mBlockWidth );
                r.bottom = r.top + mBlockHeight;
                r.right = r.left + mBlockWidth;
                canvas.drawRect( r, paint );
                bit_position++;
            }
        }
        paint.setColor( Color.RED );

        canvas.drawText( "Hello, asshole", 5, 30, paint );
        invalidate();

        super.onDraw( canvas );
    }

    @Override
    protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec )
    {
        int widthMode = MeasureSpec.getMode( widthMeasureSpec );
        int widthSize = MeasureSpec.getSize( widthMeasureSpec );

        int heightMode = MeasureSpec.getMode( heightMeasureSpec );
        int heightSize = MeasureSpec.getSize( heightMeasureSpec );

        int chosenWidth = chooseDimension( widthMode, widthSize );
        int chosenHeight = chooseDimension( heightMode, heightSize );

        int chosenDimension = Math.min( chosenWidth, chosenHeight );

        setMeasuredDimension( chosenDimension, chosenDimension );
    }

    private int chooseDimension( int mode, int size )
    {
        if ( mode == MeasureSpec.AT_MOST || mode == MeasureSpec.EXACTLY ) {
            return size;
        }
        else { // (mode == MeasureSpec.UNSPECIFIED)
            return getPreferredSize();
        }
    }

    private int getPreferredSize()
    {
        return 300;
    }

    void setCode( int i )
    {
        this.mCode = new StringBuffer( Integer.toBinaryString( i ) ).reverse().toString();
    }

    // @Override
    // protected void onConfigurationChanged( Configuration newConfig )
    // {
    // // TODO Auto-generated method stub
    // super.onConfigurationChanged( newConfig );
    // }

}
