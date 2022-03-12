package Assignment2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sales
{
    //sales attributes
    private String country;
    private String itemType;
    private char orderPriority;
    private Date orderDate;
    private long orderID;
    private Date shipDate;
    private int unitsSold;
    private float unitPrice;
    private float unitCost;
    private double revenue;
    private double totalCost;
    private double totalProfit;

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return country;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }

    public String getItemType()
    {
        return itemType;
    }

    public void setOrderPriority(char orderPriority)
    {
        this.orderPriority = orderPriority;
    }

    public char getOrderPriority()
    {
        return orderPriority;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    //return date information in "dd-mm-yyyy" format
    public String getOrderDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String dateFormatInString = dateFormat.format(orderDate);
        return dateFormatInString;
    }

    public void setOrderID(long orderID)
    {
        this.orderID = orderID;
    }

    public long getOrderID()
    {
        return orderID;
    }

    public void setShipDate(Date shipDate)
    {
        this.shipDate = shipDate;
    }

    //return date information in "dd-mm-yyyy" format
    public String getShipDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String dateFormatInString = dateFormat.format(shipDate);
        return dateFormatInString;
    }

    public void setUnitsSold(int unitsSold)
    {
        this.unitsSold = unitsSold;
    }

    public int getUnitsSold()
    {
        return unitsSold;
    }

    public void setUnitPrice(float unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public float getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitCost(float unitCost)
    {
        this.unitCost = unitCost;
    }

    public float getUnitCost()
    {
        return unitCost;
    }

    public void setRevenue(double revenue)
    {
        this.revenue = revenue;
    }

    public double getRevenue()
    {
        return revenue;
    }

    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public void setTotalProfit(double totalProfit)
    {
        this.totalProfit = totalProfit;
    }

    public double getTotalProfit()
    {
        return totalProfit;
    }
}
