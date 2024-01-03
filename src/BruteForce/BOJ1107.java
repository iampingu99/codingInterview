package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] isBroken = new boolean[10];

        if(M>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(M-->0){
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min = Math.abs(N - 100); //현재 채널은 100번
        int i, j;

        //완전 탐색
        for(i = 0; i<1000000; i++){
            String s = String.valueOf(i); //숫자의 특정 자리에 접근하기 위해 문자열로 변환

            for(j = 0; j<s.length(); j++){ //채널의 특정 자리 숫자가 고장난 버튼인지 확인
                if(isBroken[s.charAt(j) - '0']){
                    break;
                }
            }

            if(j==s.length()){ //이동가능한 채널인 경우
                min = Math.min(Math.abs(N-i)+s.length(), min); //해당 채널로 이동 후, + 또는 -만을 사용하여 이동
            }
        }
        System.out.println(min);
    }

}