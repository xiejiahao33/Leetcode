package 字符串._125;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person(10,"张三");
        Person p2 = new Person(10,"张三");
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}
class Person{
    int age;
    String name;
    public Person(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}