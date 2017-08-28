package edu.niu.z1758468.burgerweek4;

/**
 * Created by Z1758468 on 2/9/2016.
 */
public class Burger
{
    //Constants
    static final int BEEF = 90, TURKEY = 170, VEGGIE = 150,
            CHEDDAR = 113, MOZZ = 78,
            BACON = 86;

    // Instance Variables
    private int pattyCalories, cheesCalories, baconCalories, sauceCalories;

    // Constructor
    public Burger ()
    {
        // Set the calories.
        pattyCalories = BEEF;
        cheesCalories = 0;
        baconCalories = 0;
        sauceCalories = 0;
    }// End of Constructor

    public void setPattyCalories (int newCalories)
    {
        pattyCalories = newCalories;
    }
    public void setCheesCalories (int newCalories)
    {
        cheesCalories = newCalories;
    }
    public void setSauceCalories (int newCalories)
    {
        sauceCalories = newCalories;
    }
    public void setBaconCalories (boolean hasBacon)
    {
        if (hasBacon)
            baconCalories = BACON;
        else
            baconCalories = 0;
    }
    public int getTotalCalories ( )
    {
        return baconCalories + pattyCalories + cheesCalories + sauceCalories;
    }



}// End of Burger
