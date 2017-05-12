package ModuleTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SPOJ_bricks2 {

	public static void main(String[] args) {
		InputReaderN in=new InputReaderN(System.in);
		int n=in.nextInt(),i;
		int height[]=new int[n];
		int sum=0;
		for(i=0;i<n;i++){
			height[i]=in.nextInt();
			sum+=height[i];
		}
		int desiredH=sum/n;
		int nmoves=0,temp;
		for(i=0;i<=n-2;i++){
			temp=height[i]-desiredH;
			height[i+1]+=temp;
			nmoves+=(temp>=0)?temp:(desiredH-height[i]);
			height[i]=desiredH;
		}	
		System.out.print(nmoves);
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

