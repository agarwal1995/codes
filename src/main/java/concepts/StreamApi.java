package concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author raag
 */
public class StreamApi {

    public static void main(String[] args) {

        // Reduction of normal list of integers
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int sum = list1.stream().reduce(5, (x,y)-> {
            return x+y;
        });
        System.out.println(sum); // 50

        // Reduction of normal list of integers parralelism
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int sum2 = list2.parallelStream().reduce(5, (x,y)-> {
            return x+y;
        });
        System.out.println(sum2); // not sure as every parallel
        // operation starts from 5 and return the result in the end

        List<StreamApiUser> users = Arrays.asList(
                new StreamApiUser("name1",10),
                new StreamApiUser("name2", 20)
        );
        int ageSum = users.stream().reduce(0, (a,b)-> {
            return a+b.age;
        }, Integer::sum); // without combiner, it will give a compiler error, as reduce is not
        // able to interpret the datatype of the variable 'a'
        System.out.println(ageSum);

        // stream reduction using a complex object and a method call for the accumulator action
        List<StreamApiUser> list3 = new ArrayList<>(users);
        sum = list3.stream().reduce(0, (a,b)-> {
            return sumCheck(a,b.age) + sumCheck(a,b.age);
        }, Integer::sum);
        System.out.println(sum); // 80

    }

    private static int sumCheck(int val, int element) {
        System.out.println(val);
        System.out.println(element);
        return val+element;
    }
}

class StreamApiUser {
    int age;
    String name;

    public StreamApiUser(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
