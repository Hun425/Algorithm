import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//보석 정보 개수
        int K = Integer.parseInt(st.nextToken());//가방 무개

        int[][]arr = new int[N][2];

        int[]backpack = new int[K];



        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[i][0] = weight;
            arr[i][1] = value;

        }

        for (int i = 0; i < K; i++) {
            backpack[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(backpack);
        Arrays.sort(arr,(o1, o2) -> o1[0] - o2[0]);

        long ans = 0;
        int cnt =0;
        PriorityQueue<Integer> pq =new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < backpack.length; i++) {


            while(cnt<arr.length){
                if(arr[cnt][0]>backpack[i])break;
                pq.add(arr[cnt][1]);
                cnt++;
            }

            if(!pq.isEmpty()) ans+=pq.poll();
        }

        System.out.println(ans);
    }
}