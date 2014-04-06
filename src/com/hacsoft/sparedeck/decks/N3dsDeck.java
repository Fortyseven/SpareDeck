package com.hacsoft.sparedeck.decks;

import com.hacsoft.sparedeck.R;

/**
 * Spare Deck - com.hacsoft.sparedeck.decks
 * Created by Fortyseven on 4/6/2014.
 */
public class N3dsDeck extends Deck
{

    public N3dsDeck()
    {
        init( "Original 3DS AR Deck", R.drawable.deckoriginal );

        addCard( "A-1: Question Block [?]", R.drawable.a1 );
        addCard( "A-2: Mario", R.drawable.a2 );
        addCard( "A-3: Link", R.drawable.a3 );
        addCard( "A-4: Kirby", R.drawable.a4 );
        addCard( "A-5: Samus", R.drawable.a5 );
        addCard( "A-6: Pikmin", R.drawable.a6 );
    }

}
