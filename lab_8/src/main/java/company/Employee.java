package company;

import java.util.ArrayList;

public abstract class Employee {
    
    protected String name;
    protected String type;
    protected ArrayList<Employee> subordinates;
    protected int salary;
    protected int salaryCount;

    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
        this.salaryCount = 0;
    }

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public ArrayList<Employee> getSubordinates(){
        return this.subordinates;
    }
    public int getSalary(){
        return this.salary;
    }

    public String toString(){
        return String.format("%s %d", this.name, this.salary);
    }

    protected boolean hasSubordinate(String name){
        for (Employee subordinate : this.subordinates){
            if (subordinate.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    protected void raisePay(){
        this.salary = (int)(this.salary * Company.PAY_RAISE_RATE);
    }

    protected boolean receivePay(){
        this.salaryCount++;
        if (this.salaryCount % Company.PAY_RAISE_PERIOD == 0){
            int oldSalary = this.salary;
            this.raisePay();
            System.out.printf("%s mengalami kenaikan gaji sebesar 10%% dari %d menjadi %d\n", this.name, oldSalary, this.salary);
            return true;
        }
        return false;
    }

    protected abstract boolean addSubordinate(Employee employee);
}