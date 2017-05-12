package Practice_murali_sir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Uva11658 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String str=bf.readLine();
			String str1[]=str.split(" ");
			int n=Integer.parseInt(str1[0]);
			int index=Integer.parseInt(str1[1]);
			if(n==0 && index==0)break;
			int arr[]=new int[n];
			BitSet sum=new BitSet(10001);
			for(int i=0;i<n;i++){
				str=bf.readLine();
				str = str.substring(0, str.indexOf('.'))
                        + str.substring(str.indexOf('.') + 1, str.length());
                arr[i] = Integer.parseInt(str);
			}
			sum.clear();
			sum.set(0);
			sum.set(arr[0]);
			for(int i=1;i<arr.length;i++){
				if(i!=(index-1))
					for(int j=10000;j>=arr[i];j--){
						if(sum.get(j-arr[i]))
							sum.set(j);
					}
			}
			for(int i=0;i<10000;i++){
				if(sum.get(i) && (i+arr[index-1])>5000){
					float temp=((float)arr[index-1])/(i+arr[index-1]);
					System.out.printf("%.2f\n",(temp*100));break;
				}
			}
		}
	}
}

