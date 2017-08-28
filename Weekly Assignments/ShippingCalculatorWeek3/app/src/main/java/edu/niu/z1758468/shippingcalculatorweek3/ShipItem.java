package edu.niu.z1758468.shippingcalculatorweek3;

/**
 * Created by z1758468 on 2/2/2016.
 */
public class ShipItem
{
    //Constant
    static final Double BASE_AMOUNT = 3.00;
    static final Double ADDED_COST = .50;
    static final Integer BASE_WEIGHT = 16;
    static final Double EXTRA_WEIGHT = 4;

    // Instance Variables
    private Integer weight;
    private Double baseCost, addedCost, totalCost;

    //Constructor
    public ShipItem()
    {
        weight = 0;
        baseCost = BASE_AMOUNT;
        addedCost = totalCost = 0.0;
    }// end of Constructor.

    //
    public void setWeight (int newWeight )
    {
        weight = newWeight;

        // calculate
        computeCost ();

    }// end of setWeight

    public void computeCost ()
    {
        // initialized
        addedCost = 0.0;
        baseCost = BASE_AMOUNT;

        if (weight <= 0)
            baseCost = 0.00;
        else if (weight > BASE_WEIGHT)
            addedCost = Math.ceil( (double)(weight - BASE_WEIGHT) / EXTRA_WEIGHT)* ADDED_COST;

        totalCost = baseCost + addedCost;

    }// End of computeCost

    public Double getBaseCost() {
        return baseCost;
    }

    public static Double getAddedCost() {
        return ADDED_COST;
    }

    public Double getTotalCost() {
        return totalCost;
    }


}// end of ShipItem.
