import java.util.*;
import java.io.*;

public class Problem6{
	static int A[];
	static long x=0;
	public static long nextInteger1(long modp){
  			x = (x * 1103515245 + 12345)%(modp);
  			return (((long)Math.floor(x/65536))%32768)%(modp);
	}
	public static boolean gen1(int n,long modp,char sarr[],int s){
		x=s;boolean flag=true;
		int count=1;
		for(int i=0;i<n;i++){
   			 A[i] = (int)(nextInteger1(modp) % 2); 
   			 if(A[i]!=(sarr[i]-48)){
   			 	flag=false;
   			 	break;
   			 }
 		 }
		return flag;
	}
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			String str=bf.readLine();
			char sarr[]=str.toCharArray();
			int len=str.length();
			long modp=(long)Math.pow(2,32);
			A=new int[len];
			boolean mg=false;
			//boolean f=gen1(len,modp,sarr,5);
			for(int s=0;s<=31313;s++){
				boolean f=gen1(len,modp,sarr,s);
				if(f){
					mg=true;
					break;
				}
			}
			if(mg)
				System.out.println("LCG");
			else
				System.out.println("Xorshift");
		}
	}

}