package company;

public class Intern extends Employee{

    public Intern(String name, int salary){
        super(name, salary);
        this.type = "INTERN";
    }

    public boolean addSubordinate(Employee employee){
        System.out.println("add sub in intern");
        return false;
    }

}