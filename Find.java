import java.io.*;
public class find {
public static void main(String[] args) throws IOException {
	File target = new File("https://raw.githubusercontent.com/Conor-YC/EE308-LAB/main/target.c");//The file in my PC is"D:/target.c"
	BufferedReader in = new BufferedReader(new FileReader(target));
	String str;
	String fi = "";
    while ((str = in.readLine()) != null) {
        fi = fi + str;
    }
    System.out.println(fi);
    int Sw = 0;
    for(int i = 0; i < fi.length(); i++) {
    	int a = fi.indexOf("switch",i);
    	if(a == i) {
    		Sw++;
    		int b = fi.indexOf("switch",a+1);
    		if(b < 0)b = fi.length();
    		int C = 0;
    	    for(int j = i; j < b; j++) {
    	    	int n = fi.indexOf("case",j);
    	    	if(n == j) {
    	    		C++;
    	    	}
    	    }
    	    System.out.println("case of \"switch case\" structure"+Sw+": "+C);
    	}
    }
    System.out.println("The number of \"switch case\" structures is "+Sw);
    System.out.println("===========");
    int Ca = 0;
    for(int i = 0; i < fi.length(); i++) {
    	int a = fi.indexOf("case",i);
    	if(a == i) {
    		Ca++;
    	}
    }
    System.out.println("all case:"+Ca);
    int if0 = 0;//all_if
    int eif = 0;//pure_if
    for(int i = 0; i < fi.length(); i++) {
    	int a = fi.indexOf("if",i);
    	if(a == i) {
    		if0++;
    	}
    }
    for(int i = 0; i < fi.length(); i++) {
    	int b = fi.indexOf("else if",i);
    	if(b == i) {
    		eif++;
    	}
    }
    System.out.println("if:"+(if0 - eif));
    System.out.println("else if:"+eif);//all_if - pure_if = else_if
    System.out.println("all if:"+if0);
    int El = 0;//all_else
    for(int i = 0; i < fi.length(); i++) {
    	int a = fi.indexOf("else",i);
    	if(a == i) {
    	El++;
    	}
    }
    System.out.println("else:"+(El - eif));//all_else - else_if = pure_else
    System.out.println("all else:"+El);
    System.out.println("===========");
    System.out.println("The number of \"if else\" structures is "+(if0 - eif));
    
}
}
