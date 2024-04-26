package CursoNelioAlves.exercisecomposition.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private CursoNelioAlves.exercisecomposition.entities.WorkerLevel WorkerLevel;
    private double baseSalary;
    private Department department;

    //quando há uma composição do tipo têm muitos, eu não coloco no construtor, eu inicio a lista.
    private List <HourContract> contracts = new ArrayList<>();


    public Worker (String worker, String level, double salary, Department department){
    }

    public Worker(String name, CursoNelioAlves.exercisecomposition.entities.WorkerLevel workerLevel, double baseSalary, Department department) {
        this.name = name;
        WorkerLevel = workerLevel;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CursoNelioAlves.exercisecomposition.entities.WorkerLevel getWorkerLevel() {
        return WorkerLevel;
    }

    public void setWorkerLevel(CursoNelioAlves.exercisecomposition.entities.WorkerLevel workerLevel) {
        WorkerLevel = workerLevel;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

//faz associação ao contrato
    public void addContract (HourContract contract){
        contracts.add(contract);
    }
//desfaz a associação do contrato
    public void removeContract (HourContract contract){
        contracts.remove(contract);
    }

    public double income (int year, int month){
     double sum = baseSalary;
     Calendar calendar = Calendar.getInstance(); //manipulação de datas com o Calendar.
        for(HourContract contract : contracts){
            int contractYear = contract.getDate().getYear();
            int contractMonth = contract.getDate().getMonthValue();

                 if(year == contractYear && month == contractMonth){
                    sum += contract.totalValue();
                 }

     }
        return sum;
    }

}

