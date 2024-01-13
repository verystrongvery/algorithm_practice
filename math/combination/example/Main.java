
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 2;
        int[] bucket = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        combination(arr, bucket, visited, 0, r);
    }

    static void combination(int[] arr, int[] bucket, boolean[] visited, int depth, int r) {
        if (r == 0) {
            for (int i = 0; i < depth; i++) {
                System.out.print(bucket[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || (depth != 0 && bucket[depth - 1] > arr[i])) {
                continue;
            }
            visited[i] = true;
            bucket[depth] = arr[i];
            combination(arr, bucket, visited, depth + 1, r - 1);
            visited[i] = false;
        }
    }
}
