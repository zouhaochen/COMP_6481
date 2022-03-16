package Course.Week8;

import java.util.Scanner;

/*
Towers of Hanoi. There is a story about Buddhist monks who are playing this puzzle with 64 stone disks.
The story claims that when the monks finish moving the disks
from one post to a second via the third post, time will end.
A stack of n disks of decreasing size (from bottom to top) is placed on one of three posts.
The task is to move the disks one at a time from the first post to the second.
To do this, any disk can be moved from any post to any other post,
subject to the rule that you can never place a larger disk over a smaller disk.
The (spare) third post is provided to make the solution possible.
Your task is to write a recursive static method that gives instructions for a solution to this problem.
We do not want to bother with graphics, so you should output a sequence of instructions
that will solve the problem. The number of disks is a parameter to the method.
Hint: If you could move up n–1 of the disks from the first post to the third post using the second post
as a spare, the last disk could be moved from the first post to the second post.
Then, by using the same technique (whatever that may be), you can move the n–1 disks
from the third post to the second post, using the first disk as a spare.
There! You have the puzzle solved. You have only to decide what the nonrecurring case is,
what the recursive case is, and when to output instructions to move the disks.
*/
public class Question7
{
    public static void main(String[] args)
    {
        int s = 1, m = 2, l = 3;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        hanoi(input.nextInt(), s, m, l);
    }

    public static void hanoi(int n, int s, int m, int l)
    {
        if (n == 1)
            System.out.println("Move from post " + s + " to post " + l);
        else
        {
            hanoi(n - 1, s, l, m);
            System.out.println("Move from post " + s + " to post " + l);
            hanoi(n - 1, m, s, l);
        }
    }
}
