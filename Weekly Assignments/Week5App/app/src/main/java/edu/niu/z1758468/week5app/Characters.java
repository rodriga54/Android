package edu.niu.z1758468.week5app;

/**
 * Created by z1758468 on 2/16/2016.
 */
public class Characters
{
    private String characterDescrip ;
    private int characterId;

    public Characters( String newDescrip, int newId)
    {
        characterDescrip = newDescrip;
        characterId = newId;
    }

    public int getCharacterId ()
    {
        return characterId;
    }
    public void setCharacterDescrip(int newId)
    {
        characterId = newId;
    }
    public String getCharacterDescrip ()
    {
        return characterDescrip;
    }
    public void setCharacterDescrip(String newDescrip)
    {
        characterDescrip = newDescrip;
    }

}
