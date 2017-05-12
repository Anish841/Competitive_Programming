package Assignment1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11790 {

	public static void main(String[] args) {
		InputReaderE  in=new InputReaderE(System.in);
		
		  int T,N,H[],W[];
		    int dp[],A,B;
		    
		    T=in.nextInt();
		    H=new int[10000];
		    W=new int[10000];
		    for(int tc = 1;tc<=T;++tc){
		        N=in.nextInt();
		        
		        for(int i = 0;i<N;++i) H[i]=in.nextInt();
		        for(int i = 0;i<N;++i) W[i]=in.nextInt();
		        
		        int best = 0;
		        dp=new int[N];
		        for(int i = 0;i<N;++i){
		            dp[i] = W[i];
		            
		            for(int j = 0;j<i;++j){
		                if(H[j]<H[i] && W[i]+dp[j]>dp[i]){
		                    dp[i] = W[i]+dp[j];
		                }
		            }
		            
		            if(dp[i]>dp[best]) best = i;
		        }
		        
		        A = dp[best];
		        
		        best = 0;
		        
		        for(int i = 0;i<N;++i){
		            dp[i] = W[i];
		            
		            for(int j = 0;j<i;++j){
		                if(H[j]>H[i] && W[i]+dp[j]>dp[i]){
		                    dp[i] = W[i]+dp[j];
		                }
		            }
		            
		            if(dp[i]>dp[best]) best = i;
		        }
		        
		        B = dp[best];
		        if(A>=B)System.out.println("Case "+tc+". Increasing ("+A+"). Decreasing ("+B+").");
		        else System.out.println("Case "+tc+". Decreasing ("+B+"). Increasing ("+A+").");
		    }
	}
}

class InputReaderE {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReaderE(InputStream stream) {
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


