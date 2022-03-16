package Course.Week8;

import java.util.Scanner;

/*
The formula for computing the number of ways of
choosing r different things from a set of n things is the following:
C(n, r)= n!/(r!*(n – r)!)
The factorial method n! is defined by
n!= n*(n – 1)*(n – 2)*...*1
Discover a recursive version of the formula for C(n , r) and write a recursive method that
computes the value of the formula. Place the method in a class that has a main that tests the method.
*/
public class Question6
{
    public static void main(String args[])
    {
        int n,r;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of elements(n): ");
        n= input.nextInt();
        System.out.print("Enter size(r): ");
        r = input.nextInt();
        System.out.println("Total " + 	computeWays(n, r) + " ways to choose " + r + " different objects.");
    }

    public static int factorial(int n)
    {

        if (n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static int computeWays(	int x, int y)
    {
        return (factorial(x)) / (factorial(y) * factorial(x - y));
    }
}
