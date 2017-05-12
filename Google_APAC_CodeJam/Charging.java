import java.util.*;
import java.io.*;
public class Charging{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int y=1;y<=t;y++){
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int N=Integer.parseInt(st.nextToken());
			int L=Integer.parseInt(st.nextToken());
			int outlets[]=new int[N];
			int devices[]=new int[N];
			st=new StringTokenizer(bf.readLine());
			String tempStr="";
			for(int i=0;i<N;i++){
				outlets[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(outlets);
			st=new StringTokenizer(bf.readLine());
			for(int i=0;i<N;i++){
				devices[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(devices);
			int switchFlipped=140;
			int xorMap[][]=new int[N][N];
			HashMap<Integer,Integer> hm[]=new HashMap[N];
			for(int i=0;i<N;i++){
				hm[i]=new HashMap<Integer,Integer>();
				for(int j=0;j<N;j++){
					xorMap[i][j]=outlets[i]^devices[j];
					hm[i].put(xorMap[i][j],j);
				}
			}
			HashMap<Integer,Boolean> am=new HashMap<Integer,Boolean>();
			int tempFlip=150;
			for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				am.put(j,true);tempFlip=150;
				for(int p=0;p<N;p++){
					if(p!=i){
					if(hm[p].containsKey(xorMap[i][j])){
						int index=hm[p].get(xorMap[i][j]);
						if(am.containsKey(index)){
							am.clear();
							break;
						}else{
							am.put(index,true);
						}
					}else{
						am.clear();
						break;
					}
					}
				}
				
				if(am.size()==N){
					String str=String.valueOf(xorMap[i][j]);tempFlip=0;
					for(int f=0;f<str.length();f++){
						if(str.charAt(f)=='1'){
							tempFlip++;
						}						
					}
					am.clear();
				}
				if(tempFlip<switchFlipped){
					switchFlipped=tempFlip;
				}
			}
			}
			
			if(switchFlipped==140){
				System.out.println("Case #"+y+": "+"NOT POSSIBLE");
			}else{
				System.out.println("Case #"+y+": "+switchFlipped);
			}
			
		}
	}
}