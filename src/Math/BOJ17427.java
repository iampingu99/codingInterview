package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17427 {

    /**
     * 모든 약수를 구하여 합하는 방법
     */
    public static void useSomeOfFactors() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        for(int i = N; i>1; i--){
            sum += sumOfFactors(i);
        }
        System.out.println(sum);
    }

    public static int sumOfFactors(int number){
        int sum = 0;
        for(int i=1; i<=Math.sqrt(number); i++){
            if(number%i==0) {
                sum += i;
                if((number/i)!=i) sum += number/i;
            }
        }
        return sum;
    }

    /**
     * 배수를 이용해서 모든 약수를 구하는 방법
     */
    public static void useCountMultiples() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        for(int i = 1; i<=N; i++){
            int cnt = N/i;
            sum += cnt*i;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws IOException {
        useCountMultiples();
    }
}
