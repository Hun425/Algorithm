import java.util.*;
import java.io.*;
public class Main {
    static int ans,result;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][]visited = new boolean[N][N];
        int[][] arr = new int[N][N];
        int[][]dx = {{-1,-1},{1,1},{-1,1},{1,-1}};//함수 내부에 선언하면 재귀로 계속 생성해서 메모리 초과
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }


        int cnt = 0;
        DFS(0,0,arr,visited,dx);
        cnt+=result;
        result = 0;
        DFS(0,1,arr,visited,dx);
        cnt+=result;

        System.out.println(cnt);

    }
    static void DFS(int y, int x,int[][]arr,boolean[][]visited , int[][]dx){
       
        result = Math.max(ans,result);

        if(x>= arr.length){
            if(x%2==0){
                x=1;
                y++;
            }else{
                x=0;
                y++;
            }

            if(y>=arr.length){
                return;
            }
        }


        if(arr[y][x]==0){//그냥 리턴이 아니라 건너뛰어야함
            DFS(y,x+2,arr,visited,dx);
            return;
        }


        if(check(y,x,arr,visited,dx)){
            visited[y][x]=true;
            ans++;
            DFS(y,x+2,arr,visited,dx);
            ans--;
            visited[y][x]=false;
        }


        DFS(y,x+2,arr,visited,dx);

    }
    static boolean check(int y, int x,int[][]arr,boolean[][]visited,int[][]dx){
       

        for (int i = 0; i < 4; i++) {
            int dely = y + dx[i][0];
            int delx = x + dx[i][1];

            while(dely>=0 && dely<arr.length && delx>=0 && delx<arr[0].length){
                if(visited[dely][delx])return false;
                dely +=dx[i][0];
                delx +=dx[i][1];
            }

        }
        return true;
    }
}