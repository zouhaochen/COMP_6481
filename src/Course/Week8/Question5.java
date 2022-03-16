package Course.Week8;

import java.util.Scanner;

/*
Write a recursive method definition for a static method that
has one parameter n of type int and that returns the n th Fibonacci number.
Place the method in a class that has a main that tests the method.
*/
public class Question5
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number:");
        int n = input.nextInt();
        System.out.println("Fibonacci number result: " + fibonacci(n));
    }
    public static int fibonacci(int f)
    {
        if (f == 0)
            return 1;
        else if (f == 1)
            return 1;
        else
            return fibonacci(f - 1) + fibonacci(f - 2);
    }
}
