# **Tutorial 5: Array dan ArrayList**

Programming Foundations 2 - CSGE601021 | Faculty of Computer Science, Universitas Indonesia, Term 2 2017/2018

**Created by NA | NN**

* * *
In the previous tutorial, you have learned about the OOP concept and overloading in Java. This time, you will learn about Array and ArrayList.

## **Learning Objectives**
1. Understand Array
2. Understand ArrayList


### **Before You Start...**
1. Do `git pull upstream master` by using the command prompt/shell at your local
repository folder
2. Implement your code according to the specifications written in this document
and put the Java file in `lab_5/src/main/java` directory
3. After you finish implementing your code, add, commit, then push your code.

## **Tutorial Materials**

### **Array**

**Array** is the simplest data structure provided by the Java programming language. Informally, an array of **arrays** is a collection of n data pieces with the same data type. Furthermore, it can be said that the array of ** arrays ** has a length of n. Simple, is it not?. Data types that can use Arrays are **primitive** and **refference/object**.

**Array is fixed-size** which means the length of an array can not be changed after the array is instantiated. An array can be identified with the symbol "[]". The elements in the array can be accessed based on the index/position of the element. For example, array [i] will return an element with index i in array *array*, of course with i < n, index in array starts from 0.

**Array** can also be **Multidimensional Array**, which means each element is an array as well.

To further know about **array** look here [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)

### **Let's guess the results of each code below to increase your understanding!!**

**Soal 1**
```java
int[] numbers = new int[10]; // initiating an array of int with length 10
System.out.println(numbers[5]); // display ... , because ...

```
**Soal 2**
```java
String[] strList = new String[5];//...
System.out.println(strList[0]);// display ... , because ....

```
**Soal 3**
```java
int[] primes = {2,3,5,7,11}; //initiating array of int with initial values 
System.out.println(primes[2]);// display ... , because ....

```
**Soal 4**
```java
String[] animals = {"cat","bird","tiger"}; // ...
System.out.println(animals[1]); // display ... , because ....
animals[0] = "fish"; //mengganti elemen index ke 0
System.out.println(animals[1]); // display ... , because ....

```
**Soal 5**
```java
String str  = "a b c d";
String[] splitstr = str.split(" "); //initiating array of String from method split
System.out.println(splitstr[3]);// display ... , because ....
splitstr[3] = "new"; //...

```
**Soal 6**
```java
int[][] points = new int[4][4];     // array of int 2 dimension with length 4, dan wide 4 just like a chest board

System.out.println(points[0][0]);  // display ... , because ....

points[0][1] = 5;  //...
points[1] = new int[2]; //...
points[2] = {1,2,3};    //...
Int[] sesuatu = {1,2,3};  //....

System.out.println(points[0][5]); // display ... , because ....

```


### **ArrayList**
**ArrayList** is simply a dynamic array, unlike arrays, ArrayList sizes can evolve as needed, and elements that ArrayList holds should be of type reference.

To further know about **array list** look here [here](https://www.tutorialspoint.com/java/java_arraylist_class.htm)

### **ALet's guess the results of each code below to increase your understanding!!**

```java
import java.util.ArrayList;
public class Test {
    public static void main(String[] args){
    	ArrayList<Integer> numbers = new ArrayList<Integer>(); // initiating arraylist of integer

    	//.......
    	numbers.add(3); 
		numbers.add(2);
		numbers.add(4);
		numbers.add(5);
		numbers.add(7);


		numbers.size(); //...
		numbers.get(0); //...
		numbers.set(0, 1); //....


		numbers.remove(1); //....

	}
}
```



## **Tutorial Question: "Bingo? BINGO!"**

![alt text](https://myfreebingocards.com/bingo-card-generator/results?not-random=1&img=1&title=BINGO&words=02%0D%0A04%0D%0A10%0D%0A39%0D%0A53%0D%0A29%0D%0A13%0D%0A77%0D%0A42%0D%0A55%0D%0A31%0D%0A73%0D%0A88%0D%0A69%0D%0A32%0D%0A40%0D%0A86%0D%0A30%0D%0A01%0D%0A27%0D%0A08%0D%0A49%0D%0A52%0D%0A81%0D%0A17&theme=stars-and-stripes&size=5&per-page=1&free-space-text=FREE+SPACE&s=1 "Bingo Card")


------

### **What's the story?**

One day, Dek Depe was offered by Sis Dea to make a game. The Dek Depe is required to create a 5x5 size Bingo game, which has an objective to produce a straight line of 5 numbers, either horizontally, vertically or diagonally. Depe sensed that he could form the game simply using the usual array he just learned in java and with the help of his friends from DDP2 college students who were kind and diligent in saving money he was sure he could do it!

Bingo is a game on a board that has a 5x5 grid with each slot having a number. In the game, a number will be notified at random, if the number is on your board then the number will be marked. The game will end if someone manages to mark 5 consecutive numbers resulting in a straight line either vertically, horizontally or diagonally.

### **Class Specification**

Because last week you have already studied about OOP, it is expected starting now to get used to doing tutorial with using the OOP concept. If needed, the main method is only used to process data or call method class that has been made.

In the course of the tutorial, it is expected to create the BingoCard.java class (you can create another class if needed), the implementation can be creative and create the method according to your needs with at least there is a method:

- [ ] markNum
- [ ] info
- [ ] restart

### Flow Program 
Initial initiation of the program begins with receiving 5 lines of input from the user consisting of 5 separate numbers with spaces. The 5 lines will generate as many as 25 numbers that will be used as your bingo card. When the initiation has been executed, the game can be started which will continually ask for commands from the user. Commands that can be given are as follows:

### MARK (Number)

The command will indicate/cross the numbers on your card
After successfully marking the numbers, the program checks whether a straight line (diagonal included) of 5 numbers generates bingo. In case of bingo the game is over and the program will stop receiving input.

If the number is not on the card, the program will output: ”Kartu tidak memiliki Number (Number)”
If the number is on the card and it has not been crossed, the program will output the output: ”(Number) tersilang”
If the number has already been crossed, the program will output the output: ”(Number) sebelumnya sudah tersilang”
After marking a number, when BINGO is formed then the program will output “BINGO!”

### INFO

The program will print the temporary card condition. Crossed numbers will be replaced with "X"

Example output :

| 46 | 37 | 83 | 12 | 17 |

| 04 | X  | 20 | 22 | 39 |

| X  | 73 | 44 | 51 | 90 |

| 13 | 05 | 81 | X  | 55 |

| 26 | 58 | 91 | X  | 34 |

### RESTART

Repeat the game with using the same card. All the numbers that have been crossed are returned to their original state

The program will output "Mulligan!"

 
If the given command is not between the 3, the program will output the "Incorrect command"

When bingo is reached, the program will stop receiving input and issue a "BINGO!" Message and print the card's condition.


## Example Input

10 11 12 13 14

29 28 27 26 25

31 33 35 37 39

42 44 40 46 48

58 64 71 82 99

MARK 11

MARK 44

MARK 64

MARK 59

MARK 27

INFO

MARK 28

MARK 44

RESTART

MARK 44

MARK 35

MARK 14

MARK 58

INFO

MARK 26

## Example Output

11 tersilang

44 tersilang

64 tersilang

Kartu tidak memiliki Number 59

27 tersilang

| 10 | X  | 12 | 13 | 14 | 

| 29 | 28 | X  | 26 | 25 | 

| 31 | 33 | 35 | 37 | 39 | 

| 42 | X  | 40 | 46 | 48 | 

| 58 | X  | 71 | 82 | 99 | 

28 tersilang

44 sebelumnya sudah tersilang

Mulligan!

44 tersilang

35 tersilang

14 tersilang

58 tersilang

| 10 | 11 | 12 | 13 | X  | 

| 29 | 28 | 27 | 26 | 25 | 

| 31 | 33 | X  | 37 | 39 | 

| 42 | X  | 40 | 46 | 48 | 

| X  | 64 | 71 | 82 | 99 | 

26 tersilang

BINGO!

| 10 | 11 | 12 | 13 | X  | 

| 29 | 28 | 27 | X  | 25 | 

| 31 | 33 | X  | 37 | 39 | 

| 42 | X  | 40 | 46 | 48 | 

| X  | 64 | 71 | 82 | 99 | 



>Notes:
- Working on the problem, it is expected to use Arrays without ArrayList
- The numbers given are certainly unique, there will not be the same number in the card.
- The number given has a maximum of 2 digits.
- All inputs use the correct format so it is not necessary to create incorrect input handler


## **Bonus Question: "Tired always single(player) :("**
Untuk soal bonus ini, kalian sekarang diharapkan mengimplementasi MultiPlayer Mode! Mirip flow program soal utama, hanya saja sebelum menerima inputan Number yang membentuk papan bingomu, program akan pertama kali diharapkan menerima 1 baris with format suatu Number dilanjutkan with Name - Name n kali( "N Name-1 Name-2 ... Name-N") . N merepresentasikan jumlah pemain, dan Name yang diterima merupakan Name pemain tersebut. Setelah menerima baris tersebut program akan meminta 5 barisan Number seperti biasa sebanyak n kali untuk tiap pemain.

Untuk Input Output terdapat sedikit modifikasi juga.

For this bonus problem, you are now expected to implement MultiPlayer Mode! Similar to the main program flow, it's just that before accepting the numbers that form your bingo board, the program will first be expected to receive 1 row with the format of a number followed by the names n times ("N Name-1 Name-2 ... Name-N "). N represents the number of players, and the Name received is the name of the player. After receiving the line the program will ask for 5 rows of numbers as usual for n times for each player.

For Input and Output there are a few modifications as well.

### MARK (Number)
All players will execute MARK commands, however the output only shows players who successfully crossed a number, sequentially in the order in which the name was given. Example:

"(Name1): (Number) tersilang!"

"(Name2): Kartu tidak memiliki angka (Number)”

"(Name3): (Number) sebelumnya sudah tersilang”

"(Name4): (Number) tersilang!"

"(Name5): (Number) tersilang!"



### INFO (Name)
Program will print the player name and the card condition that belongs to that name.

Exmaple output :

(Name)

| 46 | 37 | 83 | 12 | 17 |

| 04 | X  | 20 | 22 | 39 |

| X  | 73 | 44 | 51 | 90 |

| 13 | 05 | 81 | X  | 55 |

| 26 | 58 | 91 | X  | 34 |

### RESTART (Name)
The function will now restore the original condition of all players, but each player may only restart once.
If the player calls the restart more than once, the program will only output "(Name) sudah pernah mengajukan RESTART" without changing the card condition.

When a player's card has reached a winning condition, then the program will print the player's name and the card's condition and stop. (Winner can be more than 1 person)


## Checklist
Fill in square brackets with x to check components
### Compulsury Component | 100 Poin
- [ ] **Create class BingoCard according to the specification**
- [ ] **Perform initial setup of the game**
- [ ] **Implementing method markNum**
- [ ] **Implementing method info**
- [ ] **Implementing method restart**
- [ ] **Stop the program when the player has won and print the card's final status**

### Komponen Bonus | 10 Poin
- [ ] **Allow more than 1 players**
- [ ] **Change method markNum**
- [ ] **Change method info**
- [ ] **Change method restart**
- [ ] **Prints the winner of the game and the condition of the card**

-----
### **Woah, what is this!?**

After you pushed your work, you will realised that there is a red cross or green tick icons beside your work (commit).

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

You might have noticed that we started using Git since semester 2, following your seniors who started using Git since semester 3. One of the benefits of using Git is we can integrate our work (commits) history with a Continuous Integration (CI) system.

What is Continuous Integration? Continuos Integration is a concept in which when you push, the results of your push will directly be build (compile) and test (direct test). If it fails, you will be notified.


The Build section will be explained in the Advanced Programming course. You just need to know the test section.

The system used to test in Java is named JUnit. We can use the JUnit framework to test directly (without having to print in the command line). For now, you do not need to know how JUnit works.

You can check Junit's work on the Commit tab. Press the green or cross red check logo to check for more details.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")


349/5000
When you hit the logo, you will check the summary of the test which has two circles.

If the first circle is cross, then your program fails due to compile error.
If the first circle ticks green but the second circle is cross, then your program is not accurate.
If both circles tick, your program is already good.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

You can press the red cross button or check green to see more results. For example, if you guys gets a red cross in the second circle, you can find a second red cross to see which test case your program is inaccurate.
