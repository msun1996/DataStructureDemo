/**
 * 自建数组基类
 * author: mSun
 * date: 2018/11/4
 */
public class Array<E> {

    private E[] data;
    // 元素数量
    private int size;

    /**
     * 传入容量capacity的Array
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认容量capacity的Array
     */
    public Array() {
        this(10);
    }


    /**
     * 默认传一个数组进行构造
     */
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i=0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 获取元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取容量capacity
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 查找元素是否包含value
     * @param value
     * @return
     */
    public boolean contains(E value) {
        for (int i=0; i<size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中value所在索引，存在返回索引，否则返回-1（第一个）
     * @param value
     * @return
     */
    public int find(E value) {
        for (int i=0; i<size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 向所有元素首位添加一个新元素
     * @param value
     * @throws IllegalAccessException
     */
    public void addFirst(E value) {
        add(0, value);
    }

    /**
     * 向所有元素之后追加一个新元素
     * @param value
     * @throws IllegalAccessException
     */
    public void addLast(E value) {
        add(size, value);
    }

    /**
     * 插入元素
     * @param index
     * @param value
     * @throws IllegalAccessException
     */
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<=size");
        }
        // 动态增量
        if (size == data.length) {
            resize(2*data.length);
        }
        for (int i=size; i>index; i-- ) {
            data[i] = data[i-1];
        }
        data[index] = value;
        size ++;
    }

    /**
     * 获取index索引位置元素
     * @param index
     * @return
     */
    E get(int index) {
        if (index<0 || index>=size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    /**
     * 修改index序号的元素为value
     * @param index
     * @param value
     */
    void set(int index, E value) {
        if(index<0 || index>=size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = value;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size-1);
    }

    /**
     * 删除元素,并返回删除元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index<0||index>=size) {
            throw new IllegalArgumentException("remove failed. Index is illegal");
        }
        E res = data[index];
        for (int i=index; i<size-1; i++) {
            data[i] = data[i+1];
        }
        size --;
        data[size] = null; // loitering objects != memory leak

        // 动态缩容（Lazy）
        if (size == data.length/4 && data.length/2 != 0) {
            resize( data.length/2);
        }

        return res;
    }

    /**
     * 从数组删除元素（第一个）
     * @param value
     */
    public void removeElement(E value) {
        int index = find(value);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 数组交换
     */
    public void swap(int i, int j) {
        if ( i<0 || i>=size || j<0 || j>=size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * 打印当前数组
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d , capacity=%d \n", size, data.length));
        res.append("[");
        for (int i=0; i<size; i++) {
            res.append(data[i]);
            if (i != size -1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 动态扩容
     * @param length
     */
    private void resize(int length) {
        E[] newData = (E[]) new Object[length];
        for (int i=0; i<size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
