# 异常

最顶级的异常类：Throwable。

## 错误

Error，无法处理的错误，只能去修改源代码。

> 错误一般情况下我们是不会遇见的。

```java
StackOverFlowError
// 栈溢出错误
```

## 异常

最顶级的异常的父类：Exception。

### 运行期异常

在运行时抛出的异常。

| 英文                      | 中文         |
| ------------------------- | ------------ |
| NullPoinertException      | 空指针异常   |
| IndexOutOfBoundsException | 下标越界异常 |
| ArithmeticException       | 除数为0异常  |

### 编译期异常

写代码的时候出现的异常。

| 英文                  | 中文           |
| --------------------- | -------------- |
| IOException           | 输入输出异常   |
| FileNotFoundException | 文件未找到异常 |

### 处理异常

#### try...catch...finally

```java
try {
    // 有可能出现异常的代码
}catch(Exception e){
    // 出现异常时要执行的代码
    // 获取异常信息
    String message = e.getMessage();
    // 打印值栈信息
    e.printStackTrance();
} finally {
    // 无论是否出现异常一定会执行的代码
}
```

> catch的说明：
>
> 1. catch是可以有多个的
> 2. catch中捕获的异常是有顺序的，先要捕获小的，后捕获大的
> 3. catch括号中写的是一个异常对象，这个异常对象在出现相应的异常时被实例化

> finally的说明：
>
> 1. 无论是否出现异常，finally中的代码块都会执行
> 2. 一般情况下，我们写在finally中的代码都是类似释放资源的操作

#### throws

抛异常，通常是使用在方法的声明处。

```java
public void show() throws RuntimeException{
    
}
```

> throws的说明：
>
> 如果在方法的声明处用throws抛出了异常，那在方法的调用处，需要进一步处理。
>
> 进一步处理的方式：
>
> - 继续throws
> - try...catch

#### throw

人为的抛出一个异常。

```java
public void show() {
    int i = 10;
    if(i < 10) {
        throw new RuntimeException("i的值不合法");
    }
}

public void show() throws Exception {
    int i = 0;
    if(i < 10){
        throw new Exception();
    }
}
```

>1. 人为的抛出一个运行期异常，通常情况下，我们在调用方法时是不需要做进一步处理的。
>2. 如果抛出的是一个编译期异常，在方法声明处，需要进行异常的throws，在调用方法处也需要进一步处理。

### 自定义异常

我们只需要创建一个类，继承Exception或者继承RuntimeException即可。

1. 如果继承的是Exception，我们自定义的异常就是编译期异常。
2. 如果继承的是RuntimeException，我们自定义的异常就是运行期异常。

```java
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
        // 还要做好多事
    }
}
```

## 面试题

1. throw和throws的区别？

   > throw手动抛出一个异常
   >
   > throws被动抛出一个异常

2. finally和finalize的区别？

   > finally异常处理的一个结构，放在finally中的代码无论是否出现异常都会执行。
   >
   > finalize()是Object类的一个方法，垃圾回收的方法，JDK9已过时。

3. 编译期异常和运行期异常的区别？

   > 编译期异常在写代码时期抛出的异常，如果不处理，编译不通过。
   >
   > 运行期异常只要不运行，就不报错。

# 枚举

用来存储有限个数对象的类，枚举。

枚举中的对象都是静态final，枚举类中的构造器都是private。

```java
public enum Season {
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","大雪纷飞"),
    ;


    private String name;
    private String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
```

> 枚举在switch...case中的应用，在JDK5以后。

# 泛型

类型参数化。

``泛型只能是引用数据类型。``

## 泛型类

```java
public class Father<T> {
    
}
```

泛型类的泛型在实例化时确定。

> 继承泛型类时：
>
> 1. 子类不是泛型类。
> 2. 子类有自己的泛型，父类也有自己的泛型，他们之间毫无瓜葛。
> 3. 子类在继承父类时，直接继承了父类的泛型，在声明子类时，直接指定父类的泛型类型。

## 泛型方法

```java
public <E> E show(E e) {
    
}
```

泛型方法的泛型在传参数是确定。

# 常用API

## Date日期类

### Date

### SimpleDateFormat

### Instant

### LocalDate

### LocalTime

### LocalDateTime

### DateTimeFormat

## Math类

比较重要的方法：

1. ceil向上取整，返回值是double类型
2. floor向下取整，返回值是double类型
3. roune四舍五入，返回值是int、long类型
4. random随机数，生成一个0~1的随机小数

## Random类

随机类，生成一个伪随机数。

```java
Random random = new Random();
random.nextInt(5);
```

## BigDecimal

大统计类型，一般情况下在开发中，涉及金额的计算，都用这个。

比较：推荐使用compareTo方法。

```java
@Test
public void show(){
    BigDecimal bigDecimal1 = new BigDecimal("120");
    BigDecimal bigDecimal2 = new BigDecimal("120.0");
    System.out.println(bigDecimal1.equals(bigDecimal2));
    System.out.println(bigDecimal1.compareTo(bigDecimal2));
}
```

``注意：构建BigDecimal时，尽量使用new BigDecimal(String str)。``

## BigInteger

大整型。范围很大。

## StringBuffer和StringBuilder

可变的字符串。

比较重要的方法：

1`append`：追加。

`reverse`：反转。

> 三个字符串的区别：
>
> 1. String是一旦声明不可改变，StringBuffer和StringBuilder是可以改变的。
> 2. StringBuffer是JDK1.0就存在了，线程安全。
> 3. StringBuilder是JDK1.5推出，线程不安全。

## System

系统类。

比较重要的方法：

- currentTimeMills：获取当前系统的毫秒数。

- getProperty(String name)：获取系统对应的属性值。

  ```java
  System.getProperty("user.dir");
  // 获取当前所在的目录
  ```

# 多线程

## 线程的生命周期

1. 新建
2. 就绪
3. 运行
4. 阻塞
5. 死亡

## 线程创建的方式

### 继承Thread类

重写run方法，调用start方法启动线程。

### 实现Runnable接口

重写run方法，把当前的实现类包装成Thread类对象，调用start方法。

```java
new Thread(()-> {
    // run方法
}).start();
```

### 实现Callable接口

重写call方法，把当前的实现类先包装成Runnable，再包装成Thread，再调用start方法。

```java
V call() throws Exception;
```

### 线程池

开发中，基本上涉及到多线程，一定会用线程池。

但是我们不会用JDK提供的线程池（阿里规约的约定）。

我们一般会自定义线程池。

## 锁

### synchronized同步锁

|            | 同步监视器           |
| ---------- | -------------------- |
| 同步代码块 | 类对象，第三方的对象 |
| 同步方法   | this                 |

## ReentrantLock锁

Lock锁。

> Lock和synchronized的区别？
>
> Lock是手动上锁，手动解锁。
>
> synchronized全自动

## 常用方法

sleep：线程休眠。

interrupt：线程中断。

join：线程加入。

yield：释放CPU执行权。

## 线程的优先级

整型。1~10的整数。

```java
public static final int MIN_PRIORITY = 1;

/**
     * The default priority that is assigned to a thread.
     */
public static final int NORM_PRIORITY = 5;

/**
     * The maximum priority that a thread can have.
     */
public static final int MAX_PRIORITY = 10;
```

## 线程通信

wait()：线程等待

notify()：唤醒下一个正在等待的线程

notifyAll()：唤醒所有等待的线程。

> 死锁：互相拿着对方需要的资源不释放。

# 集合框架

## Collection

存放单值的最大父接口。

### List

特点：数据是按照添加的先后顺序来排序，数据是可以重复的。

#### ArrayList

内部结构是数组。有下标，而且比较适合于查询，不适合做频繁的增删。

> Vector：早期的集合类。
>
> 和ArrayList的区别：
>
> - Vector是线程安全，效率低。
> - ArrayList是线程异步，效率高。

#### LinkedList

内部结构是双向链表。查询遍历效率较低，增删的效率较高。

### Set

特点：数据没有按照添加的先后顺序来排序，数据不可以重复。

> Set集合如何来保证数据的唯一性？
>
> 通过重写hashCode和equals方法。

#### HashSet

哈希表。内部结构是HashMap。

> HashSet没有取出一个值得方法。

#### TreeSet

可以排序的set集合。

排序方式：

1. 自然排序：
   - 实现Comparable接口，重写compareTo方法。
2. 定制排序（临时排序）
   - 实现Comparator接口，重写compare方法。

## Map

存放对值的最大父接口。（K-V）

key是不能重复的。

value是可以重复的。

Map集合也是无序，不是按照添加的先后顺序来排序的。

### HashMap

内部结构：

1. JDK1.7之前：数组 + 链表
2. JDK1.8以后：数组 + 链表 + 红黑树

> 面试题：
>
> HashMap和Hashtable区别：
>
> 1. HashMap线程不安全，效率高，key值可以为null。
> 2. Hashtable线程安全，效率低，key值不可以为null。

## 循环遍历

### List

```java
// 1.for循环
for (int i = 0; i < list.size(); i++) {
    // TODO
}
// 2.增强for循环
for (String s : list) {
    // TODO
}
// 3.迭代器
Iterator<String> iterator = list.iterator();
while(iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

### Set

```java
// 1.增强for循环
for (String s : set) {
    // TODO
}

// 2.迭代器
Iterator<String> iterator = set.iterator();
while(iterator.hasNext()){
    System.out.println(iterator.next());
}
```

### Map

```java
// 1.使用keySet先拿到所有的key，再根据key获取value
Set<String> keys = map.keySet();
for (String key : keys) {
    System.out.println(key + "->" + map.get(key));
}

// 2.使用内部类Entry（推荐）
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + entry.getValue());
}
```

## Collections

操作集合的工具类。

# IO流

## File

各种方法。

> File类只能操作文件，不能操作文件的内容。

## 输入输出流

输入（读）：把磁盘上的数据读取到内存中。

输出（写）：把内存中的数据写出到磁盘上。

组织架构：

| InputStream         | OutputStream         | Reader         | Writer         |
| ------------------- | -------------------- | -------------- | -------------- |
| FileInputStream     | FileOutputStream     | FileReader     | FileWriter     |
| BufferedInputStream | BufferedOutputStream | BufferedReader | BufferedWriter |

> 注意：
>
> 字节流可以操作二进制文件->所有文件。
>
> 字符流只能操作纯文本文件。
>
> - .java
> - .py
> - .txt
> - .....

关闭流：把关闭流的操作放在finally中。

## 序列化与反序列化

- 序列化：把一个对象按照某种规则以及某个版本号保存到硬盘上的某个文件。一个对象对应一个文件。

- 反序列化：把一个文件根据某种规则以及当时序列化时使用的版本号来读取对象，读到内存中。

> 如何实现序列化操作：
>
> 1. 序列化的类要实现Serializable接口
>
> 2. 添加一个序列号
>
>    private static final long serialVersionUID = -6849794470754667710L;

# Socket通信

TCP和UDP的区别：

1. TCP是可靠的传输，在传输数据之前必须建立可靠的连接。效率低。
2. UDP是不可靠的传输，在传输数据时无需建立可靠的连接。效率高。

ip，端口号，通信协议，请求，响应，请求体，请求头，响应体，响应头，URL...

# 注解和反射

# 正则表达式

# JDK

## JDK5

1. 增强for循环
2. 枚举
3. 泛型
4. 包装器
5. 自动装箱和自动拆箱
6. Callable接口
7. switch...case可以使用枚举
8. StringBuilder

## JDK7

1. 类型推断
2. try中可以创建对象
3. switch...case支持String
4. Objects类

## JDK8

1. 函数式接口
2. 箭头函数（lambda表达式）
3. 断言
4. 接口的改变
   - 默认方法
   - 静态方法
5. HashMap内部结构（数组 + 链表 + 红黑树）
6. Stream式编程

## JDK10

1. 类型推断（定义变量可以用var）

## JDK13

​	1. 文档字符串

