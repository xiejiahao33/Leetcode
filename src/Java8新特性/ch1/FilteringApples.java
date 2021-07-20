package Java8新特性.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> result =filterApples(inventory,(Apple apple)->"red".equals(apple.getColor()));
        System.out.println(result);
    }


    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p ){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }


    interface ApplePredicate{
        public boolean test(Apple a);
    }
}
