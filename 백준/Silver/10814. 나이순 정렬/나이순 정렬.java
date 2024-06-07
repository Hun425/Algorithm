import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력된 줄의 수를 읽어옵니다.
        int n = Integer.parseInt(br.readLine());

        // 키-값 쌍을 저장할 TreeMap을 생성합니다.
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        // 입력된 데이터를 읽어와 TreeMap에 저장합니다.
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 첫 번째 토큰은 숫자로 변환하여 키로 사용합니다.
            int num = Integer.parseInt(st.nextToken());
            // 두 번째 토큰은 문자열로 값으로 사용합니다.
            String s = st.nextToken();

            // 키가 이미 존재하면 해당 리스트에 값을 추가하고, 그렇지 않으면 새로운 리스트를 생성합니다.
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(s);
        }

        // TreeMap에 저장된 데이터를 키 값 기준으로 오름차순으로 출력합니다.
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<String> values = entry.getValue();
            for (String value : values) {
                System.out.println(key + " " + value);
            }
        }
    }
}