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

        if(letters.length() > string.length())
        {
            System.exit(0);
        }

        int length = letters.length();

        while (length <= string.length())
        {
            for(int i = 0; i < string.length() - length + 1; i ++)
            {
                int start = i;
                int end = i + length - 1;
                String subString = string.substring(start, end + 1);

                char[] subStringInChar = subString.toCharArray();
                char[] lettersInChar = letters.toCharArray();

                for(int j = 0; j < subStringInChar.length; j++)
                {
                    char target = subStringInChar[j];

                    for(int k = 0; k < lettersInChar.length; k++)
                    {
                        char letterInLetters = lettersInChar[k];

                        if(target == letterInLetters)
                        {
                            lettersInChar[k] = '*';
                            break;
                        }
                        else
                            continue;
                    }
                }

                boolean allCheck = true;
                for(int j = 0; j <lettersInChar.length; j ++)
                {
                    if (lettersInChar[j] == '*')
                    {

                    }
                    else
                    {
                        allCheck = false;
                    }
                }

                if(allCheck == true)
                {
                    System.out.println(subString);
                    System.exit(0);
                }
                else
                    continue;
            }
            length ++;
        }
    }
}
