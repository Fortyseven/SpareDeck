package com.hacsoft.sparedeck.decks;

import com.hacsoft.sparedeck.R;

/**
 * Spare Deck - com.hacsoft.sparedeck.decks
 * Created by Fortyseven on 4/6/2014.
 */
public class IcarusDeck extends Deck
{
    public IcarusDeck()
    {
        init( "Kid Icarus: Uprising", R.drawable.deckicarus );
        addCard( "Pit", R.drawable.icaruspit );
        addCard( "Palutena", R.drawable.icaruspet );
        addCard( "Medusa", R.drawable.icarusmed );
    }
}
