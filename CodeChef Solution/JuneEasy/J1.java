import java.util.*;
import java.io.*;
public class J1{
	public static void main(String args[]){
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		while(tc-->0){
			String str=bf.readLine();
			String s[]=str.split("\\s+");
			long n=Long.parseLong(s[0]);
			long t=Long.parseLong(s[1]);
			while(t-->0){
				if(n%2==0){
					n=n-(n/2);
				}else{
					n=n-(n+1)/2;
				}
				if(n==0){
					break;
				}else{
					n=n-(n/4);
				}
				if(n==0){
					break;
				}
			}
			System.out.println(n);
		}
	}
}