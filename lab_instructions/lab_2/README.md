# Tutorial 2: Basic Concepts of Java Programming

CSGE601021 Programming Foundations 2 @ Faculty of Computer Science Universitas
Indonesia, Term 2 2017/2018

**Created by AGA | IA**

* * *

In the previous tutorial, you have learned about some of the syntax differences in Java and Python programming. You have also learned about Git, which is a version control system. Now, you will learn more about the programming concepts in Java programming language.

## Learning Objectives

1. Understand the concept of **data type** in Java (primitive data type, reference data type, and type casting)
2. Understand the **control flow** in Java (conditionals, iteration, branching statements)
3. Understand the basic concept of **String** and `String` operations
4. Understand the concepts of **_Input_ and _Output_** in Java (`Scanner`, `System.out`, parsing)

## Before You Start...

1. Do a `git pull upstream master` by using the Command Prompt at your local repository folder
2. You can implement the second java tutorial source code in folder `ddp-lab/tutorial-2/main/java`
3. Implement your code accordingly to what the lab questions asked you to do
4. After you finish implementing your code, add, commit, then push your code
5. Done

## Tutorial Materials

### Data Type

Data type is what type of value can be assigned to a variable, and what operations can be applied to that variable. Operations that can be applied to a variable can be mathematical operations, relationships, and logic.

Unlike Python, Java uses static type system so we have to explicitly specify the type each time we declare a variable.

> Python

```python
iniString = “DDP 2”
iniInt = 2018
iniFloat = 4.4
```

> Java

```java
String iniString = “DDP 2”;
int iniInt = 2018;
float iniFloat = 4.4;
```

Many programming language has 3 data types:

1. **Primitive Data Types**

	Primitive Data Type is a data type that only has one value at maximum.
	![Primitive Data Types](https://only4techies.files.wordpress.com/2009/10/3.jpg)

	In Java programming language you can do type casting, that is to assign value of data type of a variable with different data type. There are two types of casting, ie
	- **Widening** (has already been done implicitly):
		```java
		int anInt = 18;
		long aLong = anInt;
		float aFloat = aLong;

		// results for type casting
		// anInt = 18
		// aLong = 18
		// aFloat = 18.0
		```
	- **Narrowing** (should be explicitly defined):
		```java
		double aDouble = 18.1;
		long aLong = (long) aDouble;
		int anInt = (int) aLong;

		// results for type casting
		// aDouble = 18.1
		// aLong = 18
		// anInt = 18
		```

2. **Derived Data Types**

	Derived Data Types is a data type that can be parsed. In the Java programming language, there are parsing techniques. Parsing technique is a technique for converting non primitive data types into primitive data types, and vice versa. Where the parsed results are assigned to other variables.
	```java
	// to assign var numbers with parsed results
	// string to integer var stringNumber
	String stringNumber = "2018";
	int number = Integer.parseInt(stringNumber);
	```

3. **User Defined Data Types**

	User Defined Data Type is a self-defined data type.

### Control Flow
In general, the computer will execute the code sequentially from the top row down. The command in the programming language to change the order of program execution as needed is named as Control Flow. In general, the programming language there are three types of control flow orders are:

#### 1. Decision Making
You must have understood the concept and syntax decision making in the Python programming language. Compared with the Python programming language, the decision making on the Java programming language differs only in terms of syntax.

> Python

```python
if (score >= 80):
	print("Score A")
elif (score >= 60 and score < 80):
	print("Score B")
else:
	print("Score C")
```
> Java

```java
if (score >= 80){
	System.out.println("Score A");
} else if (score >= 60 && score < 80) {
	System.out.println("Score B");
} else {
	System.out.println("Score C");
}
```

#### 2. **Looping**
The concept of looping also exist in the Java programming language. Looping in java are for loop, for each loop, do while loop, and while loop.

- **While**
	Python:
	```pyton
	i = 20;
	while (i>0):
	print(i)
	i = i-1
	```

	Java:
	```java
	int i = 20;
	while (i>0) {
		System.out.print(i);
		i--;
	}
	```

- **For**
	Python:
	```python
	for x in range(20):
		print(i);
	```

	Java:
	```java
	for (int i=0; i<20; i++) {
		System.out.print(i);
	}
	```

- **Do While**
	Looping Do While is not in Python. Here is an example of its Java code:
	```java
	do {
		System.out.println("Hello");
	} while (true);
	```

#### 3. Branching Statement
There are some very useful statements for branching on loops: statement break, continue, and return.
- **break** - is used to stop the loop

	**Example Output:**
	```
	0
	1
	2
	```

	**Example Code of Python:**
	```python
	for i in range(4):
		if i == 3:
			break
	print(i)
	```

	**Example Code of Java:**
	```java
	int[ ] arr = {0,1,2,3};
	for(int i:arr) {
		if(i == 3) {
			break;
		}
		System.out.println(i);
	}
	```

- **continue** - is used to skip an iteration

	**Example Output:**
	```
	0
	2
	3
	```

	**Example Code of Python:**
	```python
	for i in range(3):
		if i == 1:
			continue
	print(i)
	```

	**Example Code of Java:**
	```java
	int[ ] arr = {0,1,2,3};
	for(int i:arr) {
		if(i == 1) {
			continue;
		}
		System.out.println(i);
	}
	```

- **return** - is used to return the value
	**Example Output:**
	```
	2
	```

	**Example Code of Python:**
	```python
	def returnNumber(number):
			return number
	print(returnNumber(2))
	```

	**Example Code of Java:**
	```java
	public static int returnNumber(int number) {
		return number;
	}
	public static void main(String[ ] args) {
		System.out.println(returnNumber);
	}
	```

### String
Like Python, non-numeric sentences are String data types. String is a data type ** reference ** and is ** immutable ** (can not replace the contents of the same object, must create a new object). The following is a comparison example of using String:

**Python**
```python
message = "DDP2"
messageSmall = "saya usep"

messageCut = message[:3]
messageBig = MessageSmall.upper()
size = len (messageSmall)
letter = messageSmall [1]

print(messageCut)
print(messageBig)
print(size)
print(letter)
```

The program output above:
```python
DDP
SAYA USEP
9
a
```

**Java**
```java
String message = “DDP2”;
String messageSmall = “saya usep”;

String messageCut = message.substring(0,3);
String messageBig = messageSmall.toUpperCase();
int size = messageSmall.length();
char letter = messageSmall.charAt(1);

System.out.println(messageCut);
System.out.println(messageBig);
System.out.println(size);
System.out.println(letter);
System.out.println(5 + 3 + ““ + 53);
```

The program output above:
```java
DDP
SAYA USEP
9
a
853
```

### Simple Input and Output

In general, each program requires user input, and returns it back to the desired output by the user. In the Java programming language, there are two system variables that work for Input / Output, ie **System.in** as **input**, and **System.out** as **output**. How to use it is as follows:

#### 1. Output

The output in the Java command-line is actually very easy to use, we can use some methods in System.out, like ** example ** below:

```java
String cowName = “Cang”;
float cowWeight = 1532.3;

// println -> print that end with new line
System.out.println(“Nama: “);
System.out.println(cowName);
// print -> print that end without new line
System.out.print(“Berat: “);
System.out.print(cowWeight);
```

**Program Output**:
```java
Nama:
Cang
Berat: 1532.3
```

#### 2. Input

Input on Java requires a separate input reader object to read System.in. In DDP2, you will use the Scanner object. Here is an **example** of use:

```java
// Initialize the Scanner object and save it in a variable
Scanner input = new Scanner(System.in);

String name = input.nextLine();
Call string1 = input.next();
String call2 = input.next();

// Close the Scanner object once it is finished (best practice)
input.close ();
```

If the user types like this in the console:
```java
Muhammad Abdurrahman
Abd Aab
```

Maka **isi variabel** setelah program dijalankan adalah:
> - `nama`  →  `“Muhammad Abdurrahman”`
> - `panggilan1`  →  `“Abd”`
> - `panggilan2`  →  `“Aab”`

#### 3. Change the String to a number (primitive type) and number to String

Just like Python, in the Java programming language we can also convert from ** String ** to the format of numbers in the form of ** primitive types ** such as int, float, etc..
- **Integer.parseInt()**, to change **String → int**
- **Byte.parseByte()**, to change **String → byte**
- **Short.parseShort()**, to change **String → short**
- **Long.parseLong()**, to change **String → long**
- **Float.parseFloat()**, to change **String → float**
- **Double.parseDouble()**, to change **String → double**
- **Boolean.parseBoolean()**, to change **String → boolean**
- **String.valueOf()**, to change **tipe primitif → String**

**Python**

```python
number = “553”
numberInt = int(number)
numberFloat = float(number)
number2 = str(numberFloat)
```

**Java**

```java
String number = “553”
int numberInt = Integer.parseInt(number);
float numberFloat = Float.parseFloat(number);
String number2 = String.valueOf(numberFloat);
```

**Fill in variable** after program is executed:

> - `numberInt`  →  `553`
> - `numberFloat`  →  `553.0`
> - `number2`  →  `“553.0”`

## Tutorial: "Slum Census"

### What's the story?

Kak Pewe is a field survey officer from the Tamfir Provincial Population Department. Currently, the Tamfir Provincial Population Service will carry out data collection (which is often referred to by the census) as the special population in slum areas in Tamfir province. This census needs to be done to overcome the problems of hygiene and environmental health that are often complained of by the megapolitan environment such as the province of Tamfir.

Of course Kak Pewe is very worried about the weight of this work, which he must complete within three days, before the Central Government sends aid to tidy up the existing slums and prepare for relocation for the population. Well... Kak Pewe knows that his sister, Dek Depe has many friends who are now studying at Fasilkom UI.

Therefore, Kak Pewe sought the help of her sister, Dek Depe, to find her friends to do this task and you are the right person. One day, Dek Depe visits Fasilkom UI, and gives you a simple letter with its attachment:

> "O my friend, I want to ask your help to create a program that can print the population data after it is entered. Please help me, my brother really need it to improve the environment of the Tamfir province. All the provisions of the program to be made are attached, Thanks :) "

### A little trigger?

Before you do this tutorial, it's good to read the explanation of the material given earlier, then answer the following questions as "warm up" before doing the tutorial :D

> **Remember!**
> - How do we create a program that can receive input from the user?
> - How to change the input input in the form of a String into a certain data type?
> - Name the data types you know! Describe the usage of that data type!
> - What is a 'static' keyword? Explain what is meant by 'static method'!
> - Mention and describe the types of loops in the java programming language!
> - How do I create a program to print output?

### What you need to do

- [ ] **Request input from user**
- [ ] Name of the Head of the Family (sentence, can be more than 1 word).
- [ ] Home Address (sentence, can be more than 1 word).
- [ ] Length, Width, Height (integer, cm unit, guaranteed ≤ 250 cm).
- [ ] Weight (real number, unit kg, guaranteed ≤ 150 kg).
- [ ] Number of Family Members (integer, guaranteed ≤ 20).
- [ ] Date of Birth (DD-MM-YYYY format, 1000 < year < 2018, guaranteed to be true).
- [ ] Additional Note (sentence, can be more than 1 word).
- [ ] Number of Data Prints (integer, guaranteed ≤ 99).
- [ ] Make sure the data type used by each input variable is the most efficient (the smallest data type that fits the needs).
- [ ] Create a good input requests user interface (we recommend using sample formats, but can adapt to your creativity).

- [ ] **Calculate the weight ratio per volume**
- [ ] Use the formula: (Weight (kg)) / (Length (m) * Width (m) * Height (m)).
- [ ] Make sure you have adjusted input unit from cm to m when counting.
- [ ] Make sure you use the correct data type when calculating.
- [ ] The final data type of the calculation is an integer (note that the data type should be as efficient as possible → the smallest data type that fits the needs).

- [ ] **Print data according to the format specified**
- [ ] Do looping as many as the number of prints.
- [ ] At each iteration, there is an input to request the recipient's name, then print the family data. Use the following format: (input in bold)

<pre> Printing [number] from [Number of Prints] to: <b> [Data Recipient] </b>
DATA READY PRINTED FOR [DATA RECEIVER (UPPERCASE)]
-----------------
[Name of Family Head] - [Home Address]
Born on [Date of Birth]
Ratio Weight Per Volume = [Ratio] kg / m ^ 3
Note: [Note]
</pre>
- [ ] If there is no record, replace the `Note: [Note]` to:
<pre> No additional notes </pre>

### **Example of Input and Output**
Here is an example of program interaction (in bold is the input):
<pre> CENSUS DATA PRINTING PROGRAM
--------------------
Name of Family Head 		: <b> Butterfield </b>
Home Address 				: <b> RSE </b>
Body Length (cm)			: <b> 30 </b>
Body Width (cm)				: <b> 60 </b>
Body Height (cm)			: <b> 170 </b>
Body Weight (kg)			: <b> 75 </b>
Number of Family Members	: <b> 1 </b>
Date of Birth				: <b> 22-01-2000 </b>
Additional Notes 			: <b> Not married, rich man </b>
Number of Data Prints 		: <b> 3 </b>

Printing 1 of 3 for: <b> Tamfir provincial government archives </b>
DATA PREPARED FOR PRINTED GOVERNMENT ARCHIVES TAMFIR PROVINCE
--------------------
Butterfield - RSE
Born on 22-01-2000
Ratio Weight Per Volume = 245 kg / m ^ 3
Note: Not married, rich man

Printing 2 of 3 for: <b> National Environmental Health Agency </b>
DATA READY PRINTED FOR THE NATIONAL ENVIRONMENTAL HEALTH BODY
--------------------
Butterfield - RSE
Born on 22-01-2000
Ratio Weight Per Volume = 245 kg / m ^ 3
Note: Not married, rich man

Printing 3 of 3 for: <b> provincial governor of Tamfir </b>
DATA READY PRINTED FOR TAMFIR PROVINCIAL GOVERNOR
--------------------
Butterfield - RSE
Born on 22-01-2000
Ratio Weight Per Volume = 245 kg / m ^ 3
Note: Not married, rich man
</pre>

Here is another example of possible program interactions (in bold is the input):
<pre> CENSUS DATA PRINTING PROGRAM
--------------------
Name of Family Head: <b> master Shifu </b>
Home Address: <b> Ninja </b>
Body Length (cm): <b> 36 </b>
Body Width (cm): <b> 71 </b>
Body Height (cm): <b> 189 </b>
Body Weight (kg): <b> 68.5 </b>
Number of Family Members: <b> 7 </b>
Date of Birth: <b> 12-03-1971 </b>
Additional Notes: <b> </b>
Number of Data Prints: <b> 2 </b>

Printing 1 of 2 for: <b> environmental community Fasilkom </b>
PREPARED DATA PRINTED FOR THE ENVIRONMENTAL COMMUNITY FACILITY COMMUNITY
--------------------
Master Shifu - Ninja
Born on 12-03-1971
Ratio Weight Per Volume = 141 kg / m ^ 3
No additional notes

Printing 2 of 2 for: <b> Archive of district government Fasilkom </b>
DATA READY PRINTED FOR FASILKOM REGIONAL GOVERNMENTAL ARCHIVES
--------------------
Master Shifu - Ninja
Born on 12-03-1971
Ratio Weight Per Volume = 141 kg / m ^ 3
No additional notes
</pre>

### Any templates?

So ... it turned out that Dek Depe had friends who were willing to ease you in completing this job, but because he was busy, he was only able to make his **template** alone. **Template** is in `/lab_2/src/main/java/SistemSensus.java`.

How to use it? Instantly modify the template, fill it with your answer code :) Further guides are already in the template code!

## Bonus Tutorial: "Apartment Recommendation"

### What's the story?

Thanks to your help, Kak Pewe successfully executed the census of slums in Tamfir Province on time. After the environmental arrangement for one month, it turns out not everyone can occupy the area, so there is a need for relocation. Mak Dis as the head of the Tamfir Provincial People's Housing Service has recommended three apartments to be relocated, along with the provision of relocation sites. Kak Pewe was asked to reconstruct those who fulfill the prerequisites to be relocated. And he certainly asked for his sister's help, Dek Depe, again.

Therefore, Dek Depe also asks your help once again to continue the pre-made program, then add new features according to the following checklist:

### What you need to do

- [ ] **Validate input**

	Validation is done after the user has finished entering all required input. If the input does not meet the conditions below then:
	- [ ] Show message **directly** when user input invalid input (beyond the specified limit):
	<pre> WARNING: This family does not need to be relocated! </pre>
	- [ ] Exit the program (hint: use the appropriate branching statement)
	The following are the input conditions that should be validated:
		- [ ] 0 < **body length** ≤ 250 cm, is a **round**.
		- [ ] 0 < **body widht** ≤ 250 cm, is a **round**.
		- [ ] 0 < **body height** ≤ 250 cm, is a **round**.
		- [ ] 0 < **body weight** ≤ 150 kg, is a **real number**.
		- [ ] 0 < **the number of family members** ≤ 20, is a **whole**.

- [ ] **Generate family ID number**
	- [ ] Use format: `[first letter name of head of family][Result of calculation]`.
	- [ ] To calculate, use the formula:
		`` `
		((Length * Height * Width) + Number of ASCII per letter name) mod 10000.
		`` `

		**Sample case:**
		`` `java
		name = "are NG"
		length = 71
		width = 26
		high = 37
		`` `
		Then **family number** is: `a8795`.

- [ ] **Calculate the food budget per year**
	- [ ] Use the formula: `Rp 50000 * 365 * (number of family members)`.
	- [ ] Make sure you are using the right data type **when calculating**.
	- [ ] The final data type of the calculation is **round number** (note that the data type should be as efficient as possible → the smallest data type that fits the needs).

- [ ] **Calculate the age of the head of the family**
	- [ ] Take birth year from date of birth.
	- [ ] Use the formula: **2018 - (year of birth)**.
	- [ ] The final data type of the calculation is **round number** (note that the data type should be as efficient as possible → the smallest data type that fits the needs).

- [ ] **Group families into apartments**
	- [ ] Here is a list of apartments along with the criteria:
		-> Name: **PPMT**<br>
			> Regency: **Rotunda**<br>
			> RANGE Food / Year Budget: **FREE**<br>
			> RANGE Age of Family Head: **0** year s.d. **18** years
		-> Name: **Teksas**<br>
			> Regency: **Literature**<br>
			> RANGE Food / Year Budget: Rp **0** s.d. Rp **100.000.000**<br>
			> RANGE Age of Family Head: **19** year s.d. **1018** year
		-> Name: **Mares**<br>
			> County: **Margonda**<br>
			> RANGE Food / Year Budget: Rp **100.000.000** s.d. **NOT TOO** <br>
			> RANGE Age of Family Head: **19** year s.d. **1018** year
- [ ] **Print recommendations according to the format specified**
	<pre>
	RECOMMENDATIONS OF APARTMENTS
	--------------------
	KNOWN: Family ID: <Name of Family Head> - <number>
	CONSIDER: Annual food budget: Rp <Budget>
	Age of family head: <Age> years
	HAS DECIDED: Family <Name of Head of Family> will be placed at:
	<Place Name>, district <Name of Regency>
	</pre>

> **Hint**
> - Use the .split () function to separate date, month and year of birth.
> - Use casting to include ASCII letter in formula.

### Example of Input and Output

The following are examples of possible program interactions (in bold are entries):
<pre> CENSUS DATA PRINTING PROGRAM
--------------------
Name of Head of Family 		: <b> Master Shifu </b>
Home Address 				: <b> Ninja </b>
Body length (cm) 			: <b> 36 </b>
Body width (cm) 			: <b> 71 </b>
Height of body (cm) 		: <b> 189 </b>
Body weight (kg) 			: <b> 68.5 </b>
Number of Family Members 	: <b> 7 </b>
Date of Birth 				: <b> 12-03-1971 </b>
Additional Notes 			: <b> </b>
Number of Data Prints 		: <b> 2 </b>

Printing 1 of 2 for: <b> environmental community Fasilkom </b>
PREPARED DATA PRINTED FOR THE ENVIRONMENTAL COMMUNITY FACILITY COMMUNITY
--------------------
Master Shifu - Ninja
Born on 12-03-1971
Ratio Weight Per Volume = 141 kg / m ^ 3
No additional notes

Printing 2 of 2 for: <b> Archive of district government Fasilkom </b>
DATA READY PRINTED FOR FASILKOM REGIONAL GOVERNMENTAL ARCHIVES
--------------------
Master Shifu - Ninja
Born on 12-03-1971
Ratio Weight Per Volume = 141 kg / m ^ 3
No additional notes

RECOMMENDATIONS OF APARTMENTS
--------------------
KNOWLEDGE: Family Identity: Master Teacher - m4279
CONSIDER: Annual food budget: Rp 127750000
Age of family head: 47 years old
DECIDES: Master's master family will be placed at:
Mares, Margonda district
</pre>

The following is an example if the input does not meet validation (which in bold is the input):

<pre> CENSUS DATA PRINTING PROGRAM
--------------------
Name of Head of Family: <b> Esta </b>
Home Address: <b> Parbel </b>
Body length (cm): <b> 45 </b>
Body width (cm): <b> 64 </b>
Height of body (cm): <b> 288 </b>
WARNING: This family does not need to be relocated!
</pre>

## Checklist

For each evaluation component that you have completed, please mark the brackets
with `x` symbol.

### Required Components | 100 Points

- [ ] **Ask the user for input**
- [ ] **Count the weight per volume ratio**
- [ ] **Print data according to the format**

### Bonus Components | 10 Points

- [ ] **Input validation**
- [ ] **Generate family identifier number**
- [ ] **Count the budget of food per year**
- [ ] **Count the age of the head of family**
- [ ] **Group families to apartment**
- [ ] **Print recommendation according to the determined format**
