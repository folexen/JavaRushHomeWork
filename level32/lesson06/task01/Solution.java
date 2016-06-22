package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        char[] random =  "abcdefghijklmnopqrstuvwxyABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        char[] smallChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] bigChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        boolean hasSmallChars = false;
        boolean hasBigChars = false;
        boolean hasNumbers = false;
        for (int i = 0; i < 8; i++)
        {
            if (hasBigChars && hasSmallChars && hasNumbers)
            {
                byteArrayOutputStream.write(random[(int)(Math.random()*random.length)]);
            }
            else
            {
                if (!hasNumbers)
                {
                    hasNumbers = true;
                    byteArrayOutputStream.write(numbers[(int)(Math.random()*numbers.length)]);
                }
                else if (!hasSmallChars)
                {
                    hasSmallChars = true;
                    byteArrayOutputStream.write(smallChars[(int)(Math.random()*smallChars.length)]);
                }
                else if (!hasBigChars)
                {
                    hasBigChars = true;
                    byteArrayOutputStream.write(bigChars[(int)(Math.random()*bigChars.length)]);
                }
            }
        }
        return byteArrayOutputStream;
    }
}