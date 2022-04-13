package Course;

public class Practice3
{
    public static void main(String[] args)
    {
        char c1 = 97;
        System.out.println(c1);
        int i1 = 'Z';
        System.out.println(i1);
        System.out.println();

        char c2 = 'a' + 1;
        System.out.println(c2);
        int i2 = 'a' + 1;
        System.out.println(i2);
        System.out.println();

        int i3 = 97;
        char c3 = (char)i3;
        System.out.println(c3);
        System.out.println();

        char c4 = '1';
        int i4 = c4 - '0';
        System.out.println(i4);
        int i5 = 1;
        char c5 = (char)(i5 + '0');
        System.out.println(c5);
        System.out.println();

        String s1 = "22307 35806 24555 20048";
        String[] chars1 = s1.split(" ");
        for(int i = 0; i < chars1.length; i ++)
        {
            System.out.println(chars1[i] + " " + (char)Integer.parseInt(chars1[i]));
        }
        System.out.println();

        String s2 = "新年快乐";
        char[] chars2 = s2.toCharArray();
        for(int i = 0; i < chars2.length; i++)
        {
            System.out.println(chars2[i] + " " + (int)chars2[i]);
        }
        System.out.println();
    }
}
