import java.util.*;
import java.io.*;
public class MH1{
	public static long sumDigits(long no){
		return no == 0 ? 0 : no%10 + sumDigits(no/10);
	}
	public static void main(String args[])throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		while(tc-->0){
			int M=Integer.parseInt(bf.readLine());
			long ans=0;
			for(int i=0;i<M;i++){
				String str=bf.readLine();
				String s[]=str.split("\\s+");
				ans=ans+sumDigits((Long.parseLong(s[0]))*(Long.parseLong(s[1])));
			}
			long number =ans;
			while((number%10)!=number){
				number=sumDigits(number);
			}
			System.out.println(number);
		}
		
	}
}