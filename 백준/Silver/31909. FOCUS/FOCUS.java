
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());


        int[] key = new int[8];

        for (int i = 0; i < 8; i++) {
            key[i] = i;
        }

        for (int i = 0; i < t; i++) {
            int now = Integer.parseInt(st.nextToken());

            int s = 1;
            int cnt2= 0;
            int cnt3 = 0;
            int cnt = 0;
            while(true){

                double v = now-s;
                double sqrt = Math.sqrt(v);
                boolean check = true;
                if(v<0) break;
                while(v>1){
                    if(v%2==1){
                        check = false;
                        break;
                    }

                    v= v/2;
                    cnt++;
                }
                if(check){
                    int temp = key[cnt2];
                    key[cnt2] = key[cnt];
                    key[cnt] = temp;
                    break;
                }
                s = (int)Math.pow(2,++cnt3);

                cnt2++;
                cnt=0;
            }
        }
        int result= Integer.parseInt(br.readLine());
        System.out.println(key[result]);
    }
}
