import java.util.*;
import java.util.regex.*;
import java.io.*;
class TextProcessing {

public static void main(String[] args) throws Exception{

    //Scanner in = new Scanner(System.in);
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    TextProcessing processing=new TextProcessing();
    List<String> inputs=new ArrayList<String>();
	//System.out.println(n);
   // in.nextLine();
    for (int i = 0; i < 2*n; i++) {
        String input=bf.readLine();
        //if (input!=null && !input.trim().equals("")) {
            inputs.add(input);
        //}
        bf.readLine();
		i++;
    }

    for (String string : inputs) {
		//System.out.println(string);
       System.out.println(processing.noOfAs(string));
        System.out.println(processing.noOfAns(string));
        System.out.println(processing.noOfThes(string));
		//System.out.println(0);
        System.out.println(processing.noOfDates(string));
    }

}

public int noOfAs(String string) {
    String regex="\\s[aA]\\s|^[aA]\\s";
    Pattern pattern=Pattern.compile(regex);
    Matcher matcher=pattern.matcher(string);
    int i=0;
    while (matcher.find()) {
	i++; 
	return i; 
	}

public int noOfAns(String string) {
    String regex="\\s(a)(n)\\s|^(a)(n)\\s|\\s(A)(n)\\s|^(A)(n)\\s|\\s(A)(N)\\s|^(A)(N)\\s";
    Pattern pattern=Pattern.compile(regex);
    Matcher matcher=pattern.matcher(string);
    int i=0;
    while (matcher.find()) {
		i++; 
	} 
	return i; 
	}

public int noOfThes(String string) {
    String regex="\\sthe\\s|^the\\s|\\sThe\\s|^The\\s//|\\W[Tt]he\\W|^The\\s";
	
    Pattern pattern=Pattern.compile(regex);
    Matcher matcher=pattern.matcher(string);
    int i=0;
    while (matcher.find()) {
		i++; 
 } return i; 
 }

public int noOfDates(String string) {
    //(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)
    String regex="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/(\\d\\d\\d\\d)|(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/(\\d\\d)" +
            "|(0[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])/(\\d\\d\\d\\d)|(0[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])/(\\d\\d)" +
            "|(0?[1-9]|[12][0-9]|3[01])(st|nd|rd|th)(.+?)([Jj]anuary|[Jj]an|[Ff]eburary|[Ff]eb|[Mm]arch|[Mm]ar|[Aa]pril|[Aa]pr" +
            "|[Mm]ay|[Jj]une|[Jj]un|[Jj]uly|[Jj]ul|[Aa]ugust|[Aa]ug|[Ss]eptember|[Ss]ep|[Oo]ctober|[Oo]ct|[Nn]ovember|[Nn]ov" +
            "[Dd]ecember|[Dd]ec)(.+?)(\\d\\d\\d\\d|\\d\\d)" +
            "|([Jj]anuary|[Jj]an|[Ff]eburary|[Ff]eb|[Mm]arch|[Mm]ar|[Aa]pril|[Aa]pr" +
            "|[Mm]ay|[Jj]une|[Jj]un|[Jj]uly|[Jj]ul|[Aa]ugust|[Aa]ug|[Ss]eptember|[Ss]ep|[Oo]ctober|[Oo]ct|[Nn]ovember|[Nn]ov" +
            "[Dd]ecember|[Dd]ec)(.+?)" +
            "(0?[1-9]|[12][0-9]|3[01])(st|nd|rd|th|\\W)(.+?)(\\d\\d\\d\\d|\\d\\d)" +
            "";
    Pattern pattern=Pattern.compile(regex);
    Matcher matcher=pattern.matcher(string);
    int i=0;
    while (matcher.find()) {
	// System.out.println(matcher.group()); 
	i++; 
	}
	return i; 
	} 
	}

