package Assignment1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10910 {
	static int M[][]=new int[71][71];
	static int Func(int n,int t,int p){
		if(M[n][t]!=-1)return M[n][t];
		if(n==1){
			M[n][t]=(t-p<0)?0:1;
			return M[n][t];
		}
		int ways=0;
		for(int i=p;i<=t;i++){
			 ways += Func(n-1, t - i, p);
		}
		 return M[n][t] = ways;
	}
	public static void main(String[] args) {
		InputReaderE in=new InputReaderE(System.in);
		int tc,N,T,P;
		tc=in.nextInt();
		for(int i=0;i<tc;i++){
			N=in.nextInt();
			T=in.nextInt();
			P=in.nextInt();
			for(int j=0;j<71;j++){
				for(int k=0;k<71;k++){
					M[j][k]=-1;
				}
			}
			System.out.println(Func(N,T,P));
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



