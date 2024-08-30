package Composite;

public class Employee extends Organization {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void add(Organization organization) {
        throw new UnsupportedOperationException("Cannot add to an employee");
    }

    @Override
    public void remove(Organization organization) {
        throw new UnsupportedOperationException("Cannot remove from an employee");
    }

    @Override
    public void print(StringBuilder stringBuilder) {
        stringBuilder.append("<Employee name=\"").append(name).append("\" salary=\"").append(salary).append("\"/>\n");
    }
}
