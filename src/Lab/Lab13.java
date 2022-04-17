package Lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab13
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int n1;
        int count = 0;

        ArrayList<Integer> num = new ArrayList<Integer>();

        int sum;

        for (int i = 0; i < n; i++)
        {
            n1 = sc.nextInt();
            num.add(n1);
        }

        for (int i = 0; i < num.size(); i++)
        {
            if (num.get(i) == t)
            {
                count++;
            }
            else
            {
                sum = num.get(i);
                for (int j = i + 1; j < num.size(); j++)
                {
                    sum += num.get(j);
                    if (sum == t)
                    {
                        count++;
                        break;
                    }
                    else if (sum > t)
                    {
                        sum -= num.get(j);
                        continue;
                    }
                    else if (sum < t)
                    {
                        continue;
                    }
                }
            }
        }
        System.out.println(count);

    }
}
