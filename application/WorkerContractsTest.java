package CursoNelioAlves.exercisecomposition.application;

import CursoNelioAlves.exercisecomposition.entities.Department;
import CursoNelioAlves.exercisecomposition.entities.HourContract;
import CursoNelioAlves.exercisecomposition.entities.Worker;
import CursoNelioAlves.exercisecomposition.entities.WorkerLevel;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class WorkerContractsTest {
    public static void main(String[] args) {


        //OBSERVAÇÃO: ESTE CÓDIGO NÃO TRATA ERROS E FAZ VERIFICAÇÕES, É APENAS UM ESTUDO.

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the department's name: ");
        String depart = input.nextLine();
        System.out.println("Enter the worker data: ");
        System.out.println("Name:");
        String worker = input.nextLine();
        System.out.println("Level: ");
        String level = input.nextLine();
        System.out.println("Base salary: ");
        double salary = input.nextDouble();
        System.out.println("How many contracts to this worker? ");
        int y = input.nextInt();

        Department department = new Department(depart);

        Worker worker1 = new Worker(worker, WorkerLevel.valueOf(level.toUpperCase()), salary, department);

        for (int i = 1; i<=y; i++){
            System.out.println("Enter the contract # " + i + "date:");
            System.out.print("DATE (DD/MM/YYYY): ");
            String date = input.next();
            //formato a data sem necessidade de instanciar um simple data format
            LocalDate contractdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Value per hour: ");
            double valuePerHour = input.nextDouble();
            System.out.print("Duration in hours: ");
            int hours = input.nextInt();

            HourContract hourContract = new HourContract( contractdate, valuePerHour, hours);
            worker1.addContract(hourContract);
        }
        System.out.println();
        System.out.println("Enter to month and year to calculate income (MM/YYYY):  ");
        String MonthandYear = input.next();
        //formato a string abaixo a fim de evitar erros.
        int month = Integer.parseInt(MonthandYear.substring(0, 2));
        int year = Integer.parseInt(MonthandYear.substring(3));

        System.out.println( "Name: " + worker1.getName());
        System.out.println( "Department: " + worker1.getDepartment().getNome());
        System.out.println( "Income for: " + MonthandYear + " " + worker1.income(year, month));

        input.close();
    }
}
