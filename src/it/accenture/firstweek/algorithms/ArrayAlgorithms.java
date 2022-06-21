package it.accenture.firstweek.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayAlgorithms {
    public static void main(String[] args) {
        double array[] = new double[100];

        for(int i=0; i<array.length; i++) {
            array[i] = Math.round(Math.random()*10);
        }
        for(int i=0; i< array.length; i++){
            System.out.println(array[i]);
        }

        int instances = findInstances(0, array);
        System.out.println(instances);

        double result = betterFindMode(array);
        System.out.println(result);

        double mode = findMode(array);
        System.out.println(mode);
    }
    public static double findMin(double arr[]){
        double min = arr[0];

        for(int j=1; j<arr.length; j++ ){
            if(arr[j]<min){
                min = arr[j];
            }
        }
        return min;
    }

    public static int findInstances(double target, double array[]){
        int count=0;

        for(int j=0; j<array.length; j++){
            if(array[j]==target){
                count++;
            }
        }
        return count;
    }

    public static double findMode(double array[]){
        int modeInstances = findInstances(array[0], array);
        double mode = array[0];

        for(int j=1; j< array.length; j++){
            int instances=findInstances(array[j], array);
            if(instances>modeInstances){
                modeInstances = instances;
                mode = array[j];
            }
        }
        return mode;
    }

    public static double betterFindMode(double array[]){
        HashMap<Double, Integer> m = new HashMap<>();
        for(int j=0; j< array.length; j++){
            /*if(m.containsKey(array[j])){
                m.put(array[j], m.get(array[j])+1);
            }else {
                m.put(array[j], 1);
            }*/
            Integer n = m.get(array[j]);
            if(n==null){
                n=0;
            }
            n++;
            m.put(array[j], n);
        }
        double numbers[] = new double[5];
        for(double d : numbers){
            System.out.println(d);
        }
        ArrayList<Double> numbers2 = new ArrayList<>();
        for(Double d: numbers2){
            System.out.println(d);
        }
        for(Iterator<Double> it = numbers2.iterator(); it.hasNext();){
            Double d = it.next();
            System.out.println(d);
        }
        System.out.println("Stampiamo le chiavi della mappa:");
        for(Double key: m.keySet()){
            System.out.println(key);
        }
        System.out.println("Stampiamo i valori della mappa:");
        for(Integer occourence: m.values()){
            System.out.println(occourence);
        }
        System.out.println("Stampiamo le coppie chiave-valore della mappa:");
        //var z=3;
        for(Map.Entry<Double, Integer> kv: m.entrySet()){
            System.out.printf("Chiave %f Valore %d %n", kv.getKey(), kv.getValue());
        }
        Iterator<Map.Entry<Double, Integer>> it = m.entrySet().iterator();
        Map.Entry<Double, Integer> modeEntry = it.next();
        while(it.hasNext()){
            var entry = it.next();
            if(entry.getValue()>modeEntry.getValue()){
                modeEntry = entry;
            }
        }

        return modeEntry.getKey();
    }

}

