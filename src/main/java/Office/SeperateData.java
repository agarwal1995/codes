package Office;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeperateData {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Inventory>> map = new HashMap<>();
        for(int i=1;i<=686;i++) {
            String[] line = br.readLine().trim().split("\\s+");
            if(line.length >3) {
                continue;
            }
            String sku = line[0];
            String location = line[1];
            int stock = Integer.parseInt(line[2]);
            map.putIfAbsent(sku, new ArrayList<>());
            map.get(sku).add(new Inventory(location, stock));
        }
        map.forEach((key, value)-> {
            System.out.println(key + "-------" + value);
        });
    }
}


class Inventory {
    private String loc;
    private int count;


    Inventory(String loc, int count) {
        this.loc = loc;
        this.count = count;
    }

    @Override
    public String toString() {
        return loc + ":" + count;
//        return "Inventory{" +
//                "loc='" + loc + '\'' +
//                ", count=" + count +
//                '}';
    }
}
