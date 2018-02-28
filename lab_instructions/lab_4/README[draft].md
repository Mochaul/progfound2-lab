Tutorial 4: Intro to OOP (Tutorial Problem)


Programming Foundation 2 - CSGE601021 | Faculty of Computer Science, Universitas Indonesia, Term 2 2017/2018

Created by KK | MF




In the previous tutorial, you have learned about the concept of recursive in Java. You have also learned a bit about methods (return function on the branching statement). This time, you will learn more about method, static keyword, overloading and class design (intro to OOP).


Learning Objectives




Understand the concept of static keyword.
Understand the concept of overloading.
Understand the concept of encapsulation.
Understand how to design a class in Java.



Before You Start...



Do a git pull upstream master by using the Command Prompt/Shell at your local repository folder.
Implement your code according to the specifications written in this document and put the Java file in lab_4/src/main/java directory.
After you finish implementing your code, add, commit, then push your code.


Tutorial Material



Static keyword in Java


Static keyword in java is a keyword that defines a property (attribute or method) of a class is owned by that class, not an object (instantiation of a class) of that class. Access of the static property is done by using the class directly, but it can also be accessed by using the object of that class (though not the best practice).


Example of keyword static usage



Command to access static attribute/method



Overloading


In this tutorial, you will learn a concept called overloading. Overloading in Java consists of method overloading and constructor overloading. Method overloading is a concept/feature that makes it possible to make a method with the same name, but with different input parameters, whether it be parameter type or parameter count. Constructor overloading has the same concept of method overloading, but the one that is overload is the constructor from the class. One example of overloading method that you usually use is the method println().



Overloading method example

Encapsulation

Encapsulation is a covering process to limit direct access to a few number of object property (attribute /method). In Java, we can do the encapsulation process by giving access modifier to the object property. There are 4 kinds of access specifier in Java :




Access Modifier :

If we can't do the encapsulation process correctly, unwanted things may happen, such as :

So that the class behavior that we develop can be how we want it to be, and so that the user can use it easily, are the two reasons why encapsulation is important to do. (test case above can happen IF the access modifier attribute type from class Frame is public, so the solution is to change the access modifier attribute to private). Other than that, encapsulation is intended to hide the complexity of a class. For example, you use class Math in Java, and then you use method log() to count logarithm, you don't need to know what happens in method log().

So how do we access variables that with private access modifiers? The answer is by using setter and getter, for example :


Class Design

In Object Oriented Programming, the class structure that is usually used looks like this:
Dalam Object Oriented Programming, struktur kelas yang digunakan biasanya seperti ini:


Let's do this!?

Before we go right in the tutorial, we will warm-up first. To test your knowledge on Object Oriented Programming, try answering the questions below :


For example we have class:


Try guessing the output program on the main method below :

Question 1


Question 2



Question 3


Tutorial Question : “PEPERAS (PeEl's Personal Assistant)”




WARNING : For this tutorial, it is forbidden to change the code in the file PersonalAssistant.java!



What's the story?

After having fun by visiting the Rabbit House, Pak PeEl, the uncle of Kak Pewe tells them a story that he is developing a Personal Assistant that he calls PeEl's Personal Assistant (PEPERAS) in District Parbel. This PEPERAS intends to make it easier for someone to manage their finance and happiness.

Pak PeEl is given tofu (not tempe) Kak Pewe that Dek Depe has a friend that is good at making Java programs (which is you, yes you). Which is why Pak PeEl asks for your help in designing a class at a Java file that can be used as a structure program so the PEPERAS can work well. Pak PeEl will take care of the inputs from the user that is a file called PersonalAssistant.java so you are not allowed to change the file at all. Your job is to make a separate file with the name Human.java and implement a class called Human to run the commands that are contained on the file PersonalAssistant.java


Class Specification


Your file name has to be Human.java

Every Human has :




 Name

 Age

 Money (int)

 Happiness (real number)



Notes :

You can add a new attribute if you need to
MINIMUM amount of happiness is 0.0 and MAXIMUM amount is 100.0
If in a calculation the happiness amount exceeds 100, then the set amount of happiness becomes 100
If in a calculation the happiness amount is under 0, then the set amount of happiness becomes 0
Total amount of starting money if not specified is 50000
Total amount of starting happiness of every human is 50
Someone's name can consist of more than 1 word
Because there are different specifications, you are askes to do a Constructor Overloading, please adjust it with the one inside the file PersonalAssistant.java

Don't forget to implement Setters & Getters






Every human can have a few behaviors, which is :

💥 giveMoney(receiver)


Method to give money to [receiver]

The amount of money to be given can be calculated by using this formula :



The sum of ASCII value on every characters of the receiver's name is multiplied by 100.
Example :
receiver = “ABC”
Total ASCII value = 65 + 66+ 67 = 198
Total money = 198 * 100 = 19800



If the money owned by the giver is enough, then their happiness (giver and receiver) will rise.


The formula to calculate new happiness :

newHappiness = currentHappiness + [TOTAL_MONEY]/6000
Keep in mind that the happiness value is a real number and the value cannot exceed the maximum limit.

And then print :

[RECEIVER_NAME] give [TOTAL_MONEY] to [RECEIVER_NAME], they are both happy :D


If the money owned by the giver is not enough, then print :




[GIVER_NAME] wants to give money to [RECEIVER_NAME] but doesn't have enough money :'(


💥 giveMoney(receiver , amount)



Method to give money as much as [amount] to [receiver]
If the money owned by the giver is enough, then their happiness (giver and receiver) will rise


Calculating New Happiness Formula :

newHappiness = oldHappiness + [TOTAL_MONEY]/6000
Keep in mind that happiness value cannot exceed maximum value
And then print :

"[GIVER_NAME] give [AMOUNT] to [RECEIVER_NAME], they are both happy :D"


If the money owned by the giver is not enough, then print :




"[GIVER_NAME] wants to give money to [RECEIVER_NAME] but doesn't have enough money :'("



💥 work(duration, workLoad)


Method to work, get money but lose happiness.
If the human's age is under minimum work age (assume that the minimum work age in District Parbel is 18), print :




"[NAME] can't work yet because underage D:"


Total workload and happiness are connected, acquired by :



TotalWorkLoad = duration * workLoad
If (TotalWorkLoad <= Happiness), then:
Happiness = Happiness – TotalWorkLoad
Income = TotalWorkLoad * 10000



Then print:




"[NAME] worked full time, total income: [INCOME]"



Second Case :



If (TotalWorkLoad > Happiness), then that human will not be able to work full time, so it is calculated again to work duration
NewDuration = Happiness/workLoad (NewDuration in int)
TotalWorkLoad = NewDuration * workLoad
Income = TotalWorkLoad * 10000
Happiness = Happiness – TotalWorkLoad


Then print :




"[NAME] didn't work full time because of fatigue, total income : [INCOME]"



After that :



Income added to total amount of money



💥 recreation(destinationName)


Method to go on recreation, gets happiness at the cost of money
Recreation cost/money that needs to be spent to recreate in destination [destinationName] is :



Cost = String Length [DESTINATION_NAME] multiplied by 10000


If the money owned by the human is more than the recreation cost, devrease the amount of money of the Human as much as Cost needed and add the happiness of Human as much as :



NewHappiness = oldHappiness + String Length [DESTINATION_NAME]
Then print :
“[NAME] did a recreation in [DESTINATION_NAME], [NAME] is happy :)”


If the money owned by the human js not enough, print :


"[NAME] didn't have enough money to go on recreation at [DESTINATION_NAME] :("



💥 sick(diseaseName)


Method called if someone is sick, lose happiness
Formula to calculate new happiness:




newHappiness = oldHappiness – String Length [DISEASE_NAME]
Keep in mind that happiness value cannot be less than the bare minimum



Then print :




"[NAME] got [DISEASE_NAME] :O"



💥 toString()


Method that is called to get String representation of an object.
When System.out.println(anObject) is executed, then the String representation of anObject is asked, so anObject.toString() is executed.
This method must return a String, that contains :




Name(tab)(tab): [NAME]
Age(tab)(tab): [AGE]
Money(tab)(tab): [Money]
Happiness(tab): [HAPPINESS]
Use \t for tabulation



Output example that is expected when file PersonalAssistant.java is run :





Bonus Question: "Everyone alive will taste death"



The Story?


The story is, there's no story.

Implement a new feature in a form of a behavior that has these specifications :

💥 death()


Method that is called when a Human dies
Print :




"[NAME] died peacefully, happiness : [FINAL_HAPPINESS]"


And then all the remaining money will be donated to the “Last Human” (the kne called “Last Human” is the last Human Object that is instantiated). Example :




Because all the money left in human_2 will be donated to human_4 that is the “Last Human” because it is the last one to be instantiated


Because the donation is done when a Human dies, then happiness of [MONEY_GIVER] and [MONEY_RECEIVER] doesn't change.
And then print again :



“All the pennies owned by [LATE_NAME] is donated to [LAST_HUMAN_NAME]”


When a Human dies, they can't do any other behavior (except toString()) and can't be given money anymore, so when a dead Human runs a behavior or is given money, print :




"[NAME_WHO_DIED] has passed on to Nirvana"
Special Note : If method giveMoney is run and the giver nor the neither haa died, then the output can be as creative as you can be, the impirtant thing is that there cannot be any changes to money nor happiness


Modify method toString() so that it adds the title of “Late” in front of the real name if the Human is dead.
SPECIAL CASE : If the Human that died is the “Last Human” then the money will be gone and print :



"All the riches owned by [NAME] is gone"




Main Method Example and Output Bonus Question :








Notes :
You can implement your outputs as creative as you can, however, make sure there are no informations that are left out from the examples



Checklist

Fill curly bracket components with x to checklist components.


Obligatory Component | 100 Point


Create class Human matching the specification

Do a handling when the value of happiness exceeds the limit

Apply the overloading method on giveMoney and constructor overloading on class Human

Apply access modifier (encapsulation) that is appropriate on class Human

Apply the concept of static keyword that is appropriate on class Human

Create Getter Setter




Bonus Component | 10 Point


Create method death

Implement “Last Human” that is instantiated

Modify all methods (except toString()) so humans that have died can't do it anymore

Modify method toString()






Woah, what is this !?

When you push your life's work, you will notice a red cross of death or green check of live next to your work.


You might notice that we started using git system since 2nd term, following your upperclassmen who started using the git system since 3rd term. One of the functions of using git is that we can use Continuous Integration feature?

What is Continuous Integration? Continuous Integration is a concept where when you push, your work are directly build (compiled) and tested (direct testing). If it fails, you will be notified.
New Build Part will be explained in Advanced Programming. You only need to know the testing part.
The system that is used to test in Java is named JUnit. We will use the framework Junit to test directly (without having to print in the command line). For now, you don't need to know how Junit works.
You can check you Junit work in tab Commit. Press the green check or red cross logo to look at further details.


When you press the logo, you will see a summary of the test that has two circles.
If the first circle has a red cross, then your program failed because it has compile errors
If the first circle is a green check but your second circle is a cross, then your program isn't accurate.
If the second circle is a check, then your program has run well.


You can press the red cross or green chck button to see the summary in detail. For example, if you see a red cross in the second circle, you can press the second red cross to see in which test case is your program not accurate.
