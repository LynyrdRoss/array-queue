/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
* DESCRIPTION: 
*
* A QUEUE is an ADT (abstract data type) in FIFO order (first in, first out).
* It has 2 main operations: (1) ENQUEUE or adding on the tail/back, and (2) DEQUEUE or removing on the head/front.
* It is a protected SINGLY LINKED LIST where enqueue and dequeue are only allowed on the top front or last element in the queue.
* Implementation can either be in ARRAY or LINKED LIST.
* It's algorithmic complexity is CONSTANT or O(1) for both ends (enqueue, dequeue).
*
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
* TODO: 
* 
* Implement a QUEUE using ARRAY that can hold a maximum of 10 integers.
* Create operations ENQUEUE and DEQUEUE
* Allow ENQUEUE only if the queue is not yet full.
* Allow DEQUEUE only if the queue is not yet empty.
* Upon DEQUEUE, shift the element's position accordingly.
* Allow PEEK to see the topmost topmost element.
* Show the updated ARRAY QUEUE for every successful ENQUEUE and DEQUEUE.
*
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
* PSEUDOCODE:
* 
* START PROGRAM
* 
*  SET capacity, head, tail, storage[]
* 
*  PROCEDURE show
*   FOR EACH element IN queue.capacity
*    PRINT queue[element]
* 
*  PROCEDURE isEmpty
*   IF queue[0] == null
*    PRINT queue is empty
*    return TRUE
*
*  PROCEDURE isFull
*  IF head == capacity
*    PRINT queue is full
*    return TRUE
* 
*  PROCEDURE enqueue
*   IF isFull
*    PRINT add failed. element did not enqueue.
*   ELSE
*     Queue temp = new Queue(element)
*     tail.next = temp
*     tail = temp
* 
*  PROCEDURE dequeue
*   IF isEmpty
*    PRINT remove failed. no element to dequeue.
*   ELSE
*    temp = head
*    head = head.next
*    remove temp
*   
*  PROCEDURE peek
*   IF isEmpty
*    PRINT 0
*   ELSE 
*    PRINT head.data
* 
*  PROCEDURE main
*  show that queue is empty
*  enqueue 10 integers until queue is full
*  show updated queue
*  try to enqueue again, return error message
*  dequeue last element
*  peek last element
*  dequeue all elements until queue is empty
*  show updated queue
*  try to dequeue again, return error message
* 
* END PROGRAM 
* 
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
* SOURCE CODE: ArrayQueue.java
* AUTHOR NAME: Lynyrd Ross Alquiroz
* GITHUB URL: https://github.com/LynyrdRoss/RossRepository
* LAST UPDATE: 08/18/2016
*
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*/

class ArrayQueue {

	private int capacity;
	private int index = 0;
	private String [] arr;

	public ArrayQueue(int size) {
		capacity = size;
		arr = new String[capacity];		
	}

	public void show() {
		System.out.println("Current Stack Element: ");
		for (int x = 0; x <= capacity - 1; x++) {
			System.out.println("Queue[" + x + "] = " + arr[x]);
		}

		System.out.println("");
	}

	private boolean isEmpty() {
		if (arr[0] == null) {
			System.out.println("Attempting to remove an element.");
			System.out.println("");
			return true;			
		} else {
			return false;
		}
	}

	private boolean isFull() {
		if (index == capacity) {
			System.out.println("Attempting to add an element.");
			return true;
		} else {
			return false;
		}
	}

	public void enqueue(String val) {
		if (isFull()) {
			System.out.println("Add failed. Array currently full.");
			System.out.println("");
		} else {
			System.out.println("Executing Enqueue on queue[" + index + "]. . .");
			arr[index] = val;
			index++;
			System.out.println(val + " was added successfully.");
			System.out.println("");
		}

		show();
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Remove failed. Array currently empty.");
			System.out.println("");
		} else {
			System.out.println("Executing Dequeue on queue[0]. . .");
			System.out.println("Element " + arr[0] + " was removed successfully.");
			System.out.println("");
			if (index- 1 == capacity - 1) {
				for (int i = 0; i <= index - 2; i++) {
					arr[i] = arr[i+1];
				}
				arr[capacity-1] = null;				
			} else {
				for (int i = 0; i <= index - 1; i++) {
					arr[i] = arr[i+1];
				}
			}
			index--;
		}

		show();
	}

	public void peek() {
		if (arr[index-1] == arr[0]) {
			System.out.println("Peek top = " + arr[index]);
			System.out.println("");
		} else {
			System.out.println("Peek top = " + arr[index-1]);
			System.out.println("");
		}
	}

	public static void main(String [] args) {

		ArrayQueue arrObj = new ArrayQueue(6);
		System.out.println("");
		System.out.println("Storage capacity = " + arrObj.capacity);
		System.out.println("");

		arrObj.enqueue("firstinput");
		arrObj.enqueue("secondinput");
		arrObj.enqueue("thirdinput");
		arrObj.enqueue("fourthinput");
		arrObj.enqueue("fifthinput");
		arrObj.enqueue("sixthinput");
		arrObj.dequeue();
		arrObj.dequeue();

		arrObj.peek();
	}
}