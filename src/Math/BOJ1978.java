package Math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {

    /**
     * 소수 구하기
     */
    public static Boolean isPrime(int number){
        if(number == 1) return false;
        for(int i = 2; i<=Math.sqrt(number); i++){
            if(number%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        while(N-->0){
            int num = Integer.parseInt(st.nextToken());
            if(isPrime(num)) count++;
        }
        System.out.println(count);
    }
}
