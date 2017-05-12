package Assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Assignment3 {
	static LinkedList<String> l=new LinkedList<String>();
	static int f=0;
	public static String decompose(int r,int c,String str,int bitmap[][],int sum[][]){
		for (int i = 0; i < r; i++) {
		    int ones = 0;
		    for (int j = 0; j < c; j++) {
		      char zero_or_one=str.charAt((i*c)+j);
		      bitmap[i][j] = zero_or_one-'0';
		      ones += bitmap[i][j];
		      sum[i][j] = ones;
		      if (i>0)
		        sum[i][j] += sum[i - 1][j];
		    }
		  }
		String ans="";
		quarters(0, 0, r - 1, c - 1,sum,ans,bitmap);
		return ans;
	}
	static int zeros_ones(int top, int left, int bottom, int right,int sum[][],int bitmap[][])
	{
	  int s = sum[bottom][right];
	  if ((top>0) && (left>0))
	    s += sum[top - 1][left - 1] - sum[top - 1][right] - sum[bottom][left - 1];
	  else if (top>0)
	    s -= sum[top - 1][right];
	  else if (left>0)
	    s -= sum[bottom][left - 1];
	  if (s==0)
	    return 0; 
	  else if (s == (bottom - top + 1) * (right - left + 1))
	    return 1; 
	  else
	    return -1;
	}
static void quarters(int top, int left, int bottom, int right,int sum[][],String ans,int bitmap[][])
{
  int zo = zeros_ones(top, left, bottom, right,sum,bitmap);
  if (zo >= 0) {
    ans=ans+zo;l.add(new Integer(zo).toString());
  }
  else {
	  l.add("D");
    ans=ans+"D";
    int rows = bottom - top + 1, columns = right - left + 1;
    if (rows > 1 && columns > 1) {
      quarters(top, left, top + (rows - 1) / 2, left + (columns - 1) / 2,sum,ans,bitmap);
      quarters(top, left + (columns + 1) / 2, top + (rows - 1) / 2,  right,sum,ans,bitmap);
      quarters(top + (rows + 1) / 2, left, bottom, left + (columns - 1) / 2,sum,ans,bitmap);
      quarters(top + (rows + 1) / 2, left + (columns + 1) / 2, bottom, right,sum,ans,bitmap);
    }
    else if (rows > 1) {
      quarters(top, left, top + (rows - 1) / 2, right,sum,ans,bitmap);
      quarters(top + (rows + 1) / 2, left, bottom, right,sum,ans,bitmap);
    }
    else {
      quarters(top, left, bottom, left + (columns - 1) / 2,sum,ans,bitmap);
      quarters(top, left + (columns + 1) / 2, bottom,  right,sum,ans,bitmap);
    }
  }
 }
static void compose(int top, int left, int bottom, int right,String str,int bitmap[][],int sum[][]) throws IOException
{
	char c = '%';
	if(str.length()!=f){
		c=str.charAt(f++);
	}
	if (c == '0' || c == '1') {
    c -= '0';
    for (int i = top; i <= bottom; i++)
      for (int j = left; j <= right; j++){
    	  bitmap[i][j] = c;
      }
  }
  else { 
    int rows = bottom - top + 1, columns = right - left + 1;
    if (rows > 1 && columns > 1) {
    	compose(top, left, top + (rows - 1) / 2, left + (columns - 1) / 2,str,bitmap,sum);
    	compose(top, left + (columns + 1) / 2, top + (rows - 1) / 2,  right,str,bitmap,sum);
    	compose(top + (rows + 1) / 2, left, bottom, left + (columns - 1) / 2,str,bitmap,sum);
    	compose(top + (rows + 1) / 2, left + (columns + 1) / 2, bottom, right,str,bitmap,sum);
    }
    else if (rows > 1) {
    	compose(top, left, top + (rows - 1) / 2, right,str,bitmap,sum);
    	compose(top + (rows + 1) / 2, left, bottom, right,str,bitmap,sum);
    }
    else {
    	compose(top, left, bottom, left + (columns - 1) / 2,str,bitmap,sum);
    	compose(top, left + (columns + 1) / 2, bottom,  right,str,bitmap,sum);
    }
  }
}
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line=bf.readLine();
			if("#".equals(line) || " ".equalsIgnoreCase(line) ||  line=="") break;
			int r,c;
			String str[]=line.split("\\s+");
			r=Integer.parseInt(str[1]);
			c=Integer.parseInt(str[2]);
			int bitmap[][]=new int[r][c];
			int sum[][]=new int[r][c];
			l.clear();
			f=0;
			String strn;
			if("D".equals(str[0])){
				System.out.println("B    "+r+"    "+c);
				strn=bf.readLine();
				compose(0,0,r-1,c-1,strn,bitmap,sum);
				for(int i=0;i<r;i++){
					for(int j=0;j<c;j++){
						if(bitmap[i][j]==0 || bitmap[i][j]==1)
						System.out.print(bitmap[i][j]);
					}
				}
				System.out.println();
			}
			if("B".equals(str[0])){
				System.out.println("D    "+r+"    "+c);
				strn=bf.readLine();
				System.out.println(decompose(r,c,strn,bitmap,sum));
				ListIterator<String> litr=l.listIterator();
				while(litr.hasNext()){
					System.out.print(litr.next());
				}
				System.out.println();
			}
			
		}
	}
}
