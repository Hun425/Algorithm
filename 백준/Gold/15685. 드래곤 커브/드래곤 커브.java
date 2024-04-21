import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        boolean [][] arr = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int rot = Integer.parseInt(st.nextToken());//0==x++, 1==y--, 2==x--, 3==y++
            int gen = Integer.parseInt(st.nextToken());
            DragonCurve(y,x,rot,gen,arr);
        }


        int ans = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[i][j] && arr[i][j+1] && arr[i+1][j] && arr[i+1][j+1])ans++;
            }
        }

        System.out.println(ans);
    }
    static void DragonCurve(int y,int x, int rot, int gen,boolean[][]arr){
        int cnt =0;
        List<Integer> cdn = new ArrayList<>();
        cdn.add(rot);


        while(cnt<gen){
            for (int i = cdn.size()-1; i >=0 ; i--) {
                int now_rot = cdn.get(i)+1;
                cdn.add(now_rot%4);
            }
            cnt++;
        }

        arr[y][x]=true;
        //0==x++, 1==y--, 2==x--, 3==y++
        for (int i = 0; i < cdn.size(); i++) {
            if(cdn.get(i)==0){
                arr[y][++x]=true;
            } else if (cdn.get(i) == 1) {
                arr[--y][x]=true;
            } else if (cdn.get(i)==2) {
                arr[y][--x]=true;
            }else{
                arr[++y][x]=true;
            }
        }
    }
}