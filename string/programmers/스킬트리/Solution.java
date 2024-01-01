// 1. 해당 스킬트리가 skill에 존재하는지 확인

// 2.1 존재하는데 skill의 맨 앞글자가 아닌경우, 불가능한 스킬트리
// 2.2 존재하는데 skill의 맨 앞글자인 경우, skill의 맨 앞글자를 지우고, 다음 스킬트리 조회

// 3. 존재하지 않는 경우, 다음 스킬트리 조회

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String st : skill_trees) {
            if (isPossibleSkill(skill, st)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isPossibleSkill(String skill, String skillTree) {
        for(String st : skillTree.split("")) {
            if (!skill.contains(st)) {
                continue;
            }
            if (skill.charAt(0) != st.charAt(0)) {
                return false;
            }
            skill = skill.substring(1);
        }
        return true;
    }
}