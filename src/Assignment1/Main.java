package Assignment1;

import java.util.Scanner;

import static Assignment1.Vaccine.Brand.*;

/**
 * Assignment I part II B
 * © Haochen Zou
 * Written by Haochen Zou 40158179
 */
public class Main
{
    private static String password = "password";

    public static void main(String[] args)
    {
        String regex = "^[1-9]+[0-9]*$";
        int maxVaccines = 0;
        String inputMaxVaccine = "";
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        String choice = "";
        int passwordCount = 0;
        int currentVolume = 0;
        int currentVaccineAmount = 0;
        Vaccine[] inventory;

        //display welcome information
        System.out.println("Welcome to the vaccine trace application!");

        //prompt for user input maximum number of vaccine
        System.out.println("Please enter the maximum number of vaccine store can contain.");
        inputMaxVaccine = input.nextLine();

        //input data validate check
        while(!inputMaxVaccine.matches(regex))
        {
            System.out.println("Invalid input, please enter again.");
            inputMaxVaccine = input.nextLine();
        }
        maxVaccines = Integer.parseInt(inputMaxVaccine);
        currentVolume = maxVaccines;

        //empty array inventory track created vaccine objects
        inventory = new Vaccine[maxVaccines];

        //main menu
        while(flag)
        {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Enter new vaccines (password required)");
            System.out.println("2. Change information of a vaccine (password required)");
            System.out.println("3. Display all vaccines by a specific brand");
            System.out.println("4. Display all vaccines under a certain a price.");
            System.out.println("5. Quit");
            System.out.println("Please enter your choice:");

            //get user input
            choice = input.nextLine();

            switch (choice)
            {
                case "1":
                    String userInputPassword = "";
                    boolean flagPassword = true;

                    //password validate check
                    while (flagPassword)
                    {
                        System.out.println("\nPlease enter the your password: ");
                        userInputPassword = input.nextLine();

                        if(userInputPassword.equals(password))
                        {
                            flagPassword = false;
                            passwordCount = 0;
                            String inputCaseOne = "";
                            int numberVaccineAdd = 0;

                            if(currentVolume == 0)
                            {
                                System.out.println("No remain place for vaccine!");
                                break;
                            }

                            //get enter vaccine number and compare
                            System.out.println("\nHow many vaccines do you want?");
                            System.out.println("Please Enter a number: ");
                            inputCaseOne = input.nextLine();

                            //input validate check
                            while(!inputCaseOne.matches(regex))
                            {
                                System.out.println("Invalid input, please enter again.");
                                inputCaseOne = input.nextLine();
                            }

                            numberVaccineAdd = Integer.parseInt(inputCaseOne);
                            if(numberVaccineAdd <= currentVolume)
                            {
                                System.out.println("\nEnough space for you to add vaccine.");
                                int finishIndex = currentVaccineAmount + numberVaccineAdd;

                                //input vaccine information to inventory array
                                addInformation(currentVaccineAmount,finishIndex,inventory);

                                System.out.println(numberVaccineAdd + " vaccines add.");
                                currentVolume = currentVolume - numberVaccineAdd;
                                currentVaccineAmount = currentVaccineAmount + numberVaccineAdd;
                                System.out.println("Current space: " + currentVolume);
                            }
                            else
                            {
                                //inform user the number of remaining space
                                System.out.println("\nYou can only add remain places number " + currentVolume + " of vaccines.");
                                System.out.println("Do you want to add " + currentVolume + " vaccines or back to main menu?");
                                System.out.println("Y/y for add information.");
                                System.out.println("N/n for back to main menu.");
                                String addOrBack = input.nextLine();

                                //input validate check
                                while(!addOrBack.equalsIgnoreCase("y") && !addOrBack.equalsIgnoreCase("n"))
                                {
                                    System.out.println("Invalid choice, please enter again");
                                    addOrBack = input.nextLine();
                                }

                                //if user want to fill the left remaining number vaccine space
                                if(addOrBack.equalsIgnoreCase("y"))
                                {
                                    int startIndex = currentVaccineAmount;
                                    int finalIndex = inventory.length;

                                    //input vaccine information to inventory array
                                    addInformation(startIndex,finalIndex,inventory);

                                    currentVolume = 0;
                                    currentVaccineAmount = finalIndex;
                                }
                                else if(addOrBack.equalsIgnoreCase("n"))
                                {
                                    break;
                                }
                            }
                        }
                        else
                        {
                            //count for the times wrong password input
                            passwordCount++;

                            //after 3rd wrong password entry, back to main menu
                            if(passwordCount%3 == 0 && passwordCount < 12)
                                break;

                            //after enter 12 times wrong password, exit the program
                            else if(passwordCount >= 12)
                            {
                                System.out.println("\nProgram detected suspicious activities and will terminate immediately!");
                                System.exit(0);
                            }
                        }
                    }
                    break;
                case "2":
                    String passwordCaseTwo = "";
                    Boolean flagCaseTwo = true;
                    int passwordCaseTwoCount = 0;
                    String regexCaseTwo = "^\\d+$";
                    String addOrBackCaseTwo = "";

                    while(flagCaseTwo)
                    {
                        System.out.println("\nPlease enter the your password: ");
                        passwordCaseTwo = input.nextLine();

                        if(passwordCaseTwo.equals(password))
                        {
                            flagCaseTwo = false;
                            passwordCaseTwoCount = 0;
                            String userInputCaseTwo = "";
                            int userInputCaseTwoInInt = 0;

                            System.out.println("\nWhich vaccine number you want to update?");
                            System.out.println("Current vaccine number display as follow:");

                            for(int i = 0; i < inventory.length; i++)
                            {
                                System.out.print(i+" ");
                            }
                            System.out.println();

                            while(true)
                            {

                            }
                            /*
                            userInputCaseTwo = input.nextLine();

                            //vaccine number validate check
                            while(!userInputCaseTwo.matches(regexCaseTwo))
                            {
                                System.out.println("Please enter a valid vaccine number.");
                                userInputCaseTwo = input.nextLine();
                            }

                            userInputCaseTwoInInt = Integer.parseInt(userInputCaseTwo);
                            if(userInputCaseTwoInInt>inventory.length || inventory[userInputCaseTwoInInt] == null)
                            {
                                //no vaccine inform user to make choice
                                System.out.println("\nNo vaccine at specified number.");
                                System.out.println("Do you want to reenter another vaccine number?");
                                System.out.println("Y/y for reenter another number.");
                                System.out.println("N/n for back to main menu.");
                                addOrBackCaseTwo = input.nextLine();

                                //Input choice validate check
                                while(!addOrBackCaseTwo.equalsIgnoreCase("y") && !addOrBackCaseTwo.equalsIgnoreCase("n"))
                                {
                                    System.out.println("Invalid choice, please enter again");
                                    addOrBackCaseTwo = input.nextLine();
                                }

                                if(addOrBackCaseTwo.equalsIgnoreCase("y"))
                                {
                                    userInputCaseTwo = input.nextLine();
                                }
                                else if(addOrBackCaseTwo.equalsIgnoreCase("n"))
                                {
                                    break;
                                }
                            }
                             */
                        }
                        else
                        {
                            passwordCaseTwoCount++;
                            if(passwordCaseTwoCount%3==0)
                                break;
                        }
                    }
                    break;
                case "3":
                    System.out.println("\nPlease enter vaccine name:");
                    String searchName = input.nextLine();

                    //vaccine name validate check
                    while (!searchName.equals(pfizer.toString()) &&
                            !searchName.equals(moderna.toString()) &&
                            !searchName.equals(johnson.toString()) &&
                            !searchName.equals(others.toString()) &&
                            !searchName.equals(unknown.toString()))
                    {
                        System.out.println("Please enter a valid name: pfizer, moderna, johnson, others, unknown.");
                        searchName = input.nextLine();
                    }

                    Vaccine.Brand searchNameInBrand = Vaccine.Brand.valueOf(searchName);
                    findVaccinesBy(searchNameInBrand,inventory);
                    break;

                case "4":
                    String regexDouble = "^\\d+(\\.\\d+)?$";
                    double priceSmallerThan = 0;

                    System.out.println("\nPlease enter vaccine price value:");
                    String priceEnter = input.nextLine();

                    //vaccine price tag validate check
                    while (!priceEnter.matches(regexDouble))
                    {
                        System.out.println("Please enter a valid price tag.");
                        priceEnter = input.nextLine();
                    }

                    priceSmallerThan = Double.parseDouble(priceEnter);
                    findCheaperThan(priceSmallerThan,inventory);
                    break;

                case "5":
                    flag = false;
                    System.out.println("\nExit the program, see you next time");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please enter again");
                    break;
            }
        }
    }

    //add vaccine information into an array for tracking
    public static void addInformation(int startPoint, int endPoint, Vaccine[] vaccineList)
    {
        String regex = "^[1-9]+[0-9]*$";
        String regexDouble = "^\\d+(\\.\\d+)?$";
        Scanner input = new Scanner(System.in);

        for(int i = startPoint; i < endPoint; i++)
        {
            int VaccineNo = i;
            vaccineList[i] = new Vaccine(i);

            System.out.println("\nPlease enter Vaccine NO." + VaccineNo + " information:");
            System.out.println("Please enter Vaccine NO." + VaccineNo + " name:");
            String vaccineName = input.nextLine().toLowerCase();

            //vaccine brand validate check
            while (!vaccineName.equals(pfizer.toString()) &&
                    !vaccineName.equals(moderna.toString()) &&
                    !vaccineName.equals(johnson.toString()) &&
                    !vaccineName.equals(others.toString()) &&
                    !vaccineName.equals(unknown.toString()))
            {
                System.out.println("Please enter a valid name: pfizer, moderna, johnson, others, unknown.");
                vaccineName = input.nextLine();
            }

            vaccineList[i].setBrand(Vaccine.Brand.valueOf(vaccineName));

            System.out.println("Please enter Vaccine NO." + VaccineNo + " dose:");
            String vaccineDose = input.nextLine();

            //vaccine dose validate check
            while(!vaccineDose.matches(regex))
            {
                System.out.println("Please enter a valid dose.");
                vaccineDose = input.nextLine();
            }

            double vaccineDoseInNumber = Double.parseDouble(vaccineDose);
            vaccineList[i].setVaccineDose(vaccineDoseInNumber);

            System.out.println("Please enter Vaccine NO." + VaccineNo + " expiry date");
            String vaccineExpiryDate = input.nextLine();
            vaccineList[i].setExpiryDate(vaccineExpiryDate);

            System.out.println("Please enter Vaccine NO." + VaccineNo + " price tag");
            String vaccinePriceTag = input.nextLine();

            //vaccine price tag validate check
            while (!vaccinePriceTag.matches(regexDouble))
            {
                System.out.println("Please enter a valid price tag.");
                vaccinePriceTag = input.nextLine();
            }

            double vaccinePriceTagInNumber = Double.parseDouble(vaccinePriceTag);
            vaccineList[i].setPriceTag(vaccinePriceTagInNumber);
        }
    }

    //search for vaccine with price value lower than input value
    public static void findCheaperThan(double priceCheaperThan, Vaccine[] vaccineList)
    {
        System.out.println("\nVaccines value less than " + priceCheaperThan + " display as follow:");
        double vaccinePriceTag = 0;

        for(int i = 0; i < vaccineList.length; i++)
        {
            vaccinePriceTag = vaccineList[i].getPriceTag();
            if (vaccinePriceTag < priceCheaperThan)
            {
                System.out.println(vaccineList[i]);
            }
        }
    }

    //search for vaccine with input brand name
    public static void findVaccinesBy(Vaccine.Brand brandNameSearch, Vaccine[] vaccineList)
    {
        System.out.println("\nVaccine with brand name " + brandNameSearch + " displays as follow:");
        for(int i = 0; i < vaccineList.length; i++)
        {
            Vaccine.Brand vaccineBrandName = vaccineList[i].getBrand();
            if(vaccineBrandName.equals(brandNameSearch))
            {
                System.out.println(vaccineList[i]);
            }
        }
    }
}
