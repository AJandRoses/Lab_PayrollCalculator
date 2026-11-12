import java.util.Scanner;

public class LabPayrollTracker {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the Payroll Tracker!");
    System.out.print("Please enter your name: ");
    try {
      String name = scanner.nextLine();
      System.out.print("Are you a full-time or part-time employee? (Enter 'F' or 'P'): ");
      boolean validInput = false;
      while (!validInput) {
        String employeeType = scanner.nextLine().toUpperCase();
        if (employeeType.equals("F") || employeeType.equals("P")) {
          validInput = true;
          
          Employee employee;
          if (employeeType.equals("F")) {
            employee = new FullTimeEmployee();
            System.out.print("Please enter your annual salary: ");
            ((FullTimeEmployee) employee).salary = scanner.nextDouble();
            System.out.print("Please enter your bonus: ");
            ((FullTimeEmployee) employee).bonus = scanner.nextDouble();
          } else {
            employee = new PartTimeEmployee();
            System.out.print("Please enter your hourly rate: ");
            ((PartTimeEmployee) employee).hourlyRate = scanner.nextDouble();
            System.out.print("Please enter the number of hours worked: ");
            ((PartTimeEmployee) employee).hoursWorked = scanner.nextDouble();
          }

          double pay = employee.calculatePay();
          System.out.printf("%s, your calculated pay is: $%.2f%n", name, pay);
        } else {
          System.out.println("Invalid input. Please enter 'F' for full-time or 'P' for part-time.");
        }
      }
    } catch (Exception e) {
      System.out.println("An error occurred while reading input.");
    }

    scanner.close();
  }
}

class Employee {
  String name;

  double calculatePay() {
    // Implementation for calculating pay
    return 0.0;
  }
}

class FullTimeEmployee extends Employee {
  double salary;
  double bonus;

  @Override
  double calculatePay() {
    double monthlyPay = salary / 12;

    return monthlyPay + bonus;
  }
}

class PartTimeEmployee extends Employee {
  double hourlyRate;
  double hoursWorked;

  @Override
  double calculatePay() {
    return hourlyRate * hoursWorked;
  }
}

## Code Review
- **Reviewed by:** [Partner Hanan Abdulkarim]
- **Status:** Checked code. Inheritance (`extends`), Scanner input, and calorie calculations are all correct and working!
