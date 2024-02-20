import javax.sound.midi.Track;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int result=Integer.MIN_VALUE;
    static int Cal(String a, String b, String s) {
        int dela = Integer.parseInt(a);
        int delb = Integer.parseInt(b);
        if (s.equals("+")) {
            return dela+delb;
        } else if (s.equals("-")) {
            return dela-delb;
        } else {
            return dela*delb;
        }
    }
    static void DFS(int level,int sum,String[]s) {
        if (level >= s.length) {
            result = Math.max(sum, result);
            return ;
        }
        DFS(level+2,Cal(String.valueOf(sum),s[level],s[level-1]),s);

        if (level+2<s.length) {
            int right = Cal(s[level],s[level+2],s[level+1]);
            int left = Cal(String.valueOf(sum),String.valueOf(right),s[level-1]);
            DFS(level+4,left,s);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 받기
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String []ans = new String[s.length()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = String.valueOf(s.charAt(i));
        }
        int a = Integer.parseInt(ans[0]);
        DFS(2,a,ans);

        System.out.println(result);
    }
}
    /*
        1.변수명 잘 설정하기
        2.전역 변수 최대한 적게 생성하기
        3.기능 메서드화 시키기
        4.주석 적기
     */


