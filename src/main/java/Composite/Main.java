package Composite;

public class Main {
    public static void main(String[] args) {
        Department department = new Department("Head Office");

        Department department2 = new Department("IT Department");
        Department department3 = new Department("Random Department");

        Employee emp1 = new Employee("Sara", 5000);
        Employee emp2 = new Employee("Pekka", 6000);
        Employee emp3 = new Employee("Mikko", 7000);

        department2.add(emp1);
        department3.add(emp2);
        department3.add(emp3);

        department.add(department2);
        department.add(department3);

        StringBuilder builder = new StringBuilder();
        department.print(builder);
        System.out.println(builder);

        System.out.println("Total salary of the organization: " + department.getSalary() + "\n");

        builder.setLength(0);
        department3.remove(emp3);
        department.remove(department2);
        department.print(builder);
        System.out.println("Updated Structure:\n" + builder);

        System.out.println("Updated total salary of the organization: " + department.getSalary());
    }
}
