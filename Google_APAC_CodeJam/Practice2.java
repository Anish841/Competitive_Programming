package Google_APAC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice2 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		int p=1;
		while(tc-->0){
			String str=bf.readLine();
			String s[]=str.split("\\s+");
			Double V=Double.parseDouble(s[0]);
			Double D=Double.parseDouble(s[1]);
			Double C=(Math.asin(9.8*D/V/V)*180.0/3.1415926/2.0);
			System.out.print("Case #"+p+": ");
			System.out.printf("%.7f\n",C);
		}
	}

}
