package Course;

public class Practice8
{
    public static void main(String[] args)
    {
        splitChange(1748);
    }

    public static void splitChange(int change)
    {
        if(change < 1)
        {
            System.out.println("Invalid input.");
            return;
        }

        int copy = change;
        int[] notes = {100, 50, 20, 10, 5, 1};
        int[] pieces = new int[notes.length];

        while(change > 0)
        {
            for(int i = 0; i < notes.length; i ++)
            {
                if(change >= notes[i])
                {
                    change = change - notes[i];
                    pieces[i] += 1;
                    break;
                }
            }
        }

        System.out.print(String.format("Your change is %d, %d=",copy,copy));
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<pieces.length;i++)
        {
            if(pieces[i]>0)
                sb.append(String.format("%d*%d piece(s)+", notes[i],pieces[i]));
        }
        String msg=sb.toString();
        msg=msg.substring(0, msg.length()-1);
        System.out.println(msg);
    }
}
