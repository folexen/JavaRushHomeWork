package com.javarush.test.level15.lesson12.home05;

public class SubSolution extends Solution
{
    SubSolution(){}
    SubSolution(String s) {super(s);}
    SubSolution(Integer a) {super(a);}

    public SubSolution(int a){super(a);}
    public SubSolution(int a, int b){super(a, b);}
    public SubSolution(int a, float b){super(a, b);}

    protected SubSolution(double a){super(a);}
    protected SubSolution(double a, String s){super(a, s);}
    protected SubSolution(double a, float b){super(a, b);}

    private SubSolution(float a){}
    private SubSolution(float a, float b){}
    private SubSolution(float a, int b){}
}
