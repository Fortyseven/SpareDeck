package com.hacsoft.sparedeck;

class Card
{
    private final String m_name;
    private final int    m_resid;

    public Card( String name, int resource_id )
    {
        this.m_name = name;
        this.m_resid = resource_id;
    }

    public int getId()
    {
        return m_resid;
    }

    public String getName()
    {
        return m_name;
    }
}
