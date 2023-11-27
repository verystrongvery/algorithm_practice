class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skillTree : skill_trees) {
            if (isPossible(skill, skillTree)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPossible(String skill, String skillTree) {
        int i = 0;
        for(String st : skillTree.split("")) {
            if (i == skill.length()) {
                break;
            }
            String substring = skill.substring(i + 1, skill.length());
            if (substring.contains(st)) {
                return false;
            }
            if (st.charAt(0) == skill.charAt(i)) {
                i++;
            }
        }
        return true;
    }
}
