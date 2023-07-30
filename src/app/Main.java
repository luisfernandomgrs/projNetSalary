package app;

import entities.Employee;
import services.BrazilTaxService;
import services.PensionService;
import services.SalaryService;
import services.TaxService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Gross Salary: ");
        double grossSalary = sc.nextDouble();

        Employee employee = new Employee(name, grossSalary);
        TaxService  taxService = new BrazilTaxService();
        PensionService pensionService = new PensionService();
        SalaryService salaryService = new SalaryService(taxService, pensionService);

        double netSalary = salaryService.netSalary(employee);
        System.out.printf("Hi, %s. Your net salary is: %.2f%n", employee.getName(), netSalary);

        sc.close();
    }
}