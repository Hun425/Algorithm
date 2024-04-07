import java.util.*;
import java.io.*;
public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//맵 크기
        int L = Integer.parseInt(st.nextToken());//경사로 최소길이

        cnt =0 ;
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        checkRight(map,L);

        System.out.println(cnt);
    }

    static void checkRight(int[][]map, int L) {



            for (int i = 0; i < map.length; i++) {
                boolean check = true;
                int[] visited =new int[map.length];
                Loop1:
                for (int j = 0; j < map.length - 1; j++) {
                    if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
                        check=false;
                        break;
                    }



                    if (map[i][j] - map[i][j + 1] < 0) {
                        int cnt = 0;
                        int idx = j ;
                        int v = map[i][j];
                        while (cnt < L) {
                            if (idx <0) {
                                check = false;
                                break Loop1;
                            }
                            if (visited[idx] == 1) {
                                check = false;
                                break Loop1;
                            }
                            if (map[i][idx] == v) {
                                visited[idx--]=1;
                                cnt++;
                            } else {
                                check=false;
                                break Loop1;
                            }

                        }
                    } else if(map[i][j]-map[i][j+1]>0) {
                        int cnt = 0;
                        int idx = j+1 ;
                        int v = map[i][j+1];
                        while (cnt < L) {
                            if (idx >= map.length) {
                                check= false;
                                break Loop1;
                            }
                            if (visited[idx] == 1) {
                                check = false;
                                break Loop1;
                            }
                            if (map[i][idx] == v) {
                                visited[idx++]=1;
                                cnt++;
                            } else {
                                check= false;
                                break Loop1;
                            }
                        }
                    }

                }
                if(check)cnt++;
        }
            for (int i = 0; i < map.length; i++) {
                boolean check = true;
                int [] visited = new int[map.length];
                Loop1:
                for (int j = 0; j < map.length-1; j++) {
                    if (Math.abs(map[j][i] - map[j + 1][i]) > 1) {
                        check = false;
                        break;
                    }


                    if (map[j][i] - map[j+1][i] < 0) {
                        int cnt = 0;
                        int idx = j ;
                        int v = map[j][i];
                        while (cnt < L) {
                            if (idx <0) {
                                check = false;
                                break Loop1;
                            }
                            if (visited[idx] == 1) {
                                check = false;
                                break Loop1;
                            }
                            if (map[idx][i] == v) {
                                visited[idx--]=1;
                                cnt++;
                            } else {
                                check = false;
                                break Loop1;
                            }

                        }
                    } else if(map[j][i]-map[j+1][i]>0) {
                        int cnt = 0;
                        int idx = j+1;
                        int v = map[j+1][i];
                        while (cnt < L) {
                            if (idx >=map.length) {
                                check=false;
                                break Loop1;
                            }

                            if (visited[idx] == 1) {
                                check = false;
                                break Loop1;
                            }
                            if (map[idx][i] == v) {
                                visited[idx++]=1;
                                cnt++;
                            } else {
                                check=false;
                                break Loop1;
                            }

                        }
                    }

                }
                if(check)cnt++;
        }
    }
}