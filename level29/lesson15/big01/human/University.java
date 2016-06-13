package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University
{
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public University(String name, int age) {

        this.age = age;
        this.name = name;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        if (students != null && !students.isEmpty())
        {
            for (Student student: students)
            {
                if(student.getAverageGrade() == averageGrade)
                {
                    return student;
                }

            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxAverageGrade = 0;
        Student studentWithMaxAverageGrade = null;
        if (students != null && !students.isEmpty())
        {
            for (Student student: students)
            {
                if (student.getAverageGrade() > maxAverageGrade)
                {
                    maxAverageGrade = student.getAverageGrade();
                    studentWithMaxAverageGrade = student;
                }
            }
        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minAverageGrade = 100;
        Student studentWithMinAverageGrade = null;
        if (students != null && !students.isEmpty())
        {
            for (Student student: students)
            {
                if (student.getAverageGrade() < minAverageGrade)
                {
                    minAverageGrade = student.getAverageGrade();
                    studentWithMinAverageGrade = student;
                }
            }
        }
        return studentWithMinAverageGrade;

    }
    public void expel(Student student)
    {
        if (students !=null && !students.isEmpty())
        {
            students.remove(student);
        }
    }
}
