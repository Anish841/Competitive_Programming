import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Problem1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str=bf.readLine();
		int tc=Integer.parseInt(str);
		for(int i=0;i<tc;i++){
			str=bf.readLine();
			int len=str.length();
			char c[]=str.toCharArray();
			int change=0,change1=0;
			for(int j=0;j<len;j++){
				if(j%2==0){
					if(c[j]=='+')
						change++;
				}else{
					if(c[j]=='-')
						change++;
				}
				
				if(j%2==0){
					if(c[j]=='-')
						change1++;
				}else{
					if(c[j]=='+')
						change1++;
				}
			}
			if(change<=change1)
				System.out.println(change);
			else
				System.out.println(change1);
		}
	}
}
