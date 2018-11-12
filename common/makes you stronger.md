# 集合

所谓集合，具有一些特定算法的`存储多个数据的容器`就是集合，集合是我们在编码中经常用的的东西，通常，我们的程序需要根据程序运行时才知道创建多少个对象。但若非程序运行，程序开发阶段，我们根本不知道到底需要多少个数量的对象，甚至不知道它的`准确类型`。为了满足这些常规的编程需要，我们要求能在任何时候，任何地点创建任意数量的对象，而这些对象用什么来容纳呢？我们首先想到了`数组`，但是数组只能放`统一类型`的数据，而且其`长度是固定`的，那怎么办呢？集合便应运而生了。

1. List集合

List集合代表一个`元素有序`，`可重复的集合`，集合中每个元素都有对应的顺序索引。List接口中增加了一些根据索引操作元素的方法：

``` java
    //在列表的指定位置插入该元素。
    void add(int index,E element )  

    //返回集合index索引出的元素
    Object get(int index)    

    //获取指定元素删除位置目标
    boolean remove(Object o);

    Arlist.add("你好");
	Arlist.add("你好");
	Arlist.get(0);
	Arlist.get(1);
	Arlist.remove(0);
```

使用这3个方法能简单的对一个List进行操作，知道了用法，那我们必须先知道List得怎么创建，首先要了解List的实现类有哪些：

`ArrayList`、`Vector`和`LinkedList`实现类
``` java
    List Arlist = new ArrayList();
	List Vtlist = new Vector();
    List Lklist = new LinkedList();

   
```

### 那么他们都有什么不同呢？

1. Vector、ArrayList都是以`类似数组的`形式存储在内存中，LinkedList则以`链表`的形式进行存储。

2. List中的`元素有序`、`允许有重复的元素`。

3. Vector线程`同步`，ArrayList、LinkedList线程`不同步`。

4. LinkedList适合`指定位置`插入、删除操作，不适合查找；ArrayList、Vector适合查找，不适合指定位置的插入、删除操作。

5. ArrayList在元素填满容器时会`自动扩充容器大小的50%`，而Vector则是`100%`，因此ArrayList更节省空间。


### 那么他们在插入元素时谁要快些呢？

ArrayList 和Vector是采用`数组方式存储数据`，此数组元素数大于实际存储的数据以便增加和插入元素，都允许直接序号索引元素，但是插入数据要设计到数组元素移动等内存操作，所以索引数据快插入数据慢，Vector由于使用了`synchronized`方法（`线程安全`）所以性能上比ArrayList要差，LinkedList使用双向链表实现存储，按序号索引数据需要进行向前或向后遍历，但是插入数据时只需要记录本项的前后项即可，所以插入数度较快！

### 关于List的遍历

``` java
    List<String> list = new ArrayList<String>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    //方法一，for循环遍历
    for(String attribute : list) {
     System.out.println(attribute);
    }

    //方法二，对于ArrayList来说速度比较快, 用for循环, 以size为条件遍历
    for(int i = 0 ; i < list.size() ; i++) {
        system.out.println(list.get(i));
    }

    //方法三，集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
    Iterator it = list.iterator();
    while(it.hasNext()) {
        System.ou.println(it.next);
    }   
```


2. Map集合

Map是一种从`键映射到值`的结构，存储`键值对`，其中key都是唯一的不允许重复，而值可以重复。实现Map的子类有很多，HashMap、TreeMap、LinkedMap等。

那我们来说说Map的其中两个实现类,HashMap和Hashtable。

``` java
        Map<String,String> hm = new HashMap<String,String>();
		Map<String,String> htm = new Hashtable<String,String>();

        //put想Map集合内添加值，第一个为键，第二个为值
        hm.put("1", "你好");
		hm.put("2", "我好");
        //利用创建的键获取值
		hm.get("1");
        //利用创建的键删除值
		hm.remove("2");
```

HashMap和Hashtable都是Map接口的典型实现类，它们之间的关系完全类似于Arraylist和Vecctor的关系。

### 那么他们有什么不同呢？

1. Hashtable是线程`安全`的，HashMap是线程`不安全`的，所以HashMap比Hashtable的性能高一点。

2. Hashtable`不允许使用null`作为key和value；但HashMap可以使用null作为key或value。

3. HashMap和Hashtable判断两个value相等的标准：只要两个对象通过equals方法比较返回true即可。

### Map实现类的性能分析

1. HashMap与Hashtable的效率大体相同，它们的实现机制几乎一样，HashMap线程不安全，Hashtable线程安全，所以HashMap快一点。

2. TreeMap中所有的key-value对处于有序状态，所以TreeMap比HashMap，Hashtable要慢（尤其是插入、删除），因为TreeMap底层采用红黑树来管理key-value对。

3. LinkedHashMap使用链表维护键值对，所以比HahMap慢一点。

对于一般的·应用场景，推荐使用HashMap。


### 关于Map的遍历

``` java
           // 第一种：
21         System.out.println("第一种：通过Map.keySet遍历key和value：");
22         for (Integer in : map.keySet()) {
23            
24             String str = map.get(in);//得到每个key多对用value的值
25             System.out.println(in + "     " + str);
26         }
27         // 第二种：
28         System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
29         Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
30         while (it.hasNext()) {
31              Map.Entry<Integer, String> entry = it.next();
32                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
33         }
34         // 第三种：推荐，尤其是容量大时
35         System.out.println("第三种：通过Map.entrySet遍历key和value");
36         for (Map.Entry<Integer, String> entry : map.entrySet()) {
40             System.out.println("key= " + entry.getKey() + " and value= "
41                     + entry.getValue());
42         }
43         // 第四种：
44         System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
45         for (String v : map.values()) {
46             System.out.println("value= " + v);
47         }
```
