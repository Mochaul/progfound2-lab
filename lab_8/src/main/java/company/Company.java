package company;

import java.util.ArrayList;
import employee.*;

public class Company{
    private final int MAX_EMPLOYEE_COUNT = 10000;
    protected final static int PAY_RAISE_PERIOD = 6;
    protected static final double PAY_RAISE_RATE = 1.1;

    private int employeeCount = 0;
    private String name;
    private ArrayList<Employee> employees;

    public Company(String name){
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getCompanyName(){
        return this.name;
    }

    public ArrayList<Employee> getEmployees(){
        return this.employees;
    }

    public String addEmployee(String name, String type, int salary){
        if (!this.hasEmployee(name) && employeeCount <= MAX_EMPLOYEE_COUNT){
            switch (type){
                case "MANAGER":
                    this.employees.add(new Manager(name, salary));
                    break;
                case "STAFF":
                    this.employees.add(new Staff(name, salary));
                    break;
                case "INTERN":
                    this.employees.add(new Intern(name, salary));
                    break;
                default:
                    return "invalid TYPE";
            }
            employeeCount++;
            return String.format("%s mulai bekerja sebagai %s di PT. %s", name, type, this.name);
        }
        return String.format("Karyawan dengan nama %s telah terdaftar", name);
    }   

    public String status(String name){
        Employee e = this.findName(name);
        if (e != null){
            return e.toString();
        }
        return "Karyawan tidak ditemukan";
    }

    public String recruit(String superior, String subordinate){
        Employee sup = this.findName(superior);
        Employee sub = this.findName(subordinate);
        if (sup == null) return superior + " tidak berhasil ditemukan";
        if (sub == null) return subordinate + " tidak berhasil ditemukan";
        if (sup.hasSubordinate(subordinate)) return String.format("Karyawan %s telah menjadi bawahan %s", subordinate, superior);
        if(sup.addSubordinate(sub)) return String.format("Karyawan %s berhasil ditambahkan menjadi bawahan %s", subordinate, superior);
        return "Anda tidak layak memiliki bawahan";
        
    }

    public String payday(){
        for (Employee e : this.employees){
            e.receivePay();
        }
        return "Semua karyawan telah diberikan gaji";
    }

    public String toString(){
        String result = "";
        for (Employee employee : this.employees){
            result += employee + "\n";
        }
        return result;
    }

    private Employee findName(String name){
        for (Employee employee : this.employees){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    private boolean hasEmployee(String name){
        for (Employee employee : this.employees ){
            if (employee.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}