import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.HashMap;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashMap <String,Integer> map = new HashMap<>();
		HashMap <Integer,String> map2 = new HashMap<>();
		for(int i=0;i<a;i++) {
			String str = br.readLine();
			map.put(str, i+1);
			map2.put(i+1, str);
		}
		for(int i=0;i<b;i++) {
			String s = br.readLine();
			if(isNum(s)) {
				bw.write(map2.get(Integer.parseInt(s))+"\n");
			}
			else {
				bw.write(map.get(s)+"\n"); 
			}
		}
		bw.close();
	}
	/////////////
	static boolean isNum(String n) {
		char ch = n.charAt(0);
		if((int)ch>=48&&(int)ch<=57) {
			return true;
		}
		else {
			return false;
		}
	}
}