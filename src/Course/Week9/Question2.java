package Course.Week9;

import java.util.ArrayList;
import java.util.Scanner;

/*
Write a program that uses an ArrayList of parameter type Contact to store a database of contacts.
The Contact class should store the contact’s first and last name, phone number, and email address.
Add appropriate accessor and mutator methods.
Your database program should present a menu that allows the user to add a contact,
display all contacts, search for a specific contact and display it,
or search for a specific contact and give the user the option to delete it.
The searches should find any contact where any instance variable contains a target search string.
For example, if “elmore” is the search target, then any contact where the first name, last name, phone number,
or email address contains “elmore” should be returned for display or deletion.
Use the “for-each” loop to iterate through the ArrayList .
*/
public class Question2
{
}

//Contact.java
class Contact
{
    private String fName;
    private String lName;
    private String phNum;
    private String emailAdd;

    public Contact(String fn, String ln, String pn, String e)
    {
        fName = fn;
        lName = ln;
        phNum = pn;
        emailAdd = e;
    }
    public void setfName(String newFirst)
    {
        fName = newFirst;
    }
    public void setlName(String newLast)
    {
        lName = newLast;
    }
    public void setphNum(String newNumber)
    {
        phNum = newNumber;
    }
    public void setemailAdd(String newemailAdd)
    {
        emailAdd = newemailAdd;
    }
    public String getfName()
    {
        return fName;
    }
    public String getlName()
    {
        return lName;
    }
    public String getphNum()
    {
        return phNum;
    }
    public String getemailAdd()
    {
        return emailAdd;
    }
}

class ContactsTest
{
    public static void main(String args[])
    {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Scanner in = new Scanner(System.in);
        while(true)
        {
            System.out.println("1)Add a new contact");
            System.out.println("2)Display all contacts");
            System.out.println("3)Display specific contact");
            System.out.println("4)Delete a contact");
            System.out.println("-1) Quit");
            System.out.print("Enter Your choice: ");

            int choice = in.nextInt();
            in.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter first name: ");
                    String fn = in.nextLine();
                    System.out.print("Enter last name: ");
                    String ln = in.nextLine();
                    System.out.print("Enter phone number: ");
                    String pn = in.nextLine();
                    System.out.print("Enter Email address: ");
                    String ea = in.nextLine();
                    contacts.add(new Contact(fn, ln, pn, ea));
                    break;

                case 2:
                    for(int i = 0; i < contacts.size(); i++)
                    {
                        Contact c = contacts.get(i);
                        System.out.print(c.getlName() + "  " + c.getfName() + "; ");
                        System.out.print("Phone number: " + c.getphNum());
                        System.out.print("; Email: " + 	c.getemailAdd());
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Enter an information piece about person:");
                    String info = in.nextLine();
                    Contact c = findPerson(contacts, info);
                    if(c != null)
                    {
                        System.out.print(c.getlName() + ", " + c.getfName() + "; ");
                        System.out.print("Phone number: " + c.getphNum());
                        System.out.print("; Email: " + c.getemailAdd());
                        System.out.println();
                    }
                    else
                        System.out.println("Contact not found.");
                    break;

                case 4:
                    System.out.println("Enter an information piece about person:");
                    String someInfo = in.nextLine();
                    Contact contact = 	findPerson(contacts, someInfo);
                    if(contact != null)
                    {
                        System.out.print(contact.getlName() + ", " + contact.getfName() + "; 				");
                        System.out.print("Phone number: " + 	contact.getphNum());
                        System.out.print("; Email: " + 		contact.getemailAdd());
                        System.out.println();
                        System.out.println("Are you sure to delete contact? (Y/N)");
                        String delete = in.nextLine();
                        if(delete.equalsIgnoreCase("y"))
                        {
                            contacts.remove(contact);
                            System.out.println("Contact deleted successfully.");
                        }
                    }
                    else
                        System.out.println("Contact not found.");

                    break;
            }

            if(choice == -1)
                break;

            System.out.println("___________________________________________");
        }
    }

    private static Contact findPerson(ArrayList<Contact> contacts, String info)
    {
        Contact c = null;
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i).getfName().indexOf(info) != -1)
                c = contacts.get(i);

            if(contacts.get(i).getlName().indexOf(info) != -1)
                c = contacts.get(i);

            if(contacts.get(i).getphNum().indexOf(info) != -1)
                c = contacts.get(i);

            if(contacts.get(i).getemailAdd().indexOf(info) != -1)
                c = contacts.get(i);
        }
        return c;
    }
}
