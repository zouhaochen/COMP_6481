package Assignment3;

import java.util.Scanner;

public class TVShow implements Watchable
{
    private String showID;
    private String showName;
    private double startTime;
    private double endTime;

    //parameterized constructor accepts four values and initializes to passed values
    public TVShow(String showID, String showName, double startTime, double endTime)
    {
        this.showID = showID;
        this.showName = showName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TVShow(TVShow tvShow, String showID)
    {
        this.showName = tvShow.showName;
        this.startTime = tvShow.startTime;
        this.endTime = tvShow.endTime;
        this.showID = showID;
    }

    //mutator of show ID
    public void setShowID(String showID)
    {
        this.showID = showID;
    }

    //accessor of show ID
    public String getShowID()
    {
        return showID;
    }

    //mutator of show name
    public void setShowName(String showName)
    {
        this.showName = showName;
    }

    //accessor of show name
    public String getShowName()
    {
        return showName;
    }

    //mutator of start time
    public void setStartTime(double startTime)
    {
        this.startTime = startTime;
    }

    //accessor of start time
    public double getStartTime()
    {
        return startTime;
    }

    //mutator of end time
    public void setEndTime(double endTime)
    {
        this.endTime = endTime;
    }

    //accessor of end time
    public double getEndTime()
    {
        return endTime;
    }

    //clone method
    protected Object clone(String showID) throws CloneNotSupportedException
    {
        System.out.println("Please enter a new show ID:");
        Scanner keyboard = new Scanner(System.in);
        showID = keyboard.nextLine();

        TVShow tvShow = (TVShow) super.clone();
        tvShow.setShowID(showID);
        keyboard.close();
        return tvShow;
    }

    public String toString()
    {
        return "show ID: " + getShowID() + " show name: " + getShowName() + " start time: " + getStartTime() + " end time: " + getEndTime();
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
            //two shows are equal with same attributes except for show ID
            TVShow tvShow = (TVShow) object;
            return (showName.equals(tvShow.getShowName()) && startTime == tvShow.getStartTime() && endTime == tvShow.getEndTime());
        }
    }

    @Override
    public String isOnSameTime(TVShow tvShow)
    {
        if(startTime == tvShow.getEndTime() && endTime == tvShow.getEndTime())
        {
            return "Same Time";
        }
        else if(startTime < tvShow.getEndTime() && endTime < tvShow.getEndTime())
        {
            return "Different Time";
        }
        else if(startTime > tvShow.getEndTime() && endTime > tvShow.getEndTime())
        {
            return "Different Time";
        }
        else
            return "Some Overlap";
    }
}
