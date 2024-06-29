import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n;
        long b, c, ramen, cntB, cntC1 = 0, cntC2 = 0, ans = 0;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        if (b < c) {
            c = b;
        }
        for (int i = 0; i < n; i++) {
            ramen = Long.parseLong(st.nextToken());
            cntB = ramen - Math.min(ramen, cntC1);
            ans += (b * cntB) + (c * Math.min(ramen, cntC1));
            cntC2 = Math.min(cntC2, ramen);
            cntC1 = cntC2 + cntB;
            cntC2 = cntB;
        }

        System.out.println(ans);

 
    }
}