package Course.Week9;

import java.util.ArrayList;
import java.util.Scanner;

import static Course.Week9.WayPoint.calcDis;

/*
Many Global Positioning Satellite (GPS) units can record way points.
The way point marks the coordinates of a location on a map along with a timestamp.
Consider a GPS unit that stores way points in terms of an (X,Y) coordinate on a map
together with a timestamp t that records the number of seconds that have elapsed since the unit was turned on.
Write a program that allows the user to enter as many way points as desired,
storing each way point in an ArrayList , where each way point is represented by a class that you design.
Each way point represents a successive sample point during a hike along some route.
The coordinates should be input as double s, and the timestamp as an integer.
Have your program compute the total distance traveled and the average speed in miles per hour.
Use the map scaling factor of 1 = 0.1 miles.
For example, if the only two way points are (X=1,Y=1,T=0) and (X=2,Y=1,T=3600),
then the hiker traveled a distance of 0.1 miles in 3,600 seconds, or 0.1 miles per hour.
*/
public class Question3
{
    public static void main(String[] args)
    {
        Scanner qq = new Scanner(System.in);
        ArrayList coords= new ArrayList();
        String dd = "y";

        while(dd.equalsIgnoreCase("y"))
        {
            System.out.println("Type in coordinates:");

            System.out.print("X coord:");
            double xcor = qq.nextDouble();

            System.out.print("Y coord:");
            double ycor = qq.nextDouble();

            System.out.print("Type Time:");
            int Ttime = qq.nextInt();

            qq.nextLine();
            coords.add(new WayPoint(xcor,ycor,Ttime));

            System.out.println("Enter more coords Y/N");
            dd = qq.nextLine();
        }

        double td = 0;
        int mT=0;

        for(int i =0; i<coords.size()-1;i++)
        {
            WayPoint f1 = (WayPoint) coords.get(i);
            WayPoint s2 = (WayPoint) coords.get(i+1);

            td+=calcDis(f1,s2);

            if(f1.getTS()>mT)
            {
                mT = f1.getTS();
            }

            if(s2.getTS()>mT)
            {
                mT = s2.getTS();
            }
        }

        td*=.1;
        System.out.println("You traveled " +  td+ " miles");
        System.out.println("The avg speed is "+ td/(mT/3600)+"MPH");
    }
}

class WayPoint {
    private double positionX;
    private double positionY;
    private int tS;

    public WayPoint(double xx, double yy, int t) {
        positionX = xx;
        positionY = yy;
        tS = t;
    }

    public void setPosY(double YY) {
        positionY = YY;
    }

    public void setPosX(double XX) {
        positionX = XX;
    }

    public void setTs(int TT) {
        tS = TT;
    }

    public double getPosY() {
        return positionY;
    }

    public double getPosX() {
        return positionX;
    }

    public int getTS() {
        return tS;
    }

    public static double calcDis(WayPoint p1, WayPoint p2)
    {
        double xxx = p1.getPosX() - p2.getPosX();
        double yyy = p1.getPosY() - p2.getPosY();
        return Math.sqrt((xxx * xxx) + (yyy * yyy));
    }
}
