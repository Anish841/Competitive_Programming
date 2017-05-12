package ModuleTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DirectiParty {

	public static void main(String[] args) {
		InputReaderF in=new InputReaderF(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++){
			int n=in.nextInt();
			int sortedArr[][]=new int[2*n][2];int countI=0;
			for(int j=0;j<n;j++){
				sortedArr[countI][0]=in.nextInt();
				sortedArr[countI++][1]=1;
				sortedArr[countI][0]=in.nextInt();
				sortedArr[countI++][1]=0;
			}
			Arrays.sort(sortedArr, new Comparator<int[]>() {

				public int compare(int[] o1, int[] o2) {
					int temp1=o1[0];
					int temp2=o2[0];
					if(temp1==temp2){
						temp1=o1[1];temp2=o2[1];
						return temp1-temp2;
					}
					return temp1-temp2;
				}
				
			});
			int maxperson=0,max=Integer.MIN_VALUE;
			for(int j=0;j<2*n;j++){
				if(sortedArr[j][1]==0){
					maxperson-=1;
				}else{
					maxperson+=1;
				}
				if(maxperson>max){
					max=maxperson;
				}
			}
			System.out.println(max);
			
		}
		

	}

}
class InputReaderF {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReaderF(InputStream stream) {
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