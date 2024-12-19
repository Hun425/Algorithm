import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        Integer[][] arr= new Integer[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            Integer num = Integer.parseInt(st.nextToken());
            Integer startTime = Integer.parseInt(st.nextToken());
            Integer endTime = Integer.parseInt(st.nextToken());

            arr[i][0] = startTime ;
            arr[i][1] = endTime ;
        }



        Arrays.sort(arr,(o1, o2) -> o1[0]-o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(arr[0][1]);

        for (int i = 1; i < N; i++) {
            if(pq.peek()<=arr[i][0])pq.poll();
            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());
    }
}