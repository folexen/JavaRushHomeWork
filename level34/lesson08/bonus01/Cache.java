package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if (cache.containsKey(key))
        {
            return cache.get(key);
        }
        else
        {
           Constructor<V> constructor = clazz.getDeclaredConstructor(key.getClass());
           cache.put(key, constructor.newInstance(key));
        }
        return cache.get(key);

    }

    public boolean put(V obj) {
        //TODO add your code here
        try
        {
            Method methodGetKey = obj.getClass().getDeclaredMethod("getKey");
            methodGetKey.setAccessible(true);
            K key = (K)methodGetKey.invoke(obj);
            cache.put(key, obj);
            return true;
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored)
        {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
