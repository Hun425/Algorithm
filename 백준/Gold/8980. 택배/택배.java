import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer[]>[] arr= new List[N+1]; //인접리스트
        int[] max = new int[N+1];
        int ans = 0; // 정답

        for (int i = 1; i < N+1; i++) {
            max[i]=M;
        }
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }


        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st= new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[e].add(new Integer[]{s,v});
        }

        Comparator<Integer[]> comparator = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        };

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(arr[i],comparator);
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].size(); j++) {

                Integer[] now = arr[i].get(j);
                int value = now[1];
                boolean check = true;

                int v=Integer.MAX_VALUE;
                for (int k = now[0]; k <i; k++) {
                    if (max[k] == 0) {
                        v=0;
                    }
                    if (max[k] - value < 0) {
                        v = Math.min(v,max[k]);
                    } else {
                        v = Math.min(value, v);
                    }
                }

                for (int k = now[0]; k < i; k++) {
                        max[k]-=v;
                    }
                    ans+=v;

            }
        }

        System.out.println(ans);
    }
}