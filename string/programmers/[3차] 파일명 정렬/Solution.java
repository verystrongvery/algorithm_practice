// 1. 파일 관련 클래스 만들기
// 1.1 파일 클래스의 멤버 변수: fullName, head, numberStr, number, tail
// 1.2 파일 클래스의 정렬 기준 만들기
// 1.3 numberStr로 number를 만드는 메소드 만들기

// 2. files 반복문을 돌며 파일 관련 클래스 List 만들기
// 2.1 파일 관련 클래스 List 정렬하기
// 2.2 파일 관련 클래스 List를 정답 배열로 변환하기

import java.util.Arrays;

class FileName implements Comparable<FileName>{
    String fullName;
    String head;
    String numberStr;
    int number;

    public FileName(String file) {
        fullName = file;
        head = computeHead(file.toLowerCase());
        numberStr = computeNumberStr(file);
        number = Integer.parseInt(numberStr);
    }

    private String computeHead(String file) {
        for(int i = 0 ; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                return file.substring(0, i);
            }
        }
        return "";
    }

    private String computeNumberStr(String file) {
        int src = 0;
        int dst = 0;
        for(src = 0; src < file.length(); src++) {
            if (Character.isDigit(file.charAt(src))) {
                dst = src;
                while(++dst < file.length() && Character.isDigit(file.charAt(dst))) {

                }
                break;
            }
        }
        return file.substring(src, dst);
    }

    @Override
    public int compareTo(FileName fn) {
        if (!head.equals(fn.head)) {
            return head.compareTo(fn.head);
        }
        return Integer.compare(number, fn.number);
    }
}

class Solution {
    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .map(file -> new FileName(file))
                .sorted()
                .map(fileName -> fileName.fullName)
                .toArray(String[]::new);
    }
}