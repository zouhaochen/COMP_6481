package Assignment2;

import Assignment2.Exception.DuplicateRecordException;
import Assignment2.Exception.EmptyFolderException;
import Assignment2.Exception.InvalidFileException;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class SalesDatabase
{
    private static Sales[] salesArr;
    private static Sales[] salesArrTemp;
    private static Logger logger = Logger.getLogger("SalesDatabase");

    //data folder path
    private static String folderPath = "src/Assignment2/Data";
    private static File dir = new File(folderPath);

    //buffered writer and reader
    private static BufferedWriter bufferedWriter = null;
    private static BufferedReader bufferedReader = null;

    private static DateFormat format = new SimpleDateFormat("dd/mm/yyyy");

    private static int time;

    public static void main(String[] args)
    {
        salesArr = new Sales[0];

        List<File> folderList = new ArrayList<File>();
        try
        {
            folderToList(dir, folderList);
        }
        catch (Exception e)
        {
            logException(e);
            System.out.println(e.getMessage());
        }

        List<File> fileList = new ArrayList<File>();
        try
        {
            fileToList(dir, fileList);
        }
        catch (Exception e)
        {
            logException(e);
            System.out.println(e.getMessage());
        }

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
                        System.out.println("2. Store records from specified file to system.");
                        System.out.println("3. Store records from every files to system.");
                        System.out.println("4. Identify duplicate records and output database.");
                        System.out.println("5. Binary sale search record in database.");
                        System.out.println("6. Sequential sale search record in database.");
                        System.out.println("7. Add a new record to database.");
                        System.out.println("8. Back to the main menu.");

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
                                System.out.println();
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
                                System.out.println("\nRecord database in system as follows:");
                                for(int i = 0; i < salesArr.length; i++)
                                {
                                    System.out.println(salesArr[i]);
                                }
                                break;

                            case "3":
                                storeRecord("/1/Tom.txt");
                                storeRecord("/2/Sam.txt");
                                storeRecord("/3/Harry.txt");
                                System.out.println("\nRecord database in system as follows:");
                                for(int i = 0; i < salesArr.length; i++)
                                {
                                    System.out.println(salesArr[i]);
                                }
                                break;

                            case "4":
                                System.out.println();
                                try
                                {
                                    duplicateRecordNotification();
                                }
                                catch (Exception e)
                                {
                                    System.out.println(e.getMessage());
                                }
                                identifyDuplicateRecords();
                                break;

                            case "5":
                                System.out.println("\nPlease enter the order ID you want to search:");
                                System.out.println("For example 149590289");
                                String orderIDInString = keyboard.nextLine();
                                long orderID = Long.parseLong(orderIDInString);
                                System.out.println();
                                binarySaleSearch(orderID);
                                break;

                            case "6":
                                System.out.println("\nPlease enter the order ID you want to search:");
                                System.out.println("For example 149590289");
                                String orderIDInStringSequentialSearch = keyboard.nextLine();
                                long orderIDSequentialSearch = Long.parseLong(orderIDInStringSequentialSearch);
                                System.out.println();
                                sequentialSaleSearch(orderIDSequentialSearch);
                                break;

                            case "7":
                                Sales salesAdd = new Sales();
                                System.out.println("\nPlease enter the sales information you want to add:");

                                System.out.println("Please enter the country:");
                                System.out.println("For example: Germany");
                                String countryAdd = keyboard.nextLine();
                                salesAdd.setCountry(countryAdd);

                                System.out.println("Please enter the item type:");
                                System.out.println("For example: Fruits");
                                String itemTypeAdd = keyboard.nextLine();
                                salesAdd.setItemType(itemTypeAdd);

                                System.out.println("Please enter the order priority:");
                                System.out.println("For example: M");
                                String orderPriorityAdd = keyboard.nextLine();
                                salesAdd.setOrderPriority(orderPriorityAdd.charAt(0));

                                System.out.println("Please enter the order date:");
                                System.out.println("For example: 16/03/2016");
                                String orderDateAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setOrderDate(format.parse(orderDateAdd));
                                }
                                catch (ParseException e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Please enter the order ID:");
                                System.out.println("For example: 300152766");
                                String orderIDAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setOrderID(Long.parseLong(orderIDAdd));
                                }
                                catch (Exception e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Please enter the ship date:");
                                System.out.println("For example: 08-04-2016");
                                String shipDateAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setShipDate(format.parse(shipDateAdd));
                                }
                                catch (ParseException e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Please enter the units sold");
                                System.out.println("For example: 7281");
                                String unitSoldAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setUnitsSold(Integer.parseInt(unitSoldAdd));
                                }
                                catch (Exception e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Please enter the units price");
                                System.out.println("For example: 9.33");
                                String unitPriceAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setUnitPrice(Float.parseFloat(unitPriceAdd));
                                }
                                catch (Exception e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Please enter the units cost");
                                System.out.println("For example: 6.92");
                                String unitCostAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setUnitCost(Float.parseFloat(unitCostAdd));
                                }
                                catch (Exception e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Please enter the revenue");
                                System.out.println("For example: 61792.24");
                                String revenueAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setRevenue(Double.parseDouble(revenueAdd));
                                }
                                catch (Exception e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Please enter the total cost");
                                System.out.println("For example: 50307.76");
                                String totalCostAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setTotalCost(Double.parseDouble(totalCostAdd));
                                }
                                catch (Exception e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("Please enter the total profit");
                                System.out.println("For example: 1754.48");
                                String totalProfitAdd = keyboard.nextLine();
                                try
                                {
                                    salesAdd.setTotalProfit(Double.parseDouble(totalProfitAdd));
                                }
                                catch (Exception e)
                                {
                                    logException(e);
                                    System.out.println(e.getMessage());
                                }

                                addRecord(salesAdd);
                                System.out.println("The sale record has been added");
                                break;

                            case "8":
                                System.out.println();
                                caseTwoFlag = false;
                                break;

                            default:
                                System.out.println("Invalid choice, please enter again.");
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
    public static void fileToList(File dir, List<File> list) throws InvalidFileException
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
                else
                {
                    throw new InvalidFileException();
                }
            }
        }
    }

    //write folder path to list collection
    public static void folderToList(File dir, List<File> list) throws EmptyFolderException
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

                String[] fileContent = file.list();
                if (fileContent.length > 0)
                {

                }
                else if (fileContent.length <= 0)
                {
                    throw new EmptyFolderException();
                }
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

    //add record to salesArr database
    public static void addRecord(Sales sales)
    {
        Sales[] salesArrAdd = new Sales[salesArr.length+1];

        for(int i = 0; i < salesArr.length; i++)
        {
            salesArrAdd[i] = salesArr[i];
        }

        salesArrAdd[salesArr.length] = sales;
        salesArr = new Sales[salesArrAdd.length];
        salesArr = salesArrAdd;
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

        //create a temp sales array to store newly added record
        int salesArrSpace = salesArr.length;
        int salesArrTempSpace = salesArrSpace + recordNumber;
        salesArrTemp = new Sales[salesArrTempSpace];

        //store previous record
        for(int i = 0; i < salesArrSpace; i++)
        {
            salesArrTemp[i] = salesArr[i];
        }

        //define added record by default constructor
        for(int i = salesArrSpace; i < salesArrTempSpace; i++)
        {
            salesArrTemp[i] = new Sales();
        }

        //transfer from String format record in txt file to Sales objects
        try
        {
            System.out.println();

            //get character stream
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String line;
            int index = 0;

            while((line = bufferedReader.readLine()) != null)
            {
                stringDataSet[index] = line;
                index = index + 1;
            }

            for(int i = 0, k = salesArrSpace ; i < stringDataSet.length; i++, k++)
            {
                System.out.println("record NO." + (i+1) + " store in file: "+stringDataSet[i]);
                String[] splitData = stringDataSet[i].split("\\s+");
                for (int j = 0; j < splitData.length; j++)
                {
                    if (j == 0)
                    {
                        salesArrTemp[k].setCountry(splitData[j]);
                    }
                    else if (j == 1)
                    {
                        salesArrTemp[k].setItemType(splitData[j]);
                    }
                    else if (j == 2)
                    {
                        salesArrTemp[k].setOrderPriority(splitData[j].charAt(0));
                    }
                    else if (j == 3)
                    {
                        salesArrTemp[k].setOrderDate(format.parse(splitData[j]));
                    }
                    else if (j == 4)
                    {
                        salesArrTemp[k].setOrderID(Long.parseLong(splitData[j]));
                    }
                    else if (j == 5)
                    {
                        salesArrTemp[k].setShipDate(format.parse(splitData[j]));
                    }
                    else if (j == 6)
                    {
                        salesArrTemp[k].setUnitsSold(Integer.parseInt(splitData[j]));
                    }
                    else if (j == 7)
                    {
                        salesArrTemp[k].setUnitPrice(Float.parseFloat(splitData[j]));
                    }
                    else if (j == 8)
                    {
                        salesArrTemp[k].setUnitCost(Float.parseFloat(splitData[j]));
                    }
                    else if (j == 9)
                    {
                        salesArrTemp[k].setRevenue(Double.parseDouble(splitData[j]));
                    }
                    else if (j == 10)
                    {
                        salesArrTemp[k].setTotalCost(Double.parseDouble(splitData[j]));
                    }
                    else if (j == 11)
                    {
                        salesArrTemp[k].setTotalProfit(Double.parseDouble(splitData[j]));
                    }
                }
                System.out.println("record NO." + (k+1) + " add in system: " + salesArrTemp[k]);
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

        salesArr = new Sales[salesArrTempSpace];
        salesArr = salesArrTemp;
    }

    //identify and generate a collection without duplicate records
    public static void identifyDuplicateRecords()
    {
        File file = new File(dir, "output.txt");
        List<Sales> list = new ArrayList<Sales>();
        for (int i=0; i<salesArr.length; i++)
        {
            if(!list.contains(salesArr[i]))
            {
                list.add(salesArr[i]);
            }
            else if(list.contains(salesArr[i]))
            {
                System.out.println("Duplicate record: " + salesArr[i].toString());
            }
        }
        System.out.println("Database without duplicate record: " + list);

        try
        {
            bufferedWriter = new BufferedWriter( new FileWriter(file) );

            for(int i = 0; i < list.size(); i++ )
            {
                bufferedWriter.write(String.valueOf(list.get(i)));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException e)
        {
            logException(e);
            throw new RuntimeException("Failed to write file.");
        }
        System.out.println("output.txt file generate.");
    }

    //notify user duplicate records
    public static void duplicateRecordNotification() throws DuplicateRecordException
    {
        List<Sales> list = new ArrayList<Sales>();
        for (int i=0; i<salesArr.length; i++)
        {
            if(!list.contains(salesArr[i]))
            {
                list.add(salesArr[i]);
            }
            else
            {
                throw new DuplicateRecordException();
            }
        }
    }

    //search a record using binary search method
    public static void binarySaleSearch(long orderID)
    {
        //sort database order ID in increasing order
        for(int i = 0; i < salesArr.length - 1; i++)
        {
            for(int j = i + 1; j < salesArr.length; j++)
            {
                Sales temp = new Sales();
                if(salesArr[i].getOrderID()>salesArr[j].getOrderID())
                {
                    temp = salesArr[i];
                    salesArr[i] = salesArr[j];
                    salesArr[j] = temp;
                }
            }
        }

        //store sorted order ID
        long[] orderIDList = new long[salesArr.length];

        for(int i = 0; i < orderIDList.length; i++)
        {
            orderIDList[i] = salesArr[i].getOrderID();
        }

        time = 0;
        long searchResultID = binarySearchRecursion(orderIDList, 0, orderIDList.length - 1, orderID);
        if(searchResultID == -1)
        {
            System.out.println("Can not find the record with order ID: " + orderID);
        }
        else
        {
            for(int i = 0; i < salesArr.length; i++)
            {
                if (salesArr[i].getOrderID() == orderID)
                {
                    System.out.println("Record result with order ID:");
                    System.out.println(salesArr[i]);
                    System.out.println("Number of iterations need to perform the search:");
                    System.out.println(time);
                }
            }
        }
    }

    //binary search method
    public static long binarySearchRecursion(long[] input, int low, int high, long target)
    {
        int middle = (low + high) / 2;

        // base case
        if (target < input[low] || target > input[high] || low > high)
        {
            time++;
            return -1;
        }

        if (target < input[middle])
        {
            time++;
            return binarySearchRecursion(input, low, middle - 1, target);
        }
        else if (target > input[middle])
        {
            time++;
            return binarySearchRecursion(input, low + 1, high, target);
        }
        else
            {
                time++;
                return middle;
            }
    }

    //search a record using sequential search method
    public static void sequentialSaleSearch(long orderID)
    {
        boolean searchFlag = false;
        time = 0;

        for(int i = 0; i < salesArr.length; i++)
        {
            time++;
            if (salesArr[i].getOrderID() == orderID)
            {
                searchFlag = true;
                System.out.println("Record result with order ID:");
                System.out.println(salesArr[i]);
                System.out.println("Number of iterations need to perform the search:");
                System.out.println(time);
            }
        }

        if(searchFlag == false)
        {
            System.out.println("Can not find the record with order ID: " + orderID);
        }
    }
}
