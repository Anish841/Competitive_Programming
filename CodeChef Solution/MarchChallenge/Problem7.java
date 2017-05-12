import java.util.*;
import java.io.*;

public class Problem7{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int ans=0;
		for(int i=0;i<k;i++){
			ans=0;
			int l=sc.nextInt();
			int r=sc.nextInt();
			l--;
			r--;
			if(l==r){
				ans=0;
			}else{
				int tempm=0,max=0;
				int temp[]=new int[m+1];
				Arrays.fill(temp,-1);
				for(int j=l;j<=r;j++){
					if(temp[arr[j]]==-1)
						temp[arr[j]]=j;
					else{
						tempm=j-temp[arr[j]];
					}
					if(tempm>max)
						max=tempm;
				}
				ans=max;
			}
			System.out.println(ans);
		}
	}
}