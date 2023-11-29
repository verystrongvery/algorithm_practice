class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int src = 1;
        for(int station : stations) {
            int installRangeSize = station - w - src;
            if (installRangeSize > 0) {
                answer += computeInstallCount(installRangeSize, w);
            }
            src = station + w + 1;
        }
        if (src <= n) {
            int installRangeSize = n - src + 1;
            answer += computeInstallCount(installRangeSize, w);
        }
        return answer;
    }

    private int computeInstallCount(int installRangeSize, int w) {
        if (installRangeSize % (2 * w + 1) == 0) {
            return installRangeSize / (2 * w + 1);
        }
        return installRangeSize / (2 * w + 1) + 1;
    }
}
