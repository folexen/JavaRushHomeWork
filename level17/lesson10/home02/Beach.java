package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach beach)
    {
        int q  = this.getQuality() - beach.getQuality();
        float d = this.getDistance() - beach.getDistance();
        int n = this.getName().compareTo(beach.getName());
        return (int)(d*100) + q*10000 + n;
    }

    public static void main(String[] args)
    {
        Beach beach1 = new Beach("b1", 1.2f, 7);
        Beach beach2 = new Beach("b2", 1.3f, 10);
        Beach beach3 = new Beach("b3", 1.4f, 9);
        Beach beach4 = new Beach("b4", 1.3f, 10);
        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach1.compareTo(beach3));
        System.out.println(beach1.compareTo(beach4));
        System.out.println(beach2.compareTo(beach3));
        System.out.println(beach2.compareTo(beach4));

    }
}
