package com.hacsoft.sparedeck.decks;

import java.util.ArrayList;

/**
 * Spare Deck - com.hacsoft.sparedeck.decks
 * Created by Fortyseven on 4/6/2014.
 */
public class Deck
{
    protected String          mDeckName;
    protected int             mDeckIconRes;
    protected ArrayList<Card> mCards;

    public Card getCard( int card_pos )
    {
        if ( card_pos > mCards.size() ) {
            throw new RuntimeException( "Card out of bounds: " + card_pos );
        }
        return mCards.get( card_pos );
    }

    public int getCardCount()
    {
        return mCards.size();
    }

    protected void addCard( String card_name, int card_image_res )
    {
        mCards.add( new Card( card_name, card_image_res ) );
    }

    protected void init( String deck_name, int deck_icon_res )
    {
        mCards = new ArrayList<Card>( 0 );
        mDeckName = deck_name;
        mDeckIconRes = deck_icon_res;
    }

    public int getDeckIconRes()
    {
        return mDeckIconRes;
    }
}
