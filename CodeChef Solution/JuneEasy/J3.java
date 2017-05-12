import java.util.*;
import java.io.*;
public class J3{
	
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		while(tc-->0){
			String str=bf.readLine();
			String s[]=str.split("\\s+");
			int X=Integer.parseInt(s[0]);
			int Y=Integer.parseInt(s[1]);
			int Z=Integer.parseInt(s[2]);
			float temp=(X+Y+Z)/2;
			float C=temp-X,A=temp-Y,B=temp-Z;
			float sa=2*(A*B+B*C+C*A);
			System.out.printf("%0.2f\n",sa);
		}
	}
}