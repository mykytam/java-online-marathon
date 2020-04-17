package softserve.sprint06;

//Create a largestEmployees() method of the MyUtils class to return a List of unique employees with maximal working experience and payment without duplicate objects.
//The original list must be unchanged.

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Employee {

    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return experience == employee.experience &&
                Objects.equals(name, employee.name) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, basePayment);
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", experience=" + experience + ", basePayment=" + basePayment + '}' + "\n";
    }
}

class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        BigDecimal bd = super.getPayment();
        return bd.multiply(BigDecimal.valueOf(coefficient));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }
}

class MyUtils02 {
    public List<Employee> largestEmployees(List<Employee> workers) {

        Integer maxExp = workers.stream()
                .filter(Objects::nonNull)
                .map(worker -> worker.getExperience())
                .max(Integer::compareTo)
                .get();

        List<Employee> expList = workers.stream()
                .filter(Objects::nonNull)
                .filter(worker -> worker.getExperience() == maxExp)
                .collect(Collectors.toList());

        BigDecimal maxPay = workers.stream()
                .filter(Objects::nonNull)
                .map(worker -> worker.getPayment())
                .max(BigDecimal::compareTo)
                .get();

        List<Employee> payList = workers.stream()
                .filter(Objects::nonNull)
                .filter(worker -> worker.getPayment().equals(maxPay))
                .collect(Collectors.toList());

        expList.addAll(payList);
        System.out.println(expList);
        return expList;
    }
}
