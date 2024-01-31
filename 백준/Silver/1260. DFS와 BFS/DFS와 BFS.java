import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static void DFS(int x) {

        if(check[x]){
            return;
        }
        System.out.print(x+" ");
        check[x]= true;
        for ( int i: arr[x]) {

            if(!check[i]){

                DFS(i);
            }
        }
    }
    static void BFS(int x){
        que.add(x);
        check[x]= true;


        while (!que.isEmpty()) {
            int a = que.poll();
            check[a] =true;
            System.out.print(a+" ");

            for (int k : arr[a]) {
                if(!check[k]) {
                    que.add(k);
                    check[k]=true;
                }
            }
        }


    }

    static Queue<Integer> que ;
    static int cnt;
    static boolean [] check;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // Arraylist 그래프 생성 후 초기화
        arr = new ArrayList [C+1];
        for (int i = 0; i < C + 1; i++) {
            arr[i] =new ArrayList<>();
        }
        // 방문 체크 배열 생성 후 초기화
        check = new boolean[C+1];
        for (int i = 0; i < C + 1; i++) {
            check[i]=false;
        }


        // 그래프 arr 에 간선 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향 간선 추가
            arr[x].add(y);
            arr[y].add(x);

        }
        // 인접리스트 그래프는 들어온 순서대로 탐색하므로 정렬이 필요함
        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        DFS(V);

        System.out.println();



        // BFS 계산을 위한 방문배열 초기화

        for (int i = 0; i < C + 1; i++) {
            check[i]=false;
        }

        // que 생성 및 초기화

        que = new ArrayDeque<>();

        BFS(V);
//        for (ArrayList<Integer> integers : arr) {
//            for (Integer integer : integers) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }
    }
}