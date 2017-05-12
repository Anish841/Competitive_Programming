import java.util.*;
import java.io.*;
public class CookieClicker{
	public static double calStrategy1(double tempF,double X){
		return (X/tempF);
	}
	public static double calStrategy2(double tempF,double C,double X,double F){
		return (C/tempF)+(X/(tempF+F));
	}
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int y=1;y<=t;y++){
			StringTokenizer st=new StringTokenizer(bf.readLine());
			double C=Double.parseDouble(st.nextToken());
			double F=Double.parseDouble(st.nextToken());
			double X=Double.parseDouble(st.nextToken());
			double tempF=2;
			double ans=0;
			while(true){
				double t1=calStrategy1(tempF,X);
				double t2=calStrategy2(tempF,C,X,F);
				if(t1<=t2){
					ans=ans+t1;
					break;
				}else{
					ans=ans+(C/tempF);
				}
				tempF=tempF+F;
			}
			System.out.printf("Case #%d: %.7f\n",y,ans);
		}
	}
}