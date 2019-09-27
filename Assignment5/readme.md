# Assignment 5

1. `StringTokenizer`的使用

   https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html

   ***建议使用String的split方法。这个类已经废弃了，保留它是因为兼容性的问题。**

2. `BufferedReader`中`readLine()`当且只当流到达EOF或流出现问题时会返回`null`，其他情况下（特别是网络编程），如果未读到换行符，会一直阻塞，直到读到为止。

3. 当使用`BufferedWriter`的`write()`时，应该显式地传入一个String（利用各个类的`toString()`），而非传入其他类型，指望它自己转换。事实上，如果传入一个int，它将会将其按照ascii码处理。

4. 读写完之后一定要调用`close()`，否则很可能出现意料之外的事情。（尤其是写，不close写不进去）

5. **coffee accessory** 咖啡用具

6. `new File(FILENAME)`不会创建新的文件，而`new FileWriter(FILENAME)`会。如果想使用`File`对象创建文件的话，可以调用方法`createNewFile()`。

7. 如果指定文件已存在，`FileWriter`将默认从头开始写起。如果希望追加在文件末尾，可以在构造的时候传入第二个参数`append`，令其为`true`。

   参见：[https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html#FileWriter(java.io.File,%20boolean)](https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html#FileWriter(java.io.File, boolean))

8. 接口中定义的属性为隐式的`public static final`.

9. `GridLayout`有个很诡异的feature：如果你初始化它是4行4列，那么，前四个添加进去的组件默认先按列排，当添加第五个时，所有组件都变成了按行排。

   eg:

   ![1.png](https://i.loli.net/2019/09/25/EakGNYI4LtQOSuC.png)

![2.png](https://i.loli.net/2019/09/25/R3cV78BoqCJgHLu.png)

