# csc413-p1
Student Name: Arnold Jiadong Yu

Student ID: 917269189

Class: Csc413-02

Link - https://github.com/CSC-413-SFSU-02/csc413_02_p1-jyu13.git

Project Introduction: This first assignment demonstrates a calculator. Part of the codes was given. I complete the code by fulfilled the requirements, which includes operator class, operand class, eval function, and actionPerformed function.

Compile and execute directions:  This project was NetBeans project. First, open NetBeans and choose open project. Second, find the directory that saved the project and open. Now you can compile and run the project. A calculator should pop-up after you run the project.

Assumption: This project added extra parentheses operators. This project can only handle valid expression. If an unbalanced expression such as (3+2, and enter a negative number will not return an result but program will not crash. Both C and CE will clear all the text. 

Implementation discussion: EvalutorUI.java will create a frame and panel to fill in all the buttons. It also implements actionPerformed function to pass the expression to Evalutor.java to get evaluated, which mean return the calculation result. Evalutor.java has all the main algorithm of how an expression will be calculated. # and ! operator are added to make more efficient.  Abstract class operator and operand will handle each operator and operand for the Evaluator class.

Results and conclusions: I learned that how inheritance means and works. Also I have a little understanding regarding concurrency. By practice writing code requires inheritance, it helps me understand design pattern and how to write clean and efficient code. It gave me a hard time by adding the parentheses operators. First time the project only works for parentheses on the left. Then I modified, it works on the left, but not the parentheses inside the parentheses. I overcome the error by review algorithm again and walk thought the code by hands. Finally I found out I forgot to push newOperator into the Stack. After I found the bug, the project runs fine and nice.

