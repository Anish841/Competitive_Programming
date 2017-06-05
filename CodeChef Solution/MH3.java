import java.util.*;
import java.io.*;
public class MH3{
		public static void countSort(char str[][],int n,int cindex)
		{
			char output[]=new char[n];
		 	int count[]=new int[27], i;
			for(i = 0; i<n; i++)
				++count[str[i][cindex]-97];
		 
			for (i = 1; i <= 26; ++i)
				count[i] += count[i-1];
		 	for (i = 0;i<n; ++i)
			{
				output[count[str[i][cindex]-97]-1] = str[i][cindex];
				--count[str[i][cindex]-97];
			}

			//adding
		 	for (i = 0; i<n; ++i)
				str[i][cindex] = output[i];
		}
	public static void main(String args[])throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
			while(tc-->0){
				String str=bf.readLine();
				String s[]=str.split("\\s+");
				int n=Integer.parseInt(s[0]);
				int k=Integer.parseInt(s[1]);
				char arr[][]=new char[n][k];
				for(int i=0;i<n;i++){
					str=bf.readLine();
					for(int j=0;j<k;j++){
						arr[i][j]=str.charAt(j);
					}
				}
				
				for(int i=0;i<k;i++){
					countSort(arr,n,i);
				}
				char ans[]=new char[k];int in=0;
				for(int i=0;i<k;i++){
					if(n%2==0){
							in=(n/2)+((n/2)-1);
							ans[i]=arr[in/2][i];
					}			
					else
						ans[i]=arr[n/2][i];
				}
				for(int i=0;i<k;i++){
					System.out.print(ans[i]);
				}System.out.println();
			}
		}
}