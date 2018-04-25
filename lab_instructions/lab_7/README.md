# **Tutorial 7: Inheritance (Tutorial Problem)**

CSGE601021 Programming Foundations 2| Faculty of Computer Science Universitas
Indonesia, Term 2 2017/2018

**Created by AE | INT**

* * *
Pada tutorial sebelumnya, Anda telah mempelajari mengenai konsep *cohesion* dan *coupling*, pada tutorial kali ini kita akan membahas lebih dalam lagi mengenai konsep OO khususnya **inheritance**.
In the previous tutorial you have learned about the concept of *cohesion* and *coupling*, in this tutorial we will discuss in depth more about the concept of OO in particular **inheritance**.
## **Learning Objectives**
1. Understand the *concept of inheritance*
2. Able to implement the concept of *inheritance* using Java language.

### **Before You Start...**
1. Do `git pull upstream master` by using the command prompt/shell at your local repository folder
2. Implement your code according to the specifications written in this document and put the Java file in `lab_7/src/main/java`. We have provided an empty folder for you.
3. After you finish implementing your code, add, commit, then push your code

## **Tutorial Materialsl**

### **What is inheritance**
**Inheritance** can be defined as a process in which a class requires a
property (method or attribute) of another class. The use of inheritance of data information
can be managed in a hierarchical structure.
A class that inherits properties from other classes is known as a subclass and a class
is inherited is known as superclass.

#### **Example of Inheritance**
Let's try to implement inheritance in the following simple program
```java
interface HitungBangunDatar {
    void hitungLuas();

    void hitungKeliling();
}

public class ProgramBangunDatar {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(4);
        PersegiPanjang persegiPanjang = new PersegiPanjang(4, 2);
        persegi.hitungLuas();
        persegiPanjang.hitungLuas();
        persegi.hitungKeliling();
        persegiPanjang.hitungKeliling();
    }
}

class BangunDatar implements HitungBangunDatar {
    int hasil;

    public void hitungLuas() {
    }

    public void hitungKeliling() {
    }
}

class Persegi extends BangunDatar {
    int x;

    public Persegi(int x) {
        this.x = x;
    }

    public void hitungLuas() {
        hasil = x * x;
        System.out.println("Luas dari persegi adalah: " + hasil);
    }

    public void hitungKeliling() {
        hasil = x * 4;
        System.out.println("Keliling dari persegi adalah: " + hasil);
    }
}

class PersegiPanjang extends BangunDatar {
    int x, y;

    public PersegiPanjang(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void hitungLuas() {
        hasil = x * y;
        System.out.println("Luas dari persegi panjang adalah: " + hasil);
    }

    public void hitungKeliling() {
        hasil = (2 * x) + (2 * y);
        System.out.println("Keliling dari persegi panjang adalah: " + hasil);
    }
}


```
Note that the Persegi class and *PersegiPanjang* (subclass) inherit the class *BangunDatar*
(superclass), and retrieves the result attribute and method hitungKeliling() and hitungLuas() from
its superclass. The subclass is able to inherit by using the keyword `extends`.
We can also call the superclass method or take the superclass attribute through a
subclass by using the `super` keyword. Please make the following code, and try it out.

```java
# Reference: https://www.tutorialspoint.com/java/java_inheritance.htm
class Super_class {
    int num = 20;
    // display method of superclass
    public void display() {
        System.out.println("This is the display method of superclass");
    }
}

public class Sub_class extends Super_class {
    int num = 10;
    // display method of sub class
    public void display() {
        System.out.println("This is the display method of subclass");
    }
    public void my_method() {
        // Instantiating subclass
        Sub_class sub = new Sub_class();
        // Invoking the display() method of sub class
        sub.display();
        // Invoking the display() method of superclass
        super.display();
        // printing the value of variable num of subclass
        System.out.println("value of the variable named num in sub class:"+ sub.num);
        // printing the value of variable num of superclass
        System.out.println("value of the variable named num in super class:"+ super.num);
    }
    public static void main(String args[]) {
        Sub_class obj = new Sub_class();
        obj.my_method();
    }
}

```
In addition to calling the method from the superclass, we can also construct the superclass with
using the 'super' method in the subclass constructor. Please create a program like below:

```java
class Superclass {
    int age;
    
    Superclass(int age) {
        this.age = age;
    }
    public void getAge() {
        System.out.println("The value of the variable named age in super class is: " +age);
    }
}

public class Subclass extends Superclass {
    Subclass(int age) {
        super(age);
    }
    public static void main(String argd[]) {
        Subclass s = new Subclass(24);
        s.getAge();
    }
}
```
Perhatikan kembali bahwa method super pada constructor kelas *Subclass* digunakan untuk
meng-construct kelas *Superclass*. Ini sangat berguna ketika superclass mempunyai semua atribut
yang ada di subclass sehingga kita hanya perlu memanggil method super.
Dan terakhir, kita juga dapat mengecek apakah suatu kelas merupakan instance dari kelas yang
lain dengan memakai keyword `instanceof`. Silahkan Implements program sederhana
berikut untuk lebih memahami fungsionalitas instanceof

Notice again that the super method in class constructor *Subclass* is used to
construct the class *Superclass*. This is very useful when the superclass has all the attributes
that is in the subclass so we just need to call the super method.
Lastly, we can also check if a class is an instance of the class
by using the `instanceof` keyword. Please implement a simple program
below to better understand the instanceof functionality

```java
# Reference: https://www.tutorialspoint.com/java/java_inheritance.htm
interface Animal{}
class Mammal implements Animal{}
public class Dog extends Mammal {
    public static void main(String args[]) {
        Mammal m = new Mammal();
        Dog d = new Dog();
        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        System.out.println(d instanceof Animal); 
    }
}

```
Note that the output of the program will be as follows:

true

true

true

It shows that m is an instance of the Animal class, and d is a
instance of the Mammal and Animal classes. Keyword instance is very useful to know
whether a class extends a class or implements an interface.

## **Soal Tutorial: To Eat Or To Be Eaten**

### **What's the story?**
One day Dek Depe was playing a game and feeling hungry. Amid the dilemma to continue his game or to eat, Dek Depe gets an idea to make a game where all players can eat their dead opponents to get additional HPs. However, since Dek Depe did not make a prototype for this idea because he has to eat, he asked the free workers, ehm, the Programming Foundation 2 Students who are kind and helpful to complete this work.
***
This game has 2 types of players, monster and human. Both have the same HP, name, and diet. Diet is all Player that has been eaten by the player during the game. Monster can eat humans and fellow dead monster. But humans can only eat burned monster.
Ordinary humans can not burn the monster until they are cooked, but there are people who have special abilities which are the magician, magician are human who can use the move `burn` instead of just` attack` like ordinary humans. `burn` is the same as the usual` attack`, but if the monster dies due to a `burn` attack or when `burn` is directed to a monster's body then the monster will mature so it is safe for human to eat it.

There are at least 4 classes that must be implemented using the inherent concept which are:

#### Player

The player has attributes `name`,` hp`, and `diet` . All players can attack and eat with `attack` and` eat`. `attack` will reduce the enemy HP number **10**, while` eat` will eat player that is edible and get additional **15** `hp`. The player can also show `diet` and` status`. Where the `diet` returns players who have been eaten by the player. `status` will show the type of player (whether he is a human being, a monster or a wizard), his name, HP and the 'diet` information. If it dies due to the `burn` Magician, or after being exposed to `burn`, Player will mature.

**player is dead when the hp becomes 0, the minimum value of hp is 0. So when a player is attacked and its hp value becomes < 0, the stored hp remains 0.**

#### Human

Human can only eat matured monster. But Human can not do `roar` like a monster

#### Monster

Monster can eat anything that's dead. Monster can also do `roar`. `roar` from monsters is determined when monsters are added to the game. But if `roar` is not specificated, use default" AAAAAAaaaAAAAAaaaAAAAAA ". Monster has 2x hp of the assigned hp.

#### Magician

What is the meaning of RPG without Magician? Magician in this game **is a `human`** who has a special ability named `burn` who can attack and cook the Player he targets. **Damage from burn is 10**. Players who die from `burn` damage or Player who is already died and get hit by `burn` will mature. **Magician recieve 2x damage when it becomes a `target` from `attack` and `burn` method**

#### Some Rules
1. A name must be unique for the entire player. Even when it's dead.
2. The player is removed from the game when it is eaten. **The player's name is considered invalid for command eat, attack, burn, diet, status, remove, roar. However it is valid for command add**
3. Minimum HP is 0
4. The dead player can not do anything other than willingly waiting to be eaten
5. The dead player can still be attacked.
6. **For validation of method name eat, attack and burn, simply remove "Thre is no (Player) or (target)"**
7. **For validation of method of diet, status, remove, roar, simply output "There is no (Player)"**
8. **The dead player can not eat, attack, burn. Print "(Player) can not (eat/attack/burn) (target)"**
9. **Command `diet()` will print all players that has been eaten. Print `diet()` contains `diet` attributes of all players. The sequence begins printing the `diet` attribute starting from the player who entered the game from the beginning**
10. **canEat() in test is a method that must be implemented throughout the player, indicating whether a player can eat pther player or not**
11. **Character changed to Player to be consistent with template**

#### Some example output command

System.out.println(game1.add("Almarhum", "Human", 0)); 

//Almarhum is added to the game

System.out.println(game1.add("Fooder", "Monster", 0)); 

//Fooder is added to the game

System.out.println(game1.add("Mons", "Monster", 50)); 

//Mons is added to the game

System.out.println(game1.eat("Mons", "Fooder")); 

//Mons is eating Fooder

//Mons now have 65 HP

System.out.println(game1.eat("Mons", "Almarhum")); 

//Mons is eating Almarhum

//Mons now have 80 HP

System.out.println(game1.diet("Mons"));

//Human Almarhum, Monster Fooder

System.out.println(game1.status("Mons"));

// Monster Mons

// HP: 105

// Alive

// Ate Human Almarhum, Monster Fooder

**Another example**

game1.add("Fooder", "Monster", 0);

game1.add("Makan", "Monster", 10);

game1.add("Lapar", "Monster", 10);

game1.eat("Makan", "Fooder");

game1.attack("Mons")

System.out.println(game1.diet()); 

//Has been eaten : Human Almarhum, Monster Fooder, Monster Fooder

**for another example, read from the link below** 

[Lab7.java](https://gitlab.com/DDP2-CSUI/ddp-lab/blob/master/lab_7/src/main/java/Lab7.java "Lab7.java")

The 2 things below will not be testedm but to make it complete:

** If printing diet() when nothing has been eaten. Print "Nothing has been eaten" **

**If printing status() when there is no player. Print "There are no players"**

#### Bonus

1. Create a methode in `game` with name `printMenu` and print **[Tree](https://en.wikipedia.org/wiki/Tree_(data_structure))** from `diet` attribute for every player still is in the game (not yet removed or eaten). Player that is still in the game will be the root of the tree, and the Player has been eaten as the node. (the format for printinf Tree is free)
Contoh:

B Eat D

B Eat C

A Eat B

Thus the tree (Printing does not need to follow this format)

---A

---B

-C---D

## Checklist

Fill in square brackets with `x` to check components

### Mandatory Components | 100 Poin

- [ ] **Implement classes that was asked (you are allowed to implement more than that was asked)**
- [ ] **Implement attributes that suits to each class**
- [ ] **Implement every method according to the needs of the problem
**

### Bonus Components | 10 Poin

- [ ] **Implement `printMenu` that prints Tree from `diet` attribute of Players that are still alive**

### **Woah, What is This!?**

After you pushed your work, you will realise that there is a red cross or green tick icons beside your work (commit).

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

You might have noticed that we started using Git since semester 2, following your seniors who started using Git since semester 3. One of the benefits of using Git is we can integrate our work (commits) history with a Continuous Integration (CI) system.

What is Continuous Integration (CI)? To put it simply, CI is an automated process in which every changes in a work are checked and processed according to certain rules. For example, every commits you made will be checked by GitLab CI system to see whether your latest tutorial code can be compiled and produced output according to tutorial specification. If, for some reasons, your work failed to be processed by CI system, you will be notified by the CI system.

It will require a separate lecture session to properly explain about CI and concepts related to it such as build system and unit tests. At this point, you only need to know that CI automates the process of checking and testing your tutorial.

To see the history of your work, try clicking the **Commits** tab in the sidepanel of your GitLab project page. It will display list of commits made by yourself and the teaching team.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

When you press the logo, you will check the summary of the test which has two circles. If the first circle display red cross, then your program failed due to compile error. If the first circle display green tick but the second circle display red cross, then your program produced different output than the expected output. If both circles display green ticks, your program is already correct and produced output according to the specifications.

In case you were wondering, the circles represent stages/phases in a CI process. The first circle is *build stage* that contains instructions to compile your latest work (commit). If your work successfully compiled, it will be given to the next stage named *test stage* where it will be tested using JUnit testing framework.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

You can click the red cross or green tick icon to see more results. For example, if you get a red cross in the second circle, you can find a second red cross to see which test case your program is inaccurate.
