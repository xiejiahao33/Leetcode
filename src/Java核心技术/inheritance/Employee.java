package Java核心技术.inheritance;


public class Employee {

    private static int nextId = 1;

    private String name;
    private double salary;
    private int id ;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = 0;
    }

    public static int getNextId() {
        return nextId;
    }



    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Employee e =new Employee("Harry",50000);
        Employee test = e;
        test.setId(10);
        System.out.println(e.getName()+" "+ e.getSalary() +  e.getId());
        System.out.println(test.getId());
        System.out.println(e.hashCode());
        System.out.println(test.hashCode());
    }
}
