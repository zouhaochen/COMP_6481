package Course;

import java.util.Scanner;

public class Practice4
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        for(int i = 1; i <= n; i ++)
        {
            if(n % i == 0)
            {
                System.out.println(i);
            }
        }
        isPrime(n);
    }

    public static void isPrime(int num)
    {
        boolean isPrime = true;
        if(num > 0)
        {
            int k = (int) Math.sqrt(num);
            for(int i = 2; i <= k; i ++)
            {
                if(num % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime)
            {
                System.out.println(num + " is prime.");
            }
            else
            {
                System.out.println(num + " is not prime.");
            }
        }
    }
}
