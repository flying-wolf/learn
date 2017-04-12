ArrayList学习笔记

非线程安全
继承了AbstractList
实现了List、RandomAccess、Cloneable、Serializable接口
允许null值，随机访问性能较好

arraylist的核心
	Arrays.copyOf(T[] original, int newLength)-拷贝数组
		original-要复制的数组 
		newLength-要返回的副本长度
	
	System.arraycopy(Object src,int srcPos,Object dest, int destPos,int length)-复制数组
		src-源数组
		srcPos-源数组要复制的起始位置
		dest-目标数组
		destPos-目标数组要放置的起始位置
		length-复制的长度

1.数据结构：
	arraylist底层为“elementData”的Object[]数组
	使用transient关键字修饰，使用此关键字修饰的变量的值不会包含在Serialization(序列化)的列表中

2.构造函数：
	ArrayList提供三种构造函数;
	ArrayList():默认构造函数提供一个初始容量为10的空列表;
	ArrayList(int minCapacity):构造一个具有指定初始容量的空列表;
	ArrayList(Collection<? extends E> c):构造一个包含指定Collection元素的空列表，这些元素是按照Collection迭代返回的顺序排列的;

3.新增
	ArrayList提供了add(E e),add(int index,E e)、addAll(Collection<? extends E> c)、addAll(int index,Collection<? extends E> c)、set(int index,E e)这五个方法来实现新增；
		add(E e):
			将指定元素添加到此列表的尾部，步骤如下
			1).检查扩容
			2).将指定的元素添加到列表最后
		add(int index,E e):
			将指定的元素添加到列表指定位置,步骤如下
			1).校验需要添加的索引位置是否正确 ,不正确抛出IndexOutOfBoundsException异常 
			2).扩容检测
			3).对数组进行复制(位移),从index位置开始复制长度为size-index的元素,从index+1位置开始放置,将原来index位置空出来给新元素使用
			4).将新元素放置到数组指定位置
		addAll(Collention<? extends E> c):
			将指定的collention元素添加到列表的最后,元素顺序按照collention迭代器返回的顺序放置,步骤如下
			1).将collention转换为object数组 
			2).扩容检测,扩容大小为size+numNew(源数组长度加collention数组长度)
			3).对数组进行复制从,从新数组的第一位元素开始复制长度为numNew的元素,从源数组的size(最后)位置开始放置
		addAll(int index,Collention<? extends E> c):
			将指定的collention元素添加到列表指定位置,元素顺序按照迭代器返回顺序放置,步骤如下
			1).将collention转换为object数组 
			2).扩容检测,扩容大小为size+numNew(源数组长度加collention数组长度)
			3).对数组进行复制(位移)向右偏移,从源数组的index位置开始复制长度为size-index的数组元素,从源数组的index+numNew位置开始放置
			4).对数组进行复制(添加新数组),从新数组的第一个元素位置开始复制所有元素,从源数组index位置开始放置
		set(int index,E e):
			用指定元素代替列表中指定位置的元素,步骤如下
			1).检测插入位置是否越界
			2).替换指定位置的元素
4.删除
	ArrayList提供了remove(int index)、remove(Object o)、removeRange(int fromIndex, int toIndex)三个删除方法
		remove(int index):
			移除此列表中指定位置上的元素,步骤如下
			1).检查位置是否越界
			2).取出将要移除的元素
			3).计算偏移量 size-index-1 计算出从指定元素(包含指定元素)开始到数组最后一位元素的个数
			4).对数组进行复制(左偏移)操作,从源数组的index+1位置开始复制,从源数组index位置开始放置,复制元素数量为上一部计算出的偏移量 将最后一位元素空出来
			5).置空最后一个元素
			6).返回移除的元素
		remove(Object o):
			移除首次出现在列表中的指定元素(如果存在),步骤如下
			1).判断要移除的元素是否为null,arraylist允许存放null值的
			2).循环数组查找指定的元素
			3).若找到指定元素后根据它的位置索引对数组进行复制(位移)左偏移操作,并置空数组最后一位元素
		removeRange(int formIndex,int toIndex):
			移除列表中索引在formIndex(包括)和toIndex(不包括)之间的元素
			1).对数组进行复制(偏移)
			2).置空偏移后的元素
5.查找 
	git(int index)查找此列表中指定位置的元素,return emelentData[index]
6.扩容
	ensureCapacity(int minCapacity):
		根据指定的数组最小容量扩容数组,扩容到原有容量的1.5倍加1的容量,使用Arrays的copyOf方法复制数组	
			