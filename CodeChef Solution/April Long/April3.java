import java.util.*;
import java.io.*;
public class April3{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			String scale=bf.readLine();
			int noOfOctave=Integer.parseInt(bf.readLine());
			int count=0;
			for(int i=0;i<scale.length();i++){
				if(scale.charAt(i)=='T'){
					count=count+2;
				}else{
					count=count+1;
				}
			}
			long t1=12*noOfOctave;
			int i=1;
			long ans=0;
			while(true){
				if((t1-count*i)>0){
					ans=ans+(t1-count*i);
				}else{
					break;
				}
				i++;
			}
			System.out.println(ans);
		}
	}

}