import java.util.*;
import java.io.*;
public class RopeInternet{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int p=1;p<=t;p++){
			int n=Integer.parseInt(bf.readLine());
			int height[][]=new int[n][2];
			for(int i=0;i<n;i++){
				StringTokenizer st=new StringTokenizer(bf.readLine());
				height[i][0]=Integer.parseInt(st.nextToken());
				height[i][1]=Integer.parseInt(st.nextToken());
			}
			long ans=0;
			for(int i=1;i<n;i++){
				for(int j=0;j<i;j++){
					if((height[i][0]<height[j][0] && height[i][1]<height[j][1]) || (height[i][0]>height[j][0] && height[i][1]>height[j][1])){
						
					}else{
						ans++;
					}
				}
			}
			System.out.println("Case #"+p+": "+ans);
		}
	}
}