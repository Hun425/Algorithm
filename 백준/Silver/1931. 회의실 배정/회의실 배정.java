import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean []visitied;
    static int[][] arr ;
    static int sum ;
    static void DFS(int v,int x) {
        visitied[v]=true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[v][i] >= 1 && !visitied[i]) {

                visitied[i] = true;
                sum+=arr[v][i];
                System.out.println(i+" "+sum);
                x=i;
                DFS(i,x);

            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        // 배열 생성을 위한 최대값 미리 구하기
        int mx =0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (x > mx) {
                mx=x;   // x가 y 보다 항상 크기때문에 y는 검사안함
            }
            arr[i]= new int[]{y, x};

        }
        // 구간의 최소를 기준으로 정렬 해주기
        Arrays.sort(arr,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        Arrays.sort(arr,(a,b) -> {
            return Integer.compare(a[1],b[1]);

        });

//        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                System.out.print(anInt+" ");
//            }
//            System.out.println();
//        }

        int cnt=1;
        boolean check = false;
        int y = arr[0][0];
        int x = arr[0][1];
        for (int i = 1; i <arr.length; i++) {


                
                    if (x<=arr[i][0] ) {
                        y=arr[i][0];
                        x=arr[i][1];
                        cnt++;
                    }
        }

        System.out.println(cnt);




    }
}