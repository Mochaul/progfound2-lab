package company;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Manager extends Employee{
    private final int MAX_SUBORDINATE_COUNT = 10;
    private final List<String> ELIGIBLE_SUBORDINATE = new ArrayList<>(Arrays.asList("STAFF", "INTERN"));

    public Manager(String name, int salary){
        super(name, salary);
        this.type = "MANAGER";
    }

    public boolean addSubordinate(Employee employee){
        if (this.subordinates.size() < MAX_SUBORDINATE_COUNT && ELIGIBLE_SUBORDINATE.contains(employee.getType())){
            this.subordinates.add(employee);
            return true;
        }
        return false;
    }

}