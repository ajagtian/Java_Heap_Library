public class Heap {
	
	private int [] heap;
	private int size;
	private int last;

	Heap(int size) {
		this.size = size;
		heap = new int[size];
		last = -1;
	}

	public int getLast(){
		return this.last;
	}	

	public int insertElement(int ele) {
		if(last == size -1) {
			return -1;		
		}
		else{
			heap[++last] = ele;
			reHeapifyUp(last);
		}
		return 1;
	}

	private void reHeapifyUp(int source) {

		int parent = parentOf(source);
		
		if (parent == -1) {
			// node 0	
		}
		else{
			if(heap[source] < heap[parent]) {
				int temp = heap[parent];
				heap[parent] = heap[source];
				heap[source] = temp;
				reHeapifyUp(parent);
			}
		}
	}

	private int parentOf(int source) {
		return source%2==0?(source-2)/2:(source-1)/2;
	}

	public int findMin() {
		return heap[0];
	}
	public int findSecondSmallest() {
		return (heap[1]<heap[2])?heap[1]:heap[2];
	}

	public int extractMin(){
		int min = heap[0];
		heap[0] = heap[last--];
		reHeapifyDown(0);
		return min;
	}
	
	private void reHeapifyDown(int source) {
		int child1 = source*2+1;
		int child2 = source*2+2;
		int minChildKey = minOf(child1,child2);
		
		if(minChildKey == -1) {
			// no child
		}
		else{
		
			if(heap[minChildKey] < heap[source]) {
				int temp = heap[source];
				heap[source] = heap[minChildKey];
				heap[minChildKey] = temp; 
				reHeapifyDown(minChildKey);
			}
		}
	}

	private int minOf(int a, int b) {
		if(a > last || b > last) {
			return -1;
		}
		else{
			return heap[a]<heap[b]?a:b;
		}
	}

	public void reduceKey(int of, int to) {
		heap[of] = to;
		reHeapifyUp(of);
	}

	public void deleteKey(int source) {
		heap[source] = heap[last--];
		
		int parent = parentOf(source);
		int child1 = source*2+1;
		int child2 = source*2+2;
		
		if(parent!= -1 && (heap[source] < heap[parent])) {
			reHeapifyUp(source);
		}
		else {
			reHeapifyDown(source);
		}
	}

	public String getHeap(){
		String strHeap = "";
		for (int i = 0 ; i <= last ; i++) {
			strHeap = strHeap+Integer.valueOf(heap[i])+" ";
	
		}
		return strHeap;
	}
}
