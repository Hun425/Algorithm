import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();




    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] arr = new int[end+1];
        boolean[] visited = new boolean[end + 1];
        for (int i = 0; i < end + 1; i++) {
            arr[i]=1;
        }
        arr[0]=0;
        arr[1]=0;
        for (int i = 2; i < end+1; i++) {
            if (!visited[i]) {
                int idx =i;
                while (idx< end) {
                    idx = idx+i;
                    if (idx > end) {
                        break;
                    }
                    arr[idx]=0;
                    visited[idx]=true;
                }
            }

        }
        for (int i = start; i < end + 1; i++) {
            if (arr[i] == 1) {
                System.out.println(i);
            }
        }

    }
}