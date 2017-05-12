import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
 
public class AnagrammaticPrimes {
    static boolean[] sieve;
    static ArrayList<Integer> list;
    static ArrayList<Integer> anagrams;
    static int[] ans = { 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113,
            131, 199, 311, 337, 373, 733, 919, 991 };
 
    private static void sieve(int n) {
        sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
 
        list = new ArrayList<Integer>();
        list.add(2);
        int i = 0;
        for (i = 2; i <= Math.sqrt(n); i++)
            if (sieve[i]) {
                for (int j = i * i; j <= n; j += i)
                    sieve[j] = false;
                list.add(i);
            }
 
        while (i <= n) {
            if (sieve[i])
                list.add(i);
            i++;
        }
    }
 
   
    // Precalculated
    private static void generateAnaPrimes() {
        anagrams = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            if (isAnagram(curr))
                anagrams.add(curr);
        }
    }
 
    private static boolean isAnagram(int n) {
        char[] array = (n + "").toCharArray();
        return perm(array, new char[array.length], 0, new boolean[array.length]);
    }
 
    private static boolean perm(char[] array, char[] cs, int index,
            boolean[] bools) {
        if (index == array.length) {
            return sieve[Integer.parseInt(new String(cs))];
        } else {
            boolean test = true;
            for (int i = 0; i < array.length; i++)
                if (!bools[i]) {
                    bools[i] = true;
 
                    cs[index] = array[i];
                    test &= perm(array, cs, index + 1, bools);
 
                    bools[i] = false;
                }
            return test;
        }
    }
	 public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(
                System.in));
        sieve(1000);
        // generateAnaPrimes();
        while (true) {
            int n = Integer.parseInt(buff.readLine());
            if (n == 0)
                break;
 
            if (n > 1000) {
                System.out.println(0);
                continue;
            }
 
            int len = (n + "").length();
            int upper = (int) (Math.pow(10, len));
            int answer = -1;
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] > n && ans[i] < upper) {
                    answer = ans[i];
                    break;
                }
            }
            if (answer != -1)
                System.out.println(answer);
            else
                System.out.println(0);
        }
    }
}