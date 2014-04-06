package com.hacsoft.sparedeck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.hacsoft.sparedeck.decks.Deck;
import com.hacsoft.sparedeck.decks.IcarusDeck;
import com.hacsoft.sparedeck.decks.N3dsDeck;
import com.hacsoft.sparedeck.decks.VitaDeck;

import java.util.ArrayList;

public class SpareDeck extends Activity
{
    static final String PREF_LASTVER    = "last_version";
    static final int    MENU_ABOUT      = 100;
    static final int    MENU_SHOWCONFIG = 101;

    public static ArrayList<Deck> decks = null;

    private SharedPreferences prefs = null;

    // private final Deck deck_pokedex = null;


    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        this.setContentView( R.layout.deckselect );

        // load our preferences
        this.prefs = PreferenceManager.getDefaultSharedPreferences( this );

        // define our decks

        decks = new ArrayList<Deck>( 0 );

        decks.add( new N3dsDeck() );
        decks.add( new IcarusDeck() );
        decks.add( new VitaDeck() );

        // this.deck_pokedex = new Deck( "Pokedex 3D", R.drawable.deckpokedex );

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

        Intent i = new Intent( this, About.class );
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
