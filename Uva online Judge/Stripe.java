import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {

	static  BigInteger[][] tempStore = new BigInteger[210][210];
	public static void main(String[] args)  throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=0;t<test;t++){
			String s = br.readLine();
			String st[] = s.split("\\s+");
			int n = Integer.parseInt(st[0]);
			int k = Integer.parseInt(st[1]);
			int a[] = new int[k+1];
			for (int j = 1;  j<= k; j++) {
			a[j] = Integer.parseInt(st[j+1]);
		}
		for (int i = 0; i <= n; i++) {
			for (int m=0;m<=n;m++){
				tempStore[i][m]=BigInteger.ZERO;
			}
		}
		tempStore[0][0] = BigInteger.ONE;
		
		if (k > 0)
		for (int i = 1; i <= n; i++) {
			if (i + a[1] <= n) tempStore[1][i] = BigInteger.ONE;
		}
		
		for (int i = 2; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (tempStore[i - 1][j].compareTo(BigInteger.ZERO) != 0) {
					for ( int m = 1; m <= n; m++) {
						if (j + a[i - 1] - 1 + m + a[i] <= n) {
							tempStore[i][j + a[i - 1] + m] = tempStore[i][j + a[i - 1] - 1 + m].add(tempStore[i - 1][j]);
						}
					}
				}
			}	
		}
		BigInteger ans = BigInteger.ZERO;
		for (int i = 0; i <= n; i++) {
			ans = ans.add(tempStore[k][i]);
		}
		System.out.println(ans);
		}
	}
}