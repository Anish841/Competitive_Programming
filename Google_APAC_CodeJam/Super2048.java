import java.util.*;
import java.io.*;
public class Super2048{
	public static void shiftToRight(int tiles[][],int n){
		for(int i=0;i<n;i++){
			int tempn0=n-1,temp0=n-1;
			for(int j=n-1;j>=0;){
				while(j>=0 && tiles[i][j]==0){
					temp0--;j--;
				}
				while(j>=0 && tiles[i][j]!=0){
					if(tempn0!=temp0){
						tiles[i][tempn0]=tiles[i][temp0];tiles[i][temp0]=0;
					}
					j--;tempn0--;temp0--;
				}
			}
		}
	}
	public static void shiftToLeft(int tiles[][],int n){
		for(int i=0;i<n;i++){
			int tempn0=0,temp0=0;
			for(int j=0;j<n;){
				while(j<n && tiles[i][j]==0){
					temp0++;j++;
				}
				while(j<n && tiles[i][j]!=0){
					if(tempn0!=temp0){
						tiles[i][tempn0]=tiles[i][temp0];tiles[i][temp0]=0;
					}
					j++;tempn0++;temp0++;
				}
			}
		}
	}
	public static void shiftToUp(int tiles[][],int n){
		for(int j=0;j<n;j++){
			int tempn0=0,temp0=0;
			for(int i=0;i<n;){
				while(i<n && tiles[i][j]==0){
					temp0++;i++;
				}
				while(i<n && tiles[i][j]!=0){
					if(tempn0!=temp0){
						tiles[tempn0][j]=tiles[temp0][j];tiles[temp0][j]=0;
					}
					i++;tempn0++;temp0++;
				}
			}
		}
	}
	
	public static void shiftToBottom(int tiles[][],int n){
		for(int j=0;j<n;j++){
			int tempn0=n-1,temp0=n-1;
			for(int i=n-1;i>=0;){
				while(i>=0 && tiles[i][j]==0){
					temp0--;i--;
				}
				while(i>=0 && tiles[i][j]!=0){
					if(tempn0!=temp0){
						tiles[tempn0][j]=tiles[temp0][j];tiles[temp0][j]=0;
					}
					i--;tempn0--;temp0--;
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int y=1;y<=t;y++){
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int n=Integer.parseInt(st.nextToken());
			String dir=st.nextToken();
			int tiles[][]=new int[n][n];
			for(int i=0;i<n;i++){
				StringTokenizer st1=new StringTokenizer(bf.readLine());
				for(int j=0;j<n;j++){
					tiles[i][j]=Integer.parseInt(st1.nextToken());
				}
			}
			if(dir.equalsIgnoreCase("right")){
				for(int i=0;i<n;i++){
					for(int j=n-1;j>0;j--){
						for(int k=j-1;tiles[i][j]!=0 && k>=0;k--){
							if(tiles[i][k]!=0 && tiles[i][j]!=tiles[i][k]){
								j=k+1;
								break;
							}
							if(tiles[i][k]!=0 && tiles[i][j]==tiles[i][k]){
								tiles[i][j]=tiles[i][j]+tiles[i][k];
								tiles[i][k]=0;j=k;
								break;
							}
						}
					}
				}
				shiftToRight(tiles,n);
			}
			if(dir.equalsIgnoreCase("left")){
				for(int i=0;i<n;i++){
					for(int j=0;j<n-1;j++){
						for(int k=j+1;tiles[i][j]!=0 && k<n;k++){
							if(tiles[i][k]!=0 && tiles[i][j]!=tiles[i][k]){
								j=k-1;
								break;
							}
							if(tiles[i][k]!=0 && tiles[i][j]==tiles[i][k]){
								tiles[i][j]=tiles[i][j]+tiles[i][k];
								tiles[i][k]=0;j=k;
								break;
							}
						}
					}
				}
				shiftToLeft(tiles,n);
			}
			if(dir.equalsIgnoreCase("up")){
				for(int j=0;j<n;j++){
					for(int i=0;i<n-1;i++){
						for(int k=i+1;tiles[i][j]!=0 && k<n;k++){
							if(tiles[k][j]!=0 && tiles[i][j]!=tiles[k][j]){
								i=k-1;
								break;
							}
							if(tiles[k][j]!=0 && tiles[i][j]==tiles[k][j]){
								tiles[i][j]=tiles[i][j]+tiles[k][j];
								tiles[k][j]=0;i=k;
								break;
							}
						}
					}
				}
				shiftToUp(tiles,n);
			}
			if(dir.equalsIgnoreCase("down")){
				for(int j=0;j<n;j++){
					for(int i=n-1;i>0;i--){
						for(int k=i-1;tiles[i][j]!=0 && k>=0;k--){
							if(tiles[k][j]!=0 && tiles[i][j]!=tiles[k][j]){
								i=k+1;
								break;
							}
							if(tiles[k][j]!=0 && tiles[i][j]==tiles[k][j]){
								tiles[i][j]=tiles[i][j]+tiles[k][j];
								tiles[k][j]=0;i=k;
								break;
							}
						}
					}
				}
				shiftToBottom(tiles,n);
			}
			System.out.println("Case #"+y+":");
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(j==n-1)
						System.out.print(tiles[i][j]);
					else
						System.out.print(tiles[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}