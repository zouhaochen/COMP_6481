package Course.Week8;

import java.util.Scanner;

/*
A savings account typically accrues savings using compound interest.
If you deposit $1,000 with a 10% interest rate per year, then after one year you have a total of $1,100.
If you leave this money in the account for another year at 10% interest, then after two years the total will be $1,210.
After three years, you would have $1,331, and so on.
Write a program that inputs the amount of money to deposit, an interest rate per year,
and the number of years the money will accrue compound interest.
Write a recursive function that calculates the amount of money
that will be in the savings account using the input information.
*/
public class Question1
{
    public static double calculateAmount(double amount, double rate, int years)
    {
        if(years <= 0)
        {
            return amount;
        }
        else
            return calculateAmount(amount * (1 + rate / 100), rate, years - 1);
    }

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter the amount of money to deposit: $");
        double P = console.nextDouble();

        System.out.print("Enter an interest rate per year: $");
        double i = console.nextDouble();

        System.out.print("Enter the number of years: ");
        int n = console.nextInt();

        double finalAmount = calculateAmount(P, i, n);

        System.out.printf("\nFinal amount of money in the savings account: $%.2f", finalAmount);
    }
}
