package edu.niu.z1758468.myfavorites;

/**
 * Created by aberodriguez on 2/20/16.
 */
public class Teams {

        private String teamDescrip ;
        private int teamId;

        public Teams( String newDescrip, int newId)
        {
            teamDescrip = newDescrip;
            teamId = newId;
        }

        public int getTeamId () {return teamId;}
        public void setTeamId(int newId)
        {
            teamId = newId;
        }
        public String getTeamDescrip ()
        {
            return teamDescrip;
        }
        public void setTeamDescrip(String newDescrip)
        {
            teamDescrip = newDescrip;
        }
}
