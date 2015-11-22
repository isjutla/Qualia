import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Map<String, Integer> radix = new HashMap<String, Integer>();
        radix.put("a", 1);
        radix.put("b",2);
        radix.put("c", 3);
        List<String> ina = new ArrayList<String>();
        ina.add("abc");
        ina.add("c");
        ina.add("aaa");
        ina.add("cc");
        ina.add("cba");
        ina.add("aa");
        ina.add("b");
        ina.add("");
        List<List<String>> buck;
        System.out.println("nothing");
        boolean done = false;
        int pos = 2;
        while(pos >= 0) {
            done = true;
            buck = new ArrayList<List<String>>(26);
            initBuck(buck, 26);
            for(String a: ina){
                if(a.length() >= pos+1) {
                    done = false;
                    int r = radix.get(Character.toString(a.charAt(pos)));
                    List<String> rad = buck.get(r);
                    rad.add(a);
                } else {
                    List<String> rad = buck.get(0);
                    rad.add(a);
                }
            }
            System.out.println(ina);
            pos = pos - 1;
            ina = bucketToList(buck);
        }
        System.out.println(ina);

    }

    public static void initBuck(List<List<String>> buck, int size) {
        for(int i = 0; i < size; i++) {
            buck.add(new ArrayList<String>());
        }
    }

    public static List<String> bucketToList(List<List<String>> buck) {
        List<String> test = new ArrayList<String>();
        for(List<String> bucket: buck) {
            for(String val: bucket) {
                test.add(val);
            }
        }
        return test;
    }

}