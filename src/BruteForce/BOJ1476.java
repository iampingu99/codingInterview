package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(E == 15) E = 0;
        if(M == 19) M = 0;

        for(int i = S;; i+=28){
            if(i%15 == E && i%19 == M){
                System.out.println(i);
                break;
            }
        }

//        int result = 1;
//        int i = 1;
//        int j = 1;
//        int k = 1;
//        while(true){
//            if(i == E && j == S && k == M) {
//                System.out.println(result);
//                break;
//            }
//            result++;
//            i++;
//            j++;
//            k++;
//            if(i == 16) i = 1;
//            if(j == 29) j = 1;
//            if(k == 20) k = 1;
//        }

    }
}
