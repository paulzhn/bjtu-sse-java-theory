当`new`一个新的object时，会先完成method外attr的赋值，然后再调用构造器？

奇怪的问题：exercise2中最后输出时，Order的信息会和下一次的提示信息混在一起输出。猜想可能是buffer没处理好？

提示语句是在`strErr`中输出的，而`Order`的信息是在`stdOut`中输出的。当把两者放在同一个输出流的时候，问题就消失了。估计是因为`stdErr`中的信息比`stdOut`中少得多，因此从buffer中读取速度更快一点。

然而又有问题：这个东西应该是串行的，在没有输出完之前不应当继续向下运行。

**Solved：**疑似IDEA的bug。在powershell里跑是没有问题的。

**Notice：**对于迭代器，`while(something.iterator().hasNext())`这样的写法是错误的。每一次调用`iterator()`时，都会生成一个新的迭代器对象。因此，这样的写法会导致迭代器似乎“止步不前”。