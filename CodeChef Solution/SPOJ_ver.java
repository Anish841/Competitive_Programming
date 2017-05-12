package ModuleTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SPOJ_ver {
	static int max=-1;
	static int arr[];
	static int Recurs(int q,int m,int i,int n){
		if(q<0)return -1;
		if(q>m)return -1;
		if(i>=n){
			if(max<q){
				max=q;
			
			}
			return max;
		}
		Recurs(q+arr[i], m, i+1, n);
		Recurs(q-arr[i], m, i+1, n);
		return max;
	}
	
	public static void main(String[] args) {
		InputReaderD in=new InputReaderD(System.in);
		int t=in.nextInt();
		int n = 0,q = 0,m = 0;
		for(int i=0;i<t;i++){
			max=-1;
			arr=null;
			n=in.nextInt();
			q=in.nextInt();
			m=in.nextInt();
		
			arr=new int[n];
			for(int j=0;j<n;j++){
				arr[j]=in.nextInt();
			}
			int index=0;
			Recurs(q, m,index,n);
			System.out.println(max);
		}
	}
}


class InputReaderD {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReaderD(InputStream stream) {
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

