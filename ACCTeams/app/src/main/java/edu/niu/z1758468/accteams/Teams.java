//////////////////////////////////////////////////////////////////////////////////////////
// CSCI 322         Program: 2     Spring 2016
// Name: Abe Rodriguez
// Date Due: 3/4/2016
// Purpose: This application demonstrates the Intent and widget features. The app contains
//          a few Intent functions and widgets.
//          Class Teams sets new and handles team names and team ids passed.
/////////////////////////////////////////////////////////////////////////////////////////

package edu.niu.z1758468.accteams;

/**
 * Created by aberodriguez on 2/20/16.
 */
public class Teams
{
    // Variables
    private String teamDescrip ;
    private int teamId;

    // Teams function takes 2 arguements a String an Integer.
    // Returns: nothing
    // sets teamDescrip and teamId.
    public Teams( String newDescrip, int newId)
    {
        teamDescrip = newDescrip;
        teamId = newId;
    }

    // getTeamId function takes no arguements.
    // Returns: Int (Team Id)
    public int getTeamId () {return teamId;}

    // setTeam Id function takes 1 arguements, an Integer.
    // Returns: nothing
    // sets newId to teamId.
    public void setTeamId(int newId)
    {
        teamId = newId;
    }

    // getTeamDescrip function takes no arguements.
    // Returns: String
    public String getTeamDescrip () {return teamDescrip;}

    // setTeamDescrip function takes 1 arguements a String.
    // Returns: nothing
    // sets newDescrip to teamDescrip.
    public void setTeamDescrip(String newDescrip) {teamDescrip = newDescrip;}
}
