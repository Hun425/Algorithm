import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//사람명수
        int M = Integer.parseInt(st.nextToken());//그룹수

        int[]person = new int[N+1];//0포함 안함

        for (int i = 0; i < N + 1; i++) { //그룹화를 위한 배열 생성
            person[i] = i;
        }

        st= new StringTokenizer(br.readLine());// 진실을 아는사람
        int K = Integer.parseInt(st.nextToken());

        int[]true_person = new int[K];
        List<Integer>check = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            true_person[i] = Integer.parseInt(st.nextToken());
            check.add(true_person[i]);
        }

        for (int i = 0; i < K - 1; i++) {
            Union(true_person[i],true_person[i+1],person);
        }

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] group = new int[n];

            for (int j = 0; j < n; j++) {
                group[j] = Integer.parseInt(st.nextToken());

            }

            list.add(group);
            if(n>=2){
                for (int j = 0; j < n-1; j++) {
                    Union(group[j],group[j+1],person);
                }
            }
        }



        int cnt= 0;
        if(true_person.length==0){
            System.out.println(M);
        }
        else{

            for (int[] ints : list) {
                boolean lie = false;
                for (int anInt : ints) {
                    if(find(true_person[0],person)==find(anInt,person)){
                    lie = true;
                    break;
                }
                }
                if(lie)continue;
                else cnt++;
            }

            System.out.println(cnt);
        }

    }
    static int find(int a,int[]person){
        if(a==person[a])return a;
        else return person[a] = find(person[a],person);
    }

    static void Union(int a, int b, int[]person){
        a = find(a,person);
        b = find(b,person);

        if(a==b)return;
        else person[b]=a;
    }


}