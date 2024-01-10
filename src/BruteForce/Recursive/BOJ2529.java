package BruteForce.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2529 {

    public static int N;
    public static char c[];
    public static boolean visited[];
    public static int arr[];
    public static ArrayList<String> ans = new ArrayList<>();

    public static void combination(int depth, String num) {
        if (depth == arr.length) {
            ans.add(num); //만들어진 수열이 오름차순으로 최댓값 최소값을 위해 저장해둔다
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            //선택할 원소가 이전 원소와 부등호식을 만족한다면 선택한다
            if (depth == 0 || isInequalitySatisfied(num.charAt(depth-1), (char)(i+'0'), c[depth-1])) {
                visited[i] = true;
                combination(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    public static boolean isInequalitySatisfied(char a, char b, char c) {
        if (c == '<')
            if (!(a < b)) return false;
        if (c == '>')
            if (!(a > b)) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        c = new char[N];
        visited = new boolean[10];
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = st.nextToken().charAt(0);
        }

        combination(0, "");
        System.out.println(ans.get(ans.size()-1)); //조건을 통과한 마지막 수열이 최대값이 된다
        System.out.println(ans.get(0)); //조건을 통과한 처음 수열이 최소값이 된다
    }
}