import java.util.*;
import java.io.*;

public class Problem5{
	static int n,k;
	static String strf;
	static int arr[];
	static int tempi;
	public static void fillArray(){
		int c0=0,c1=0;
		arr=new int[n];
		int j=1;boolean flag=false,fflag=false;
		if(strf.charAt(j)=='0')
					c0++;
				else
					c1++;
		for(int i=0;i<n;i++){
			if(i==0){
				if(strf.charAt(i)=='0')
					c0++;
				else
					c1++;
			}else{
				if(strf.charAt(i-1)=='0')
					c0--;
				else
					c1--;
			}flag=true;
			for(;j<n;j++){
				//System.out.println("j="+j);
				if(!flag){
					flag=false;
					if(strf.charAt(j)=='0')
						c0++;
					else
						c1++;
				}else{flag=false;}
				if(j==n-1 && (c0<=k && c1<=k)){
					tempi=i;
					arr[i]=j-i;
					i++;
					while(i<n){
						arr[i]=j-i;i++;
					}fflag=true;
					break;
				}
				if(c0>k || c1>k){
						arr[i]=j-1-i;
					break;
				}

			}if(fflag)break;
		}
		// for(int i=0;i<n;i++){
		// 	System.out.println(arr[i]);
		// }
	}
	public static void main(String[] args) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			String str=bf.readLine();
			String s1[]=str.split("\\s+");
			n=Integer.parseInt(s1[0]);
			k=Integer.parseInt(s1[1]);
			int q=Integer.parseInt(s1[2]);
			strf=bf.readLine();
			int l,r;
			fillArray();
			long sumarr[]=new long[n];
			sumarr[0]=arr[0];
			for(int i=1;i<n;i++){
				sumarr[i]=sumarr[i-1]+arr[i];
			}
			for(int i=0;i<q;i++){
				str=bf.readLine();
				s1=str.split("\\s+");
				l=Integer.parseInt(s1[0]);
				r=Integer.parseInt(s1[1]);
				l--;r--;
				long ans=0;
				if(l==0 && r==n-1){
					ans=sumarr[r];
				}else if(r==(n-1)){
					ans=sumarr[r]-sumarr[l-1];
				}else if(tempi<=l && r<=(n-1)){
					if(l==0){
						ans=sumarr[r];
					}else{
						ans=sumarr[r]-sumarr[l-1];
					}
					ans=ans-arr[r]*(r-l+1);
				}else{
					for(int p=l;p<=r;p++){
						if(p+arr[p]>r)
							ans+=(r-p);
						else
							ans+=arr[p];
					}
				}
				ans=ans+(r-l+1);
				System.out.println(ans);
			}
		}
	}
}