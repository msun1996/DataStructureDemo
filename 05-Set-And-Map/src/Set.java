/**
 * 几个底层接口
 * @author: mSun
 * @date: 2018/12/22
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
