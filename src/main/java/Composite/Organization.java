package Composite;

public abstract class Organization {
    public String name;

    public Organization(String name) {
        this.name = name;
    }

    public abstract double getSalary();
    public abstract void add(Organization organization);
    public abstract void remove(Organization organization);
    public abstract void print(StringBuilder stringBuilder);
}
