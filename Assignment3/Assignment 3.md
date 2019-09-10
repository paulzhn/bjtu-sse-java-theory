---
typora-root-url: ..\assets
typora-copy-images-to: ..\assets
---

# Assignment 3:

(total 110 points)

### Exercise 1 Inheritance &amp;Polymorphism(40 points)

Purpose: After finishing this exercise, you will know about an interface, class inheritance, polymorphism and dynamic binding.

 Requirements:

- Please create an interface **ElectricalDevice** which has methods **turnOn()** and **turnOff().** (10 points)

- Please create classes **AudioDevice** and **Refrigerator** which implement the interface **ElectricalDevice**. **AudioDevice** has its own methods **increaseVol()** and **decreaseVol()**. **Refrigerator** has its own method **setFreezingLevel()**.

(10 points)

- Please create **AudioDevice**&#39;s subclasses **TV** and **Radio**. **TV** has its own methods **changeChannel()** and ** adjustColor()**. **Radio** has its own method **adjustWavelength()**. Classes **TV** and **Radio** should override the methods **increaseVol()** and **decreaseVol()** from **AudioDevice**. When overriding the two methods, use **super** to invoke the two methods first and then add the other sentences that you want. (10 points)

- Please create a class **TestElecDevice**. This class should be able to accept a command-line argument. You can run the class with different argument **TV** or **Radio**. In the class, create instance variables **ed** (which type is   **ElectricalDevice** ) and **ad** (which type is **AudioDevice** ). In the main method, assign the instance of **Refrigerator** to **ed** and then use **ed** to invoke the method **turnOn()** and **turnoff().**  According to the argument, assign the instance of **TV** or **Radio** to **ad** and invoke the method **increaseVol()** and **decreaseVol()**. Please watch the result and make clear the methods in which class to be invoked.

(10 points)



**Notice:**

- In each method of the classes, please include a statement to display a message. For example, put **System.out.println(&quot;The refrigerator is on&quot;)** in the class **Refrigerator**&#39;s method **turnOn()**.

- You are free to add more methods in the classes.

### Exercise 2 singleton pattern &amp;strategy pattern

**(70 points)**

|   |
## Using Design Patterns in the Gourmet Coffee System

### Prerequisites, Goals, and Outcomes
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
### Background
In this assignment, you will create another version of the _Gourmet Coffee System_. This version will present the user with four choices:[0] Quit
[1] Display sales (Plain Text)
[2] Display sales (HTML)
[3] Display sales (XML)
choice\&gt;The user will be able to display the sales information in three formats: plain text, HTML, or XML. Part of the work has been done for you and is provided in the student archive. You will implement the code that formats the sales information. This code will use the singleton and strategy patterns.

### Description
The following class diagram shows how the singleton and strategy pattern will be used in your implementation:

![1568132094691](/a3-f1.png)

**Figure 1** _Portion of Gourmet Coffee System class diagram_ 

The elements of the pattern are:
- Interface SalesFormatter declares a method called formatSales that produces a string representation of the sales information.
- Class PlainTextSalesFormatter implements formatSales. Its version returns the sales information in a plain-text format.
- Class HTMLSalesFormatter implements formatSales. Its version returns the sales information in an HTML format.
- Class XMLSalesFormatter implements formatSales. Its version returns the sales information in an XML format.
- Class GourmetCoffee is the context class. It also contains client code. The client code calls:
  - Method GourmetCoffee.setSalesFormatter to change the current formatter
  - Method GourmetCoffee.displaySales to display the sales information using the current formatter
In this assignment, you should implement the following interface and classes:
- SalesFormatter
- PlainTextSalesFormatter
- HTMLSalesFormatter
- XMLSalesFormatter
- GourmetCoffee (a partial implementation is provided in the student archive)
Complete implementations of the following classes are provided in the student archive:
- Coffee
- CoffeeBrewer
- Product
- Catalog
- OrderItem
- Order
- Sales

#### Interface SalesFormatter
Interface SalesFormatter declares the method that every &quot;Formatter&quot; class will implement._Method:_
- _public String formatSales(Sales sales)_. Produces a string representation of the sales information.

#### Class PlainTextSalesFormatter
Class PlainTextSalesFormatter implements the interface SalesFormatter. This class is implemented as a singleton so a new object will not be created every time the plain-text format is used._Static variable:_
- _singletonInstance_. The single instance of class PlainTextSalesFormatter.
_Constructor and methods:_
- _static public PlainTextSalesFormatter getSingletonInstance()_. Static method that obtains the single instance of class PlainTextsalesFormatter.

- _private PlainTextSalesFormatter()_. Constructor that is declared private so it is inaccessible to other classes. A private constructor makes it impossible for any other class to create an instance of class PlainTextSalesFormatter.

- _public String formatSales(Sales sales)_. Produces a string that contains the specified sales information in a plain-text format. Each order in the sales information has the following format:
- ------------------------
- Order _number_
-
- _quantity1 __code1__ price1_
- _quantity2 __code2__ price2_
- ...
- _quantityN __codeN__ priceN_
-
Total = _totalCost_where
-
  - _number_ is the order number.
  - _quantityX_ is the quantity of the product.
  - _codeX_ is the code of the product.
  - _priceX_ is the price of the product.
  - _totalCost_ is the total cost of the order.
Each order should begin with a dashed line. The first order in the sales information should be given an order number of 1, the second should be given an order number of 2, and so on.
#### Class HTMLSalesFormatter
Class HTMLSalesFormatter implements the interface SalesFormatter. This class is implemented as a singleton so a new object will not be created every time the HTML format is used._Static variable:_
- _singletonInstance_. The single instance of class HTMLSalesFormatter.
_Constructor and methods:_
- _static public HTMLSalesFormatter getSingletonInstance()_. Static method that obtains the single instance of class HTMLSalesFormatter.

- _private HTMLSalesFormatter()_. Constructor that is declared private so it is inaccessible to other classes. A private constructor makes it impossible for any other class to create an instance of class HTMLSalesFormatter.

- _public String formatSales(Sales sales)_. Produces a string that contains the specified sales information in an HTML format.

- The string should begin with the following HTML:
- \&lt;html\&gt;
-   \&lt;body\&gt;
    \&lt;center\&gt;\&lt;h2\&gt;Orders\&lt;/h2\&gt;\&lt;/center\&gt;
- Each order in the sales information should begin with horizontal line, that is, an \&lt;hr\&gt; tag.
- Each order in the sales information should have the following format:
    \&lt;hr\&gt;    \&lt;h4\&gt;Total = _totalCost_\&lt;/h4\&gt;      \&lt;p\&gt;        \&lt;b\&gt;code:\&lt;/b\&gt; _code_1\&lt;br\&gt;        \&lt;b\&gt;quantity:\&lt;/b\&gt; _quantity_1\&lt;br\&gt;        \&lt;b\&gt;price:\&lt;/b\&gt; _price_1     \&lt;/p\&gt;         ...     \&lt;p\&gt;        \&lt;b\&gt;code:\&lt;/b\&gt; _codeN_\&lt;br\&gt;        \&lt;b\&gt;quantity:\&lt;/b\&gt; _quantityN_\&lt;br\&gt;        \&lt;b\&gt;price:\&lt;/b\&gt; _priceN_     \&lt;/p\&gt;where:
-
  - _quantityX_ is the quantity of the product.
  - _codeX_ is the code of the product.
  - _priceX_ is the price of the product.
  - _totalCost_ is the total cost of the order.

- The string should end with the following HTML:
  \&lt;/body\&gt;
\&lt;/html\&gt;
#### Class XMLSalesFormatter
Class XMLSalesFormatter implements the interface SalesFormatter. This class is implemented as a singleton so a new object will not be created every time the XML format is used._Static variable:_
- _singletonInstance_. The single instance of class XMLSalesFormatter.
_Constructor and methods:_
- _static public XMLSalesFormatter getSingletonInstance()_. Static method that obtains the single instance of class XMLSalesFormatter.

- _private XMLSalesFormatter()_. Constructor that is declared private so it is inaccessible to other classes. A private constructor makes it impossible for any other class to create an instance of class XMLSalesFormatter.

- _public String formatSales(Sales sales)_. Produces a string that contains the specified sales information in an XML format.

- The string should begin with the following XML:
\&lt;Sales\&gt;
- Each order in the sales information should have the following format:
-   \&lt;Order total=&quot;_totalCost_&quot;\&gt;
    \&lt;OrderItem quantity=&quot;_quantity1_&quot; price=&quot;_price1_&quot;\&gt;_code1_\&lt;/OrderItem\&gt;
    ...
    \&lt;OrderItem quantity=&quot;_quantityN_&quot; price=&quot;_priceN_&quot;\&gt;_codeN_\&lt;/OrderItem\&gt;
  \&lt;/Order\&gt;where:
-
  - _quantityX_ is the quantity of the product.
  - _codeX_ is the code of the product.
  - _priceX_ is the price of the product.
  - _totalCost_ is the total cost of the order.

- The string should end with the following XML:
\&lt;/Sales\&gt;
#### Class GourmetCoffee
Class GourmetCoffee lets the user display the sales information in one of three formats: plain text, HTML, or XML. A partial implementation of this class is provided in the student archive. _Instance variables:_
- _private Sales sales_. A list of the orders that have been paid for.

- _private SalesFormatter salesFormatter_. A reference variable that refers to the current formatter: a PlainTextSalesFormatter, HTMLSalesFormatter, or XMLSalesFormatter object.
_Constructor and methods:_The following methods and constructor are complete and require no modification:
- _public static void main(String[] args) throws IOException_. Starts the application.

- _private GourmetCoffee()_. Initialize instance variables sales and salesFormatter.

- _private Catalog loadCatalog()_.Populates the product catalog.

- _private void loadSales(Catalog catalog)_. Populates the sales object.

- _private int getChoice() throws IOException_. Displays a menu of options and verifies the user&#39;s choice.
The following methods should be completed:
- _private void setSalesFormatter(SalesFormatter newFormatter)_. Changes the current formatter by updating the instance variable salesFormatter with the object specified in the parameter newFormatter.

- _private void displaySales()_. Displays the sales information in the standard output using the method salesFormatter.formatSales to obtain the sales information in the current format.

- _private void run() throws IOException_. Presents the user with a menu of options and executes the selected task

-
  - If the user chooses option 1, run calls method setSalesFormatter with the singleton instance of class PlainTextSalesFormatter, and calls method displaySales to display the sales information in the standard output.

-
  - If the user chooses option 2, run calls method setSalesFormatter with the singleton instance of class HTMLSalesFormatter, and calls method displaySales to display the sales information in the standard output.

-
  - If the user chooses option 3, run calls method setSalesFormatter with the singleton instance of class XMLTextSalesFormatter, and calls method displaySales to display the sales information in the standard output.

### Files
The following files are needed to complete this assignment:
- [_student-files.zip_](https://www.icarnegie.com/content/SSD/SSD3/4.2.0.0/normal/pg-class-imp/pg-adv-clss-dsgn/assm-exer-dsgn-ptrns/pool-pr-dsgn-ptrns/qn-pr-formtr-gou-sys/handout/student-files.zip) — Download this file. This archive contains the following:
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
  - _GourmetCoffee.java_. A partial implementation of the class GourmetCoffee.

### Tasks
Implement the interface SalesFormatter and the classes PlainTextSalesFormatter, HTMLSalesFormatter, XMLSalesFormatter. Finish the implementation of class GourmetCoffee. Document using Javadoc and follow Sun&#39;s code conventions. The following steps will guide you through this assignment. Work incrementally and test each increment. Save often.
1. **Extract** the student-files.zip
2. **Then** , implement interface SalesFormatter from scratch. （10 points）

1. **Next** , implement class PlainTextSalesFormatter from scratch.
（10 points）
1. **Then** , implement class HTMLSalesFormatter from scratch.  （10 points）

1. **Next** , implement class XMLSalesFormatter from scratch. （10 points）

1. **Then** , complete the method GourmetCoffee.setSalesFormatter.
（10 points）
1. **Next** , complete the method GourmetCoffee.displaySales. （10 points）

1. **Then** , complete the method GourmetCoffee.run. （10 points）

1. **Finally** , compile and execute the class GourmetCoffee. Sales information has been hard-coded in the GourmetCoffee template provided by iCarnegie.
  - If the user chooses to display the sales information in plain text, the output should be:
  - ------------------------
  - Order 1
    -
  - 5 C001 17.99
    -
  - Total = 89.94999999999999
  - ------------------------
  - Order 2
    -
  - 2 C002 18.75
  - 2 A001 9.0
    -
  - Total = 55.5
  - ------------------------
  - Order 3
    -
  - 1 B002 200.0
    -
Total = 200.0
1.
  - If the user chooses to display the sales information in HTML, the output should be:
  - \&lt;html\&gt;
    \&lt;body\&gt;
    \&lt;center\&gt;\&lt;h2\&gt;Orders\&lt;/h2\&gt;\&lt;/center\&gt;
    \&lt;hr\&gt;
    \&lt;h4\&gt;Total = 89.94999999999999\&lt;/h4\&gt;
      \&lt;p\&gt;
        \&lt;b\&gt;code:\&lt;/b\&gt; C001\&lt;br\&gt;
        \&lt;b\&gt;quantity:\&lt;/b\&gt; 5\&lt;br\&gt;
        \&lt;b\&gt;price:\&lt;/b\&gt; 17.99
      \&lt;/p\&gt;
    \&lt;hr\&gt;
    \&lt;h4\&gt;Total = 55.5\&lt;/h4\&gt;
      \&lt;p\&gt;
        \&lt;b\&gt;code:\&lt;/b\&gt; C002\&lt;br\&gt;
        \&lt;b\&gt;quantity:\&lt;/b\&gt; 2\&lt;br\&gt;
        \&lt;b\&gt;price:\&lt;/b\&gt; 18.75
      \&lt;/p\&gt;
      \&lt;p\&gt;
        \&lt;b\&gt;code:\&lt;/b\&gt; A001\&lt;br\&gt;
        \&lt;b\&gt;quantity:\&lt;/b\&gt; 2\&lt;br\&gt;
        \&lt;b\&gt;price:\&lt;/b\&gt; 9.0
      \&lt;/p\&gt;
    \&lt;hr\&gt;
    \&lt;h4\&gt;Total = 200.0\&lt;/h4\&gt;
      \&lt;p\&gt;
        \&lt;b\&gt;code:\&lt;/b\&gt; B002\&lt;br\&gt;
        \&lt;b\&gt;quantity:\&lt;/b\&gt; 1\&lt;br\&gt;
        \&lt;b\&gt;price:\&lt;/b\&gt; 200.0
      \&lt;/p\&gt;
    \&lt;/body\&gt;
\&lt;/html\&gt;

1.
  - If the user chooses to display the sales information in XML, the output should be:
  - \&lt;Sales\&gt;
    \&lt;Order total=&quot;89.94999999999999&quot;\&gt;
    \&lt;OrderItem quantity=&quot;5&quot; price=&quot;17.99&quot;\&gt;C001\&lt;/OrderItem\&gt;
    \&lt;/Order\&gt;
    \&lt;Order total=&quot;55.5&quot;\&gt;
    \&lt;OrderItem quantity=&quot;2&quot; price=&quot;18.75&quot;\&gt;C002\&lt;/OrderItem\&gt;
    \&lt;OrderItem quantity=&quot;2&quot; price=&quot;9.0&quot;\&gt;A001\&lt;/OrderItem\&gt;
    \&lt;/Order\&gt;
    \&lt;Order total=&quot;200.0&quot;\&gt;
    \&lt;OrderItem quantity=&quot;1&quot; price=&quot;200.0&quot;\&gt;B002\&lt;/OrderItem\&gt;
    \&lt;/Order\&gt;
\&lt;/Sales\&gt;

### Submission
Upon completion, submit **only** the following:
1. SalesFormatter.java ，SalesFormatter.class
2. PlainTextSalesFormatter.java , PlainTextSalesFormatter.class
3. HTMLSalesFormatter.java, HTMLSalesFormatter.class
4. XMLSalesFormatter.java,XMLSalesFormatter.class
5. GourmetCoffee.java, GourmetCoffee.class
6. A word file with running results of the program.
 |
| --- | --- |