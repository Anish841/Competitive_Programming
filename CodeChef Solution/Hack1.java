import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Hack1 {

	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		HashMap<Integer, Integer> h[]=new HashMap[N];
		for(int i=0;i<N;i++){
			String str=bf.readLine();
			String s1[]=str.split("\\s+");
			h[i]=new HashMap<Integer,Integer>();
			int len=Integer.parseInt(s1[0]);
			int value=0;
			for(int j=1;j<=len;j++){
				value=0;
				int no=Integer.parseInt(s1[j]);
				if(h[i].containsKey(no)){
					value=h[i].get(no);
				}
					value++;
					h[i].put(no, value);
			}
		}
		int q=Integer.parseInt(bf.readLine());
		for(int i=0;i<q;i++){
			String str=bf.readLine();
			String s1[]=str.split("\\s+");
			int type=Integer.parseInt(s1[0]);
			int len=Integer.parseInt(s1[1]);
			long ans=0;
			if(type==1){
				HashMap<Integer, Integer> temp=new HashMap<Integer, Integer>();
				int v=0;
				for(int k=0;k<len;k++){
					v=0;
					int no=Integer.parseInt(s1[k+2]);
					if(temp.containsKey(no)){
						v=temp.get(no);
					}
					v++;
					temp.put(no, v);
				}
				for(int j=0;j<N;j++){
					boolean flag=false;
					for(int k=0;k<len;k++){
						flag=false;
						int no=Integer.parseInt(s1[k+2]);
						int count=temp.get(no);
						if(h[j].containsKey(no) && count<=h[j].get(no)){
							flag=true;
						}
						if(!flag)
							break;
					}
					if(flag)
						ans++;
				}
			}else if(type==2){
				for(int j=0;j<N;j++){
					for(int k=0;k<len;k++){
						int no=Integer.parseInt(s1[k+2]);
						if(h[j].containsKey(no)){
							ans++;break;
						}
					}
				}
			}else if(type==3){
				for(int j=0;j<N;j++){
					boolean flag=false,oneflag=false,t1=false;
					for(int k=0;k<len;k++){
						flag=false;
						int no=Integer.parseInt(s1[k+2]);
						if(h[j].containsKey(no)){
							oneflag=true;
							flag=true;
						}else{
							if(oneflag)
								break;
						}
						if(!flag)
							t1=true;
					}
					if(oneflag && (!flag || (t1 && flag)))
						ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
