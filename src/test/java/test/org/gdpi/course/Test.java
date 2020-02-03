package test.org.gdpi.course;

import org.gdpi.course.pojo.SingleQuestion;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] array = {1,34,5,23,65,234,9,2,8};
        List<SingleQuestion> list = new ArrayList<SingleQuestion>();
        for (int i = 0; i < array.length; i++) {
            SingleQuestion singleQuestion = new SingleQuestion();
            singleQuestion.setId(i + 1);
            singleQuestion.setGrade(array[i]);
            list.add(singleQuestion);
        }
        calSum(list, 10,2);
    }

    /**
     * 遍历数组
     */
    public static void calSum(List<SingleQuestion> questions,int result,int count) {
        // 保存生成的每套试题
        List<Set<Integer>> papers = new ArrayList<>();
        for (int i = 1; i < 1 << questions.size(); i++)//从1循环到2^N
        {
            int sum=0;
            // 保存生成的一套试题 值为 题目的id
            Set<Integer> paper = new HashSet<>();
            for (int j = 0; j < questions.size(); j++)
            {
                if ((i & 1 << j) != 0)//用i与2^j进行位与运算，若结果不为0,则表示第j位不为0,从数组中取出第j个数
                {
                    sum += questions.get(j).getGrade();
                    paper.add(questions.get(j).getId());
                }
            }
            if (sum == result&&count==paper.size()) {
                papers.add(paper);
                System.out.println(paper);
            }
        }
            System.out.println(papers.size());
    }
}
