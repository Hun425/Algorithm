import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]idx = new int[N+1];
        PriorityQueue<Nd> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.weight));

        for (int i = 0; i < N+1; i++) {
            idx[i]=i; // 유니온 파인드를 위한 배열 초기화
        }

        long total = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int nowNd = Integer.parseInt(st.nextToken());
            int nextNd = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());

            total+=weight;

            Nd nd = new Nd(nowNd, nextNd, weight);

            pq.add(nd);
        }

        int cnt = 0; // 연결 개수 count
        long result = 0; // 최종 결과값 sum
        while(cnt<N){
            if(pq.isEmpty()){
                System.out.println(-1);
                break;
            }

            Nd nd = pq.poll();

            if(find(nd.nowNd,idx)!= find(nd.nextNd,idx)){ // 만약 연결되어있지 않으면
                Union(nd.nowNd,nd.nextNd,idx); // 합친다
                result +=nd.weight;
                cnt++;
            }
            if (cnt==N-1) {
                System.out.println(total-result);
                break;
            }
        }



    }
    static void Union(int a, int b,int[]idx){
        a = find(a, idx);
        b = find(b, idx);

        if(a!=b) idx[b]=a;
    }
//    static int find(int a ,int[] idx){
//        if(a ==idx[a])return a;
//        else return find(idx[a], idx);
//
//    }
    static int find(int a, int[] idx) {
        if (a != idx[a]) {
            idx[a] = find(idx[a], idx); // 경로 압축
        }
        return idx[a];
}
}

class Nd{
    int nowNd;
    int nextNd;
    long weight;

    public Nd(int nowNd,int nextNd, long weight) {
        this.nowNd = nowNd;
        this.nextNd = nextNd;
        this.weight = weight;
    }

}