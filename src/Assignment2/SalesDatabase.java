package Assignment2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesDatabase
{
    private static Sales[] salesArr;

    public static void main(String[] args)
    {
        //data folder path
        String folderPath = "src/Assignment2/Data";
        File dir = new File(folderPath);

        List<File> folderList = new ArrayList<File>();
        folderToList(dir, folderList);

        List<File> fileList = new ArrayList<File>();
        fileToList(dir, fileList);

        //main menu
        boolean flag = true;
        Scanner keyboard = new Scanner(System.in);
        String choice = "";


        while (flag)
        {
            System.out.println("Please enter the option:");
            System.out.println("1. List files.");
            System.out.println("2. Process files.");
            System.out.println("3. Exit.");

            //get user input choice
            choice = keyboard.nextLine();

            switch (choice)
            {
                case "1":
                    //create the log.txt file
                    File file = new File(dir, "log.txt");
                    writePathToFile(folderList, fileList, file.toString());
                    System.out.println("The log.txt file create.");
                    break;

                case "2":
                    break;

                case "3":
                    flag = false;
                    System.out.println("\nExit the program, see you next time!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please enter again.");
                    break;
            }
        }
    }

    //write file path to list collection
    public static void fileToList(File dir, List<File> list)
    {
        File[] files = dir.listFiles();

        //recurse to the specified directory
        for(File file:files)
        {
            if(file.isDirectory())
            {
                //get the path to all files during recursion
                fileToList(file, list);
            }
            else
            {
                //store paths into the collection
                if(file.getName().endsWith(".txt"))
                {
                    list.add(file);
                }
            }
        }
    }

    //write folder path to list collection
    public static void folderToList(File dir, List<File> list)
    {
        File[] files = dir.listFiles();

        //recurse to the specified directory
        for (File file : files)
        {
            if(file.isDirectory())
            {
                //get the path to all folders during recursion
                list.add(file);
                folderToList(file, list);
            }
        }
    }

    //write data from the list collection to the file
    public static void writePathToFile(List<File> folderList, List<File> fileList, String txtListFile)
    {
        BufferedWriter bufferedWriter = null;

        try
        {
            bufferedWriter = new BufferedWriter(new FileWriter(txtListFile));

            for(File file : folderList)
            {
                String absolutePath = file.getAbsolutePath();
                bufferedWriter.write("directory: "+absolutePath);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            for(File file : fileList)
            {
                String absolutePath = file.getAbsolutePath();
                bufferedWriter.write("file: "+absolutePath);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch(IOException e)
        {
            throw new RuntimeException("Failed to write file.");
        }
        finally
        {
            try
            {
                if(bufferedWriter != null)
                {
                    bufferedWriter.close();
                }
            }
            catch (IOException e)
            {
                throw new RuntimeException("Failed to close file.");
            }
        }
    }
}
