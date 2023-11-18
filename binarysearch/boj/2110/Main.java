import java.io.*;
import java.util.*;
class Main{
    private static int n, c;
    private static int[] router;
    public static void main(String[] args) throws Exception {
        init();
        int output = binarySearch();
        System.out.println(output);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        router = new int[n];
        for (int i = 0; i < n; i++) {
            router[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(router);
    }

    private static int binarySearch() {
        int low = 1;
        int high = router[n - 1] + 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if (countInstallableRouter(mid) < c) {
                high = mid;
                continue;
            }
            low = mid + 1;
        }
        return low - 1;
    }

    private static int countInstallableRouter(int distance) {
        int count = 1;
        int installedRouterPosition = router[0];
        for(int i = 1; i < router.length; i++) {
            if (router[i] - installedRouterPosition < distance) {
                continue;
            }
            count++;
            installedRouterPosition = router[i];
        }
        return count;
    }
}
