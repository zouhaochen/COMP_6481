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

            if(i == tvShowArray.length - 1)
            {
                System.out.println("The linked list of tv show guide is constructed.");
                System.out.println();
            }
        }

        //read and store interest content
        File interest = new File(interestPath);
        String interestContent = txtToString(interest);
        String[] interestArray = stringToArray(interestContent);
        ArrayList<String> interestArrayList = stringArrayList(interestArray);

        int indexWatching = interestArrayList.indexOf("Watching");
        int indexWishList = interestArrayList.indexOf("Wishlist");
        int interestSize = interestArrayList.size();

        //count the information of watching and wish
        ArrayList<String> watchingList = new ArrayList<String>();
        ArrayList<String> wishList = new ArrayList<String>();

        for(int i = indexWatching + 1; i < indexWishList; i ++)
        {
            watchingList.add(interestArrayList.get(i));
        }

        for(int i = indexWishList + 1; i < interestSize; i ++)
        {
            wishList.add(interestArrayList.get(i));
        }

        ShowList watchingLinkedList = new ShowList();

        //construct the show list that user is watching
        for(int i = 0; i < watchingList.size(); i ++)
        {
            if(i == 0)
            {
                System.out.println("Start checking and construct the linked list of tv shows that the user is watching:");
            }

            TVShow tvShow = tvGuideLinkList.showNodeToTvShow(tvGuideLinkList.find(watchingList.get(i)));
            watchingLinkedList.addNode(tvShow);

            if(i == watchingList.size() - 1)
            {
                System.out.println("The linked list of tv shows that the user is watching is constructed.");
                System.out.println();
            }
        }

        ArrayList<String> availableTvShowList = new ArrayList<String>();

        //check the availability of tv shows user interested
        for(int i = 0; i < wishList.size(); i ++)
        {
            if(i == 0)
            {
                System.out.println("Start checking the availability of tv shows user interested:");
            }

            System.out.println("Whether tv guide contain the tv show: " + wishList.get(i) +
                    " that the user is interested: " + tvGuideLinkList.contain(wishList.get(i)));
            tvGuideLinkList.find(wishList.get(i));

            if(tvGuideLinkList.contain(wishList.get(i)))
            {
                availableTvShowList.add(wishList.get(i));
            }

            if(i == wishList.size() - 1)
            {
                System.out.println("Finish checking the availability of tv shows user interested.");
                System.out.println();
            }
        }

        for(int i = 0; i < availableTvShowList.size(); i ++)
        {
            String availableTVShowID = availableTvShowList.get(i);
            TVShow availableTVShow = tvGuideLinkList.showNodeToTvShow(tvGuideLinkList.findWithoutIterationInformation(availableTVShowID));
            String[] isOnSameTimeInformation = new String[watchingLinkedList.getSize()];

            for(int j = 0; j < watchingLinkedList.getSize(); j++)
            {
                TVShow watchingShow = watchingLinkedList.showNodeToTvShow(watchingLinkedList.getNode(j));
                String twoShowInformation = watchingShow.isOnSameTime(availableTVShow);
                isOnSameTimeInformation[j] = twoShowInformation;
            }

            boolean isDifferentTime = true;
            for(int j = 0; j < isOnSameTimeInformation.length; j++)
            {
                if(!isOnSameTimeInformation[j].equals("Different Time"))
                    isDifferentTime = false;
            }

            if(isDifferentTime == true)
            {
                System.out.println("User can watch show: " + availableTVShow + ".");
                System.out.println("As she/he is not watching anything else during that time.");
            }

            for(int j = 0; j < isOnSameTimeInformation.length; j++)
            {
                TVShow watchingShow = watchingLinkedList.showNodeToTvShow(watchingLinkedList.getNode(j));

                if(isOnSameTimeInformation[j].equals("Same Time"))
                {
                    System.out.println("User cannot watch show: " + availableTVShow + ".");
                    System.out.println("As she/he will begin & end another show: " + watchingShow + " at the same time.");
                }

                if(isOnSameTimeInformation[j].equals("Some Overlap"))
                {
                    double interestShowStartTime = availableTVShow.getStartTime();
                    double interestShowEndTime = availableTVShow.getEndTime();

                    double watchingShowStarTime = watchingShow.getStartTime();
                    double watchingShowEndTime = watchingShow.getEndTime();

                    if(interestShowStartTime == watchingShowStarTime)
                    {
                        System.out.println("User cannot watch show: " + availableTVShow + ".");
                        System.out.println("As she/he will begin another show: " + watchingShow + " at the same time.");
                        continue;
                    }

                    if(interestShowEndTime <= watchingShowEndTime)
                    {
                        System.out.println("User cannot watch show: " + availableTVShow + ".");
                        System.out.println("As she/he is not finished with a show: " + watchingShow + " he/she is watching.");
                        continue;
                    }
                }
            }

            System.out.println();
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
