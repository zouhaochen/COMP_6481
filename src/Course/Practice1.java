package Course;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice1
{
    public static void main(String[] args)
    {
        int[] arr={1,8,5,4,6,7};
        ArrayList<Integer> list=new ArrayList<>();

        ArrayList<ArrayList<Integer>>printList=new ArrayList<>();

        Arrays.sort(arr);
        group(arr,list,printList,0);
        for(ArrayList<Integer>tem : printList)
        {
            System.out.println(Arrays.toString(tem.toArray()));
        }
    }

    public static ArrayList<ArrayList<Integer>> group(int[]arr,ArrayList<Integer>list,ArrayList<ArrayList<Integer>>printList,int index)
    {
        printList.add(new ArrayList<>(list));

        if(list.size()==arr.length)
            return printList;

        for(int i=index; i<arr.length; i++)
        {
            list.add(arr[i]);
            group(arr,list,printList,i+1);
            list.remove(list.size()-1);
        }
        return printList;
    }
}

