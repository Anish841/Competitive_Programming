import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice3 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		int p=1;
		while(tc-->0){
			int N=Integer.parseInt(bf.readLine());
			int ans=0;
			String last="";
			for(int i=0;i<N;i++){
				String str=bf.readLine();
				if(last.compareTo(str)<0){
					last=str;
				}else{
					ans++;
				}
			}
			System.out.println("Case #"+p+": "+ans);p++;
		}
	}
}
