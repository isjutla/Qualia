import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Runtime: O(k*n) where k is the maximum size of a word
 * and n is the length of the list. The while loop will
 * iterate about k times. Each iteration of the while loop
 * does a constant number of operations that are at most O(n).
 * (List.get, List.add, and HashMap.get are all O(1) and are done
 * for each element of the list). bucketToList also process at most
 * n values. Thus the total runtime is O(k*n)
 * <p/>
 * Author: Inderjit Jutla
 * Date: 2015-11-22
 */
public class Solution {

    /**
     * @param words is the list of words to sort in order
     * @param order describes the lexographic ordering required
     * @return the ordered version of words
     */
    public static List<String> order(List<String> words, String order) {
        Map<Character, Integer> radix = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) {
            radix.put(order.charAt(i), i + 1);
        }
        int pos = 0;
        for (String word : words) {
            if (word.length() - 1 > pos) {
                pos = word.length() - 1;
            }
        }
        while (pos >= 0) {
            List<List<String>> buck = new ArrayList<List<String>>();
            initBuck(buck, radix.size() + 1);
            for (String a : words) {
                if (a.length() >= pos + 1) {
                    int r = radix.get(a.charAt(pos));
                    List<String> rad = buck.get(r);
                    rad.add(a);
                } else {
                    List<String> rad = buck.get(0);
                    rad.add(a);
                }
            }
            pos = pos - 1;
            words = bucketToList(buck);
        }
        return (words);

    }

    public static void initBuck(List<List<String>> buck, int size) {
        for (int i = 0; i < size; i++) {
            buck.add(new ArrayList<String>());
        }
    }

    public static List<String> bucketToList(List<List<String>> buck) {
        List<String> test = new ArrayList<String>();
        for (List<String> bucket : buck) {
            for (String val : bucket) {
                test.add(val);
            }
        }
        return test;
    }

}