import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private LinkedList<Integer> queue;
    MyQueue(){
        queue = new LinkedList<>();
    }
    void enqueue(int element){
        queue.addLast(element);

    }
    int dequeue (){
        return queue.poll();
    }
    int first(){
        return queue.peek();
    }
}
