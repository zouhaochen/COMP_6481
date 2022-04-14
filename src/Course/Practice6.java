package Course;

import java.util.Scanner;

public class Practice6
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many number do you want to store?");
        int count = keyboard.nextInt();

        System.out.println("Please enter NO.1 number:");
        Node root = new Node(keyboard.nextInt());

        for(int i = 2; i <= count; i ++)
        {
            System.out.println("Please enter NO." + i + " number:");
            int number = keyboard.nextInt();
            Main.put(root, number);
        }

        System.out.println("Sort from small to large:");
        Main.showAsc(root);
        System.out.println("Sort from large to small:");
        Main.showDesc(root);
    }
}

class Node
{
    int value;
    Node left;
    Node right;
    Node(int input)
    {
        this.value = input;
    }
}

class Main
{
    public static void put(Node node, int number)
    {
        if(number <= node.value)
        {
            if(node.left == null)
            {
                node.left = new Node(number);
            }
            else
            {
                put(node.left, number);
            }
        }
        else
        {
            if(node.right == null)
            {
                node.right = new Node(number);
            }
            else
            {
                put(node.right, number);
            }
        }
    }

    public static void showAsc(Node node)
    {
        if(node.left != null)
        {
            showAsc(node.left);
        }
        System.out.println(node.value + " ");
        if(node.right != null)
        {
            showAsc(node.right);
        }
    }

    public static void showDesc(Node node)
    {
        if(node.right != null)
        {
            showDesc(node.right);
        }
        System.out.println(node.value + " ");
        if(node.left != null)
        {
            showDesc(node.left);
        }
    }
}
