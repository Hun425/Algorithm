import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger ans = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);
        System.out.println(ans);

        if(N<=20) Hanoi_Top(N,1,2,3);
    }

    static void Hanoi_Top(int N, int from, int temp, int to){
        if(N==1){
            System.out.println(from +" "+to);
            return;
        }



        Hanoi_Top(N-1,from,to,temp); // 자기 자신보다 작은 탑을 임시공간에 미리 이동시켜놔야함

        System.out.println(from +" "+to);

        Hanoi_Top(N-1,temp,from,to); // 임시공간에 이동한 탑들을 전부 목적지로 옮김

    }
}