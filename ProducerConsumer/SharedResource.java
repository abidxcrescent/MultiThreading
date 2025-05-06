package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    public Queue<Integer> sharedBuffer;
    public int bufferSize;

    public SharedResource(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public void produce(int i) throws InterruptedException {

        while(sharedBuffer.size()==bufferSize){
            System.out.println("Buffer full");
            wait();
        }

    }

    public void consume(){

    }

}
