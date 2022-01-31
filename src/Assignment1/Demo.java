package Assignment1;

import java.util.Scanner;

import static Assignment1.Vaccine.Brand.*;

/**
 * @Auther: Haochen Zou
 * @Date: 2022/1/30 - 下午4:19
 * @Description: Assignment1
 * @version: 1.0
 */
public class Demo
{
    public static void main(String[] args)
    {
        String regex = "^\\d+(\\.\\d+)?$";
        String ss = "-0.1";
        System.out.println(ss.matches(regex));
    }
}
