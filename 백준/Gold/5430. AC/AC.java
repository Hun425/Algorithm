import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String method = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            arr = arr.substring(1, arr.length() - 1);

            Deque<String> deque = new LinkedList<>(Arrays.asList(arr.split(",")));
            boolean rot = false;
            boolean isError = false;

            for (char cmd : method.toCharArray()) {
                if (cmd == 'R') {
                    rot = !rot;
                } else {
                    if (deque.isEmpty() || deque.peek().equals("")) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (rot) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (!isError) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (rot) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}