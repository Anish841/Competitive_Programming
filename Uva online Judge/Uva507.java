package Assignment1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva507 {

	public static void main(String[] args) {
		InputReaderN in=new InputReaderN(System.in);
		int b=in.nextInt();
		int s,no[];
		for(int i=1;i<=b;i++){
			s=in.nextInt();
			no=new int[s];
			no[0]=0;
			for(int j=1;j<s;j++){
				no[j]=in.nextInt();
			}
			int start = 1, finish = 0, auxStart= 0, sum = 0, max = 0;
	        for(int j = 1; j < s; j++) {
	            sum += no[j];
	            if(sum > max || (sum == max && j - auxStart> finish - start)) {
	                max = sum;
	                finish=j;start=auxStart;
	            }
	            if(sum < 0) {
	            	auxStart=j;
	                sum = 0;
	            }
	        }
	        if(max>0){
	        	System.out.println("The nicest part of route "+i+" is between stops "+(start+1)+" and "+(finish+1));
	        }else{
	        	System.out.println("Route "+i+" has no nice parts");
	        }
		}

	}

}
class InputReaderN {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReaderN(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

