package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution(){}
    Solution(String s){}
    Solution(Integer a){}

    public Solution(int a){}
    public Solution(int a, int b){}
    public Solution(int a, float b){}

    private Solution(float a){}
    private Solution(float a, float b){}
    private Solution(float a, int b){}

    protected  Solution(double a){}
    protected Solution(double a, String s){}
    protected Solution(double a, float b){}

}

