import java.io.*;
public class CandidateCode 
{ 
    public static int findGCD(int a,int b){
   	if(a<b){
   		int t=a;
   		a=b;
   		b=t;
   	}
   	while(b!=0){
   		int r=a%b;
   		a=b;
   		b=r;
   	}
   	return a;
    }
    public static int[] coins_value(int[] input1)
    {
       int a=input1[0];
       int b=input1[1];
       int gcd=1;
       int ans[]=new int[2];
       if(a<0 || b<0){
       	ans[0]=0;ans[1]=0;
       }else if(a==0  && b==0){
       	ans[0]=0;
       	ans[1]=0;    
       }else if(a==0 || b==0){
       		if(a==0){
       			ans[0]=0;
       			ans[1]=1;
       		}else if(b==0){
       			ans[1]=0;
       			ans[0]=1;
       		}
       }else{
       		gcd=findGCD(a,b);
       		a=a/gcd;b=b/gcd;
       		boolean flag=false;
       		for(int i=gcd;i>=(-gcd);i--){
       			for(int j=-gcd;j<=gcd;j++){
       				if((a*i + b*j)==1){
       					ans[0]=i;flag=true;
       					ans[1]=j;break;
       				}
       				
       			}
       			if(flag)
       			    break;
       		}
       }
       return ans;
       
    }
}