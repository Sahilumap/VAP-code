package demo5_project_file;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * PROJECT: Employee Management System
 * Version 2: With File Storage - Data persists after program exits!
 * 
 * This is the COMPLETE solution with file handling.
 */
public class EmployeeManagement {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "employees.txt";
    
    public static void main(String[] args) {
        // Load existing data at startup
        loadFromFile();
        
        System.out.println("=============================================");
        System.out.println("  EMPLOYEE MANAGEMENT SYSTEM (File Storage)");
        System.out.println("  Data is saved to: " + FILE_NAME);
        System.out.println("=============================================");
        
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            
            switch (choice) {
                case 1: 
                    addEmployee(); 
                    saveToFile();  // Save after adding
                    break;
                case 2: 
                    viewAll(); 
                    break;
                case 3: 
                    searchById(); 
                    break;
                case 4: 
                    updateEmployee(); 
                    saveToFile();  // Save after updating
                    break;
                case 5: 
                    deleteEmployee(); 
                    saveToFile();  // Save after deleting
                    break;
                case 6: 
                    System.out.println("Goodbye! Your data has been saved."); 
                    break;
                default: 
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
        
        sc.close();
    }
    
    static void printMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search by ID");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }
    
    static void addEmployee() {
        System.out.println("\n--- Add Employee ---");
        
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        
        // Check for duplicate ID
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println("Error: Employee with ID " + id + " already exists!");
                return;
            }
        }
        
        sc.nextLine();  // Consume newline
        
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        
        Employee e = new Employee(id, name, dept, salary);
        employees.add(e);
        
        System.out.println("Employee added successfully!");
    }
    
    static void viewAll() {
        System.out.println("\n--- All Employees ---");
        
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        
        System.out.println("ID | Name            | Department | Salary");
        System.out.println("--------------------------------------------");
        for (Employee e : employees) {
            e.display();
        }
        System.out.println("--------------------------------------------");
        System.out.println("Total: " + employees.size() + " employee(s)");
    }
    
    static void searchById() {
        System.out.println("\n--- Search Employee ---");
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println("\nEmployee Found:");
                System.out.println("ID | Name            | Department | Salary");
                System.out.println("--------------------------------------------");
                e.display();
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    
    static void updateEmployee() {
        System.out.println("\n--- Update Employee ---");
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println("Current details:");
                e.display();
                
                sc.nextLine();  // Consume newline
                
                System.out.print("New Name (press Enter to skip): ");
                String name = sc.nextLine();
                if (!name.isEmpty()) e.setName(name);
                
                System.out.print("New Department (press Enter to skip): ");
                String dept = sc.nextLine();
                if (!dept.isEmpty()) e.setDepartment(dept);
                
                System.out.print("New Salary (0 to skip): ");
                double salary = sc.nextDouble();
                if (salary > 0) e.setSalary(salary);
                
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    
    static void deleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        
        boolean removed = employees.removeIf(e -> e.getId() == id);
        
        if (removed) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
    
    // ==================== FILE HANDLING ====================
    
    /**
     * Save all employees to file
     * Format: id,name,department,salary (one per line)
     */
    static void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            
            for (Employee e : employees) {
                bw.write(e.toFileString());
                bw.newLine();
            }
            
            bw.close();
            System.out.println("[Data saved to " + FILE_NAME + "]");
            
        } catch (IOException ex) {
            System.out.println("Error saving data: " + ex.getMessage());
        }
    }
    
    /**
     * Load employees from file at startup
     */
    static void loadFromFile() {
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            System.out.println("[No existing data file found. Starting fresh.]");
            return;
        }
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String dept = parts[2];
                    double salary = Double.parseDouble(parts[3]);
                    
                    employees.add(new Employee(id, name, dept, salary));
                }
            }
            
            br.close();
            System.out.println("[Loaded " + employees.size() + " employee(s) from file.]");
            
        } catch (IOException ex) {
            System.out.println("Error loading data: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Error: Invalid data format in file.");
        }
    }
}
