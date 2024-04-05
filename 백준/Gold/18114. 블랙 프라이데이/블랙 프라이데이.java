import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long goal = Integer.parseInt(st.nextToken());

        int[]arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        boolean check = false;
        for (int i = 0; i < N; i++) {
            if(arr[i]==goal) {
                check=true;
                break;
            }
        }
        Loop1:
        if(!check) {
            for (int i = 0; i < N; i++) {
                int s= i+1;
                int e = N-1;
                while(s<=e) {
                    long sum = arr[i];
                    int mid = (s+e)/2;
                    sum+=arr[mid];

                    if(sum>goal) {
                        e = mid-1;
                    }else if(sum<goal) {
                        s = mid+1;
                    }else {
                        check=true;
                        break Loop1;
                    }
                }
            }
        }
        if(!check) {
            Loop2:
            for (int i = 0; i < N-3; i++) {
                for (int j = i+1; j < N-2; j++) {
                    int s= j+1;
                    int e = N-1;
                    while(s<=e) {
                        long sum = arr[i]+arr[j];
                        int mid = (s+e)/2;
                        sum+=arr[mid];

                        if(sum>goal) {
                            e = mid-1;
                        }else if(sum<goal) {
                            s = mid+1;
                        }else {
                            check=true;
                            break Loop2;
                        }
                    }
                }
            }
        }

        if(check)System.out.println(1);
        else System.out.println(0);

    }
}