import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        cdn[]arr = new cdn[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new cdn(s,e);
        }
        Arrays.sort(arr);



        int v = arr[0].end;
        pq.add(arr[0].end);
        for (int i = 1; i < N; i++) {
            if(pq.peek()<=arr[i].start){
                pq.poll();
            }
            pq.add(arr[i].end);
        }

        System.out.println(pq.size());
    }
}
class cdn implements Comparable<cdn>{
    int start;
    int end;

    public cdn(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(cdn next) {
        if(this.start==next.start){
            return this.end-next.end;
        }
        return this.start-next.start;
    }
}