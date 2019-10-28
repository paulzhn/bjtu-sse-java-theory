# Assignment 3

## exercise 1

**NOTE: The input here is referred to program argument.**

### input 1

```
TV
```

### output 1

```
Fridge turns on.
Fridge turns off.
The device has turned on.
The device has increased volume.
TV has increased volume.
The device has decreased volume.
TV has decreased volume.
The device has turned off.
```

### input 2

N/A

### output 2

```
Fridge turns on.
Fridge turns off.
The device has turned on.
The device has increased volume.
The device has decreased volume.
The device has turned off.
```

### input 3

```
Radio
```

### output 3

```
Fridge turns on.
Fridge turns off.
The device has turned on.
The device has increased volume.
Radio has increased volume.
The device has decreased volume.
Radio has decreased volume.
The device has turned off.
```

## exercise 2

### input

```
1
2
3
0
```

### output

```
[0]  Quit
[1]  Display sales (Plain Text)
[2]  Display sales (HTML)
[3]  Display sales (XML)
choice> 1

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

[0]  Quit
[1]  Display sales (Plain Text)
[2]  Display sales (HTML)
[3]  Display sales (XML)
choice> 2

<html>
	<body>
		<center><h2>Orders</h2></center>
		<hr>
		<h4>Total = 89.94999999999999</h4>
		<p>
			<b>code: </b>C001<br>
			<b>quantity: </b>5<br>
			<b>price: </b>17.99
		</p>
		<hr>
		<h4>Total = 55.5</h4>
		<p>
			<b>code: </b>C002<br>
			<b>quantity: </b>2<br>
			<b>price: </b>18.75
		</p>
		<p>
			<b>code: </b>A001<br>
			<b>quantity: </b>2<br>
			<b>price: </b>9.0
		</p>
		<hr>
		<h4>Total = 200.0</h4>
		<p>
			<b>code: </b>B002<br>
			<b>quantity: </b>1<br>
			<b>price: </b>200.0
		</p>
	</body>
</html>
[0]  Quit
[1]  Display sales (Plain Text)
[2]  Display sales (HTML)
[3]  Display sales (XML)
choice> 3

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
[0]  Quit
[1]  Display sales (Plain Text)
[2]  Display sales (HTML)
[3]  Display sales (XML)
choice> 0
```

