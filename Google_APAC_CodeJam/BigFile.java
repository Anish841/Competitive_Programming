import java.util.*;
import java.io.*;

public class BigFile{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int noOfFile=Integer.parseInt(bf.readLine());
		int lenFiles[]=new int[noOfFile];
		int fileInts[][]=new int[noOfFile][];
		for(int i=0;i<noOfFile;i++){
			String str=bf.readLine();
			String s1[]=str.split("\\s+");
			lenFiles[i]=Integer.parseInt(s1[0]);
			fileInts[i]=new int[lenFiles[i]];
			for(int j=1;j<=lenFiles[i];j++){
				fileInts[i][j-1]=Integer.parseInt(s1[j]);
			}
		}
		int noQueries=Integer.parseInt(bf.readLine());
		for(int i=0;i<noQueries;i++){
			String str=bf.readLine();
			String s1[]=str.split("\\s+");
			int type=Integer.parseInt(s1[0]);
			int len=Integer.parseInt(s1[1]);
			int ans=0;
			if(type==1){
				boolean flag=false,ff=false;
						//System.out.println(noOfFile+" "+len);
						for(int j=0;j<noOfFile;j++){
							flag=false;ff=false;
							for(int k=0;k<len;k++){
								ff=false;
								int no=Integer.parseInt(s1[k+2]);
								//System.out.println("no==>"+no);
								flag=false;
								for(int p=0;p<lenFiles[j];p++){
									//System.out.println(fileInts[j][p]);
									if(fileInts[j][p]==no){
										//System.out.println("match");
										flag=true;
									}
								}
								if(!flag){
									ff=true;
									break;
								}
							}
							if(!ff)
								ans++;
							//System.out.println(ans);
						}
			}else if(type==2){
				boolean flag=false;
						for(int j=0;j<noOfFile;j++){
							flag=false;
							for(int k=0;k<len;k++){
								int no=Integer.parseInt(s1[k+2]);
								flag=false;
								for(int p=0;p<lenFiles[j];p++){
									if(fileInts[j][p]==no){
										flag=true;break;
									}
								}
								if(flag){
									break;
								}
							}
							if(flag)
								ans++;
							//System.out.println(ans);
						}
			}else if(type==3){
				boolean flag=false,oneflag=false,ff=false;
						for(int j=0;j<noOfFile;j++){
							flag=false;
							int lenflag=0;
							for(int k=0;k<len;k++){
								int no=Integer.parseInt(s1[k+2]);
								flag=false;
								for(int p=0;p<lenFiles[j];p++){
									if(fileInts[j][p]==no){
										oneflag=true;
										lenflag++;
									}
								}
							}
							if(oneflag && lenflag!=len)
								ans++;
							
							//System.out.println(ans);
						}
			}
			System.out.println(ans);
			}
		}
		
	}