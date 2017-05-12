package Assignment1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Combo{
	int num[],price;
	public Combo(int n) {
		num=new int[6];
	}
}
public class Uva10898 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String str=bf.readLine();
			if(str==null) break;
			String str1[]=str.split("\\s+");
		int items=Integer.parseInt(str1[0]);
		
		int best[]=new int[1000000];
		ArrayList<Combo> al=new ArrayList<Combo>();
		Combo c=null;
		for(int i=0;i<items;i++){
			c=new Combo(items);
			c.price=Integer.parseInt(str1[i+1]);
			c.num[i]=1;
			al.add(c);
		}
		int noCombo;
		str=bf.readLine();
		noCombo=Integer.parseInt(str);
		for(int i=0;i<noCombo;i++){
			c=new Combo(items);
			str=bf.readLine();
			str1=str.split("\\s+");
			for(int j=0;j<items;j++){
				c.num[j]=Integer.parseInt(str1[j]);
			}
			c.price=Integer.parseInt(str1[items]);
			al.add(c);
		}
		 int last = 0;
		    for (int i = 0; i < items; i++) {
		      last = last * 10 + 9;
		    }
		    for (int i = 1; i <= last; i++) {
		        best[i] = Integer.MAX_VALUE;
		      }
		    best[0] = 0;
		    for (int price = 0; price <= last; price++) {
		        if (best[price] == Integer.MAX_VALUE) {
		          continue;
		        }
		        int num[] =new int[6];
		        for (int temp = price, d = items - 1; temp>0; temp /= 10, d--) {
		          num[d] = temp % 10;
		        }
		        for (int i = 0; i < al.size(); i++) {
		            int next[] = new int[6], index = 0;
		            boolean push = true;
		            for (int j = 0; j < items && push; j++) {
		              next[j] = num[j] + al.get(i).num[j];
		              index = index * 10 + next[j];
		              push = (next[j] <= 9);
		            }
		            if (!push) {
		                continue;
		              }
		              best[index] = Math.min(best[index], best[price] + al.get(i).price);
		         }
		    }
		    str=bf.readLine();
		    int M=Integer.parseInt(str);
		    while (M-->0) {
		        int index = 0;
		        str=bf.readLine();
		        str1=str.split("\\s+");
		        for (int i = 0; i < items; i++) {
		          int num;
		          num=Integer.parseInt(str1[i]);
		          index = index * 10 + num;
		        }
		        System.out.println(best[index]);
		        
		      }
	}
	}

}

class InputReaderF {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReaderF(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
            	String str=reader.readLine();
        		if(str==null)return str;
                tokenizer = new StringTokenizer(str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
