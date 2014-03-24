package com.hacsoft.sparedeck;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


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
        return SpareDeck.decks.size();
    }

    @Override
    public Object getItem( int position )
    {
        return SpareDeck.decks.get( position );
    }

    @Override
    public long getItemId( int position )
    {
        return SpareDeck.decks.get( position ).getThumbId();
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent )
    {
        if ( convertView == null ) {
            convertView = new ImageView( this.m_context );
        }

        ( (ImageView) ( convertView ) ).setImageResource( SpareDeck.decks.get( position ).getThumbId() );
        ( (ImageView) ( convertView ) ).setLayoutParams( new GridView.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ) );
        ( (ImageView) ( convertView ) ).setScaleType( ImageView.ScaleType.FIT_CENTER );
        // ((ImageView)(convertView)).setBackgroundResource(
        // mGalleryItemBackground );

        return convertView;
    }

}