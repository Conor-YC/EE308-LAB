import java.io.*;
import java.util.Scanner;
public class find {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	String f_str = sc.nextLine();
	File target = new File(f_str);
	/*
	*	The site of the target in GitHub is 
	*	"https://raw.githubusercontent.com/Conor-YC/EE308-LAB/main/target.c"
	*/
	int lever = sc.nextInt();
	sc.close();
	BufferedReader in = new BufferedReader(new FileReader(target));
	String str;
	String fi = "";
    while ((str = in.readLine()) != null) {
        fi = fi + str;
    }
    //get the target file
    if(lever >= 1) {
    	lv1(fi);
    }//lever 1. Basic requirement
    if(lever >= 2) {
    	lv2(fi);
    }//lever 2. Advanced requirement
    if(lever == 3) {
    	lv3(fi);
    }//lever 3. Uplifting requirement
    if(lever == 4) {
    	lv3_4(fi);
    }//lever 4. Ultimate requirement
}
static void lv1(String fi) {
	int keyword = 0;
    for(int i = 0; i < fi.length(); i++) {
    	int a = fi.indexOf("case",i);
    	int b = fi.indexOf("if",i);
    	int c = fi.indexOf("else",i);
    	int d = fi.indexOf("default",i);
    	int e = fi.indexOf("break",i);
    	int f = fi.indexOf("switch",i);
    	int g = fi.indexOf("return",i);
    	int h = fi.indexOf("int",i);
    	int j = fi.indexOf("long",i);
    	int k = fi.indexOf("double",i);//all the keyword in target
    	if(i == a||i == b||i == c||i == d||i == e||i == f||i == g||i == h||i == j||i == k) {
    		keyword++;
    	}
    }
    System.out.println("total num: "+keyword);
}
static void lv2(String fi) {
	int Sw = 0;
    for(int i = 0; i < fi.length(); i++) {
    	int a = fi.indexOf("switch",i);
    	if(a == i) {
    		Sw++;
    		i = a;
    	}
    }
    System.out.println("switch num: "+Sw);
    Sw = 0;
    System.out.print("case num: ");
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
    	    System.out.print(C + " ");
    	}
    }
    System.out.println();
}
static void lv3(String fi) {
    int eif = 0;//else_if
    for(int i = 0; i < fi.length(); i++) {
    	int b = fi.indexOf("else if",i);
    	if(b == i) {
    		eif++;
    	}
    }
    int El = 0;//all_else
    for(int i = 0; i < fi.length(); i++) {
    	int a = fi.indexOf("else",i);
    	if(a == i) {
    	El++;
    	}
    }
    System.out.println("if-else num: "+(El - eif));//all_else - else_if = pure_else = if_else
}
static void lv3_4(String fi) {
    int eif = 0;//pure_if
    for(int i = 0; i < fi.length(); i++) {
    	int b = fi.indexOf("else if",i);
    	if(b == i) {
    		eif++;
    	}
    }
    int El = 0;//all_else
    for(int i = 0; i < fi.length(); i++) {
    	int a = fi.indexOf("else",i);
    	if(a == i) {
    	El++;
    	}
    }
    System.out.println("if-else num: "+(El - eif));//all_else - else_if = pure_else = if_else
    int i_ei_e = 0;
    for(int i = 0; i < fi.length(); i++) {
    	int b = fi.indexOf("else if",i);
    	int c = fi.indexOf("if",i);
    	if((b != c-5)&& b > 0) {
    		i_ei_e++;
    		i = b + 5;
    	}
    }
    System.out.println("if-elseif-else num: "+(i_ei_e));
}
}
