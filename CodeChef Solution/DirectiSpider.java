package ModuleTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DirectiSpider {

	static int M,N;
	static int minpath(int cost[][],int x,int y,int D){
		int i,j;
		int temp[][]=new int[M][N];
		for(i=1;i<M;i++){
			for(j=1;j<N;j++){
				temp[i][j]=-1;
			}
		}
		temp[0][0]=0;
		for(i=1;i<=x;i++){
			if(Math.abs(cost[i][0]-cost[i-1][0])<=D)
			temp[i][0]=temp[i-1][0]+1;
		}
		for (j = 1; j <= y; j++){
			if(Math.abs(cost[0][j]-cost[0][j-1])<=D)
	        temp[0][j] = temp[0][j-1] + 1;
		}
		for (i = 1; i <= x; i++)
	        for (j = 1; j <= y; j++)
	        	if(Math.abs(cost[i][j-1]-cost[i][j])<=D || Math.abs(cost[i-1][j]-cost[i][j])<=D )
	        		if(temp[i][j-1]!=-1 && temp[i-1][j]!=-1)
	        		temp[i][j] = Math.min(temp[i][j-1], temp[i-1][j]) + 1;
	        		else if(temp[i][j-1]!=-1)
	        				temp[i][j]=temp[i][j-1]+1;
	        		else if(temp[i-1][j]!=-1)
	        				temp[i][j]=temp[i-1][j]+1;
		return temp[x][y];
	}
	
	public static void main(String[] args) {
		InputReaderG in=new InputReaderG(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++){
			M=in.nextInt();
			N=in.nextInt();
			int X=in.nextInt();
			int Y=in.nextInt();
			int D=in.nextInt();
			int cost[][]=new int[M][N];
			for(int j=0;j<M;j++){
				for(int k=0;k<N;k++){
					cost[j][k]=in.nextInt();
				}
			}
			int temp=minpath(cost, X-1, Y-1,D);
			if(temp>0)
			System.out.println(temp);
			else
				System.out.println("-1");
			
			
			
		}

	}

}
class InputReaderG {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReaderG(InputStream stream) {
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
