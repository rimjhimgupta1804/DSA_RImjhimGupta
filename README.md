Employee Management System

A Java-based console application developed as a Data Structures and Algorithms (DSA) Project at Rungta International Skills University.

The application manages employee records using a custom Singly Linked List and HashMap, providing functionalities such as adding, displaying, searching, deleting and sorting employee records.

Project Details

Detail

Information

Project Title

Employee Management System

Project Number

PS No. 4

Student Name

Rimjhim Gupta

ERP ID

RU-25-11165

Faculty Guide

Naina Singh

University

Rungta International Skills University

Department

School of Computer Science and Engineering

Programming Language

Java

Features

Add Employee: Add new employee records with automatically generated unique IDs starting from E101.

Display Employees: Display all employee records stored in the linked list.

Search by ID: Find employee records efficiently using HashMap.

Search by Name: Search employees by their names using linked-list traversal.

Delete Employee: Remove an employee record using their employee ID.

Sort by Salary: Arrange employee records in descending order of salary.

File Handling: Load employee records from a file at startup and save updated records on exit.

Data Structures and Algorithms Used

Concept

Application

Singly Linked List

Stores employee records using dynamically connected nodes.

HashMap

Provides efficient employee ID-based searching.

Searching

Supports searching by employee ID and name.

Sorting

Arranges employees according to salary in descending order.

File Handling

Maintains employee records using employees.txt.

Object-Oriented Programming

Uses classes and objects to organize employee data and operations.

Singly Linked List Representation

Each node contains one Employee object and a reference to the next node.

HEAD
 |
 v
[E101] -> [E102] -> [E103] -> NULL

Project Structure

Employee-Management-System/
│
├── Main.java
├── employees.txt
└── README.md

Main.java – Contains the main application, Employee class, Node class and EmployeeList implementation.

employees.txt – Stores employee records for persistence between executions.

README.md – Project documentation.

Technologies Used

Java

Singly Linked List

HashMap

Searching and Sorting Algorithms

Java File Handling

Object-Oriented Programming

Installation and Execution

1. Clone the Repository

git clone https://github.com/your-username/Employee-Management-System.git

2. Navigate to the Project Directory

cd Employee-Management-System

3. Compile the Java Program

javac Main.java

4. Run the Application

java Main

The application will display a console menu through which users can perform employee management operations.

Sample Input and Output

Test Case 1: Add Employee

Input:

Menu Option: 1
Name: Anil Rao
Department: IT
Salary: 50000

Output:

Employee added. ID: E101 | Anil Rao | IT | 50000

Test Case 2: Delete Employee

Input:

Menu Option: 4
Employee ID: E101

Output:

Employee E101 deleted.
Total employees: 0

Test Case 3: Search Invalid Employee ID

Input:

Menu Option: 3
Employee ID: E999

Output:

Employee E999 not found.

Test Case 4: Sort Employees by Salary

Employees:

E101 | Anil Rao | IT | 50000
E102 | Sara Khan | HR | 60000

Output:

E102 | Sara Khan | HR | 60000
E101 | Anil Rao | IT | 50000

Time Complexity Analysis

Operation

Time Complexity

Add Employee

O(N)

Display Employees

O(N)

Search by ID

O(1) Average

Search by Name

O(N)

Delete Employee

O(N)

Sort by Salary

O(N²)

Here, N represents the total number of employee records.

Future Enhancements

Update existing employee information.

Integrate a database such as MySQL.

Develop a graphical user interface.

Implement authentication and access control.

Add department-wise employee filtering.

Generate employee reports.

Learning Outcomes

Through this project, I gained practical experience in:

Implementing a custom singly linked list in Java.

Understanding HashMap and efficient key-based searching.

Applying searching and sorting algorithms.

Working with file handling for persistent data storage.

Designing modular applications using classes and methods.

Author

Rimjhim Gupta

B.Tech – Computer Science and Engineering

Rungta International Skills University

Project: Employee Management System | DSA | PS No. 4

⭐ If you find this project useful, feel free to explore the repository!
