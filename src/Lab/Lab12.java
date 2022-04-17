package Lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab12
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int n1;

        ArrayList<Integer> num = new ArrayList<Integer>();

        int sum;

        for (int i = 0; i < n; i++)
        {
            n1 = sc.nextInt();
            num.add(n1);
        }

        ArrayList<Integer> sumList = new ArrayList<Integer>();
        ArrayList<String> finalList = new ArrayList<String>();

        for (int i = 0; i < num.size(); i++)
        {
            if (num.get(i) == t)
            {
                sumList.add(num.get(i));
                String sumListInString = sumList.toString();

                if(finalList.contains(sumListInString))
                {

                }
                else
                {
                    finalList.add(sumListInString);
                }

                sumList.clear();
            }
            else
            {
                sum = num.get(i);
                sumList.add(num.get(i));

                for (int j = i + 1; j < num.size(); j++)
                {
                    sum += num.get(j);

                    if (sum == t)
                    {
                        sumList.add(num.get(j));
                        String sumListInString = sumList.toString();

                        if(finalList.contains(sumListInString))
                        {

                        }
                        else
                        {
                            finalList.add(sumListInString);
                        }

                        sumList.clear();

                        break;
                    }
                    else if (sum > t)
                    {
                        sum -= num.get(j);
                        continue;
                    }
                    else if (sum < t)
                    {
                        sumList.add(num.get(j));
                        continue;
                    }
                }
            }
        }

        System.out.println(finalList);
        System.out.println(finalList.size());
    }
}
