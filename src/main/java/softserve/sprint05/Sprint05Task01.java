package softserve.sprint05;

public class Sprint05Task01 {
    abstract class Employee {
        protected String employeeID;

        public Employee(String employeeID) {
            this.employeeID = employeeID;
        }

        public abstract String getFullInfo();
    }

    class SalariedEmployee extends Employee {
        protected String socialSecurityNumber;

        public SalariedEmployee(String employeeID, String socialSecurityNumber) {
            super(employeeID);
            this.socialSecurityNumber = socialSecurityNumber;
        }

        public String getFullInfo() {
            return employeeID + socialSecurityNumber;
        }
    }

    class ContractEmployee extends Employee {
        protected String federalTaxIDMember;

        public ContractEmployee(String employeeID, String federalTaxIDMember) {
            super(employeeID);
            this.federalTaxIDMember = federalTaxIDMember;
        }

        public String getFullInfo() {
            return employeeID + federalTaxIDMember;
        }
    }
}
