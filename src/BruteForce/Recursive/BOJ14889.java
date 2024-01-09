package BruteForce.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {

    public static int N;
    public static int matrix[][];
    public static boolean visited[];
    public static int MIN_DIFF = Integer.MAX_VALUE;

    public static void combination(int depth, int r) {
        if (depth == N/2) {
            MIN_DIFF = Math.min(MIN_DIFF, teamAbility());
            return;
        }

        for (int i = r; i < N; i++) {
            visited[i] = true;
            combination(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static int teamAbility(){
        int sAbility = 0;
        int lAbility = 0;

        for(int i = 0; i<N; i++){
            for(int j = i; j<N; j++){
                if(visited[i] && visited[j]) sAbility += matrix[i][j] + matrix[j][i];
                if(!visited[i] && !visited[j]) lAbility += matrix[i][j] + matrix[j][i];
            }
        }

        return Math.abs((sAbility - lAbility));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(MIN_DIFF);
    }
}
