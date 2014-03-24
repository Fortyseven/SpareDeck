package com.hacsoft.sparedeck;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class SpareDeck extends Activity
{
    static final String PREF_LASTVER    = "last_version";
    static final int    MENU_ABOUT      = 100;
    static final int    MENU_SHOWCONFIG = 101;

    private static List<Deck> decks = null;

    private SharedPreferences prefs = null;

    // private final Deck deck_pokedex = null;

    public class DeckSelectAdapter extends BaseAdapter
    {
        private final Context m_context;

        public DeckSelectAdapter( Context context, int textViewResourceId )
        {
            this.m_context = context;
        }

        @Override
        public int getCount()
        {
            return decks.size();
        }

        @Override
        public Object getItem( int position )
        {
            return decks.get( position );
        }

        @Override
        public long getItemId( int position )
        {
            return decks.get( position ).getThumbId();
        }

        @Override
        public View getView( int position, View convertView, ViewGroup parent )
        {
            if ( convertView == null ) {
                convertView = new ImageView( this.m_context );
            }

            ( (ImageView) ( convertView ) ).setImageResource( decks.get( position ).getThumbId() );
            ( (ImageView) ( convertView ) ).setLayoutParams( new GridView.LayoutParams( LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT ) );
            ( (ImageView) ( convertView ) ).setScaleType( ImageView.ScaleType.FIT_CENTER );
            // ((ImageView)(convertView)).setBackgroundResource(
            // mGalleryItemBackground );

            return convertView;
        }

    }

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        this.setContentView( R.layout.deckselect );

        // load our preferences
        this.prefs = PreferenceManager.getDefaultSharedPreferences( this );

        // define our decks
        Deck deck_default = new Deck( "Original 3DS AR Deck", R.drawable.deckoriginal );

        deck_default.addCard( "A-1: Question Block [?]", R.drawable.a1 );
        deck_default.addCard( "A-2: Mario", R.drawable.a2 );
        deck_default.addCard( "A-3: Link", R.drawable.a3 );
        deck_default.addCard( "A-4: Kirby", R.drawable.a4 );
        deck_default.addCard( "A-5: Samus", R.drawable.a5 );
        deck_default.addCard( "A-6: Pikmin", R.drawable.a6 );

        Deck deck_icarus = new Deck( "Kid Icarus: Uprising", R.drawable.deckicarus );
        deck_icarus.addCard( "Pit", R.drawable.icaruspit );
        deck_icarus.addCard( "Palutena", R.drawable.icaruspet );
        deck_icarus.addCard( "Medusa", R.drawable.icarusmed );

        Deck deck_vita = new Deck( "PS Vita", R.drawable.deckvita );
        deck_vita.addCard( "01", R.drawable.vita01 );
        deck_vita.addCard( "02", R.drawable.vita02 );
        deck_vita.addCard( "03", R.drawable.vita03 );
        deck_vita.addCard( "04", R.drawable.vita04 );
        deck_vita.addCard( "05", R.drawable.vita05 );
        deck_vita.addCard( "06", R.drawable.vita06 );

        // this.deck_pokedex = new Deck( "Pokedex 3D", R.drawable.deckpokedex );

        decks = Arrays.asList( deck_default, deck_icarus, deck_vita );

        // populate the gallery with our decks fed into a modified arrayadapter

        GridView gal = (GridView) this.findViewById( R.id.deckselectgallery );

        gal.setAdapter( new DeckSelectAdapter( this, 0 ) );

        gal.setOnItemClickListener( new OnItemClickListener()
        {

            @Override
            public void onItemClick( AdapterView parent, View v, int position, long id )
            {
                Intent i = new Intent( parent.getContext(), DeckViewer.class );
                i.putExtra( "deck_id", position );
                SpareDeck.this.startActivity( i );
            }
        } );

        // finally, show off whatever is new
        this.showWhatsNew();
    }

    public static Deck getDeck( int id )
    {
        return decks.get( id );
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item )
    {
        Intent i;

        switch ( item.getItemId() ) {
            case SpareDeck.MENU_SHOWCONFIG:
                i = new Intent( this, ShowConfig.class );
                this.startActivity( i );
                break;
            case SpareDeck.MENU_ABOUT:
                i = new Intent( this, About.class );
                this.startActivity( i );
                break;
        }
        return super.onOptionsItemSelected( item );
    }

    public void showWhatsNew()
    {
        if ( this.prefs.contains( PREF_LASTVER ) ) {
            if ( this.prefs.getString( PREF_LASTVER, null ).contentEquals( this.getString( R.string.version ) ) ) {
                // Already showed the box (version last shown == current
                // version)
                return;
            }
        }

        this.prefs.edit().putString( PREF_LASTVER, this.getString( R.string.version ) ).commit();

        Intent i = new Intent( this, WhatsNew.class );
        startActivity( i );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        menu.add( 0, MENU_SHOWCONFIG, 0, "Settings" );
        menu.add( 0, MENU_ABOUT, 0, "About" );
        return super.onCreateOptionsMenu( menu );
    }
}
