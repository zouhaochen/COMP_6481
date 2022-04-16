package Lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab12
{
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String totalInString = keyboard.nextLine();
        int total = 0;

        try
        {
            total = Integer.parseInt(totalInString);
        }
        catch (Exception e)
        {
            System.exit(0);
        }

        if(total >= 1000 || total <= 0)
        {
            System.exit(0);
        }

        String numberOfIntegerInString = keyboard.nextLine();
        int numberOfInteger = 0;

        try
        {
            numberOfInteger = Integer.parseInt(numberOfIntegerInString);
        }
        catch (Exception e)
        {
            System.exit(0);
        }

        if(numberOfInteger < 1 || numberOfInteger > 12)
        {
            System.exit(0);
        }

        int[] list = new int[numberOfInteger];

        for(int i = 0; i < list.length; i++)
        {
            list[i] = keyboard.nextInt();
        }

        for(int i = 0; i < list.length; i ++)
        {
            if (list[i] <= 0 || list[i] >= 100)
            {
                System.exit(0);
            }
        }

        for(int i = 0; i < list.length - 1; i ++)
        {
            for(int j = i + 1; j < list.length; j ++)
            {
                if(list[i] < list[j])
                {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }


}
