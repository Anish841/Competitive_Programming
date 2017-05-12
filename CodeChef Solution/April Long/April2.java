import java.util.*;
import java.io.*;
public class April2{
	public static void main(String[] args) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			if(n==1){
				System.out.println("1");
			}else if(n==2){
				System.out.println("3");
			}else if(n==3){
				System.out.println("4");
			}else if(n>=4){
				int loopn=(int)Math.sqrt(n);
				int i=2;
				long ans=0;boolean checkPrime=true;
				while(i<=loopn){
					if(n%i==0){
						if(i==(n/i)){
							ans=ans+i;
						}else{
							ans=ans+(i)+(n/i);
						}
						checkPrime=false;
					}
					i++;
				}
				ans=ans+1;
					System.out.println((ans+n));
			}
		}
	}


}