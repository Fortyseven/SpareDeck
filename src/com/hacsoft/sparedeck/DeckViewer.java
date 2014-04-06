package com.hacsoft.sparedeck;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hacsoft.sparedeck.decks.Deck;

public class DeckViewer extends Activity
{
    private Deck              mDeck    = null;
    private SharedPreferences prefs    = null;
    private LinearLayout      mContent = null;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.deck );

        mDeck = SpareDeck.getDeck( getIntent().getExtras().getInt( "deck_id" ) );
        prefs = PreferenceManager.getDefaultSharedPreferences( this );

        mContent = (LinearLayout) findViewById( R.id.deckviewer_content );

        HorizontalScrollView foo = new HorizontalScrollView( this );

        ImageView iv;
        iv = new ImageView( this );
        iv.setImageResource( R.drawable.vita01 );
        mContent.addView( iv );
        for ( int i = 0; i < mDeck.getCardCount(); i++ ) {
            iv = new ImageView( this );
            iv.setImageResource( mDeck.getCard( i ).image_resource );
            mContent.addView( iv );
        }
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita02 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
//        iv = new ImageView( this );
//        iv.setImageResource( R.drawable.vita03 );
//        mContent.addView( iv );
    }

    public void updateSettings()
    {
        if ( prefs.getBoolean( "stay_awake", false ) ) {
            // ( (Gallery) ( findViewById( R.id.gallery ) ) ).setKeepScreenOn(
            // true );
        }
        else {
            // ( (Gallery) ( findViewById( R.id.gallery ) ) ).setKeepScreenOn(
            // false );
        }

        // brightness
        float bri = (float) ( prefs.getInt( "screen_brightness", 0 ) / 100.0 );

        if ( bri == 0.0 ) {
            bri = (float) -1.0;
        }

        Window mywindow = getWindow();
        WindowManager.LayoutParams lp = mywindow.getAttributes();
        lp.screenBrightness = bri;

        mywindow.setAttributes( lp );
    }
}

// public class DeckViewer extends Activity
// {
//
// class DeckAdapter extends BaseAdapter
// {
// // class GalleryPane
// // {
// // public int position;
// // public Bitmap bitmap;
// // }
//
// // GalleryPane mGalleryPanes[];
//
// // Bitmap bitmaps[];
//
// Deck deck = null;
//
// int cock_count = 0;
//
// public DeckAdapter(Deck deck)
// {
// this.deck = deck;
//
// // bitmaps = new Bitmap[deck.count()];
// // for ( int i = 0; i < deck.count(); i++ ) {
// // Log.i( "HSD", "#" + i );
// // bitmaps[ i ] = BitmapFactory.decodeResource( getResources(),
// // deck.getCard( i ).getId() );
// // }
// }
//
// @Override
// public int getCount()
// {
// return deck.count();
// }
//
// @Override
// public Object getItem( int position )
// {
// return deck.getCard( position );
// }
//
// @Override
// public long getItemId( int position )
// {
// return deck.getCard( position ).getId();
// }
//
// // private final Bitmap b = null;
//
// @Override
// public View getView( int position, View view, ViewGroup parentgroup )
// {
// ImageView iv = (ImageView) view;
//
// try
// {
// if ( iv == null ) {
// Log.e( "HSD", "Creating" );
// iv = new ImageView( parentgroup.getContext() );
// iv.setScaleType( ScaleType.FIT_CENTER );
//
// }
// else {
// Log.e( "HSD", "Recycling" );
// // if ( iv.getDrawable() != null )
// // ( (BitmapDrawable) ( iv.getDrawable() )
// // ).getBitmap().recycle();
// //
// // iv.setImageDrawable( null );
// // iv.setImageBitmap( null );
// // iv = new ImageView( parentgroup.getContext() );
// }
//
// Card card = (Card) getItem( position );
//
// iv.setImageResource( card.getId() );
// }
// catch ( OutOfMemoryError e ) {
// Log.e( "HSD", "OH GOD OH GOD" );
// return iv;
// }
//
// return iv;
// }
// }
//
// class DeckPager extends PagerAdapter
// {
//
// @Override
// public int getCount()
// {
// // TODO Auto-generated method stub
// return 0;
// }
//
// @Override
// public boolean isViewFromObject( View view, Object object )
// {
// return view == ( (TextView) object );
// }
//
// }
//
// Deck mDeck;
// SharedPreferences prefs;
//
// /*******************************************************************************/
// @Override
// public void onCreate( Bundle savedInstanceState )
// {
// super.onCreate( savedInstanceState );
// setContentView( R.layout.deck );
//
// mDeck = SpareDeck.getDeck( getIntent().getExtras().getInt( "deck_id" ) );
//
// prefs = PreferenceManager.getDefaultSharedPreferences( this );
//
// // GridView grid = (GridView) findViewById( R.id.grid );
// // grid.setAdapter( new DeckAdapter( mDeck ) );
//
// ViewPager vp = (ViewPager) findViewById( R.id.pager );
// vp.setAdapter( new DeckPager() );
//
// // Gallery g = (Gallery) findViewById( R.id.gallery );
// //
// // g.setAdapter( new DeckAdapter( mDeck ) );
// //
// // g.setOnItemClickListener( new OnItemClickListener() {
// // public void onItemClick( AdapterView parent, View v, int position,
// // long id )
// // {
// // Toast.makeText( DeckViewer.this, mDeck.getCard( position ).getName(),
// // Toast.LENGTH_SHORT ).show();
// // }
// // } );
// }
//
// /*******************************************************************************/
// public void updateSettings()
// {
// if ( prefs.getBoolean( "stay_awake", false ) ) {
// // ( (Gallery) ( findViewById( R.id.gallery ) ) ).setKeepScreenOn(
// // true );
// }
// else {
// // ( (Gallery) ( findViewById( R.id.gallery ) ) ).setKeepScreenOn(
// // false );
// }
//
// // brightness
// float bri = (float) ( prefs.getInt( "screen_brightness", 0 ) / 100.0 );
//
// if ( bri == 0.0 ) {
// bri = (float) -1.0;
// }
//
// Window mywindow = getWindow();
// WindowManager.LayoutParams lp = mywindow.getAttributes();
// lp.screenBrightness = bri;
//
// mywindow.setAttributes( lp );
// }
//
// /*******************************************************************************/
// @Override
// public boolean onOptionsItemSelected( MenuItem item )
// {
// Intent i;
//
// switch ( item.getItemId() )
// {
// case SpareDeck.MENU_SHOWCONFIG:
// i = new Intent( this, ShowConfig.class );
// startActivity( i );
// break;
// case SpareDeck.MENU_ABOUT:
// i = new Intent( this, About.class );
// startActivity( i );
// break;
// }
// return super.onOptionsItemSelected( item );
// }
//
// /*******************************************************************************/
// @Override
// protected void onResume()
// {
// super.onResume();
// System.gc();
// updateSettings();
// }
//
// /*******************************************************************************/
// @Override
// public boolean onCreateOptionsMenu( Menu menu )
// {
// menu.add( 0, SpareDeck.MENU_SHOWCONFIG, 0, "Settings" );
// menu.add( 0, SpareDeck.MENU_ABOUT, 0, "About" );
// return super.onCreateOptionsMenu( menu );
// }
//
// /*******************************************************************************/
// @Override
// protected void onDestroy()
// {
// System.gc();
// super.onDestroy();
// }
//
// public void gridClick( View v )
// {
//
// }
//
// }