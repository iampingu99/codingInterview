package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Boolean[] isPrimeList = new Boolean[N+1];
        isPrimeList[1] = false;

        for(int i = 2; i <= N; i++){
            if(isPrimeList[i] == null) isPrimeList[i] = true;
            if(isPrimeList[i] == false) continue;
            for(int j = i; j<= N/i; j++){
                isPrimeList[i*j] = false;
            }
        }

        for(int i = M; i<=N; i++){
            if(isPrimeList[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
