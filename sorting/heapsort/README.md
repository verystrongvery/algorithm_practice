### Heap Sort
- 우선순위 큐 구현을 위한 정렬
- 최솟값 또는 최댓값을 쉽게 구할 수 있음
- Unstable Sort
- In Place Sort

### Heap Sort 과정(오름 차순)
1. 정렬해야 할 n개의 요소들로 최소 힙을 만듬
2. 최소힙에서 요소를 하나씩 꺼내어 배열의 앞에서 부터 저장

### Heap Sort 장점과 단점
- 장점: 시간복잡도가 낮음
- 단점: 구현이 어려움

### Heap Sort 시간 복잡도
- 힙 트리의 전체 높이: log n
- n개의 요소 삽입: O(n log n)
- n개의 요소 삭제: O(n log n)
- Heap Sort 시간 복잡도: O(n log n)
