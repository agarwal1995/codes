package Office;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckStreamToMapNull {


    public static void main(String[] args) throws Exception {
//        Check check = new Check();
//        check.a = null;
//        check.b = 1;
//
//        List<Check> checkList = new ArrayList<>();
//        checkList.add(check);
//        Map<Integer, Integer> map = checkList.stream().collect(Collectors.toMap(Check::getA, Check::getB, (v1,v2)->v1));
//        System.out.println(map);

        List<String> list = new ArrayList<>();
        list.add("dgfsda");
        System.out.println(list.remove(0));
        System.out.println(list.remove(0));
        System.out.println(list.remove(0));
    }
}

class Check {
    public Integer a;
    public Integer b;

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }
}
