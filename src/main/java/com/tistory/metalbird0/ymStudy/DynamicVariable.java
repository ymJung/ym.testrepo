package com.tistory.metalbird0.ymStudy;

import java.util.HashMap;

import com.google.common.collect.Maps;

public class DynamicVariable {

    public void printArr(int... args) {
        for (int arg : args) {
            System.out.println(args.getClass() + " : printArr : " + arg);
        }
    }

    public void printArr(String... args) {
        for (String arg : args) {
            System.out.println(args.getClass() + " : printArr : " + arg);
        }
    }

    public void simpleHashMap(HashMap<String, String> map, String key) {
        System.out.println("simpleHashMap" + map.get(key));
    }
    
    
    public static void main(String[] args) {
        DynamicVariable obj = new DynamicVariable();
        obj.printArr(1, 2, 3, 4);
        obj.printArr("one", "two", "three");
        
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "new HashMap<>() <- java1.7 diamond operator");
        obj.simpleHashMap(map, "key");
        HashMap<String, String> gMap = Maps.newHashMap();
        map.put("key", "Maps.newHashMap() <- nice guava");
        obj.simpleHashMap(gMap, "key");
    }
}
