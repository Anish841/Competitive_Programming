import java.util.*;
import java.io.*;
public class MagicTrick{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int y=1;y<=t;y++){
			int firstans=Integer.parseInt(bf.readLine());
			int firstChoice[]=new int[4];
			HashMap<Integer,Boolean> secondChoice=new HashMap<Integer,Boolean>();
			for(int i=1;i<=4;i++){
				StringTokenizer st=new StringTokenizer(bf.readLine());
				if(i==firstans){
					for(int j=0;j<4;j++){
						firstChoice[j]=Integer.parseInt(st.nextToken());
					}
				}
			}
			int secondans=Integer.parseInt(bf.readLine());
			for(int i=1;i<=4;i++){
				StringTokenizer st=new StringTokenizer(bf.readLine());
				if(i==secondans){
					for(int j=0;j<4;j++){
						secondChoice.put(Integer.parseInt(st.nextToken()),true);
					}
				}
			}
			long ans=0,number=0;
			for(int i=0;i<4;i++){
				if(secondChoice.containsKey(firstChoice[i])){
					ans++;number=firstChoice[i];
				}
			}
			if(ans==0)
				System.out.println("Case #"+y+": Volunteer cheated!");
			else if(ans==1)
				System.out.println("Case #"+y+": "+number);
			else if(ans>1)
				System.out.println("Case #"+y+": Bad magician!");
		}
		
		
	}


}