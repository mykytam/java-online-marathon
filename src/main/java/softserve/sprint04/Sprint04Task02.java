package softserve.sprint04;

class Employee {
    public String fullName;
    public float salary;
}


public class Sprint04Task02 {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.fullName = "Ivan";
        emp1.salary = 9000.0f;
        emp2.fullName = "John";
        emp2.salary = 15000.0f;

        Employee employees[]  = {emp1, emp2};

        String employeesInfo;

        for (int i = 0; i <employees.length; i++) {
            employeesInfo ="[{fullName: \"" + employees[i].fullName + "\", salary: " + employees[i].salary + "}]";
            System.out.println(employeesInfo);
        }
    }
}
