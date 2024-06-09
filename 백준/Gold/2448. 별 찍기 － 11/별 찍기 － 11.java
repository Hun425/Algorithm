import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int size = (int)Math.pow(2,N)*3;
        String[][] arr = new String[N][N*2];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], " ");
        }
        makeStar(N,0,N,arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                bw.write(arr[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void makeStar(int h,int y, int x,String[][]arr){
        if(h<3)return;
        if(h==3){
            printStar(h, y, x,arr);
        }
        makeStar(h/2,y,x,arr);
        makeStar(h/2,y+h/2,x+h/2,arr);
        makeStar(h/2,y+h/2,x-h/2,arr);
    }

    static void printStar(int h, int y, int x,String[][]arr){
        arr[y][x] ="*";
        arr[y+1][x-1]="*";
        arr[y+1][x+1]="*";
        for (int i = 0; i < 5; i++) {
            arr[y+2][x-2+i]="*";
        }
    }
}