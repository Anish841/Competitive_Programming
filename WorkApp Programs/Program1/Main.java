/**
 * Main.java --- program to find out highest score user can get in the game.
 * @author    Anish Ratnawat
 */

import java.util.*;
import java.io.*;
public class Main{

	// This function will return maximum score user can get in the game.
	public static long getMaxScore(long grid[][],long scoreDP[][],int numRow,int numCol){
		long maxScore=0;														// It holds maximum score of the game 
		long temp=0;															// A temporary variable
		long prevRow=0;															// It holds previous value of row in the function
		boolean upDown=true;													// It denotes false means upward direction and true means downward direction
		int count=0;
		for(int j=0;j<numCol;j++){
			for(int i=0;i<numRow;i++){
				if(grid[i][j]==-1){												// If grid value is -1 then corresponding element in scoreDP is also -1.
					scoreDP[i][j+1]=-1;
					continue;
				}
				if(scoreDP[i][j]==-1){											
					continue;
				}

				int k=0;
				count=0;
				upDown=true;

				while(count<2){													// It will go upward and downward direction to fill scoreDP array.
					prevRow=i;													// if upDown is true then go downward direction and if false then go upward direction
					temp=scoreDP[i][j]+grid[i][j];
					scoreDP[i][j+1]=Math.max(temp,scoreDP[i][j+1]);
					k=(upDown)?(i+1):(i-1);

					while(true){
						k=(k+numRow)%numRow;
						if(grid[k][j]==-1 || k==i)
							break;

						if(Math.abs(k-prevRow)>1){									// Case when element is teleported
							scoreDP[k][j+1]=Math.max(scoreDP[k][j+1],grid[k][j]);
							temp=grid[k][j];
						}else{
							temp=temp+grid[k][j];
							if(temp>scoreDP[k][j+1])
	                            scoreDP[k][j+1]=temp;
	                    }
	                    prevRow=k;
	                    k=(upDown)?(k+1):(k-1);
					}
					upDown=false;
					count++;
				}
			}
		}
		for(int i=0;i<numRow;i++){													// Finding maxscore from last column of scoreDP
			if(scoreDP[i][numCol]>maxScore){
				maxScore=scoreDP[i][numCol];
			}
		}
		return maxScore;															// return maxScore
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=bf.readLine();
		String tempArr[]=firstLine.split("\\s+");
		int n=Integer.parseInt(tempArr[0]);
		int m=Integer.parseInt(tempArr[1]);
		long grid[][]=new long[n][m];
		String nLine="";
		for(int i=0;i<n;i++){
			nLine=bf.readLine();
			tempArr=nLine.split("\\s+");
			for(int j=0;j<m;j++){
				grid[i][j]=Long.parseLong(tempArr[j]);									//Read input values and fill it in grid array
			}
		}
		long scoreDP[][]=new long[n][m+1];												// Array to hold max score values till processed column 
		long maxScore=0;
		maxScore=getMaxScore(grid,scoreDP,n,m);
		if(maxScore==0){
			System.out.println("-1");													// If snake can not reach right side then print -1.
		}else{
			System.out.println(maxScore);
		}
	}
}