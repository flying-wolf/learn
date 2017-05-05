hashcode and equals and "=="

hashCode:
是一种算法,不保证唯一,根据对象地址or字符串or数值计算产生的int类型hash码。
主要是为了提高集合的性能。
例如在集合中添加元素时,首先将放入的对象与集合中任意对象的hashCode进行比较,如果相等则调用equals方法进行内容比较


*equals和hashCode方法的通用约定：
在覆盖了equals方法的类中，也必须覆盖hashCode方法,否则违反了Object.hashCode()的通用约定会,
导致该类无法与基于散列的集合(HashMap/HashSet/HashTable)一起正常使用。

equals:
默认情况（没有被覆盖重写）下调用的是Object对象的equals方法
没有被覆盖的equals方法用于判断两个对象的引用地址是否相同
如果类中覆盖了equals方法,通常情况下是根据对象的内容判断两个对象是否相等；
例如 包装类String、Date覆盖了equals方法,判断内容是否相等

"==":
基本数据类型是比较值是否相等
引用数据类型比较的是引用地址是否相同
