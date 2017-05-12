package MarchChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Amex {

	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> hlm=new LinkedHashMap<String, String>();
		int n=Integer.parseInt(bf.readLine());
		String data[][]=new String[n][5];
		int k=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			String str=bf.readLine();
			String s1[]=str.split(",");
			data[i][0]=new String();
			data[i][1]=new String();
			data[i][2]=new String();
			data[i][3]=new String();
			data[i][4]=new String();
			data[i][0]=s1[0];
			data[i][1]=s1[1];data[i][2]=s1[2];data[i][3]=s1[3];
			if(!data[i][3].equalsIgnoreCase("?")){
				data[i][4]="Y";
			}else{
				data[i][4]="N";
			}
			if(hlm.containsKey(s1[1])){
				if(hlm.get(s1[1]).equalsIgnoreCase("?")){
					hlm.put(s1[1], s1[3]);
				}
			}else{
				hlm.put(s1[1], s1[3]);
			}
			if(hlm.containsKey(s1[2])){
				if(hlm.get(s1[2]).equalsIgnoreCase("?")){
					hlm.put(s1[2], s1[3]);
				}
			}else{
				hlm.put(s1[2], s1[3]);
			}
		}
		
		boolean flag=true;
		while(flag){
			for(int i=0;i<n;i++){
				if(data[i][3].equalsIgnoreCase("?")){
					if(!hlm.get(data[i][1]).equalsIgnoreCase("?")){
							data[i][3]=hlm.get(data[i][1]);
							hlm.put(data[i][2], data[i][3]);
					}
					if(!hlm.get(data[i][2]).equalsIgnoreCase("?")){
						data[i][3]=hlm.get(data[i][2]);
						hlm.put(data[i][1], data[i][3]);
					}
				}
			}
			flag=false;
			for(int i=0;i<n;i++){
				if(data[i][3].equalsIgnoreCase("?")){
					flag=true;break;
				}
			}
		}
		Arrays.sort(data,new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				String s1=o1[0];
				String s2=o2[0];
				return s1.compareTo(s2);
			}
		});
		for(int i=0;i<n;i++){
			if(data[i][4].equalsIgnoreCase("N"))
				System.out.println(data[i][0]+","+data[i][3]);
		}
		
		
		
//		Iterator it = hlm.entrySet().iterator();
//		while(it.hasNext()){
//			Map.Entry pair = (Map.Entry)it.next();
//			System.out.println(pair.getKey()+" "+pair.getValue());
//		}
	}

}
