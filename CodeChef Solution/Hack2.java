import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Hack2 {

	public static String block[];
	public static int globalMin=Integer.MAX_VALUE;
	public static void calMinTrans(int index){
//		if(index>=block.length)
//			return ;
		int globali=0;int tempi=0,tempj=1;
		while(globali<block.length){
			boolean ispaired[]=new boolean[block.length];
			int min=block.length;boolean flag=false;
			for(int i=tempi;i<block.length;i++){
				if(!ispaired[i])
					for(int j=tempj;j<block.length;j++){
						if(!ispaired[j])
							if(isPalindrome(block[i]) || isPalindrome(block[j])){
								min--;
								if(globalMin>min)
									globalMin=min;
								if(!flag){
									tempi=i;tempj=j+1;
								}ispaired[i]=true;ispaired[j]=true;flag=true;
									break;
							}
					}
			}
			System.out.println(tempi+" "+tempj);
			globali=tempi;
		}
	}
	public static boolean isPalindrome(String str)
	{
	    int l = 0;
	    int h = str.length() - 1;
	    while (h > l)
	    {
	        if (str.charAt(l++) != str.charAt(h--))
	        {
	            return false;
	        }
	    }
	   return true;
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str;
		while(true){
			str=bf.readLine();
			if(str==null){
				break;
			}
			int n=Integer.parseInt(str);
			block=new String[n];
			for(int i=0;i<n;i++){
				block[i]=bf.readLine();
			}
			globalMin=Integer.MAX_VALUE;
			calMinTrans(0);
			System.out.println(globalMin);
		}
	}
}
