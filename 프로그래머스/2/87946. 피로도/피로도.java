import java.util.*;
class Solution {
    int result = 0;
    public int solution(int k, int[][] dungeons) { 
        int answer = -1;
        int len = dungeons.length;
        int[]path = new int[len];
        boolean[]visited = new boolean[len];
        DFS(0,k,dungeons,len,path,visited);
        answer = result;
        return answer;
    }
    void DFS(int level,int k, int[][] dungeons, int len,int[]path,boolean[]visited){
        if(level == len){
            int cnt = 0;
            int v = k;
            for (int i = 0; i < path.length; i++) {
                int idx = path[i];
                if(v>=dungeons[idx][0]){
                    v-=dungeons[idx][1];
                    if(v<0)break;
                    cnt++;
                }
            }
            result = Math.max(result,cnt);

            return;
        }

        for(int i =0;i<len;i++){
            if(visited[i])continue;
            path[level]=i;
            visited[i]=true;
            DFS(level+1,k,dungeons,len,path,visited);
            visited[i]=false;
        }
    }
}