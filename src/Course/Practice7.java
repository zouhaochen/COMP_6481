package Course;

import java.util.Arrays;

public class Practice7
{
    public static void main(String[] args)
    {
        Student s1 = new Student("Zhang", 80);
        Student s2 = new Student("Zhbng",68);
        Student s3 = new Student("Zhcng", 71);
        Student s4 = new Student("Li", 80);

        Student[] ss = {s1, s2, s3, s4};

        for(Student s : ss)
        {
            System.out.println(s);
        }

        Arrays.sort(ss);
        for(Student s : ss)
        {
            System.out.println(s);
        }
    }
}

class Student implements Comparable<Student>
{
    public String name;
    public int point;

    public Student()
    {

    }

    public Student(String name, int point)
    {
        this.name = name;
        this.point = point;
    }

    public int compareTo(Student student)
    {
        int stringCompare = this.name.compareTo(student.name);
        if(stringCompare == 0)
        {
            return this.point - student.point;
        }
        else
        {
            return stringCompare;
        }
    }

    public String toString()
    {
        return this.name + "\t" + point;
    }
}

