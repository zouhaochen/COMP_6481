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
    private String password = "password";

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

        System.out.println("Welcome to the vaccine trace application");
        System.out.println("Please enter the maximum number of vaccine store can contain");
        inputMaxVaccine = input.nextLine();
        while(!inputMaxVaccine.matches(regex))
        {
            System.out.println("Invalid input, please enter again.");
            inputMaxVaccine = input.nextLine();
        }

        maxVaccines = Integer.parseInt(inputMaxVaccine);
        currentVolume = maxVaccines;

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
                //option one
                case "1":
                    String userInputPassword = "";
                    boolean flagPassword = true;

                    while (flagPassword)
                    {
                        System.out.println("\nPlease enter the your password: ");
                        userInputPassword = input.nextLine();
                        if(userInputPassword.equals("password"))
                        {
                            flagPassword = false;
                            passwordCount = 0;
                            String inputCaseOne = "";
                            int numberVaccineAdd = 0;

                            System.out.println("\nHow many vaccines do you want?");
                            System.out.println("Please Enter a number: ");
                            inputCaseOne = input.nextLine();

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
                                addInformation(currentVaccineAmount,finishIndex,inventory);

                                System.out.println(numberVaccineAdd + " vaccines add.");
                                currentVolume = currentVolume - numberVaccineAdd;
                                currentVaccineAmount = currentVaccineAmount + numberVaccineAdd;
                                System.out.println("Current space: " + currentVolume);
                            }
                            else
                            {
                                if(currentVolume == 0)
                                {
                                    System.out.println("No remain place for vaccine!");
                                    break;
                                }
                                System.out.println("\nYou can only add remain places number " + currentVolume + " of vaccines.");
                                System.out.println("Do you want to add " + currentVolume + " vaccines or back to main menu?");
                                System.out.println("Y/y for add information.");
                                System.out.println("N/n for back to main menu.");

                                String addOrBack = input.nextLine();

                                while(!addOrBack.equalsIgnoreCase("y") && !addOrBack.equalsIgnoreCase("n"))
                                {
                                    System.out.println("Invalid choice, please enter again");
                                    addOrBack = input.nextLine();
                                }

                                if(addOrBack.equalsIgnoreCase("y"))
                                {
                                    int startIndex = currentVaccineAmount;
                                    int finalIndex = inventory.length;

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
                            passwordCount++;
                            if(passwordCount%3 == 0 && passwordCount < 12)
                                break;
                            else if(passwordCount >= 12)
                            {
                                System.out.println("\nProgram detected suspicious activities and will terminate immediately!");
                                System.exit(0);
                            }
                        }
                    }
                    break;
                case "2":
                case "3":
                case "4":
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

            while (!vaccinePriceTag.matches(regexDouble))
            {
                System.out.println("Please enter a price tag.");
                vaccinePriceTag = input.nextLine();
            }
        }
    }
}
