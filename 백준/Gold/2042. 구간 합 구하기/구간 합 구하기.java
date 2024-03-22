
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        segmentTree sgtree = new segmentTree();

        sgtree.setHeight(N);

        for (int i = 1; i < N+1; i++) {
            long n = Long.parseLong(br.readLine());

            sgtree.setTree(i,n);
        }



        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                sgtree.setTree((int)b, c);
            } else {
                sgtree.findTree(b,c,sb);
            }
        }
        System.out.println(sb);
    }
}
class segmentTree{
    long[]tree;
    long h;
    long startidx;



    void setHeight(int n) {
        long len = 0;
        long cnt = 0;
        while (n != 0) {
            n/=2;
            cnt++;
        }
        h = cnt;

        startidx =(int)Math.pow(2,h)-1;
        len = (int)Math.pow(2,h+1);
        tree = new long[(int)len+1];
    }

    void setTree(int idx, long num) {
        idx+=startidx;

        long dis = num-tree[idx];
        tree[idx]= num;

        while (idx > 1) {
            tree[idx/2]+=dis;
            idx/=2;
        }

    }

    void completeTree() {
        int idx = tree.length-1;

        while (idx > 1) {
            tree[idx/2]+=tree[idx];
            idx--;
        }
    }

    void findTree(long s, long e ,StringBuilder sb){

        s +=startidx;
        e +=startidx;


        long sum =0;
        while (s <= e) {
            if (s % 2 == 1) {
                sum +=tree[(int)s];
            }
            if (e % 2 == 0) {
                sum+=tree[(int)e];
            }
            s = (s+1)/2;
            e = (e-1)/2;
        }
        sb.append(sum).append("\n");
    }
}
