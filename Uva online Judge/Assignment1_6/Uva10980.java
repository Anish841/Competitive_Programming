package Assignment1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uva10980 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int casecount = 1;
		while (true) {
			String str=bf.readLine();
			if(str==null)break;
			String str1[]=str.split("\\s+");
			double unitp = Double.parseDouble(str1[0]);
			int m = Integer.parseInt(str1[1]);
			int N[] = new int[m + 1];
			double P[] = new double[m + 1];
			for (int i = 1; i <= m; i++) {
				str=bf.readLine();
				str1=str.split("\\s+");
				N[i] = Integer.parseInt(str1[0]);
				P[i] = Double.parseDouble(str1[1]);
			}
			double dp[] = new double[101];
			dp[0] = 0;
			for (int i = 1; i <= 100; i++) {
				dp[i] = unitp * i;
			}
			for (int i = 1; i <= m; i++) {
				int n = N[i];
				double p = P[i];
				
				for (int j = 0; j <= 100 - n; ++j)
	                for (int k = 1; k <= n; ++k)
	                    dp[j + k] = checkMin(dp[j + k], dp[j] + p);
			}
			str = bf.readLine();
			str1 = str.split("\\s+");
			System.out.println("Case " + (casecount++) + ":");
			int len=str1.length,s;
			for (int i = 0; i < len; i++) {
				s = Integer.parseInt(str1[i]);
				System.out.printf("Buy %d for $%.2f\n", s, dp[s]);
			}
		}
	}
	public static double checkMin(double a,double b){
		if(a<=b)return a;
		else return b;
	}

}