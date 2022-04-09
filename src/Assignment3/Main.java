package Assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main
{
    private static String tVGuidePath = "src/Assignment3/Data/TVGuide.txt";
    private static String interestPath = "src/Assignment3/Data/Interest.txt";

    public static void main(String[] args)
    {
        //read and store tv guide content
        File tvGuide = new File(tVGuidePath);
        String tvGuideContent = txtToString(tvGuide);
        String[] tvGuideArray = stringToArray(tvGuideContent);
        ArrayList<String> tvGuideArrayList = stringArrayList(tvGuideArray);

        //count the number of tv show
        int numberOfTvShow = tvGuideArrayList.size()/3;

        //create tv show array to first store tv guide information
        TVShow[] tvShowArray = new TVShow[numberOfTvShow];

        //store tv show information
        for(int i = 0; i < tvShowArray.length; i++)
        {
            //initialize current tv show
            TVShow tvShow = new TVShow();

            //get and set show id and show name
            String showIDAndShowName = tvGuideArrayList.get(i * 3 + 0);
            String[] showIDAndShowNameArray = showIDAndShowName.split(" ");

            String showID = showIDAndShowNameArray[0];
            String showName = showIDAndShowNameArray[1];

            tvShow.setShowID(showID);
            tvShow.setShowName(showName);

            //get and set show start time
            double startTime = 0;
            String startTimeInStringTotal = tvGuideArrayList.get(i * 3 + 1);
            String[] startTimeInStringArray = startTimeInStringTotal.split(" ");
            String startTimeInString = startTimeInStringArray[1];

            try
            {
                startTime = Double.parseDouble(startTimeInString);
            }
            catch (Exception e)
            {
                System.out.println("Exception occur in parse string to double.");
            }

            tvShow.setStartTime(startTime);

            //get and set show end time
            double endTime = 0;
            String endTimeInStringTotal = tvGuideArrayList.get(i * 3 + 2);
            String[] endTimeInStringArray = endTimeInStringTotal.split(" ");
            String endTimeInString = endTimeInStringArray[1];

            try
            {
                endTime = Double.parseDouble(endTimeInString);
            }
            catch (Exception e)
            {
                System.out.println("Exception occur in parse string to double.");
            }

            tvShow.setEndTime(endTime);

            tvShowArray[i] = tvShow;
        }

        //show list of tv guide
        ShowList tvGuideLinkList = new ShowList();

        //add tv show into show list
        for(int i = 0; i < tvShowArray.length; i++)
        {
            tvGuideLinkList.addNode(tvShowArray[i]);
        }


    }

    public static String txtToString(File file)
    {
        String result = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine())!=null)
            {
                result = result + "\n" +s;
            }
            br.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static String[] stringToArray(String string)
    {
        String[] stringArray = string.split("\n");
        return stringArray;
    }

    public static ArrayList<String> stringArrayList(String[] stringArray)
    {
        ArrayList<String> arrayList = new ArrayList();

        for(int i = 0; i < stringArray.length; i++)
        {
            if(!stringArray[i].equals(""))
            {
                arrayList.add(stringArray[i]);
            }
            else
                continue;
        }

        return arrayList;
    }


}
