package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Flex on 26.04.2016.
 */
public class AmigoSet<T> extends AbstractSet<T> implements Serializable, Cloneable, Set<T>
{
    private static final Object PRESENT = new Object();
    private transient HashMap<T, Object> map;

    public AmigoSet()
    {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends T> collection)
    {
        this.map = new HashMap<>(Math.max(16, (int)(collection.size()/0.75f)));
        for (T t: collection)
        {
            map.put(t, PRESENT);
        }

    }

    @Override
    public Iterator<T> iterator()
    {
        return map.keySet().iterator();
    }

    @Override
    public int size()
    {
        return map.keySet().size();
    }

    public boolean add(T t)
    {
        if (map.containsKey(t))
        {
            map.put(t, PRESENT);
            return true;
        }
        else
        {
            map.put(t, PRESENT);
            return false;
        }
    }

    public boolean isEmpty()
    {
        return map.keySet().size() == 0;
    }

    public boolean contains(Object o)
    {
        return map.containsKey(o);
    }

    public void clear()
    {
        map.clear();
    }

    public boolean remove(Object o)
    {
        if (map.containsKey(o))
        {
            map.remove(o);
            return true;
        }
        else return false;

    }

    public Object clone()
    {
        try
        {
            AmigoSet<T> amigoSet = new AmigoSet<>();
            amigoSet.map = this.map;
            return amigoSet;
        }
        catch (Exception ex)
        {
            throw new InternalError();
        }

    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException
    {
        s.defaultWriteObject();
        s.writeObject(map.size());
        for(T t:map.keySet()){
            s.writeObject(t);
        }
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }
    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException
    {
        s.defaultReadObject();
        int size = (int)s.readObject();
        Set<T> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((T)s.readObject());
        }
        int capacity = (int)s.readObject();
        float loadFactor = (float)s.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for(T t:set){
            map.put(t,PRESENT);
        }
    }




}
