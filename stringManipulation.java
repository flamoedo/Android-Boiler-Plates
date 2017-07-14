import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld {
  public static void main(String[] args) {
  
  String fruit = "Banana";
  	String[] splitFruit = fruit.split("a");
  	
    	System.out.println(Arrays.toString(splitFruit));
  
  	/*
  	String river = "Mississippi";
  	String[] splitRiver = river.split("s");
  	
    	System.out.println(Arrays.toString(splitRiver));
    	
    	String river = "Mississippi";
  	String riverPart = river.substring(4, 8);
  	
    	System.out.println(riverPart);
    	*/
    	
    	String html = "<div class=\"image\"><img src=\"http://cdn.posh24.com/images/:profile/18779183022145d9ce7229d752f4c116f\" alt=\"Caitlyn Jenner\"/></div>";
  	
  	Pattern p = Pattern.compile("src=\"(.*?)\"");
  	Matcher m = p.matcher(html);
  	
  	while (m.find()) {
  	
  		System.out.println(m.group(1));
  		
  	}
  	
  	p = Pattern.compile("alt=\"(.*?)\"");
  	m = p.matcher(html);
  	
  	while (m.find()) {
  	
  		System.out.println(m.group(1));
  		
  	}
  	
    	
    	
  }
}











