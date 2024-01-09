package BruteForce.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15661 {

    public static int N;
    public static int ability[][];
    public static boolean visitd[];
    public static int MIN_DIFF = Integer.MAX_VALUE;

    public static void combination(int M, int depth, int r){
        if(depth == M){
            MIN_DIFF = Math.min(MIN_DIFF, calcAbilityDiff());
            return;
        }

        for(int i = r; i<N; i++){
            visitd[i] = true;
            combination(M, depth + 1, i + 1);
            visitd[i] = false;
        }
    }

    public static int calcAbilityDiff(){
        int sAbility = 0;
        int lAbility = 0;

        for(int i = 0; i<N; i++){
            for(int j = i; j<N; j++){
                if(visitd[i] && visitd[j]) sAbility += ability[i][j] + ability[j][i];
                if(!visitd[i] && !visitd[j]) lAbility += ability[i][j] + ability[j][i];
            }
        }

        return Math.abs(sAbility - lAbility);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        visitd = new boolean[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<=N/2; i++){
            combination(i, 0, 0);
        }

        System.out.println(MIN_DIFF);
    }
}
