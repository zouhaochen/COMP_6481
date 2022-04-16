package Lab;

import java.util.Scanner;

public class Lab5
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String string = keyboard.nextLine();
        String letters = keyboard.nextLine();

        if(string.length() > 70)
        {
            System.exit(0);
        }

        if(letters.length() >= string.length())
        {
            System.exit(0);
        }

    }
}
