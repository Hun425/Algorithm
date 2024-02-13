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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Union arr 배열 초기화
        arr= new int[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i]=i;
        }

        // m만큼 입력값 받으면서 계산
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (check == 0) {
                Union(idx, value);
            }
            else{
                if (Find(idx)==Find(value)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                }
            }
        }
    }

/*
집합의 관계를 배열을 통해 연결 표시를 간략화 하는 과정 == UNION FIND
자기 자신을 값으로 가진 배열을 만들고 서로 연결된 인덱스는 작은값을 기준으로 갱신해준다
 */