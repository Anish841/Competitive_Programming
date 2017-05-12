import java.util.*;
import java.io.*;
import java.util.regex.*;
public class Alien{
	public static void main(String args[]) throws Exception{
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int L=Integer.parseInt(st.nextToken());
			int D=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			ArrayList<String> set=new ArrayList<String>();
			for(int i=0;i<D;i++){
				set.add(bf.readLine());
			}
			for(int i=0;i<N;i++){
				String sen=bf.readLine();
				sen=sen.replaceAll("\\(","[");
				sen=sen.replaceAll("\\)","]");
				long ans=0;
				for(int j=0;j<D;j++){
					if(set.get(j).matches(sen)){
						ans++;
					}
				}
				System.out.println("Case #"+(i+1)+": "+ans);
			}
	}
	
}