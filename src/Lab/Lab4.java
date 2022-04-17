package Lab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Lab4
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<Integer>();

        while(true)
        {
            int x = keyboard.nextInt();
            if (x == -1)
            {
                break;
            }
            else
            {
                inputList.add(x);
            }
        }

        inputList.sort(Comparator.naturalOrder());

        int inputSize = inputList.size();
        int middle;

        if(inputSize % 2 == 1)
        {
            middle = (inputSize + 1) / 2;
        }
        else
        {
            middle = inputSize / 2;
        }

        int root = inputList.get(middle - 1);

    }

}
