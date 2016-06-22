package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{

    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException
    {

        Object tmp = objectStream.readObject();
        if (tmp instanceof B) return (B)tmp;
        else return (A)tmp;

    }

    public class A implements Serializable
    {
        private static final long serialVersionUID = 1L;
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
