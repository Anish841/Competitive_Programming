import java.util.*;
import java.io.*;
public class ExpBracket{
	static int N=30;
	static long f[]=new long[30],b[]=new long[30];
	static void init () {
		int n = 26;
		b[1] = b[2] = 1;
		for (int i = 3; i <= n; i++)
			b[i] = b[i-1] * (4*i-6) / i;

		f[1] = f[2] = 1;
		for (int i = 3; i <= n; i++)
			f[i] = (3 * (2 * i - 3) * f[i-1] - (i - 3) * f[i-2])/i;
	}
	public static void main(String args[]) throws Exception{
		init();
		int n;
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String str=bf.readLine();
			if(str==null)
				break;
			n=Integer.parseInt(str);
			System.out.println(f[n]-b[n]);
		}
	}
}