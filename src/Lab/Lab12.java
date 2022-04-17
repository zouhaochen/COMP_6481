package Lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab12
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String firstLine = keyboard.nextLine();
        int total = 0;

        try
        {
            total = Integer.parseInt(firstLine);
        }
        catch (Exception e)
        {
            System.exit(0);
        }

        if(total >= 1000)
        {
            System.exit(0);
        }

        String secondLine = keyboard.nextLine();
        int numberOfInteger = 0;

        try
        {
            numberOfInteger = Integer.parseInt(secondLine);
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

        for(int i = 0; i < list.length; i++)
        {
            if(list[i] >= 100)
            {
                System.exit(0);
            }
        }

        int sum = 0;

        for(int i = 0; i < list.length; i++)
        {
            sum = sum + list[i];
        }

        if(sum < total)
        {
            System.out.println(0);
            System.exit(0);
        }

        ArrayList<Integer> dataList = new ArrayList<Integer>();
        for(int i = 0; i < list.length; i ++)
        {
            dataList.add(list[i]);
        }

        int remain = total;
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        ArrayList<String> sumInfoList = new ArrayList<String>();
        int count = 0;

        for(int i = 0; i < dataList.size(); i ++)
        {
            if(remain > 0)
            {
                int newRemain = remain - dataList.get(i);
                if(newRemain > 0)
                {
                    sumList.add(dataList.get(i));
                    remain = newRemain;
                }
                else if(newRemain == 0)
                {
                    sumList.add(dataList.get(i));
                    String currentInfo = sumList.toString();

                    if(sumInfoList.contains(currentInfo))
                    {

                    }
                    else
                    {
                        sumInfoList.add(currentInfo);
                    }

                    sumList.clear();
                    remain = total;
                    i = count ++;
                    continue;
                }
                else
                {
                    continue;
                }
            }
        }

        System.out.println(sumInfoList.size());
    }
}
