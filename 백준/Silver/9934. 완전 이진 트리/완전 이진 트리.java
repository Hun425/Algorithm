
import java.util.*;
import java.io.*;
public class Main {
    static void DFS(int left, int right, int [] arr,int level,List<Integer>[] ans,int N) {
        if(level==N)return;
        int mid =(left+right)/2;

        ans[level].add(arr[mid]);

        DFS(left,mid,arr,level+1,ans,N);
        DFS(mid+1,right,arr,level+1,ans,N);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[st.countTokens()];
        List<Integer>[] ans = new List[N+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N + 1; i++) {
            ans[i] = new ArrayList<>();
        }

        DFS(0,arr.length-1,arr,0,ans,N);

        for (List<Integer> an : ans) {
            for (Integer i : an) {
                System.out.print(i+" ");
            }
            System.out.println();
        }


    }
}
