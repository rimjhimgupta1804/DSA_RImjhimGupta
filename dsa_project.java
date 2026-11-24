
import java.util.*;
import java.io.*;

// Employee class stores employee details
class Employee {
    String id;
    String name;
    String department;
    int salary;

    Employee(String id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " | " + name + " | " +
                           department + " | " + salary);
    }
}

// Node class for singly linked list
class Node {
    Employee data;
    Node next;

    Node(Employee data) {
        this.data = data;
        this.next = null;
    }
}

// Custom singly linked list
class EmployeeList {

    Node head = null;

    // HashMap for searching employees using ID
    HashMap<String, Employee> map = new HashMap<>();

    int nextId = 101;

    // Add employee
    void addEmployee(String name, String department, int salary) {

        String id = "E" + nextId++;

        Employee emp = new Employee(id, name, department, salary);

        Node newNode = new Node(emp);

        if(head == null) {
            head = newNode;
        }
        else {
            Node temp = head;

            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        map.put(id, emp);

        System.out.println("Employee added successfully.");
        emp.display();
    }

    // Add existing employee while loading file
    void addExisting(Employee emp) {

        Node newNode = new Node(emp);

        if(head == null) {
            head = newNode;
        }
        else {
            Node temp = head;

            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        map.put(emp.id, emp);

        int number = Integer.parseInt(emp.id.substring(1));

        if(number >= nextId) {
            nextId = number + 1;
        }
    }

    // Display all employees
    void displayEmployees() {

        if(head == null) {
            System.out.println("No employees found.");
            return;
        }

        Node temp = head;

        System.out.println("ID | Name | Department | Salary");

        while(temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    // Search employee by ID
    void searchById(String id) {

        if(map.containsKey(id)) {
            System.out.println("Employee found:");
            map.get(id).display();
        }
        else {
            System.out.println("Employee " + id + " not found.");
        }
    }

    // Search employee by name
    void searchByName(String name) {

        Node temp = head;
        boolean found = false;

        while(temp != null) {

            if(temp.data.name.equalsIgnoreCase(name)) {
                temp.data.display();
                found = true;
            }

            temp = temp.next;
        }

        if(!found) {
            System.out.println("Employee not found.");
        }
    }

    // Delete employee using ID
    void deleteEmployee(String id) {

        if(head == null) {
            System.out.println("No employees to delete.");
            return;
        }

        if(head.data.id.equals(id)) {

            head = head.next;
            map.remove(id);

            System.out.println("Employee " + id + " deleted.");
            return;
        }

        Node temp = head;

        while(temp.next != null &&
              !temp.next.data.id.equals(id)) {

            temp = temp.next;
        }

        if(temp.next == null) {
            System.out.println("Employee " + id + " not found.");
        }
        else {
            temp.next = temp.next.next;
            map.remove(id);

            System.out.println("Employee " + id + " deleted.");
        }
    }

    // Sort employees by salary (high to low)
    void sortBySalary() {

        if(head == null || head.next == null) {
            System.out.println("Not enough employees to sort.");
            return;
        }

        Node i = head;

        while(i != null) {

            Node j = i.next;

            while(j != null) {

                if(i.data.salary < j.data.salary) {

                    Employee temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }

                j = j.next;
            }

            i = i.next;
        }

        System.out.println("Employees sorted by salary (high to low).");

        displayEmployees();
    }

    // Load employees from file
    void loadFromFile() {

        try {
            File file = new File("employees.txt");

            if(!file.exists()) {
                return;
            }

            BufferedReader br = new BufferedReader(
                new FileReader(file)
            );

            String line;

            while((line = br.readLine()) != null) {

                String[] parts = line.split("\\|", -1);

                if(parts.length == 4) {

                    Employee emp = new Employee(
                        parts[0],
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3])
                    );

                    addExisting(emp);
                }
            }

            br.close();

            System.out.println("Employee records loaded.");

        }
        catch(Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // Save employees to file
    void saveToFile() {

        try {
            PrintWriter pw = new PrintWriter(
                new FileWriter("employees.txt")
            );

            Node temp = head;

            while(temp != null) {

                Employee emp = temp.data;

                pw.println(emp.id + "|" + emp.name + "|" +
                           emp.department + "|" + emp.salary);

                temp = temp.next;
            }

            pw.close();

            System.out.println("Employee records saved successfully.");

        }
        catch(IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

// Main class
public class dsa_project {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeList list = new EmployeeList();

        // Load old records when program starts
        list.loadFromFile();

        while(true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Sort by Salary");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    int salary = Integer.parseInt(sc.nextLine());

                    list.addEmployee(name, department, salary);

                    break;

                case 2:

                    list.displayEmployees();

                    break;

                case 3:

                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by Name");

                    int searchChoice = Integer.parseInt(sc.nextLine());

                    if(searchChoice == 1) {

                        System.out.print("Enter Employee ID: ");
                        String id = sc.nextLine();

                        list.searchById(id);
                    }
                    else if(searchChoice == 2) {

                        System.out.print("Enter Employee Name: ");
                        String empName = sc.nextLine();

                        list.searchByName(empName);
                    }
                    else {
                        System.out.println("Invalid search choice.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Employee ID to delete: ");
                    String deleteId = sc.nextLine();

                    list.deleteEmployee(deleteId);

                    break;

                case 5:

                    list.sortBySalary();

                    break;

                case 6:

                    list.saveToFile();

                    System.out.println("Exiting Employee Management System.");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
