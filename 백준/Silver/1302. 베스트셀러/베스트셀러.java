import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<String> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> cnt = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            cnt.put(key,cnt.getOrDefault(key,0)+1);
        }
        int max = 0;
        for (Integer s : cnt.values()) {
            if(max<s){
                max = s;
            }
        }
        
        for (String s : cnt.keySet()) {
            if(cnt.get(s)==max){
                arr.add(s);

            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));



    }
}
