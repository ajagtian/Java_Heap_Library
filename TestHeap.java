public class TestHeap {

	public static void main(String [] args) {

		Heap minHeap = new Heap(10);
		
		minHeap.insertElement(10);
		minHeap.insertElement(11);
		minHeap.insertElement(7);
		minHeap.insertElement(8);
		minHeap.insertElement(12);
		minHeap.insertElement(6);
		minHeap.insertElement(0);
		minHeap.insertElement(1);
		System.out.println("Heap - "+minHeap.getHeap());
		System.out.println("find min - "+minHeap.findMin());
		System.out.println("findSecondSmallest - "+minHeap.findSecondSmallest());
		System.out.println("extract min - "+minHeap.extractMin());
		System.out.println("Heap - "+minHeap.getHeap());
		System.out.println("extract min - "+minHeap.extractMin());
		System.out.println("Heap - "+minHeap.getHeap());
		System.out.println("Reduce key at 2 to -1");
		minHeap.reduceKey(2,-1);
		System.out.println("Heap - "+minHeap.getHeap());
		System.out.println("delete key 3");
		minHeap.deleteKey(3);
		System.out.println("Heap - "+minHeap.getHeap());
		System.out.println("extract min - "+minHeap.extractMin());
		System.out.println("Heap - "+minHeap.getHeap());
	}
}
