## 数组
- 把数据码排成一排进行存放。
- 数组最大优点是快速查询；
- 数组最好索引应用于"索引有寓意"情况。
### 基础数组
**创建数组**
```
int[] arr = int[10]; 
int[] arr = int[] {0,1,2,3};
```

**遍历数组**
```
for (int i=0; i<arr.length; i++) {
    System.out.println(arr[i]);
}
for (int num:arr) {
    System.out.println(num);
}
```
> length是数组的属性：容量capacity

> E 声明泛型  
泛型数组声明方式：  
E[] data = (E[]) new Object[10];

### 简单时间复杂度分析
- O描述算法的运行时间和输入数据之间关系(简单说明)

> O(1),O(n),O(lgn),O(nlogn),O(n^2)
O(n): 时间和输入数据数量n成线性关系  
O(n^2): 时间和输入数据数量n的2次方成正比  
O(n)和O(n^2)比消耗时间大小和其中代表算式常数其实是有关系，（时间复杂度不直接等于时间消耗大小）
但时间复杂度(渐进)一般描述是n趋于无穷大，即O(n^2)的时间复杂度高于O(n)

### 分析动态数组时间复杂度
> 以下统一为O(n)(综合算法考虑最坏结果)
addLast(value) O(1)  [考虑到resize扩容情况还是O(1)系数2倍]  
addFirst(value) O(n)  
add(index, value) O(n/2)=O(n)  
* 增：O(n)
* 删：O(n)
* 改：已知索引O(1); 未知索引O(n)
* 查：已知索引O(1); 未知缩印O(n)

(Java 实现ArrayList)

