package MidSem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;


public class Program4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		BitSet ans=new BitSet(t);
		for(int i=0;i<t;i++){
			ans.clear();
		}
		for(int i=0;i<t;i++){
			int n=Integer.parseInt(in.readLine());
			String str[][]=new String[n][2];
			
			for(int j=0;j<n;j++){
				str[j][0]=in.readLine();
				str[j][1]=new Integer(str[j][0].length()).toString();
			}
			
			Arrays.sort(str,new Comparator<String[]>() {
				public int compare(String[] o1, String[] o2) {
					String s1=o1[1];
					String s2=o2[1];
					return s1.compareTo(s2);
				}
			});
//			for (final String[] s : str) {
//	            System.out.println(s[0] + " " + s[1]);
//	        }
			boolean finalFlag=false;
			for(int k=0;k<n;k++){
				for(int l=k+1;l<n;l++){
					if(str[k][1]==str[l][1]){
						if(str[k][0].equalsIgnoreCase(str[l][0])){
							finalFlag=true;
						}
					}else {
						String strtemp=str[l][0].substring(0, Integer.parseInt(str[k][1]));
						if(str[k][0].equalsIgnoreCase(strtemp)){
							finalFlag=true;
						}
					}
					if(finalFlag)break;
				}
				if(finalFlag)break;
			}
			if(finalFlag){
				ans.set(i);
			}
		}
			
		
		for(int i=0;i<t;i++){
			if(ans.get(i)){
				System.out.print("1");
			}else{
				System.out.print("0");
			}
		}
		
	}

}
