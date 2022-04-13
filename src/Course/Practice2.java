package Course;

import java.util.ArrayList;
import java.util.List;

public class Practice2
{
    public static void main(String[] args)
    {
        String[] a = { "a", "b", "c", "d" };
        subSets(a);
    }

    public static void subSets(String[] a)
    {

        int max = 1 << a.length;

        List<List<String>> result = new ArrayList<List<String>>();

        for (int i = 0; i < max; i++)
        {
            List<String> list = new ArrayList<String>();
            int j = i;
            int index = 0;

            while (j > 0)
            {
                if ((j & 1) > 0)
                {
                    list.add(a[index]);
                }

                index++;
                j = j >> 1;
            }

            result.add(list);
        }
        print(result);
    }

    public static void print(List<List<String>> para)
    {
        for (List<String> list : para)
        {
            System.out.println(list.toString());
        }
    }
}

