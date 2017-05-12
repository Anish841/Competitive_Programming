package Assignment1_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Uva856 {
	static char decode_vigenere(char decoded, char encoded) {
	    int a = 'z' - decoded;
	    int b = encoded - 'A';

	    return (char) ('A' + (b + a) % 26);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
		boolean first = true;
	    String input;
	    String nums[] = {"nine", "eight", "seven", "six", "five", "four", "three", "two", "one", "zero"};
	    ArrayList<String> numbers = new ArrayList<String>();

	    for (int i = 0; i < 10; i++)
	        for (int j = 0; j < 10; j++)
	            for (int k = 0; k < 10; k++)
	                numbers.add(nums[i] + nums[j] + nums[k]);

	    while ((input=bf.readLine())!=null) {
	        if (!first)
	            out.println();
	        first = false;

	        for (int i = 0, sz = numbers.size(); i < sz; i++) {
	            if (numbers.get(i).length() != input.length())
	                continue;

	            for (int j = 0; j < numbers.get(i).length(); j++) {
	                out.print(decode_vigenere(numbers.get(i).charAt(j), input.charAt(j)));
	            }
	            out.println(" -> "+numbers.get(i));
	        }
	        
	    }
	 out.close();
	}


}
