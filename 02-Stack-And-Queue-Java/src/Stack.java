/**
 * 栈
 * author: mSun
 * date: 2018/11/8
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
