# Tutorial 6: OO Case Study (Tutorial Problem)

CSGE601021 Programming Foundations 2 @ Faculty of Computer Science Universitas
Indonesia, Term 2 2017/2018

**Created by JIA | RF**

* * *

You have learned on how to use array during the previous tutorial. That means
you have added another programming concept into your OO toolbelt. Cool! You
are getting more ready to develop more OO-based programs!

Now in this tutorial, you will learn about *cohesion* and *coupling* as
measures in determining how good a class is designed in OO programming.

## Learning Objectives

1. Understand the definition of *cohesion*
2. Understand the definition of *coupling*
3. Understanding why *cohesion* in designing a class is important
4. Understanding why *coupling* in designing a class is important

### Before You Start...

1. Do `git pull upstream master` by using the command prompt/shell at your
local repository folder
2. Implement your code according to the specifications written in this document
and put the Java file in `lab_6/src/main/java` directory
instead of `Lab6.java`
3. After you finish implementing your code, add, commit, then push your code

## Tutorial Materials

### What is Cohesion

*Cohesion* is the presence of "focus" level in a *class*; or how focused a
*class* represents an object/concept. The advantage of developing with
high *cohesion* is the convenience for both the user and us to understand the
*class* better. In addition, in program development, we want *classes* for a
specific purposes. In order to achieve a high *cohesion*, all methods and
variables within the *class* should represent only an object/concept instead
of another.

For example, the `Car` class only contains the necessities of a car. If we
want to add a feature to buy a car, add the feature in a **new class that is
responsible to purchase a car** not in the `Car` class itself. Design a
good program that has a high *cohesion* program.

#### Example of Low Cohesion

-------------------
| Staff           |
-------------------
| checkEmail()    |
| sendEmail()     |
| emailValidate() |
| printLetter()   |
-------------------

#### Example of High Cohesion
----------------------------
| Staff                   |
----------------------------
| -salary                 |
| -emailAddr              |
----------------------------
| setSalary(newSalary)    |
| getSalary()             |
| setEmailAddr(newEmail)  |
| getEmailAddr()          |
----------------------------

> Source: https://stackoverflow.com/questions/3085285/cohesion-coupling

### What is Coupling

Coupling is the level of relevance of a *class* to other *classes*. *Class* A is
considered to be related to *class* B if:

- B is stored as a variable in A
- B is a method parameter in A
- B represents the return type method in A

When *class* A corresponds to *class* B, there are some consequences:

- When we need *class* A, we have to include *class* B
- When we modify *class* B, we may have to modify *class* A as well

Strive for designing a good program that has a low *coupling* level

#### Example of Tight Coupling

```java
class Names {
	public String name;
	
	public String getName() {
        // Some additional logic involved in `name` accessor
		return name;
	}
	
	public void setName(String s) {
        // Some additional logic involved in modifying `name`
		name=s;
	}
}

class ModifyData {
	public void updateName() {
		Name ob = new Name();
		ob.name="Hello"; // Directly accessing name with dot operator shows tight coupling between two classes
		System.out.println(ob.name); // Tight coupling because of bad encapsulation
	}
}
```

Program Analysis:

- *Class Name* has  an *instance variable*, name; which is declared **public**
- *Class Name* has 2 *public method* *getter, setter* which validates access to variable name before *getting* or *setting* variable.
- *Class ModifyData* has *method* **updateName()**, which creates an object from *class* Name and accesses its instance variable directly with the dot operator, since the variable is declared **public**
- Therefore, *method* **getName()** and **setName()** are never called and their security access check is bypassed. It shows that *class* Name *is tighly coupled* with *class* **ModifyData**. This is an ugly program design

#### Example of Loose Coupling

```java
class Names {
	private String name;
	
	public String getName() {
        // Some additional logic involved in `name` accessor
		return name;
	}
	
	public void setName(String s) {
        // Some additional logic involved in modifying `name`
		name=s;
	}
}

class ModifyData{

	public void updateName() {
		Name ob = new Name();
		ob.setName("Howard");
		ob.getName();
	}
}
```

Program Analysis:

- *Class* **Name** has an instance variable, name; which is declared **private**.
- *Class Name* has 2 *public method* *getter, setter* which validates access to variable name before *getting* or *setting* variable.
- *Class* **ModifyData** has *method* **updateName()**, which creates an object from *class* Name, then it calls *method* **getName()** and **setName()** from *class* Name.
- Because *method* **getName()** and **setName()** of *class* Name are called and checked before the instance variable is *get* or *set*. This shows that *class* **Name** *loose coupling* against *class* **ModifyData**, which is a good program design.

> Source: https://www.decodejava.com/coupling-cohesion-java.htm

## Programming Exercise: "Business in Cinemas"

### What's the story?

After adventuring to help Kak Pewe breed his rabbits in the RabbitHouse, make PEPERAS for Pak PeEl, and create a Bingo game with Sis Dea, this time Dek Depe is offered by Koh Mas to design a ticketing system for cinema. Incidentally Dek Depe has a hobby to watch movie,thus without thinking about it Depe Dek directly approved it. Because the Dek Depe knows he can not finish this job alone, he calls his trust team, JAVAvengers, which consists of you as a powerful Programming Foundation 2 programmer.

* * *

Here is a basic request from Koh Mas to Dek Depe:

This program simulates the ticketing system at the cinemas owned by Koh Mas. There are at least 4 programs that you must make (you are freed to make more than requested if there is a need). The four programs are programs that represent **movies, movie tickets, cinemas, and customers**.

#### Film

The movie has attribute title, age rating (consisting of <span style="color:blue"> "General" </span> for all ages, <span style="color:blue"> "Teenager" </span> for age at least 13 years old, and <span style="color:blue"> "Adult" </span> for a minimum age of 17), movie genre, duration in minutes, and status whether the films are **local or import**. This program can return results of detailed movie information in the following format:
```
------------------------------------------------------------------ 
Title 		: <Movie Title>
Genre 		: <Genre Name>
Duration 	: <Number> minutes
Rating 		: <General/Teenager/Adult>
Type 		: <Local/Import>
------------------------------------------------------------------
```
#### Ticket

Next is the ticket. Ticket has a specification in the form of film, showtimes (day), status whether ordinary tickets or 3 dimensions. The program also has a **standard ticket price of 60000 Rupiah**. This program can also calculate the ticket price where the ticket price will **increase by 40000** if the ticket is for **Saturday or Sunday**. If the ticket is a **3 Dimensional** type ticket, then the ticket price is **20 percent** more expensive than regular tickets. The program can also print information about tickets with the format:
```
------------------------------------------------------------------ 
Movies 		: <Movie Title>
Showtimes 	: <Day>
Type 		: <Normal/3 Dimensions>
------------------------------------------------------------------
```

#### Cinema

The Cinema program has the name of the cinema, the list of movies owned, the list of available movie tickets, and the beginning cash balance of the cinema. In addition the program can also save the **total** amount of revenue from all cinemas combined. With this program, customers can purchase tickets with movie title information, movie schedules (days), and the choose whether the movie is shown in 3 Dimensions or 2 Dimensions. The program can also display the list of movies it owns and refill the ticket list with new tickets. The program can also print short information with the format:

```
------------------------------------------------------------------ 
Cinema 							: <Cinema name>
Cash Balance 					: <Total balance>
Number of tickets available 	: <Number of tickets>
Movie list available 			: <Movie-1>, <Movie-2>, ..., <Movie-N>
------------------------------------------------------------------
```

Koh Mas also wants the program to print the amount of cash balance from each cinema and the combined balance of everything. Here's the preferred print format:

```
Koh Mas's total money: Rp. <Amount of revenue>
------------------------------------------------------------------
Cinema 			: <Cinema Name-1>
Cash Balance 	: Rp. <Balance-1>

Cinema 			: <Cinema Name-2>
Cash Balance 	: Rp. <Balance-2>

...

Cinema 			: <Cinema Name-N>
Cash Balance 	: Rp. <Balance-N>
------------------------------------------------------------------
``` 

#### Customer

Lastly is the program that represents the customer. Customer data to keep in mind are name, age, and gender. Customers can purchase tickets at the cinema he wants.
- After successfully purchasing tickets, the program will print <pre>`<Customer's name> has purchased tickets for <Movie Name> type <Ordinary/3 Dimensions> at <Cinema> on <Day> for Rp.<Ticket price> `</pre>
- If the ticket that the customer wants to buy does not exist in the cinema, then print <pre> `Tickets for the movie <Movie Title> type <Ordinary/3 Dimension> on <Day> are not available in <Cinema Name>` </pre>
- Please note also, if the age is not according to the provisions, then print <pre> `<Customer Name> is not old enough to watch <movie title>` </pre>
- Customers can also view detailed information of a movie in the theaters that he chooses in accordance with the [format] (#### Film) mentioned above. If the movie is not in the movies, then print <pre> `Movie <Movie Title> searched by <Customer Name> is not in the cinema <Cinema Name>` </pre>

## Expexted Output

Here is the expected output when the main program is run:

```
------------------------------------------------------------------
Cinema 						: CGT Blitz
Cash Balance 				: 0
Number of tickets available : 12
List of Movie available 	: Black Panther, Dilan 1990, The Greatest Showman, Si Juki The Movie
------------------------------------------------------------------
------------------------------------------------------------------
Cinema 						: CompFest XXI
Cash Balance 				: 25000
Number of tickets available : 12
List of Movie available  	: Black Panther, Dilan 1990
------------------------------------------------------------------
Tickets for the movie Black Panther type 3 Dimension on Monday are not available at CGT Blitz
Dek Depe has purchased tickets for The Greatest Showman types 3 Dimensions at CGT Blitz on Tuesday for Rp.72000
Movie Si Juki The Movie searched by Sis Dea is not in the cinema CompFest XXI
Movie <Movie Title> searched by <Customer Name> is not in cinema <Cinema Name>`
------------------------------------------------------------------
Title 		: Dilan 1990
Genre 		: Romantic / Drama
Duration 	: 110 minutes
Rating 		: Teenagers
Type 		: Local Movie
------------------------------------------------------------------
Tickets for the movie Dilan 1990 type Ordinary on Tuesday are not available in CompFest XXI
Sis Dea has purchased tickets for Dilan 1990 type Ordinary at CompFest XXI on Saturday for Rp.100000
Kak Pewe has purchased Si Juki's The Movie type Types at CGT Blitz on Thursday for Rp.60000
Kak Pewe has purchased Black Panther type 3 Dimensions at CompFest XXI on Saturday for Rp.120000
Koh Mas's total money: Rp. 377000
------------------------------------------------------------------
Cinema 			: CGT Blitz
Cash Balance-N 	: Rp.132000

Cinema 			: CompFest XXI
Cash Balance 	: Rp.245000

------------------------------------------------------------------
```

Please implement the programs according to the specifications. **The main program
for running all 4 subprograms are available in `lab_6` directory.** Pay attention
to how the classes and methods are named in the main program (`Lab6.java`).

## Bonus Question: "I want a refund!"

### What's the story?

In order to provide the best service for its customers, Koh Mas makes a policy whereby customers can cancel **tickets that are most recently purchased** but have not been used. The returned ticket does not have to be from the same cinema when he bought the tickets. Ticket prices will also be refunded even though Koh Mas movie revenues should be reduced.

After successfully restored, print <pre> `Movie Ticket <Movie title> on <day> type <Ordinary/3 Dimensions> has been returned to cinema <Cinema name>` </pre>
- But if the movie on the ticket is not on the movie list available in the cinema, then print <pre> `Sorry tickets can not be refunded, <Movie title> is not available in <Cinema name>` </pre>
- If the movie ticket is already in use, then print <pre> `Ticket can not be refunded because movie <Movie title> has been watched by <Customer Name>` </pre>
- If the balance of a cinema is not sufficient to refund the ticket money, then print <pre> `Sorry tickets can not be refunded, cash in the cinema <Cinema name> is not sufficient` </pre>

In addition, there is a `watchMovie` method with parameter ticket for the movie that will be watched. When a customer has used his ticket to watch a movie, the program will print:
`<Customer Name> has watched the movie <Movie Title>`


**Hint**: In the Movie program it is necessary to implement its own `equal` feature in order to check the movie tickets that will be returned the same as the movies available in the cinema. (Find out about overriding method)

## Output Example 

Here is an example of the expected output if the main program for which the bonus section is run:

```
Movie Ticket Black Panther with Saturday time type 3 Dimensions has been returned to cinema CGT Blitz 
Sorry tickets can not be refunded, Si Juki The Movie is not available in CompFest XXI
Kak Pewe has watched the movie Si Juki The Movie
Ticket can not be refunded because the movie Si Juki The Movie has been watched by Kak Pewe
Sorry tickets can not be refunded, cash in the cinema <Cinema name> is not sufficient
Koh Mas's total money: Rp. 257000
------------------------------------------------------------------
Cinema 			: CGT Blitz
Cash Balance 	: Rp. 12000

Cinema 			: CompFest XXI
Cash Balance 	: Rp. 245000

------------------------------------------------------------------

```

## Checklist

Fill in square brackets with `x` to check components

### Mandatory Components | 100 Points
- [ ] **Implements the requested objects (may implement more than requested)**
- [ ] **Implement appropriate attributes on each object**
- [ ] **Implement every method according to Koh Mas**
- [ ] **Save all programs besides the main program in a separate package**

### Bonus Components | 10 Points
- [ ] **Creates ticket cancellation function (may add a helper method if feels necessary)**
- [ ] **Creates watchMovie() method for customer to indicate the tickets have been used**
- [ ] **Creates the `equals` function to check the similarity of two movies**


-----
### **Woah, What is This!?**

After you pushed your work, you will realise that there is a red cross or green tick icons beside your work (commit)

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

After you pushed your work, you will realise that there is a red cross or green tick icons beside your work (commit).

![alt text](https://i.imgur.com/ZNfetmP.png "Ilustrasi git 1")

You might have noticed that we started using Git since semester 2, following your seniors who started using Git since semester 3. One of the benefits of using Git is we can integrate our work (commits) history with a Continuous Integration (CI) system.

What is Continuous Integration (CI)? To put it simply, CI is an automated process in which every changes in a work are checked and processed according to certain rules. For example, every commits you made will be checked by GitLab CI system to see whether your latest tutorial code can be compiled and produced output according to tutorial specification. If, for some reasons, your work failed to be processed by CI system, you will be notified by the CI system.

> All of these work of checking and running the program actually can be done by
> human (yourself, TA, or lecturer). However, human are prone to error and
> mishap so we ask a machine to automate the process. :)

It will require a separate lecture session to properly explain about CI and concepts related to it such as build system and unit tests. At this point, you only need to know that CI automates the process of checking and testing your tutorial.

To see the history of your work, try clicking the **Commits** tab in the sidepanel of your GitLab project page. It will display list of commits made by yourself and the teaching team.

![alt text](https://i.imgur.com/E23AOfl.png "Ilustrasi commit")

When you press the logo, you will check the summary of the test which has two circles. If the first circle display red cross, then your program failed due to compile error. If the first circle display green tick but the second circle display red cross, then your program produced different output than the expected output. If both circles display green ticks, your program is already correct and produced output according to the specifications.

> In case you were wondering, the circles represent stages/phases in a CI
> process. The first circle is *build stage* that contains instructions to
> compile your latest work (commit). If your work successfully compiled,
> it will be given to the next stage named *test stage* where it will be
> tested using JUnit testing framework.

![alt text](https://i.imgur.com/1ElduFi.png "Ilustrasi status")

You can click the red cross or green tick icon to see more results. For example, if you get a red cross in the second circle, you can find a second red cross to see which test case your program is inaccurate.
