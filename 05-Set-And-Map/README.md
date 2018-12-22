### 集合时间复杂度

||LinkedListSet|BSTSet|BST平均|BST最差(退化成链表)|
|------|-----|-----|-----|-----|
|增add     |O(n)|O(h)|O(log n)|O(n)|
|查contains|O(n)|O(h)|O(log n)|O(n)|
|删remove  |O(n)|O(h)|O(log n)|O(n)|
> h为树深度。满二叉树情况：n=2^h-1 即 h=O(log2 n)=O(log n)
