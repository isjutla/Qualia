import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by indie on 11/22/2015.
 */


public class SolutionTest {

    @Test
    public void noEntries() {
        String order = "abc";
        List<String> ina = new ArrayList<String>();
        List<String> answer = Solution.order(ina, order);
        assertEquals(0, answer.size());
    }

    @Test
    public void radix3FewEntries() {
        String order = "abc";
        List<String> ina = new ArrayList<String>();
        ina.add("abc");
        ina.add("c");
        ina.add("aaa");
        ina.add("cc");
        ina.add("cba");
        ina.add("aa");
        ina.add("b");
        ina.add("");
        List<String> answer = Solution.order(ina, order);
        assertEquals(8, answer.size()); //correct: [ , aa, aaa,abc, b, c, cba, cc]
        //ideally would check the whole list
        //String[] expected = new String[]{"" , "aa", "aaa","abc", "b", "c", "cba", "cc"};
        //List<String> expectedList = Arrays.asList(expected);
        assertEquals("", answer.get(0));
        assertEquals("aaa", answer.get(2));
        assertEquals("cc", answer.get(7));
    }

    @Test
    public void radix3ReversedFewEntries() {
        String order = "cba";
        List<String> ina = new ArrayList<String>();
        ina.add("abc");
        ina.add("c");
        ina.add("aaa");
        ina.add("cc");
        ina.add("cba");
        ina.add("aa");
        ina.add("b");
        ina.add("");
        List<String> answer = Solution.order(ina, order);
        assertEquals(8, answer.size()); //correct: [ ,c, cc, cba, b, abc, aa, aaa]
        System.out.println(answer);
        assertEquals("", answer.get(0));
        assertEquals("cc", answer.get(2));
        assertEquals("aaa", answer.get(7));
    }

    @Test
    public void radix26FewEntries() {
        String order = "abcdefghijklmnopqrstuvwxyz";
        List<String> ina = new ArrayList<String>();
        ina.add("abc");
        ina.add("c");
        ina.add("aaa");
        ina.add("cc");
        ina.add("cba");
        ina.add("aa");
        ina.add("b");
        ina.add("");
        List<String> answer = Solution.order(ina, order);
        assertEquals(8, answer.size()); //correct: [ , aa, aaa,abc, b, c, cba, cc]
        //ideally would check the whole list
        //String[] expected = new String[]{"" , "aa", "aaa","abc", "b", "c", "cba", "cc"};
        //List<String> expectedList = Arrays.asList(expected);
        assertEquals("", answer.get(0));
        assertEquals("aaa", answer.get(2));
        assertEquals("cc", answer.get(7));
    }

    @Test
    public void radix26FewEntriesWideRange() {
        String order = "abcdefghijklmnopqrstuvwxyz";
        List<String> ina = new ArrayList<String>();
        ina.add("a");
        ina.add("b");
        ina.add("z");
        ina.add("e");
        ina.add("aa");
        ina.add("xyz");
        ina.add("hello");
        ina.add("bye");
        List<String> answer = Solution.order(ina, order);

        assertEquals(8, answer.size()); //correct: [a, aa, b, bye, e, hello, xyz, z]
        assertEquals("a", answer.get(0));
        assertEquals("b", answer.get(2));
        assertEquals("z", answer.get(7));
    }


}
