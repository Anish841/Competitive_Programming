package Assignment1_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uva11888 {
	static char original [];
	static boolean is_palindrome (int a, int b)
	{
	    while ( a < b ) {
	        if ( original [a] != original [b - 1] ) return false;
	        a++; b--;
	    }
	    return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		 	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		    int testCase=Integer.parseInt(bf.readLine());
		    while ( testCase-->0 ) {
		    	String str;
		        str=bf.readLine();
		        original=str.toCharArray();
		        int len = original.length;
		        boolean found = false;
		 
		        for ( int i = 0; i < len - 1; i++ ) {
		            if ( original [0] == original [i] && original [i + 1] == original [len - 1] ) {
		                if ( is_palindrome (0, i + 1) && is_palindrome (i + 1, len) ) {
		                    found = true;
		                    System.out.println("alindrome");
		                    break;
		                }
		            }
		        }
		 
		        if ( !found ) {
		            if ( is_palindrome (0, len) ) 
		            	System.out.println("palindrome");
		            else 
		            	System.out.println("simple");
		        }
		    }
		 

	}

}

