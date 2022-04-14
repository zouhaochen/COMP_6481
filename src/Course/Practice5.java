package Course;

public class Practice5
{
    public static void main(String[] args)
    {
        System.out.println(fac(5));
        print(12345);
        System.out.println(sum(525615));
        System.out.println(fib(10));
    }

    public static int fac(int num)
    {
        if(num == 1)
        {
            return 1;
        }
        return num * fac(num - 1);
    }

    public static void print(int num)
    {
        if(num > 9)
        {
            print(num / 10);
        }
        System.out.println(num % 10);
    }

    public static int sum(int n)
    {
        if(n < 10)
        {
            return n;
        }
        return n % 10 + sum(n / 10);
    }

    public static int fib(int n)
    {
        if(n == 1 || n == 2)
        {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
