# Assignment 6:

**(total 30 points)**

## Exercise 1: Implementing a GUI for the Gourmet Coffee System

**(30 points)**

### Prerequisites, Goals, and Outcomes

**Prerequisites:** Before you begin this exercise, you need mastery of the following:

- _Graphical user interface_
  - Knowledge of Swing components and containers
  - Knowledge of Swing event handling
  - Knowledge of `JFileChooser` dialog

**Goals:** Reinforce your ability to create a GUI with event handling

**Outcomes:** You will master the following skills:

- Produce interactive applications that use a Swing GUI

### Background
In this assignment, you will create a comprehensive GUI for the _Gourmet Coffee System_. Part of the work has been done for you and is provided in the student archive. You will implement the code that handles the button events.
### Description
Class `GourmetCoffeeGUI` implements a GUI for the _Gourmet Coffee System_. This GUI lets the user display the product catalog, process orders, and track the store&#39;s sales:

![aaa.jpg](https://i.loli.net/2019/09/29/UHGDgLkXl852RNs.jpg)
**Figure 1** _Execution of GourmetCoffeeGUI_ 

The GUI is divided into four panels: Catalog, Product Information, Order, and Status:
- The Catalog panel contains a list of product codes.
- The Product Information panel contains product details. Positioned immediately beneath this panel are a text field to specify the quantity of the selected product and a button to add the selected product to the current order.
- The Order panel contains the current order, its cost, and buttons to edit the order and register its sale.
- The Status panel contains a text area to display messages and sales information; command buttons to display and save sales information; and radio buttons to specify the format of the sales information when it is displayed or saved.

When a user clicks one of the following command buttons, `GourmetCoffeeGUI` handles the associated event as described below:

- _`addModifyButton`_. Adds the selected product to the current order. If the selected product is already part of the order, modifies the quantity of that product in the order.
- _`removeButton`_. Removes the selected item from the current order.
- _`registerSaleButton`_. Adds the current order to the store&#39;s sales and empties the current order.
- _`displaySalesButton`_. Lists all orders that have been sold in the specified format (plain text, HTML, or XML).
- _`saveSalesButton`_. Saves all orders that have been sold in a file with the specified format (plain text, HTML, or XML).

When a user clicks one of the following radio buttons, `GourmetCoffeeGUI` handles the associated event as described below:

- _`plainRadioButton`_. Changes the format of the sales information to plain text.
- _`HTMLRadioButton`_. Changes the format of the sales information to HTML.
- _`XMLRadioButton`_. Changes the format of the sales information to XML.

When a user selects an element in the following list, `GourmetCoffeeGUI` handles the associated event as described below:

- _`catalogList`_. Displays the details of the selected product in the &quot;Product Information&quot; panel.

`GourmetCoffeeGUI` defines the following Swing components:

- _`catalogList`_. Displays the product code of every product in the product catalog.
- _`orderList`_. Displays the items in the current order.
- _`quantityTextField`_. Allows user to specify the quantity of the selected product.
- _`totalTextField`_. Displays the total cost of the current order.
- _`statusTextArea`_. Displays status messages and sales information.
- _`fileChooser`_. A [`JFileChooser`](http://java.sun.com/j2se/1.5/docs/api/javax/swing/JFileChooser.html) object. Allows user to specify the name and location of the file in which the sales information will be saved. This dialog box appears when the &quot;Save Sales&quot; button is clicked.
`GourmetCoffeeGUI` defines the following instance variables:
- _`catalog`_. Contains the product catalog, a `Catalog` object.
- _`currentOrder`_. An Order object that contains the items to be purchased.
- _`sales`_. A Sales object that contains the orders that have been sold.
- _`salesFormatter`_. A `SalesFormatter` object that specifies the format to be used when the sales information is displayed or saved.
- _`dollarFormatter`_. A [`NumberFormat`](http://java.sun.com/j2se/1.5/docs/api/java/text/NumberFormat.html#getCurrencyInstance()) object used to find the dollar representation of a number. (The dollar representation of 1.0 is &quot;$1.00&quot;.)
New methods have been added to classes Catalog and Order:
- The method `getCodes` has been added to the class Catalog. It returns an array of product codes (all the product codes in the product catalog) which is used by `GourmetCoffeeGUI` to populate the catalog `JList`.
- The method `getItems` has been added to the class Order. It returns an array of the `OrderItem` objects (all the items in the current order) which is used by `GourmetCoffeeGUI` to populate the order `JList`.
The button events are handled using named inner classes in class `GourmetCoffeeGUI`. The following inner classes are complete and should not be modified:
- _`DisplayProductListener`_. Listener for the catalog list
- _`RegisterSaleListener`_. Listener for the button &quot;Register Sale of Current Order&quot;
- _`PlainListener`_. Listener for the radio button &quot;Plain&quot;
- _`HTMLListener`_. Listener for the radio button &quot;HTML&quot;
- _`XMLListener`_. Listener for the radio button &quot;XML&quot;
- _`DisplaySalesListener`_. Listener for button &quot;Display Sales&quot;
In this assignment, you should complete the implementation of the following inner classes:
- _`AddModifyListener`_. Listener for button &quot;Add|Modify Order Item&quot;
- _`RemoveListener`_. Listener for button &quot;Remove Order Item&quot;
- _`SaveSalesListener`_. Listener for button &quot;Save Sales&quot;

### Files
The following files are needed to complete this assignment:
- [_exe-gourmet-coffee-gui.jar_](https://www.icarnegie.com/content/SSD/SSD3/4.2.0.0/normal/pg-adv-class-impl/pg-twrd-cmmrcl/assm-exer-evnt-hndlng/pool-pr-evnt-hndlng/qn-pr-gui-gou-cof/handout/exe-gourmet-coffee-gui.jar). Download this file. It is the sample executable.
- [_student-files.zip_](https://www.icarnegie.com/content/SSD/SSD3/4.2.0.0/normal/pg-adv-class-impl/pg-twrd-cmmrcl/assm-exer-evnt-hndlng/pool-pr-evnt-hndlng/qn-pr-gui-gou-cof/handout/student-files.zip). Download this file. This archive contains the following:
  - Class files
    - _Coffee.class_
    - _CoffeeBrewer.class_
    - _Product.class_
    - _Catalog.class_. A modified version of class Catalog
    - _OrderItem.class_
    - _Order.class_. A modified version of class Order
    - _Sales.class_
    - _CatalogLoader.class_
    - _File__CatalogLoader.class_
    - _DataFormatException.class_
    - _SalesFormatter.class_
    - _PlainTextSalesFormatter.class_
    - _HTMLSalesFormatter.class_
    - _XMLSalesFormatter.class_
    - _DataField.class_
  - Documentation
    - _Coffee.html_
    - _CoffeeBrewer.html_
    - _Product.html_
    - _Catalog.html_. A modified version of class Catalog
    - _OrderItem.html_
    - _Order.html_. A modified version of class Order
    - _Sales.html_
    - _CatalogLoader.html_
    - _File__CatalogLoader.html_
    - _DataFormatException.html_
    - _SalesFormatter.html_
    - _PlainTextSalesFormatter.html_
    - _HTMLSalesFormatter.html_
    - _XMLSalesFormatter.html_
    - _DataField.html_
  - Java files
    - _GourmetCoffeeGUI.java_. Use this template to complete your implementation.
  - Data files for the test driver
    - _catalog.dat_. A file with product information for every product in the product catalog

### Tasks
Complete the implementation of `AddModifyListener`, `RemoveListener`, and `SaveSalesListener`. The messages displayed in the status area by these inner classes should match the messages displayed by the sample executable. Follow Sun&#39;s code conventions. The following steps will guide you through this assignment. Work incrementally and test each increment. Save often.
1. **Extract** the files from _student-files.zip_

2. **Run** the sample executable by issuing the following command at the command prompt:

  ```
  C:\>java -jar exe-gourmet-coffee-gui.jar 
  ```

  **Note** : This application requires the file _catalog.dat_ which you will find in _student-files.zip_.

3. **Then** , copy the code of method `getDataFieldsPanel` that you created in the previous exercise.

4. **(10 points)Next**, implement method `actionPerformed` in the inner class `AddModifyListener`: If the current order does not contain an item with the selected product, then create a new order item and add it to the current order. Otherwise, locate the item in the order with the selected product and changes its quantity to the value specified by the user. Finally, update the current order list (use method `Order.getItems` to obtain an array containing all the items in this order), display a status message in the status area, and update the display of the order&#39;s total cost. Use the following code to display the order&#39;s total cost in dollars:

  `totalTextField.setText(dollarFormatter.format(currentOrder.getTotalCost()));`

  This method should display an error message in the status area when it detects one of the following errors:
  - The quantity text field does not contain an integer
  - The quantity text field contains a negative integer or zero.
  - The user has not selected a product.

5. **(10 points)Then**, implement method `actionPerformed` in the inner class `RemoveListener`: Remove the selected item from the current order, display a status message in the status area, update the current order list (use method `Order.getItems` to obtain an array containing all the items in this order), and update the display of the order&#39;s total cost. Use the following code to display the order&#39;s total cost in dollars:

   `totalTextField.setText(dollarFormatter.format(currentOrder.getTotalCost()));`

   This method should display an error message in the status area when it detects one of the following errors:

  - The current order is empty.
  - The user has not selected an item in the order.

6. **(10 points)Next**, implement method `actionPerformed` in the inner class `SaveSalesListener`: Save the sales information in a file. Begin by opening a file chooser so the user can specify the name and location of the file in which the sales information will be saved. Next, save the sales information in the specified file. The file should be saved in the format indicated by the radio button selection. Finally, display a status message in the status area.

   This method should display an error message in the status area when it detects one of the following errors:

  - No orders have been sold.
  - The user closes the file chooser without selecting a file.
  - The file specified by the user cannot be created or opened.

8. **Finally** , compile and execute the class `GourmetCoffeeGUI`.

### Submission
Upon completion, submit **only** the following.
1. GourmetCoffeeGUI.java, GourmetCoffeeGUI.class
2. a word file including the program running result.