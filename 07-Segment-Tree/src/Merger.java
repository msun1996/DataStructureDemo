/**
 * 融合接口
 * @author: mSun
 * @date: 2019/1/5
 */
public interface Merger<E> {
    E merge(E a, E b);
}
