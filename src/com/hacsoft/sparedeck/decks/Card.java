package com.hacsoft.sparedeck.decks;

/**
 * Spare Deck - com.hacsoft.sparedeck.decks
 * Created by Fortyseven on 4/6/2014.
 */
public class Card
{
    public String name;
    public int    image_resource;

    public Card( String card_name, int image_res )
    {
        name = card_name;
        image_resource = image_res;
    }
}
