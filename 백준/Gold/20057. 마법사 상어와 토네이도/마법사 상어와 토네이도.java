
import java.io.*;
import java.util.*;
public class Main {
    static int sum,N;
    static int[][]arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());//맵 크기

        arr = new int[N][N];//맵

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int y = N/2;
        int x = N/2;
        x--;//시작이동
        wind(y,x,0);//좌 0 하 1 우 2 상 3   < 반시계방향
        int del=2;
        y++;
        wind(y,x,1);
        boolean check = true;
        Loop1:
        while (true) {
            if (check) {
                for (int i = 1; i < del + 1; i++) {
                    x +=1;
                    wind(y,x,2);
                }

                for (int i = 1; i < del + 1; i++) {
                    y-=1;
                    wind(y,x,3);
                }
                check=false;
                del++;
            } else {
                for (int i = 1; i < del + 1; i++) {
                    x-=1;
                    wind(y,x,0);
                    if(y==0&&x==0)break Loop1;
                }

                for (int i = 1; i < del + 1; i++) {
                    y+=1;
                    wind(y,x,1);
                }

                del++;
                check=true;
            }

        }
        System.out.println(sum);
    }

    static void wind(int y, int x,int rot) {
        int value = arr[y][x];
        int value_10 = (int)Math.floor(value*0.1);
        int value_7 = (int)Math.floor(value*0.07);
        int value_5 = (int)Math.floor(value*0.05);
        int value_2 = (int)Math.floor(value*0.02);
        int value_1 = (int)Math.floor(value*0.01);
        int remain = value-(value_1+value_2+value_7+value_10)*2-value_5;

        if (rot == 0) {

            if(y-1<0 || x+1>=N)sum+=value_1;
            else arr[y-1][x+1]+=value_1;

            if(y-1<0)sum+=value_7;
            else arr[y-1][x]+=value_7;

            if(y-1<0 || x-1<0)sum+=value_10;
            else arr[y-1][x-1]+=value_10;

            if(y-2<0)sum+=value_2;
            else arr[y-2][x]+=value_2;


            if(y+1>=N || x+1>=N)sum+=value_1;
            else arr[y+1][x+1]+=value_1;

            if(y+1>=N)sum+=value_7;
            else arr[y+1][x]+=value_7;

            if(y+1>=N || x-1<0)sum+=value_10;
            else arr[y+1][x-1]+=value_10;

            if(y+2>=N)sum+=value_2;
            else arr[y+2][x]+=value_2;

            if(x-2<0)sum+=value_5;
            else arr[y][x-2]+=value_5;

            if(x-1<0)sum+=remain;
            else arr[y][x-1]+=remain;

        } else if (rot==1) {

            if(y-1<0 || x+1>=N)sum+=value_1;
            else arr[y-1][x+1]+=value_1;

            if(x-1<0)sum+=value_7;
            else arr[y][x-1]+=value_7;

            if(y+1>=N || x-1<0)sum+=value_10;
            else arr[y+1][x-1]+=value_10;

            if(x-2<0)sum+=value_2;
            else arr[y][x-2]+=value_2;


            if(y-1<0 || x-1<0)sum+=value_1;
            else arr[y-1][x-1]+=value_1;

            if(x+1>=N)sum+=value_7;
            else arr[y][x+1]+=value_7;

            if(y+1>=N || x+1>=N)sum+=value_10;
            else arr[y+1][x+1]+=value_10;

            if(x+2>=N)sum+=value_2;
            else arr[y][x+2]+=value_2;

            if(y+2>=N)sum+=value_5;
            else arr[y+2][x]+=value_5;

            if(y+1>=N)sum+=remain;
            else arr[y+1][x]+=remain;
        } else if (rot==2) {

            if(y-1<0 || x-1>=N)sum+=value_1;
            else arr[y-1][x-1]+=value_1;

            if(y-1<0)sum+=value_7;
            else arr[y-1][x]+=value_7;

            if(y+1>=N || x+1>=N)sum+=value_10;
            else arr[y+1][x+1]+=value_10;

            if(y-2<0)sum+=value_2;
            else arr[y-2][x]+=value_2;


            if(y+1>=N || x-1>=N)sum+=value_1;
            else arr[y+1][x-1]+=value_1;

            if(y+1>=N)sum+=value_7;
            else arr[y+1][x]+=value_7;

            if(y-1<0 || x+1>=N)sum+=value_10;
            else arr[y-1][x+1]+=value_10;

            if(y+2>=N)sum+=value_2;
            else arr[y+2][x]+=value_2;



            if(x+2>=N)sum+=value_5;
            else arr[y][x+2]+=value_5;


            if(x+1>=N)sum+=remain;
            else arr[y][x+1]+=remain;

        }else if (rot==3) {

            if(y+1>=N || x+1>=N)sum+=value_1;
            else arr[y+1][x+1]+=value_1;

            if(x-1<0)sum+=value_7;
            else arr[y][x-1]+=value_7;

            if(y-1<0 || x-1>=N)sum+=value_10;
            else arr[y-1][x-1]+=value_10;

            if(x-2<0)sum+=value_2;
            else arr[y][x-2]+=value_2;


            if(y+1>=N || x-1>=N)sum+=value_1;
            else arr[y+1][x-1]+=value_1;

            if(x+1>=N)sum+=value_7;
            else arr[y][x+1]+=value_7;

            if(y-1<0 || x+1>=N)sum+=value_10;
            else arr[y-1][x+1]+=value_10;

            if(x+2>=N)sum+=value_2;
            else arr[y][x+2]+=value_2;

            if(y-2<0)sum+=value_5;
            else arr[y-2][x]+=value_5;

            if(y-1<0)sum+=remain;
            else arr[y-1][x]+=remain;
        }

        arr[y][x] =0;
    }
}
