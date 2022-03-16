package Course.Week8;

import java.util.Scanner;

/*
Consider a frame of bowling pins shown below, where each * represents a pin:
*
* *
* * *
* * * *
* * * * *
There are 5 rows and a total of 15 pins.
If we had only the top 4 rows, then there would be a total of 10 pins.
If we had only the top 3 rows, then there would be a total of 6 pins.
If we had only the top 2 rows, then there would be a total of 3 pins.
If we had only the top row, then there would be a total of one pin.
Write a recursive function that takes as input the number of rows n
and outputs the total number of pins that would exist in a pyramid with n rows.
Your program should allow for values of n that are larger than 5.
*/
public class Question3
{
    public static void recursionPins(int n, int t)
    {
        if (n == 1)
        {
            System.out.print("\t");
            for (int i = 1; i <= t - 1; i++)
                System.out.print(" ");
            System.out.println("*");
        }
        else
        {
            System.out.print("\t\t");
            recursionPins(n - 1, t);
            for (int i = 1; i <= t - n; i++)
                System.out.print(" ");
            for (int i = 1; i <= n; i++)
                System.out.print("* ");
            System.out.println();
        }
    }

    // main method
    public static void main(String args[])
    {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter number of rows of pins: ");
        int n = input.nextInt();
        recursionPins(n, n);
    }
}
