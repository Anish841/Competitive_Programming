import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class standing
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		File file = new File("answer.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		int x = 1;		
		while(testcase-->0){
			String s = br.readLine();
			String s1[] = s.split("\\s+");
			int count=0,ans=0;
			for(int i=0;i<s1[1].length();i++){
				int temp = Integer.parseInt(s1[1].substring(i, i+1));
				if(i==0)
					count+=temp;
				else{
					if(temp!=0){
						if(count-i < 0){
							ans += (i-count);
							count += (i-count);
						}
						count+=temp;
					}
				}
			}
			String s2 = "Case #"+x+": "+ans;
			writer.write(s2+"\n");
			x++;
		}
		writer.flush();
	    writer.close();
	}
}
