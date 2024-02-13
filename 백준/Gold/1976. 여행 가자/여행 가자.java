import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[]arr;
    static void Union(int a, int b) {
        a= Find(a);
        b= Find(b);
        if (a != b) {
            arr[b]=a;
        }
    }

    static int Find(int a) {
        if (a == arr[a]) {
            return a;
        }
        else{
            return arr[a]=Find(arr[a]);
        }

    }


    public static void main(String[] args) throws IOException {
        // 입력값 받기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i]=i;
        }
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int []check = new int[N+1];
            for (int j = 1; j < N+1; j++) {
                check[j] = Integer.parseInt(st.nextToken());
                if (check[j] == 1) {
                    Union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int [] ans = new int[M];

        // 마지막 계산할 열 받기
        for (int i = 0; i < M; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        boolean travel = true;
        for (int i = 0; i < M-1; i++) {
            if (Find(ans[i]) != Find(ans[i + 1])) {
                travel= false;
            }
        }

        if (travel) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    }

/*
    문제 조건에 나와있는대로 Union 해준후 (그룹화)
    마지막 열 값들의 find 값이 전부 동일한지 확인

 */