
class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] bucket = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        permutation(arr, bucket, visited, 0);
    }

    private static void permutation(int[] arr, int[] bucket, boolean[] visited, int depth) {
        if (depth == arr.length) {
            for (int i = 0; i < bucket.length; i++) {
                System.out.print(bucket[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            bucket[depth] = arr[i];
            permutation(arr, bucket, visited, depth + 1);
            visited[i] = false;
        }
    }
}
