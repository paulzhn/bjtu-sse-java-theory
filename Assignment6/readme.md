# Assignment 6

1. `getValueIsAdjusting()`

   举个栗子，在一个list中，当你使用鼠标选中其中的某个元素的时候，事实上激发的是两个事件：`mouseDown`和`mouseUp`；因此，在listener中的代码，会在鼠标抬起和放下的时候均执行一次。为了避免这种情况，jdk里就搞了这个函数。

   它的功能是和另一个函数`setValueIsAdjusting()`一起实现的。这个东西的功能是，如果因为某个动作激发了一系列事件，那么，当且仅当最后一个事件结束时，`setValueIsAdjusting()`才会将`valueIsAdjusting`这个值设成`false`，在这一系列中的其他事件执行时，这个值都是`true`。

   感觉不说人话是不是？我们还是用上面那个栗子。

   假如原来一个`ListSelectionListener`的实现是这样的：

   ```java
   public void valueChanged(ListSelectionEvent event) {
   	System.out.println("The event invoked")
   }
   ```

   那么，如果随便选择list里的一个项目，输出是这样的：

   ```
   The event invoked
   The event invoked
   ```

   原因上面已经解释过了，鼠标点击一次激发的是两个事件。那如果我把代码改成这样：

   ```java
   public void valueChanged(ListSelectionEvent event) {
   	if (!catalogList.getValueIsAdjusting()) {
   		System.out.println("The event invoked")
   	}
   }
   ```

   输出就变成了：

   ```
   The event invoked
   ```

   再讲的详细一点，鼠标按下时激发了`mouseDown`，然而jdk很聪明，知道你之后肯定还有一个抬起鼠标的事件，就把list的属性`valueIsAdjusting`设成了`true`。而当你的鼠标放开时，激发了`mouseUp`，而这就是“这一系列事件”的结束了，此时，`valueIsAdjusting`被设成了`false`，我们listener里的代码就可以愉快地执行了。

   ref:

   - https://docs.oracle.com/javase/6/docs/api/javax/swing/ListSelectionModel.html#setValueIsAdjusting(boolean)
   - https://stackoverflow.com/questions/10860419/what-exactly-does-getvalueisadjusting-do

2. `class.this`仅用在有`nested class`时指代`outer class`的`instance` 。

   ref:

   - https://stackoverflow.com/questions/5666134/what-is-the-difference-between-class-this-and-this-in-java

3. 