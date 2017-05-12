import java.util.*;
import java.io.*;
import java.math.*;

public class April4{
	public static long modu=1000003;
	static long power(long x,long y)
	{
		long temp;
		if( y == 0)
			return 1;
		temp = power(x, y/2);
		if (y%2 == 0)
			return ((temp%modu)*(temp%modu))%modu;
		else
			return ((x%modu)*(temp%modu)*(temp%modu))%modu;
	}
	public static void main(String args[]) throws Exception{
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			int t=Integer.parseInt(bf.readLine());
			//BigInteger modu=new BigInteger(""+1000003+"");
			while(t-->0){
				String str=bf.readLine();
				String s1[]=str.split("\\s+");
				int n=Integer.parseInt(s1[0]);
				int l=Integer.parseInt(s1[1]);
				int r=Integer.parseInt(s1[2]);
				int m=r-l+1;
				int t1=m+n;
				long mulTerm=1,divTerm=1;
				//BigInteger mulTerm=new BigInteger(""+1+"");
				//BigInteger divTerm=new BigInteger(""+1+"");
				for(int i=m;i>=1;i--){
					mulTerm=((mulTerm%modu)*(t1%modu))%modu;
					divTerm=((divTerm%modu)*(i%modu))%modu;
					t1--;
					//mulTerm=mulTerm.multiply(new BigInteger(""+t1+""));
					//divTerm=divTerm.multiply(new BigInteger(""+i+""));
					//System.out.println(mulTerm+" "+divTerm);
					//t1--;
				}
				//long ans=(mulTerm/divTerm)-1;
				//long ans=(long)((Math.pow(mulTerm,modu-divTerm))%modu)-1;
				long modInv=(power(divTerm,modu-2)%modu);
				long ans=(((modInv%modu)*(mulTerm%modu))%modu)-1;
				//BigInteger ans=mulTerm.divide(divTerm).subtract(new BigInteger("1"));
				System.out.println(ans);			
			}
	
	}
	

}