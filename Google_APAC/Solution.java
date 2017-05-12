package Morgan;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(bf.readLine());
        while(tc-->0){
            int nos=Integer.parseInt(bf.readLine());
            String str=bf.readLine();
            String s[]=str.split("\\s+");
            int price[]=new int[nos+1];
            for(int i=1;i<=nos;i++){
                price[i]=Integer.parseInt(s[i-1]);              
            }
            for(int i=2;i<nos;i++){
                if(price[i-1]%2==0 && price[i+1]%2==0){
                    int olddiff=Math.abs(price[i]-price[nos-i+1]);
                    int temp=(price[i-1]+price[i+1])/2;
                    int newd=Math.abs(temp-price[nos-i+1]);
                    if(newd>=olddiff){
                        price[i]=temp;
                    }
                }
            }
            for(int i=1;i<=nos;i++){
               System.out.println(price[i]);       
            }
            long ans=0;
            for(int i=1;i<=nos/2;i++){
                ans+=Math.abs(price[i]-price[nos-i+1]);
                //System.out.println(ans);
            }
            System.out.println(ans);
            Arrays.sort(s,new Comparator<String>(){

				public int compare(String arg0, String arg1) {
					// TODO Auto-generated method stub
					return 0;
				}
            	
            });
        }
    }
}