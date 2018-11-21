/**
 * 队列接口
 * author: mSun
 * date: 2018/11/14
 */
public interface Queues<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
