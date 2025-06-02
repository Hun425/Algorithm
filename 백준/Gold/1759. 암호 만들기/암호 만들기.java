
import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] alpha, ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        ans = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha); 
        DFS(0, 0);
        System.out.print(sb);
    }

    // 조합 생성: level = 현재 몇 개 골랐는지, start = 시작 인덱스
    static void DFS(int level, int start){
        if(level == L){
            if(check(ans)) sb.append(new String(ans)).append("\n");
            return;
        }
        for (int i = start; i < C; i++) {
            ans[level] = alpha[i];
            DFS(level+1, i+1);  // 조합이므로 i+1부터 시작
        }
    }

    static boolean check(char[] ans){
        int consonant = 0, vowel = 0;
        for (char c : ans) {
            if("aeiou".indexOf(c) >= 0) vowel++;
            else consonant++;
        }
        return (vowel >= 1 && consonant >= 2);
    }
}
