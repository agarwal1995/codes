package discussions.oracle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Java8 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("A",10));
        employees.add(new Employee("A",11));
        employees.add(new Employee("B",10));
        employees.add(new Employee("B",1));

        Map<String, Optional<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.reducing(BinaryOperator.maxBy((o1,o2)-> o1.salary.compareTo(o2.salary)))));
        System.out.println(map);
    }
}

@Data
@AllArgsConstructor
@ToString
class Employee {
    public String department;
    public Integer salary;
}
