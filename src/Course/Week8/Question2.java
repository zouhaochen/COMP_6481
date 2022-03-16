package Course.Week8;

import java.util.Scanner;

/*
There are n people in a room, where n is an integer greater than or equal to 1.
Each person shakes hands once with every other person. What is the total number, h(n) , of handshakes?
Write a recursive function to solve this problem.
To get you started, if there are only one or two people in the room, then
handshake(1) = 0
handshake(2) = 1
If a third person enters the room, he or she must shake hands with each of the two people already there.
This is two handshakes in addition to the number of handshakes that would be made in a room of two people,
or a total of three handshakes.
If a fourth person enters the room, he or she must shake hands with each of the three people already present.
This is three handshakes in addition to the number of handshakes that would be made in a room of three people,
or six handshakes.
If you can generalize this to n handshakes, then it should help you write the recursive solution.
*/
public class Question2
{
    //main method
    public static void main(String[] args)
    {
        int n;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of hands:");
        n=scn.nextInt();

        for (int i = 1; i <= n; i++)
        {
            System.out.println("handshake("+i+")="+handshake(i));
        }
    }

    // Recursion method
    public static int handshake(int num)
    {
        if (num < 2)
            return num - 1;
        else
            return num - 1 + handshake(num - 1);
    }
}
