import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840
// 모의 고사
public class pg42840 {
    public int[] solution(int[] answers) {

        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};

        int[] sum = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == answer1[i%5])  sum[0]+=1;
            if(answers[i] == answer2[i%8])  sum[1]+=1;
            if(answers[i] == answer3[i%10]) sum[2]+=1;
        }

        int top = Arrays.stream(sum).max().getAsInt();

        List<Integer> list = IntStream.range(0, sum.length)
                .filter(i -> sum[i] == top)
                .mapToObj(i -> i+1)
                .collect(Collectors.toList());

        return list.stream().mapToInt(i -> i).toArray();
    }

}
