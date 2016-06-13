package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution sol = new Solution();
        B b = sol.new B("B");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Flex\\Desktop\\1.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\Flex\\Desktop\\1.txt"));
        System.out.println(b + " " + b.name);
        out.writeObject(b);
        out.close();
        B new_b = (B)in.readObject();
        System.out.println(new_b +" "+new_b.name);

        in.close();
    }
    public static class A {
        public A(){}
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
        }
    }
}
