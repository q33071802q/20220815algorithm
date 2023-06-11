package algorithm.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution_1_21 {
    public static void main(String[] args) {
        String str = "This is a sample string that needs to be split into chunks of 1000 characters.";
        System.out.println(subStrToList(str, 5));
    }

    /**
     * 滑动窗口计算获取结果集
     * @param str
     * @param chunkSize
     * @return
     */
    public static List<String> subStrToList(String str,int chunkSize){
        int length = str.length();
        int startIndex = 0;
        int endIndex = length-1;
        List<String> resultList = new ArrayList<>();
        int i = 0;
        while (startIndex < endIndex){
            if (i>0){
                startIndex = startIndex -chunkSize;
            }
            String temp = str.substring(startIndex,Math.min(startIndex+10,endIndex));
            startIndex+=10;
            resultList.add(temp);
            if (startIndex > endIndex){
                break;
            }
            i++;
        }
        return resultList;
    }
}
