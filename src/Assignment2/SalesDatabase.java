package Assignment2;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class SalesDatabase
{
    private static Sales[] salesArr = new Sales[0];
    private static Logger logger = Logger.getLogger("SalesDatabase");

    //data folder path
    private static String folderPath = "src/Assignment2/Data";
    private static File dir = new File(folderPath);

    //buffered writer and reader
    private static BufferedWriter bufferedWriter = null;
    private static BufferedReader bufferedReader = null;

    private static DateFormat format = new SimpleDateFormat("dd/mm/yyyy");

    public static void main(String[] args)
    {
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
                    System.out.println();
                    break;

                case "2":
                    boolean caseTwoFlag = true;
                    String caseTwoChoice = "";

                    while (caseTwoFlag)
                    {
                        System.out.println("\nPlease enter the option:");
                        System.out.println("1. Display file contents.");
                        System.out.println("2. Store records from file to system.");

                        caseTwoChoice = keyboard.nextLine();

                        switch (caseTwoChoice)
                        {
                            case "1":
                                System.out.println("\nPlease enter the file name:");
                                System.out.println("For example:");
                                System.out.println("log.txt");
                                System.out.println("/1/Tom.txt");
                                System.out.println("/2/Sam.txt");
                                System.out.println("/3/Harry.txt");
                                String fileNameCaseOne = keyboard.nextLine();
                                displayFileContents(fileNameCaseOne);
                                break;

                            case "2":
                                System.out.println("\nPlease enter the file name:");
                                System.out.println("For example:");
                                System.out.println("/1/Tom.txt");
                                System.out.println("/2/Sam.txt");
                                System.out.println("/3/Harry.txt");
                                String fileNameCaseTwo = keyboard.nextLine();
                                storeRecord(fileNameCaseTwo);
                                break;
                        }
                    }

                    break;

                case "3":
                    flag = false;

                    //close all opened files before closing
                    try
                    {
                        if(bufferedWriter != null)
                        {
                            bufferedWriter.close();
                        }
                    }
                    catch (IOException e)
                    {
                        logException(e);
                        throw new RuntimeException("Failed to close file.");
                    }

                    try
                    {
                        if(bufferedReader != null)
                        {
                            bufferedReader.close();
                        }
                    }
                    catch (IOException e)
                    {
                        logException(e);
                        throw new RuntimeException("Failed to close file.");
                    }

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
            logException(e);
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
                logException(e);
                throw new RuntimeException("Failed to close file.");
            }
        }
    }

    //catch and log exceptions
    public static void logException(Exception e)
    {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void addRecord(Sales sales)
    {

    }

    //display file content method, accept an input file stream name
    public static void displayFileContents(String fileName)
    {
        File file = new File(dir, fileName);
        try
        {
            //get character stream
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                //the data that circulates
                System.out.println(line);
            }
        }
        catch(Exception e)
        {
            logException(e);
            throw new RuntimeException("Failed to read file.");
        }
        finally
        {
            if(bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }
                catch(Exception e)
                {
                    logException(e);
                    throw new RuntimeException("Failed to close file.");
                }
            }
        }
    }

    //store sales records in file to array in the system
    public static void storeRecord(String fileName)
    {
        File file = new File(dir, fileName);
        int lines = 0;

        //get line number of the file
        try
        {
            FileReader fileReader = new FileReader(file);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
            lineNumberReader.skip(Long.MAX_VALUE);
            lines = lineNumberReader.getLineNumber();
            lineNumberReader.close();
        }
        catch (Exception e)
        {
            logException(e);
            throw new RuntimeException("Failed to read file.");
        }

        //space number for store records in array
        int recordNumber = lines+1;
        String[] stringDataSet = new String[recordNumber];

        int salesArrSpace = salesArr.length;
        int salesArrTempSpace = salesArrSpace + recordNumber;
        Sales[] salesArrTemp = new Sales[salesArrTempSpace];

        for(int i = 0; i < salesArrSpace; i++)
        {
            salesArrTemp[i] = salesArr[i];
        }

        for(int i = salesArrSpace; i < salesArrTempSpace; i++)
        {
            salesArrTemp[i] = new Sales();
        }

        try
        {
            //get character stream
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String line;
            int index = 0;

            while((line = bufferedReader.readLine()) != null)
            {
                stringDataSet[index] = line;
                index = index + 1;
            }

            for(int i = 0 ; i < stringDataSet.length; i++)
            {
                System.out.println(stringDataSet[i]);
                String[] splitData = stringDataSet[i].split("\\s+");
                for (int j = 0; j < splitData.length; j++)
                {
                    if (j == 0)
                    {
                        salesArrTemp[i].setCountry(splitData[j]);
                    }
                    else if (j == 1)
                    {
                        salesArrTemp[i].setItemType(splitData[j]);
                    }
                    else if (j == 2)
                    {
                        salesArrTemp[i].setOrderPriority(splitData[j].charAt(0));
                    }
                    else if (j == 3)
                    {
                        salesArrTemp[i].setOrderDate(format.parse(splitData[j]));
                    }
                    else if (j == 4)
                    {
                        salesArrTemp[i].setOrderID(Long.parseLong(splitData[j]));
                    }
                    else if (j == 5)
                    {
                        salesArrTemp[i].setShipDate(format.parse(splitData[j]));
                    }
                    else if (j == 6)
                    {
                        salesArrTemp[i].setUnitsSold(Integer.parseInt(splitData[j]));
                    }
                    else if (j == 7)
                    {
                        salesArrTemp[i].setUnitPrice(Float.parseFloat(splitData[j]));
                    }
                    else if (j == 8)
                    {
                        salesArrTemp[i].setUnitCost(Float.parseFloat(splitData[j]));
                    }
                    else if (j == 9)
                    {
                        salesArrTemp[i].setRevenue(Double.parseDouble(splitData[j]));
                    }
                    else if (j == 10)
                    {
                        salesArrTemp[i].setTotalCost(Double.parseDouble(splitData[j]));
                    }
                    else if (j == 11)
                    {
                        salesArrTemp[i].setTotalProfit(Double.parseDouble(splitData[j]));
                    }
                }
                System.out.println(salesArrTemp[i]);
            }
        }
        catch(Exception e)
        {
            logException(e);
            throw new RuntimeException("Failed to read file.");
        }
        finally
        {
            if(bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }
                catch(Exception e)
                {
                    logException(e);
                    throw new RuntimeException("Failed to close file.");
                }
            }
        }

    }
}