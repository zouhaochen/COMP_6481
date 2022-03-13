package Assignment2;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sales implements Serializable
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

    //default constructor
    public Sales()
    {
        country = "";
        itemType = "";
        orderPriority = Character.MIN_VALUE;
        orderDate = null;
        orderID = 0;
        shipDate = null;
        unitsSold = 0;
        unitPrice = 0;
        unitCost = 0;
        revenue = 0;
        totalCost = 0;
        totalProfit = 0;
    }

    //constructor
    public Sales(String country, String itemType, char orderPriority, Date orderDate,
                 long orderID, Date shipDate, int unitsSold, float unitPrice,
                 float unitCost, double revenue, double totalCost, double totalProfit)
    {
        this.country = country;
        this.itemType = itemType;
        this.orderPriority = orderPriority;
        this.orderDate = orderDate;
        this.orderID = orderID;
        this.shipDate = shipDate;
        this.unitsSold = unitsSold;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.revenue = revenue;
        this.totalCost = totalCost;
        this.totalProfit = totalProfit;
    }

    //copy constructor
    public Sales(Sales sales)
    {
        if(sales == null)
        {
            System.out.println("Fatal error");
            System.exit(0);
        }
        this.country = sales.country;
        this.itemType = sales.itemType;
        this.orderPriority = sales.orderPriority;
        this.orderDate = sales.orderDate;
        this.orderID = sales.orderID;
        this.shipDate = sales.shipDate;
        this.unitsSold = sales.unitsSold;
        this.unitPrice = sales.unitPrice;
        this.unitCost = sales.unitCost;
        this.revenue = sales.revenue;
        this.totalCost = sales.totalCost;
        this.totalProfit = sales.totalProfit;
    }

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

    public String toString()
    {
        return getCountry() + " " + getItemType() + " " + getOrderPriority() + " " + getOrderDate() + " " +
                getOrderID() + " " + getShipDate() + " " + getUnitsSold() + " " + getUnitPrice() + " " +
                getUnitCost() + " " + getRevenue() + " " + getTotalCost() + " " + getTotalProfit() + " ";
    }

    public boolean equals(Object object)
    {
        if(object == null)
        {
            return false;
        }
        else if(getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            Sales sales = (Sales) object;
            return (country.equals(sales.country) && itemType.equals(sales.itemType) && orderPriority == sales.orderPriority &&
                    orderDate.equals(sales.orderDate) && orderID == sales.orderID && shipDate.equals(sales.shipDate) &&
                    unitsSold == sales.unitsSold && unitPrice == sales.unitPrice && unitCost == sales.unitCost &&
                    revenue == sales.revenue && totalCost == sales.totalCost && totalProfit == sales.totalProfit);
        }
    }

}
