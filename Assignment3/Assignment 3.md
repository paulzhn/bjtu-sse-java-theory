# Assignment 3:

**(total 110 points)**

## Exercise 1: Inheritance & Polymorphism

**(40 points)**

Purpose: After finishing this exercise, you will know about an interface, class inheritance, polymorphism and dynamic binding.

 Requirements:

- Please create an interface `ElectricalDevice` which has methods `turnOn()` and `turnOff()`. (10 points)

- Please create classes `AudioDevice` and `Refrigerator` which implement the interface `ElectricalDevice`. `AudioDevice` has its own methods `increaseVol`() and `decreaseVol`(). `Refrigerator` has its own method `setFreezingLevel()`. (10 points)

- Please create `AudioDevice`'s subclasses `TV` and `Radio`. `TV` has its own methods `changeChannel()` and `adjustColor()`**. **`Radio` has its own method `adjustWavelength()`. Classes `TV` and `Radio` should override the methods `increaseVol()` and `decreaseVol()` from `AudioDevice`. When overriding the two methods, use `super` to invoke the two methods first and then add the other sentences that you want. (10 points)

- Please create a class `TestElecDevice`. This class should be able to accept a command-line argument. You can run the class with different argument `TV` or `Radio`. In the class, create instance variables `ed` (which type is  `ElectricalDevice` ) and `ad` (which type is `AudioDevice` ). In the main method, assign the instance of `Refrigerator` to `ed` and then use `ed` to invoke the method `turnOn()` and `turnoff()`.  According to the argument, assign the instance of `TV` or `Radio` to `ad` and invoke the method `increaseVol()` and `decreaseVol()`. Please watch the result and make clear the methods in which class to be invoked. (10 points)

**Notice:**

- In each method of the classes, please include a statement to display a message. For example, put `System.out.println("The refrigerator is on")` in the class `Refrigerator`'s method `turnOn()`.

- You are free to add more methods in the classes.

## Exercise 2: singleton pattern & strategy pattern

**(70 points)**

### Using Design Patterns in the Gourmet Coffee System

#### Prerequisites, Goals, and Outcomes
**Prerequisites:** Before you begin this exercise, you need mastery of the following:

- _Object-oriented Programming_
  - How to define interfaces
  - How to implement interfaces

- _Design Patterns_:
  - Knowledge of the singleton pattern
  - Knowledge of the strategy pattern
**Goals:** Reinforce your ability to use the singleton and strategy patterns **Outcomes:** You will demonstrate mastery in the following:
- Producing applications that use the singleton pattern
Producing applications that use the strategy pattern
#### Background
In this assignment, you will create another version of the _Gourmet Coffee System_. This version will present the user with four choices:

```
[0] Quit
[1] Display sales (Plain Text)
[2] Display sales (HTML)
[3] Display sales (XML)
choice>
```

The user will be able to display the sales information in three formats: plain text, HTML, or XML. Part of the work has been done for you and is provided in the student archive. You will implement the code that formats the sales information. This code will use the singleton and strategy patterns.

#### Description
The following class diagram shows how the singleton and strategy pattern will be used in your implementation:



![a3-f1.png](https://i.loli.net/2019/09/11/ClMKXLnxJZfGHcd.png){:height="100%" width="100%"}







**Figure 1** _Portion of Gourmet Coffee System class diagram_

The elements of the pattern are:

- Interface `SalesFormatter` declares a method called `formatSales` that produces a string representation of the sales information.
- Class `PlainTextSalesFormatter` implements `formatSales`. Its version returns the sales information in a plain-text format.
- Class `HTMLSalesFormatter` implements `formatSales`. Its version returns the sales information in an HTML format.
- Class `XMLSalesFormatter` implements `formatSales`. Its version returns the sales information in an XML format.
- Class `GourmetCoffee` is the context class. It also contains client code. The client code calls:
  - Method `GourmetCoffee.setSalesFormatter` to change the current formatter
  - Method `GourmetCoffee.displaySales` to display the sales information using the current formatter

In this assignment, you should implement the following interface and classes:

- `SalesFormatter`
- `PlainTextSalesFormatter`
- `HTMLSalesFormatter`
- `XMLSalesFormatter`
- `GourmetCoffee` (a partial implementation is provided in the student archive)

Complete implementations of the following classes are provided in the student archive:

- `Coffee`
- `CoffeeBrewer`
- `Product`
- `Catalog`
- `OrderItem`
- `Order`
- `Sales`

##### Interface `SalesFormatter`

Interface `SalesFormatter` declares the method that every "Formatter" class will implement.

_Method:_

- `public String formatSales(Sales sales)`. Produces a string representation of the sales information.

##### Class `PlainTextSalesFormatter`
Class `PlainTextSalesFormatter` implements the interface `SalesFormatter`. This class is implemented as a singleton so a new object will not be created every time the plain-text format is used.

_Static variable:_

- _`singletonInstance`_. The single instance of class `PlainTextSalesFormatter`.

_Constructor and methods:_

- `static public PlainTextSalesFormatter getSingletonInstance()`. Static method that obtains the single instance of class `PlainTextsalesFormatter`.

- `private PlainTextSalesFormatter()`. Constructor that is declared private so it is inaccessible to other classes. A private constructor makes it impossible for any other class to create an instance of class `PlainTextSalesFormatter`.

- `public String formatSales(Sales sales)`. Produces a string that contains the specified sales information in a plain-text format. Each order in the sales information has the following format:

  ```
  ------------------------
  Order number
  	
  quantity1 code1 price1
  quantity2 code2 price2
  
  quantityN codeN priceN
  
  Total = totalCost
  ```

  - `number` is the order number.
  - `quantityX` is the quantity of the product.
  - `codeX` is the code of the product.
  - `priceX` is the price of the product.
  - `totalCost` is the total cost of the order.
  Each order should begin with a dashed line. The first order in the sales information should be given an order number of 1, the second should be given an order number of 2, and so on.
##### Class `HTMLSalesFormatter`
Class `HTMLSalesFormatter` implements the interface `SalesFormatter`. This class is implemented as a singleton so a new object will not be created every time the HTML format is `used`.

_Static variable:_

- _`singletonInstance`_. The single instance of class `HTMLSalesFormatter`.

_Constructor and methods:_

- `static public HTMLSalesFormatter getSingletonInstance()`. Static method that obtains the single instance of class `HTMLSalesFormatter`.

- `private HTMLSalesFormatter()`. Constructor that is declared private so it is inaccessible to other classes. A private constructor makes it impossible for any other class to create an instance of class `HTMLSalesFormatter`.

- `public String formatSales(Sales sales)`. Produces a string that contains the specified sales information in an HTML format.

- The string should begin with the following HTML:

    ```html
    <html>
    	<body>
    		<center><h2>Orders</h2></center>
    ```

- Each order in the sales information should begin with horizontal line, that is, an `<hr>` tag.

- Each order in the sales information should have the following format:
  
```html
  <hr>
  <h4>Total = totalCost</h4>
  	<p>
  		<b>code:</b> code1<br>
    	<b>quantity:</b> quantity1<br>
        	<b>price:</b> price1
    	</p>
    		...
    	<p>
        	<b>code:</b> codeN<br>
        	<b>quantity:</b> quantityN<br>
        	<b>price:</b> priceN
    	</p>
```

    - `quantityX` is the quantity of the product.
    - `codeX` is the code of the product.
    - `priceX` is the price of the product.
    - `totalCost` is the total cost of the order.

- The string should end with the following HTML:
  
```html
      </body>
  </html>
```


##### Class `XMLSalesFormatter`
Class `XMLSalesFormatter` implements the interface `SalesFormatter`. This class is implemented as a singleton so a new object will not be created every time the XML format is used.

_Static variable:_

- `singletonInstance`. The single instance of class `XMLSalesFormatter`.

_Constructor and methods:_

- `static public XMLSalesFormatter getSingletonInstance()`. Static method that obtains the single instance of class `XMLSalesFormatter`.

- `private XMLSalesFormatter()`. Constructor that is declared private so it is inaccessible to other classes. A private constructor makes it impossible for any other class to create an instance of class `XMLSalesFormatter`.

- `public String formatSales(Sales sales)`. Produces a string that contains the specified sales information in an XML format.

- The string should begin with the following XML:

  ```xml
  <Sales>
  ```

- Each order in the sales information should have the following format:

  ```xml
  <Order total="totalCost">
      <OrderItem quantity="quantity1" price="price1">code1</OrderItem>
      ...
      <OrderItem quantity="quantityN" price="priceN">codeN</OrderItem>
  </Order>
  ```

  - `quantityX` is the quantity of the product.
  - `codeX` is the code of the product.
  - `priceX` is the price of the product.
  - `totalCost` is the total cost of the order.

- The string should end with the following XML:

  ```
  </Sales>
  ```
#### Class `GourmetCoffee`
Class `GourmetCoffee` lets the user display the sales information in one of three formats: plain text, HTML, or XML. A partial implementation of this class is provided in the student archive.

_Instance variables:_

- `private Sales sales`. A list of the orders that have been paid for.
- `private SalesFormatter salesFormatter`. A reference variable that refers to the current formatter: a `PlainTextSalesFormatter`, `HTMLSalesFormatter`, or `XMLSalesFormatter` object.

_Constructor and methods:_

The following methods and constructor are complete and require no modification:

- `public static void main(String[] args)` throws `IOException`. Starts the application.
- `private GourmetCoffee()`. Initialize instance variables sales and `salesFormatter`.
- `private Catalog loadCatalog()`.Populates the product catalog.
- `private void loadSales(Catalog catalog)`. Populates the `sales` object.
- `private int getChoice() throws IOException`. Displays a menu of options and verifies the user's choice.

The following methods should be completed:

- `private void setSalesFormatter(SalesFormatter newFormatter)`. Changes the current formatter by updating the instance variable `salesFormatter` with the object specified in the parameter `newFormatter`.
- `private void displaySales()`. Displays the sales information in the standard output using the method `salesFormatter.formatSales` to obtain the sales information in the current format.
- `private void run() throws IOException`. Presents the user with a menu of options and executes the selected task

    - If the user chooses option 1, `run` calls method `setSalesFormatter` with the singleton instance of class `PlainTextSalesFormatter`, and calls method `displaySales` to display the sales information in the standard output.

    - If the user chooses option 2, `run` calls method `setSalesFormatter` with the singleton instance of class `HTMLSalesFormatter`, and calls method `displaySales` to display the sales information in the standard output.

  - If the user chooses option 3, `run` calls method `setSalesFormatter` with the singleton instance of class `XMLTextSalesFormatter`, and calls method displaySales to display the sales information in the standard output.

### Files
The following files are needed to complete this assignment:
- _student-files.zip_ — Download this file. This archive contains the following:
  - Class files
    - _Coffee.class_
    - _CoffeeBrewer.class_
    - _Product.class_
    - _Catalog.class_
    - _OrderItem.class_
    - _Order.class_
    - _Sales.class_
  - Documentation
    - _Coffee.html_
    - _CoffeeBrewer.html_
    - _Product.html_
    - _Catalog.html_
    - _OrderItem.html_
    - _Order.html_
    - _Sales.html_
  - _GourmetCoffee.java_. A partial implementation of the class `GourmetCoffee`.

### Tasks
Implement the interface `SalesFormatter` and the classes `PlainTextSalesFormatter`, `HTMLSalesFormatter`, `XMLSalesFormatter`. Finish the implementation of class `GourmetCoffee`. Document using Javadoc and follow Sun's code conventions. The following steps will guide you through this assignment. Work incrementally and test each increment. Save often.
1. **Extract** the *student-files.zip*
2. **Then** , implement interface `SalesFormatter` from scratch. （10 points）

1. **Next** , implement class `PlainTextSalesFormatter` from scratch.
（10 points）
1. **Then** , implement class `HTMLSalesFormatter` from scratch.  （10 points）

1. **Next** , implement class `XMLSalesFormatter` from scratch. （10 points）

1. **Then** , complete the method `GourmetCoffee.setSalesFormatter`.
（10 points）
1. **Next** , complete the method `GourmetCoffee.displaySales`. （10 points）

1. **Then** , complete the method `GourmetCoffee.run`. （10 points）

1. **Finally** , compile and execute the class `GourmetCoffee`. Sales information has been hard-coded in the `GourmetCoffee` template provided by **iCarnegie**.
  - If the user chooses to display the sales information in plain text, the output should be:

    ```
    ------------------------
    Order 1
    
    5 C001 17.99
    
    Total = 89.94999999999999
    ------------------------
    Order 2
    
    2 C002 18.75
    2 A001 9.0
    
    Total = 55.5
    ------------------------
    Order 3
    
    1 B002 200.0
    
    Total = 200.0
    ```

  - If the user chooses to display the sales information in HTML, the output should be:

    ```html
    <html>
        <body>
            <center><h2>Orders</h2></center>
            <hr>
            <h4>Total = 89.94999999999999</h4>
            <p>
                <b>code:</b> C001<br>
                <b>quantity:</b> 5<br>
                <b>price:</b> 17.99
            </p>
            <hr>
            <h4>Total = 55.5</h4>
            <p>
                <b>code:</b> C002<br>
                <b>quantity:</b> 2<br>
                <b>price:</b> 18.75
            </p>
            <p>
                <b>code:</b> A001<br>
                <b>quantity:</b> 2<br>
                <b>price:</b> 9.0
            </p>
            <hr>
            <h4>Total = 200.0</h4>
            <p>
                <b>code:</b> B002<br>
                <b>quantity:</b> 1<br>
                <b>price:</b> 200.0
            </p>
    	</body>
    </html>
    ```

  - If the user chooses to display the sales information in XML, the output should be:

    ```xml
    <Sales>
      <Order total="89.94999999999999">
        <OrderItem quantity="5" price="17.99">C001</OrderItem>
      </Order>
      <Order total="55.5">
        <OrderItem quantity="2" price="18.75">C002</OrderItem>
        <OrderItem quantity="2" price="9.0">A001</OrderItem>
      </Order>
      <Order total="200.0">
        <OrderItem quantity="1" price="200.0">B002</OrderItem>
      </Order>
    </Sales>
    
    ```

### Submission
Upon completion, submit **only** the following:
1. SalesFormatter.java，SalesFormatter.class
2. PlainTextSalesFormatter.java, PlainTextSalesFormatter.class
3. HTMLSalesFormatter.java, HTMLSalesFormatter.class
4. XMLSalesFormatter.java, XMLSalesFormatter.class
5. GourmetCoffee.java, GourmetCoffee.class
6. A word file with running results of the program.
