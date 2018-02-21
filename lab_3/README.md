# Tutorial 3: Recursive (Tutorial Problem)

CSGE601021 Programming Foundations 2 @ Faculty of Computer Science Universitas
Indonesia, Term 2 2017/2018

**Created by DS | KD**

* * *

In the previous tutorial, you have learned about Java programming concepts and
various data operations in Java. You have also mentioned a little material about
the method (return on the branching statement). This time, you will learn more
about method, and a function that is called a recursive method.

If you want to skip directly to the tutorial programming exercise, you may proceed
to tutorial section. Otherwise, please follow through the review notes that has
been prepared by TA.

## Learning Objectives

1. Understand how to create **method** in Java
2. Understand the concept of **recursive method**

### Before You Start...

1. Do `git pull upstream master` by using the command prompt/shell at your local
repository folder
2. Implement your code according to the specifications written in this document
and put the Java file in `lab_3/src/main/java` directory
3. After you finish implementing your code, add, commit, then push your code.

## Tutorial Materials

### Methods in Java

In Programming Foundation 1, you have learned how to define a function using
Python. The definition of a function in Java is similar to the definition of a
function in Python, only we have to define the function parameter data type,
and the data type to be returned by that function.

> If we want to be more pedantic, there are differences between function and
> method. Can you guess what the differences are?

In Python:

```python
def add(number1, number2):
    return number1 + number2
```

In Java:

```Java
public static int add(int number1, int number2){
    return number1 + number2;
}
```

> Note: To call a method in main method's block, the method must have `static`
> keyword as well. It will be discussed more deeply in the next tutorial.

### Recursive Method

In this tutorial, you will learn a function called the recursive method. A function
can be said to be recursive if the function calls itself. Usually a recursive
function is used to solve problems that can be reduced to a smaller identical problem.

One example is to calculate the factorial of a number. Notice the following figure:

![alt text](https://i.imgur.com/hriRLZ7.png "Ilustrasi faktorial")

Do you see a pattern? The above factorial function is called four times, with
the parameter becomes smaller. We can conclude that in the factorial function
(n), it will be called the factorial function (n-1) until it completes. In
order for recursive function to not continue non-stop, we need a base or base
case that does not use a recursive call, or does not invoke the recursive
function again. Consider the following code example:

```java
int factorial(int number){
    if (number <= 1) {                 //base
        return 1;
    }
    else {                             //recurrence
        return number * factorial(number - 1);
    }
}
```

Basically, the recursive function can be divided into bases and recurrences. In
the code above, the base case of the function is if the parameter number is a
number less than or equal to one, because 1! = 1, and 0! = 1 (assuming the
input is not negative, because the negative factorial is undefined). This base
case does not use a recursive call because it aims to stop recursive calls if
they occur.

As for recurrence, the above function returns the value of the number itself
multiplied by the function call back, but the parameter becomes number-1. The
value at which the next call will narrow to closing to the base. The factorial
call (4) will return a value of 4 multiplied by the factorial (3), which will
return a value of 3 times by factorial (2), to factorial base (1).

### Let's do this!?

Before we get into the tutorial problem, we will warm up first. For each question, look for the *base case* and *recurrence*

1. A function that has an output that count backwords from n to 1

    ```
    n = 5
    Output:
    5
    4
    3
    2
    1
    ```

2. A function that calculates the nth Fibonacci number (the nth Fibonacci number is the sum of the two previous numbers)

    ```
    fibonacci(6)
    Output:
    13
    ```

3. A function that input the char ‘*’ in between every letter in a string. 

    ```
    masukkanBintang(“depechan”)
    Output:
    d*e*p*e*c*h*a*n
    ```


## Tutorial: "Kak Pewe's Rabbit House"

![alt text](https://i.imgur.com/vdT6fB9.png "Gambar Rabbit House")

------

**WARNING** For this tutorial, it is forbidden to use loop (for, while, etc.)

------

### What's the Story?

Thanks to your help and Dek Depe last week, Kak Pewe's job as a Tamfir Province survey officer has been done very well. As a thank you, Kak Pewe invited you and Dek Depe to visit the Rabbit House Tamfir Province managed by Kak Pewe. "Rabbit House is not just a cafe for coffee, but also a home that can speed up the breeding of rabbits!" said Kak Pewe.

The rabbit house has several rules:
1. Kak Pewe will activate the house by entering a rabbit with a name.
2. The rabbit will breed once, producing rabbits that are every permutation of an adult rabbit's name which has omitted one letter.
3. Each new rabbit will immediately reproduce again according to rule number 2.
4. Each rabbit will breed once. If it has multiplied, it can not breed again. New rabbits will continue to breed until no new rabbits can breed again (one-lettered rabbits can not breed anymore).

Example:
Suppose Kak Pewe put a rabbit named **PEWEW** into the Rabbit House. The rabbit will breed five rabbits: **EWEW**, **PWEW**, **PEEW**, **PEWW**, and **PEWE**.
The four rabbits will breed again. A rabbit named **EWEW** will breed and produce four rabbits: **WEW**, **EEW**, **EWW**, and **EWE**. This will happen until all rabbits can not breed (if a rabbit has a 1-letter long name, it can not breed).

Dek Depe is very curious, and wanted to know how many rabbits are in the Rabbit House after a single rabbit has been put. He asks you as his friend who has learned about the recursive method to implement a recursive program that can calculate how many rabbits will be produced if a single rabbit has been put into the Rabbit House.

### Program Specifications

The name your program **must** be RabbitHouse.java

Your program will receive **one** line of input, which contained **two command** which are String, that are seperated by a space. The first command contains the type of mode that it recieved. For compulsory task, the first command will always be **normal**. The second command is the rabbit name in String. The String name of the rabbit will not be longer than **ten letter**.

Output is the total rabbit after all of the rabbit have finished breeding. 

Input example 1:

>normal PEWEW 

Output example 1:

>206 

Explenation:

At first there is one rabbit name PEWEW. The rabbit PEWEW produce 5 rabbit.  **(1 X 5 = 5)**  
Each of  the 5 rabbits yields 4 rabbits. **(5 X 4 = 20)**  
Each of the 20 yields 3 rabbit **(20 x 3 = 60)**  
Each of the 60 yields 2 rabbit **(60 x 2 = 120)**  

Until 120 + 60 + 20 + 5 + 1 (the Pewew) = 206

Input example 2:

>normal A

Output example 2:

>1

## Bonus Tutorial: "Palindrome Problem"

------
For the bonus task, there is no restriction. Looping is allowed.

------

### What's the Story?

You have successfully created a program that can count the number of rabbits in the Rabbit House. However, Kak Pewe says that there is a rare disease in rabbit, the Palindromitis disease. This disease is a genetic disease. That means all the offspring of a Palindromitis rabbit will have the disease as well.

If the name of a rabbit affected by Palindromitis is a palindrome, then the rabbit will die. Palindrom is a word that if read from the front or back, like "ADA" or "MAKAM" is the same.
Your task now is to add conditions to your program above in order to meet the conditions if the rabbit has the Palindromitis disease.

Example:
Kak Pewe put a single rabit that has the Palindromitis named **PEWEW** into the Rabbit House. Since **PEWEW** is not a palindrome, that rabbit will breed and will produce 4 rabbits which are : **EWEW**, **PWEW**, **PEEW**, **PEWW**, and **PEWE**. 
The four names of the rabbits are not a palindrome, thus the four rabbit will continue to breed. The rabbit named **EWEW** will breed and produce four rabbits: **WEW**, **EEW**, **EWW**, **EWE**.
**WEW** and **EWE** are palindrome, thus the two rabbit will die. **EEW** and **EWW** are not palindrome, hence the two rabbits will live and continue to breed.

### Program Specifications

If you remember, your program will recieve two **command** : the mode type and the rabbit name.

If you put *palindrom* to the first command, your program must apply the palindrome rules.

Input example *palindrom* 1:

> palindrom PEWEW

Output example *palindrom* 1:

> 62

Input example *palindrom* 2:

> palindrom A

Output example *palindrom* 2:

> 0

## Checklist
Fill in the square brackets with x to check the components.
### Required Component | 100 Poin
- [ ] **Ask input from the user**
- [ ] **Validate the input**
- [ ] **Make a recursive function that count the total amount of rabbits**
- [ ] **Calls the function in the main method and print the results in the console**

###  Bonus Component | 10 Poin
- [ ] **Make a condition for the rabbit that has a palindrome name**
- [ ] **Set the function to run if the input receives a "palindrom" String before the rabbit name**

-----
### **Woah, what is this!?**

After you have pushed your work, you will relised that there is a red cross logo or green check beside your work.

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

You may notice that we started using the git system since semester 2, following your older generation who started using the git system since semester 3. One of the uses of using git is that we can use the Continuos Integration feature.

What is Continuous Integration? Continuos Integration is a concept in which when you push, the results of your push will directly be build (compile) and be tested (direct test). If it fails, you will be notified.

The new Build section will be explained in the Advanced Programming course. You just need to know the test section.

The system used to test in Java is named JUnit. We can use the JUnit framework to test directly (without having to print in the command line). For now, you do not need to know how JUnit works.

You can check Junit's work on the Commit tab. Press the green or cross red check logo to check for more details.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

When you press the logo, you will check the summary of the test which has two circles.

If the first circle is cross, then your program fails due to compile error.
If the first circle ticks green but the second circle is cross, then your program is not accurate.
If both circles tick, your program is good.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

You can press the red cross button or check green to see more results. For example, if you get a red cross in the second circle, you can find a second red cross to see which test case your program is inaccurate.
