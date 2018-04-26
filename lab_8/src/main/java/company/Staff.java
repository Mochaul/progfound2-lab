package company;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Staff extends Employee{
    private final int MAX_SUBORDINATE_COUNT = 10;
    private final List<String> ELIGIBLE_SUBORDINATE = new ArrayList<>(Arrays.asList("INTERN"));

    public Staff(String name, int salary){
        super(name, salary);
        this.type = "STAFF";
    }

    public boolean addSubordinate(Employee employee){
        
        System.out.println("add sub in staff");
        if (this.subordinates.size() < MAX_SUBORDINATE_COUNT && ELIGIBLE_SUBORDINATE.contains(employee.getName())){
            this.subordinates.add(employee);
            return true;
        }
        return false;
    }

}