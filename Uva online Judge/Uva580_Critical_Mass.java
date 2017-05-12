import java.util.*;
import java.io.*;
class Main{
		public static void main(String args[]) throws Exception{
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			int n; int a[]=new int[40];int s1,s2,s0;int i;int m;
			a[0]=0;
			a[1]=0;
			a[2]=0;
			s2=1;
			s1=1;
			s0=2;
			i=3;
			m=8;
			while( i <= 30 ){
				a[i]=2*a[i-1];
				a[i]+=s2;
				s2=s1;
				s1=s0;
				s0=m-s1-s2-a[i];
				m*=2;
				i++; 
			}
			while(true){
				String str=bf.readLine();
				if(str==null)
					break;
				n=Integer.parseInt(str);
				if(n==0){
					break;
				}else{
					System.out.println(a[n]);
				}
			}
	}
}