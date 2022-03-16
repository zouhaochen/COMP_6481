package POD;

import java.util.*;

public class POD4
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        int number = 0;

        while(number != -1)
        {
            number = Integer.parseInt(keyboard.nextLine());
            int[] entrySet = new int[1000000];
            int x = 1;
            int y;
            int sum = 0;

            ArrayList<Integer> arrayListOne = new ArrayList<>();
            ArrayList<String> arrayListTwo = new ArrayList<>();

            if(number > 2 && number < 1000000)
            {
                for(int i = 0; i < entrySet.length; i++)
                {
                    if(x < number)
                    {
                        y = number % x;
                        if(y == 0)
                        {
                            entrySet[i] = x;
                            x++;
                        }
                        else if(y!= 0)
                        {
                            x++;
                        }
                    }
                    sum += entrySet[i];
                    arrayListOne.add(entrySet[i]);

                    if(arrayListOne.get(i) > 0)
                    {
                        arrayListTwo.add(String.valueOf(entrySet[i]));
                    }
                }
            }

            if(sum == number && number > 2 && number < 1000000)
            {
                System.out.println(number + " = " + String.join(" + ", arrayListTwo) );
            }
            else if(sum != number && number>2 && number < 1000000)
            {
                System.out.println(number + " is NOT perfect.");
            }
        }

        keyboard.close();
    }
}