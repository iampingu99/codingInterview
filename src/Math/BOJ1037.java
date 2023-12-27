package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1037 {

    /**
     * 리스트 정렬을 사용한 방법
     */
    public static void useCollectionsSort() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> divisors = new ArrayList<>();

        for(int i = 0; i<N; i++){
            divisors.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(divisors);
        System.out.println(divisors.get(0) * divisors.get(N-1));

    }

    /**
     * 배열 정렬을 사용한 방법
     */
    public static void useArraysSort() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] divisors = new int[N];

        for(int i = 0; i<N; i++){
            divisors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(divisors);
        System.out.println(divisors[0] * divisors[N-1]);
    }

    /**
     * 정렬을 사용하지 않고 최소값 최대값을 사용하는 방법
     */
    public static void useMinMax() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-->0){
            int divisor = Integer.parseInt(st.nextToken());
            max = Math.max(divisor, max);
            min = Math.min(divisor, min);
        }

        System.out.println(min * max);
    }
    public static void main(String[] args) throws IOException {
        BOJ1037.useMinMax();
    }
}
