# Tutorial 5: Array and ArrayList

CSGE601021 Programming Foundations 2 @ Faculty of Computer Science Universitas
Indonesia, Term 2 2017/2018

**Created by NA | NN**

* * *

In the previous tutorial, you have learned about the OOP concept and method
overloading in Java. This time, you will learn about array and `ArrayList`.

## Learning Objectives

1. Understand the difference between fixed-size and dynamic-size data elements
container
2. Use array and `ArrayList` in implementing a simple program

### Before You Start...

1. Do `git pull upstream master` by using the command prompt/shell at your local
repository folder
2. Implement your code according to the specifications written in this document
and put the Java file in `lab_5/src/main/java` directory
3. After you finish implementing your code, add, commit, then push your code

## Tutorial Materials

### Array

**Array** is the simplest data structure provided by the Java programming
language. Informally, an array with size `n` is a collection of `n` data
pieces/elements with the same data type. The data type can refer to a
**primitive** or **reference** data type.

**Array is fixed-size** container which means the length of an array can
not be changed after the array is instantiated. An array can be identified
with the symbol `[]`. The elements in the array can be accessed based on the
index/position of the element. For example, `arr[i]` will return an element
at index `i` in array `arr`, of course with `i < n`, index in array starts
from 0.

**Array** can also be **Multidimensional Array**, which means each element
in the array can be (referring to) an array as well.

To further know about **array** look here [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)

### Let's guess the results of each code below to increase your understanding!

**Example 1**
```java
int[] numbers = new int[10]; // initiating an array of int with length 10
System.out.println(numbers[5]); // display ... , because ...

```
**Example 2**
```java
String[] strList = new String[5];//...
System.out.println(strList[0]);// display ... , because ....

```
**Example 3**
```java
int[] primes = {2,3,5,7,11}; //initiating array of int with initial values 
System.out.println(primes[2]);// display ... , because ....

```
**Example 4**
```java
String[] animals = {"cat","bird","tiger"}; // ...
System.out.println(animals[1]); // display ... , because ....
animals[0] = "fish"; //mengganti elemen index ke 0
System.out.println(animals[1]); // display ... , because ....

```
**Example 5**
```java
String str  = "a b c d";
String[] splitstr = str.split(" "); //initiating array of String from method split
System.out.println(splitstr[3]);// display ... , because ....
splitstr[3] = "new"; //...

```
**Example 6**
```java
int[][] points = new int[4][4];     // array of int 2 dimension with length 4, dan wide 4 just like a chest board

System.out.println(points[0][0]);  // display ... , because ....

points[0][1] = 5;  //...
points[1] = new int[2]; //...
points[2] = {1,2,3};    //...
int[] sesuatu = {1,2,3};  //....

System.out.println(points[0][5]); // display ... , because ....

```

### ArrayList

**`ArrayList`** is a dynamic-size data elements container that behaves
similarly to array. Unlike arrays, `ArrayList` capacity can evolve as
needed and elements contained in `ArrayList` be of type reference.

To further know about **array list** look here [here](https://www.tutorialspoint.com/java/java_arraylist_class.htm)

### Let's guess the results of each code below to increase your understanding!

```java
import java.util.ArrayList;
public class Test {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>(); // Instantiate an empty ArrayList of Integer

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

## Programming Exercise: "Bingo? BINGO!"

![alt text](https://myfreebingocards.com/bingo-card-generator/results?not-random=1&img=1&title=BINGO&words=02%0D%0A04%0D%0A10%0D%0A39%0D%0A53%0D%0A29%0D%0A13%0D%0A77%0D%0A42%0D%0A55%0D%0A31%0D%0A73%0D%0A88%0D%0A69%0D%0A32%0D%0A40%0D%0A86%0D%0A30%0D%0A01%0D%0A27%0D%0A08%0D%0A49%0D%0A52%0D%0A81%0D%0A17&theme=stars-and-stripes&size=5&per-page=1&free-space-text=FREE+SPACE&s=1 "Bingo Card")

------

### What's the Story?

One day, Dek Depe was offered by Sis Dea to make a game. Dek Depe is required to
create a 5x5 size Bingo game, which has an objective to produce a straight line
of 5 numbers, either horizontally, vertically or diagonally. Dek Depe guessed
that he could build the game simply using the usual array that he just learned.
With the help of his friends who are kind and diligent, he is sure that he can
do it!

Bingo is a game on a board that has a 5x5 grid with each slot having a number.
In the game, a number will be notified at random, if the number is on your board
then the number will be marked. The game will end if someone manages to mark 5
consecutive numbers resulting in a straight line either vertically, horizontally
or diagonally.

### Class Specification

Because last week you have already studied about OOP, it is expected starting
now to get used to doing tutorial with using the OOP concept. If needed, the
main method is only used to process data or call method class that has been made.

In the course of the tutorial, you are expected to create a file named
`BingoCard.java` that contains the Java class. You may create another class if
needed. There is no limit on methods and classes you can create as long that
the following three methods exist in `BingoCard` class:

- [ ] `markNum`
- [ ] `info`
- [ ] `restart`

### Program Flow 

The program starts by reading 5 lines of string from the input. Each lines
consists of 5 numbers separated with a single whitespace and actually represent
a row of numbers in the Bingo card. After done reading the first 5 lines, the
program will continue reading input until no further input given by user.

The input given by user will be a series of commands. The following subsections
describe every possible commands.

### `MARK N`

`MARK` command will mark/cross a number `N` on the Bingo Card. Each time this
command was received and executed, the program needs to check whether a winning
condition has been achieved. Remember that a winning condition in Bingo is either:

- A vertically straight line of 5 crosses
- A horizontally straight line of 5 crosses
- A diagonal line of 5 crosses

Has been formed on the Bingo card. If the program reached winning condition, the
program must terminate and stop receiving input.


If the number is not on the card, the program will print: `N is not found on the card`
If the number is on the card and it has not been crossed, the program will print: `Crossed N`
If the number has been crossed before, the program will print: `N has been crossed`
After marking a number, when BINGO is formed then the program will print: `BINGO!`

### `INFO`

The program will print the current card condition. Crossed numbers will be replaced with `X`

Example output :

```
| 46 | 37 | 83 | 12 | 17 |
| 04 | X  | 20 | 22 | 39 |
| X  | 73 | 44 | 51 | 90 |
| 13 | 05 | 81 | X  | 55 |
| 26 | 58 | 91 | X  | 34 |
```

### `RESTART`

Repeat the game with using the same card. All the numbers that have been crossed are returned to their original state

The program will output "Mulligan!"
 
If the given command is not between the 3, the program will output the "Incorrect command"

When bingo is reached, the program will stop receiving input and issue a "BINGO!" Message and print the card's condition.

## Input Example

```
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
```

## Output Example

```
Crossed 11
Crossed 44
Crossed 64
59 is not found on the card
Crossed 27
| 10 | X  | 12 | 13 | 14 | 
| 29 | 28 | X  | 26 | 25 | 
| 31 | 33 | 35 | 37 | 39 | 
| 42 | X  | 40 | 46 | 48 | 
| 58 | X  | 71 | 82 | 99 | 
Crossed 28
44 has been crossed
Mulligan!
Crossed 44
Crossed 35
Crossed 14
Crossed 58
| 10 | 11 | 12 | 13 | X  | 
| 29 | 28 | 27 | 26 | 25 | 
| 31 | 33 | X  | 37 | 39 | 
| 42 | X  | 40 | 46 | 48 | 
| X  | 64 | 71 | 82 | 99 | 
Crossed 26
BINGO!
| 10 | 11 | 12 | 13 | X  | 
| 29 | 28 | 27 | X  | 25 | 
| 31 | 33 | X  | 37 | 39 | 
| 42 | X  | 40 | 46 | 48 | 
| X  | 64 | 71 | 82 | 99 | 
```

> Notes:

- Working on the problem, it is expected to use Arrays without ArrayList
- The numbers given are certainly unique, there will not be the same number in the card.
- The number given has a maximum of 2 digits.
- All inputs use the correct format so it is not necessary to create incorrect input handler


## Bonus Programming Exercise: "Multiplayer Bingo"

For this bonus problem, you are now expected to implement MultiPlayer Mode! Similar to the main program flow, it's just that before accepting the numbers that form your bingo board, the program will first be expected to receive 1 row with the format of a number followed by the names n times ("N Name-1 Name-2 ... Name-N "). N represents the number of players, and the Name received is the name of the player. After receiving the line the program will ask for 5 rows of numbers as usual for n times for each player.

For Input and Output there are a few modifications as well.

### `MARK N`

All players will execute MARK commands with given number `N`. However the
output only shows players who successfully crossed a number, sequentially
in the order in which the name was given. Example:

```
"Name1: Crossed N"
"Name2: N is not found on the card"
"Name3: N has been crossed”
"Name4: Crossed N"
"Name5: Crossed N"
```

### `INFO NAME`

Program will print the player name `NAME` and the card condition that belongs
to that name.

Output example:

```
NAME
| 46 | 37 | 83 | 12 | 17 |
| 04 | X  | 20 | 22 | 39 |
| X  | 73 | 44 | 51 | 90 |
| 13 | 05 | 81 | X  | 55 |
| 26 | 58 | 91 | X  | 34 |
```

### `RESTART NAME`

The function will now restore the original condition of all players, but each
player may only restart once. If the player calls the restart more than once,
the program will only display `NAME has called RESTART` without changing the
card condition.

When a player's card has reached a winning condition, then the program will
print the player's name and the card's condition and stop. (Winner can be
more than 1 person)

## Checklist

Fill in square brackets with `x` to check components

### Mandatory Components | 100 Points

- [ ] **Create class BingoCard according to the specification**
- [ ] **Perform initial setup of the game**
- [ ] **Implementing method markNum**
- [ ] **Implementing method info**
- [ ] **Implementing method restart**
- [ ] **Stop the program when the player has won and print the card's final status**

### Bonus Components | 10 Points

- [ ] **Allow more than 1 players**
- [ ] **Change method markNum**
- [ ] **Change method info**
- [ ] **Change method restart**
- [ ] **Prints the winner of the game and the condition of the card**

-----

### Woah, What is This!?

After you pushed your work, you will realise that there is a red cross or
green tick icons beside your work (commit).

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

You might have noticed that we started using Git since semester 2, following
your seniors who started using Git since semester 3. One of the benefits of
using Git is we can integrate our work (commits) history with a Continuous
Integration (CI) system.

What is Continuous Integration (CI)? To put it simply, CI is an automated
process in which every changes in a work are checked and processed according
to certain rules. For example, every commits you made will be checked by
GitLab CI system to see whether your latest tutorial code can be compiled
and produced output according to tutorial specification. If, for some reasons,
your work failed to be processed by CI system, you will be notified by the CI
system.

> All of these work of checking and running the program actually can be done by
> human (yourself, TA, or lecturer). However, human are prone to error and
> mishap so we ask a machine to automate the process. :)

It will require a separate lecture session to properly explain about CI and
concepts related to it such as build system and unit tests. At this point, you
only need to know that CI automates the process of checking and testing your
tutorial.

To see the history of your work, try clicking the **Commits** tab in the sidepanel
of your GitLab project page. It will display list of commits made by yourself and
the teaching team.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

When you press the logo, you will check the summary of the test which has two
circles. If the first circle display red cross, then your program failed due to
compile error. If the first circle display green tick but the second circle
display red cross, then your program produced different output than the
expected output. If both circles display green ticks, your program is
already correct and produced output according to the specifications.

> In case you were wondering, the circles represent stages/phases in a CI
> process. The first circle is *build stage* that contains instructions to
> compile your latest work (commit). If your work successfully compiled,
> it will be given to the next stage named *test stage* where it will be
> tested using JUnit testing framework.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

You can click the red cross or green tick icon to see more results. For
example, if you get a red cross in the second circle, you can find a second
red cross to see which test case your program is inaccurate.
