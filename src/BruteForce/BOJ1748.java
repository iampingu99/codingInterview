package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int temp = 0;
        long result = 0;
        double count = 0;
        int i;

        for(i  = 1; i < N.length(); i++){
            count = Math.pow(10, i) - Math.pow(10, i-1); //9 90 900 ...
            temp += count;
            result += count * i; //자리수 만큼 곱해서 더함
        }
        result += (Integer.parseInt(N) - temp) * i; //N - temp 만큼 마지막 자리수를 곱해서 더함

        System.out.println(result);
    }
}
