package BruteForce.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {

    public static StringBuilder sb = new StringBuilder();
    public static int L, C;
    public static char base[];
    public static char arr[];

    public static void passwd(int depth, int r, int count){
        if(depth == L){
            if(count < 1 || depth - count < 2) return; //모음이 1개 미만, 전체길이 - 2 초과인 경우 조건 미충족
            for(char c : arr){
                sb.append(c);
            }
            sb.append('\n');
            return;
        }

        for(int i = r; i < C; i++){
            arr[depth] = base[i];
            if(isVowels(base[i])) passwd(depth + 1, i + 1, count+1); //모음인 경우 count 증가
            else passwd(depth + 1, i + 1, count); //자음인 경우 유지
        }
    }

    public static boolean isVowels(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        base = new char[C];
        arr = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<C; i++){
            base[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(base);
        passwd(0, 0, 0);
        System.out.println(sb);
    }
}
