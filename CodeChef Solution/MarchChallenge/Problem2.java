import java.util.*;
import java.io.*;

public class Problem2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int s=sc.nextInt();
			int c=sc.nextInt();
			int k=sc.nextInt();
			long ans=0;
			long temp=0;
			if(c==0 && s==0){
				ans=0;
			}else if(c==0 && s>0 && s>=k){
				ans=3+(2*((long)Math.pow(2,s-k)-1));
			}else if(s==0 && c>0 && k==1){
				ans=2*((long)Math.pow(2,c)-1);
			}else if(s>=c && k==1){
				ans=3+(2*((long)Math.pow(2,s-k)-1));
				if(s==c)
					ans=ans+(long)Math.pow(2,c);
			}else if(s<c && k==1){
				ans=3+(2*((long)Math.pow(2,s-k)-1));
				temp=2*((long)Math.pow(2,c)-1)-2*((long)Math.pow(2,s-1)-1);
				ans=ans+temp;
			}else if(k>s){
				ans=0;
			}else{
				int temp1[]=new int[s+1];
				int j=s;
				for(int i=1;i<=s;i++){
					temp1[i]=j--;
				}
				j=c;
				for(int k1=2;k1<=(c+1) && k1<=s;k1++){
					//System.out.println("k1===>"+k1);
					temp1[k1]++;
				}
				int tempi=s+1;
				for(int i=1;i<=s;i++){
					if(k>temp1[i]){
						tempi=i;
						break;
					}
				}
				//System.out.println("tempi===>"+tempi);
				ans=3+(2*((long)Math.pow(2,tempi-2)-1));
			}
			System.out.println(ans);
		}
	}

}