package Course.Week9;

import java.util.ArrayList;
import java.util.Scanner;

/*
In the sport of diving, seven judges award a score between 0 and 10, where each score may be a floating-point value.
The highest and lowest scores are thrown out and the remaining scores are added together.
The sum is then multiplied by the degree of difficulty for that dive.
The degree of difficulty ranges from 1.2 to 3.8 points.
The total is then multiplied by 0.6 to determine the diver’s score.
Write a computer program that inputs a degree of difficulty and seven judges’ scores and
outputs the overall score for that dive. The program should use an ArrayList of type Double to store the scores.
*/
public class Question1
{
    public static void main(String args[])
    {

        ArrayList<Double> judgeScores = new ArrayList<Double>();

        double highestScore,lowestScore,total=0;

        Scanner input = new Scanner(System.in);

        //Accept the values of difficulty and scores from user.

        System.out.print("Enter degree of difficulty : ");
        double difficulty = input.nextDouble();
        System.out.print("Enter score of first judge : ");
        judgeScores.add(input.nextDouble());
        System.out.print("Enter score of second judge: ");
        judgeScores.add(input.nextDouble());
        System.out.print("Enter score of third judge: ");
        judgeScores.add(input.nextDouble());
        System.out.print("Enter score of fourth judge: ");
        judgeScores.add(input.nextDouble());
        System.out.print("Enter score of fifth judge: ");
        judgeScores.add(input.nextDouble());
        System.out.print("Enter score of sixth judge: ");
        judgeScores.add(input.nextDouble());
        System.out.print("Enter score of seventh judge: ");
        judgeScores.add(input.nextDouble());

        // Find the highest and lowest scores. Using the remove method
        // remove the highest and lowest scores from the ArrayList.

        lowestScore = judgeScores.get(0);
        highestScore = judgeScores.get(0);
        for(int i = 0; i < judgeScores.size(); i++)
        {
            if(judgeScores.get(i) < lowestScore)
                lowestScore = judgeScores.get(i);

            if(judgeScores.get(i) > highestScore)
                highestScore = judgeScores.get(i);
        }
        judgeScores.remove(lowestScore);
        judgeScores.remove(highestScore);

        //calculate the sum of scores.
        for(int i = 0; i < judgeScores.size(); i++)
        {
            total += judgeScores.get(i);
        }

        total = total * difficulty * 0.6;

        System.out.println("The diver's score is " + total + ".");
    }
}
