package BruteForce.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {

    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int T[], P[];
    public static int MAX_PRICE = Integer.MIN_VALUE;

    public static void recursion(int time, int price){
        //마지막날을 포함해야 하므로 N
        if(time == N){
            MAX_PRICE = Math.max(MAX_PRICE, price);
            return;
        }

        //해당일의 상담을 시작하는 경우, 넘어가는 경우
        if(time + T[time] <= N) //상담의 끝이 기간을 초과하지 않을때
            recursion(time + T[time], price + P[time]); //상담의 끝 날로 이동 + 수입더하기
        recursion(time + 1, price); //다음날로 이동 + 수입유지
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0,0);
        System.out.println(MAX_PRICE);
    }
}
