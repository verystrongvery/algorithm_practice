import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Person implements Comparable<Person>{
    int score1;
    int score2;

    public Person(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public int compareTo(Person p) {
        if (score1 != p.score1) {
            return Integer.compare(p.score1, score1);
        }
        return Integer.compare(p.score2, score2);
    }
}

class Solution {
    public int solution(int[][] scores) {
        Person[] people = new Person[scores.length];
        for(int i = 0; i < scores.length; i++) {
            people[i] = new Person(scores[i][0], scores[i][1]);
        }
        Arrays.sort(people);
        List<Person> bucket = new ArrayList<>();
        bucket.add(people[0]);
        for(Person p : people) {
            boolean isInsentive = true;
            if (p.score2 > bucket.get(bucket.size() - 1).score2) {
                bucket.add(p);
                continue;
            }
            if (bucket.get(bucket.size() - 1).score1 == p.score1) {
                if (bucket.size() == 1) {
                    continue;
                }
                if (bucket.get(bucket.size() - 2).score2 > p.score2) {
                    isInsentive = false;
                }
            }
            else if (bucket.get(bucket.size() - 1).score2 > p.score2) {
                isInsentive = false;
            }
            if (!isInsentive) {
                if (scores[0][0] == p.score1 && scores[0][1] == p.score2) {
                    return -1;
                }
                p.score1 = -1;
                p.score2 = -1;
            }
        }
        int answer = 1;
        int sum = scores[0][0] + scores[0][1];
        for(Person p : people) {
            if (sum < p.score1 + p.score2) {
                answer++;
            }
        }
        return answer;
    }
}
