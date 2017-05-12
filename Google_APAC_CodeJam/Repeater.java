import java.util.*;
import java.io.*;
public class Repeater{
	public static void minNoOfWays(String dataSet[]){
		
	}
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int y=1;y<=t;y++){
			int N=Integer.parseInt(bf.readLine());
			//String dataSet[]=new String[N];
			HashMap<Character,Integer> dataSet[]=new HashMap[N];
			String temp="";
			for(int i=0;i<N;i++){
				temp=bf.readLine();
				dataSet[i]=new HashMap<String,Integer>();
				for(int j=0;j<temp.length();j++){
					if(dataSet[i].containsKey(temp.charAt(j))){
						int num=dataSet[i].get(temp.charAt(j));
						dataSet[i].put(temp.charAt(j),num++);
					}else{
						
						dataSet[i].put(temp.charAt(j),0);
					}
				}
			}
			
		}
	}
}