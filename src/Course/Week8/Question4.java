package Course.Week8;

/*
The game of “Jump It” consists of a board with n positive integers
in a row except for the first column, which always contains zero.
These numbers represent the cost to enter each column. Here is a sample game board where n is 6:
0 3 80 6 59 10
The object of the game is to move from the first column to the last column in the lowest total cost.
The number in each column represents the cost to enter that column.
Always start the game in the first column and have two types of moves.
You can either move to the adjacent column or jump over the adjacent column to land two columns over.
The cost of a game is the sum of the costs of the visited columns.
In the board shown above, there are several ways to get to the end.
Starting in the first column, our cost so far is 0.
We could jump to 80, then jump to 57, then move to 10 for a total cost of 80 + 57 + 10 = 147.
However, a cheaper path would be to move to 3, jump to 6, then jump to 10,
for a total cost of 3 + 6 + 10 = 19.
Write a recursive solution to this problem that computes the cheapest cost of the game
and outputs this value for an arbitrarily large game board represented as an array.
Your program does not have to output the actual sequence of jumps, only the cheapest cost of this sequence.
After making sure that your solution works on small arrays,
test your solution on boards of larger and larger values of n
to get a feel for how efficient and scalable your solution is.
*/
public class Question4
{
    public static int lowestTestCost(int[] x, int y, int z)
    {
        z += x[y];
        if (y == x.length - 1)
            return z;
        else if (y == x.length - 2)
            return lowestTestCost(x, y + 1, z);
        else
            {
                int path1 = lowestTestCost(x, y + 1, z);
                int path2 = lowestTestCost(x, y + 2, z);
                return Math.min(path1, path2);
            }
    }

    public static void main(String args[])
    {
        int[] x = { 0, 3, 80, 6, 57, 10 };
        int n = 0;
        n = lowestTestCost(x, 0, n);
        System.out.print("The cost to enter each column:");
        for (int i = 0; i < x.length; i++)
            System.out.print(x[i] + " ");
        System.out.println();
        System.out.println("Total cost: " + n);
    }
}
