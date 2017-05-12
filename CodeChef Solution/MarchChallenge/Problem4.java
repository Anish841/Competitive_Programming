import java.util.*;
import java.io.*;

public class Problem4{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int type=Integer.parseInt(bf.readLine());
			String str=bf.readLine();
			int b=0,g=0;
			long ans=0;
			for(int i=0;i<str.length();i++){
				if('B'==str.charAt(i))
					b++;
				else
					g++;
			}
				if(b>g+1)
					ans=-1;
				if(g>b+1)
					ans=-1;

				if(b==g){
					int t1=0,t2=0;
					int t1arrB[]=new int[g],t1arrG[]=new int[g],index1G=0,index1B=0;
					int t2arrB[]=new int[g],t2arrG[]=new int[g],index2B=0,index2G=0;
					for(int i=0;i<str.length();i++){
						if(i%2==0){
							if(str.charAt(i)!='B'){
								t1++;t1arrG[index1G++]=i;
							}
							if(str.charAt(i)!='G'){
								t2++;t2arrB[index2B++]=i;
							}
						}else{
							if(str.charAt(i)!='G'){
								t1++;t1arrB[index1B++]=i;
							}
							if(str.charAt(i)!='B'){
								t2++;t2arrG[index2G++]=i;
							}
						}
					}
					if(type==0){
						if(t1<=t2)
							ans=t1/2;
						else
							ans=t2/2;
					}else{
						long ans1=0,ans2=0;
						for(int j=0;j<t1/2;j++){
								ans1+=Math.abs(t1arrG[j]-t1arrB[j]);
						}						
						for(int j=0;j<t2/2;j++){
							ans2+=Math.abs(t2arrG[j]-t2arrB[j]);
						}
						if(ans1<=ans2)
							ans=ans1;
						else
							ans=ans2;
					}
				}
				if(b==g+1){
					int t1=0,t1arrB[]=new int[g],t1arrG[]=new int[g],indexB=0,indexG=0;
					for(int i=0;i<str.length();i++){
					if(i%2==0){
							if(str.charAt(i)!='B'){
								t1++;t1arrG[indexG++]=i;
							}
						}else{
							if(str.charAt(i)!='G'){
								t1++;t1arrB[indexB++]=i;
							}
						}
					}
							if(type==0){
								ans=t1/2;
							}else{
								for(int j=0;j<t1/2;j++){
										ans+=Math.abs(t1arrG[j]-t1arrB[j]);
								}
							}
						
				}else if(g==b+1){
						int t1=0,t1arrB[]=new int[b],t1arrG[]=new int[b],indexB=0,indexG=0;
						for(int i=0;i<str.length();i++){
						if(i%2==0){
							if(str.charAt(i)!='G'){
									t1++;t1arrB[indexB++]=i;
							}
						}else{
							if(str.charAt(i)!='B'){
								t1++;t1arrG[indexG++]=i;
							}
						}
					}
							if(type==0){
								ans=t1/2;
							}else{
								for(int j=0;j<t1/2;j++){
										ans+=Math.abs(t1arrG[j]-t1arrB[j]);
								}
							}
			}
				System.out.println(ans);
		}
	}

}