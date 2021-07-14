package Java核心技术.inheritance;

public class ManagerTest {
    public static void main(String[] args) {


        Employee[] staff = new Employee[3];

        staff[0] = new Employee("ZZZ",50000);
        staff[1] = new Employee("Harry",50000);
        staff[2] = new Employee("Tom",40000);

        for (Employee e: staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",id=" + e.getId());
        }

        System.out.println(Employee.getNextId());
    }
}
