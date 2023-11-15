### BFS
1. Breath First Search
- 그래프에서 너비 부분을 우선적으로 탐색하는 알고리즘
- 큐로 구현

2. BFS 시간복잡도
- 정점의수: N, 간선의 수: E
- 인접 리스트로 표현된 그래프의 시간복잡도: O(N + E)
- 인접 행렬로 표현된 그래프의 시간복잡도:O(N^2)
- 따라서 DFS 사용시, 인접리스트를 사용하는것이 유리함

3. 언제 BFS를 사용?
- 모든 정점을 방문해야 할때
- 최단거리를 구해야할 때

### DFS 
1. Depth First Search
- 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
- 스택 또는 재귀 함수로 구현

2. DFS 시간복잡도
- 정점의수: N, 간선의 수: E
- 인접 리스트로 표현된 그래프의 시간복잡도: O(N + E)
- 인접 행렬로 표현된 그래프의 시간복잡도:O(N^2)
- 따라서 DFS 사용시, 인접리스트를 사용하는것이 유리함

3. 언제 DFS를 사용?
- 모든 정점을 방문해야 할때
- 경로의 특징을 저장해야 할때