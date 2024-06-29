import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{

        int[][] arr = new int[30][30];

        for (int i = 0; i < 15; i++) {
            arr[15][i] = 1;
        }

        for (int i = 16; i < 30; i++) {
            arr[15][i] = 256;
        }

        for (int i = 0; i < 15; i++) {
            arr[i][15] = 16;
        }

        for (int i = 16; i <30 ; i++) {
            arr[i][15] = 3840;
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}