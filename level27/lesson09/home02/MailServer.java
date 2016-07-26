package com.javarush.test.level27.lesson09.home02;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {

            synchronized (mail)
            {
                long beforeTime = System.currentTimeMillis();
                while (mail.getText() == null)
                {
                    try
                    {
                        mail.wait();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

                String name = Thread.currentThread().getName();
                long afterTime = System.currentTimeMillis();
                System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
            }
            //сделайте что-то тут - do something here

    }
}