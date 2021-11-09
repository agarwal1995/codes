package discussions.wallmart;

import java.util.*;

public class CityItinerary {


    private static void findItinerary(Map<String, String> map, String source) {
        int noOfTickets = map.size();
        int i=0;
        while (i<noOfTickets) {
            String destination = map.get(source);
            System.out.println(source + " -> " + destination);
            source = destination;
            i++;
        }
    }


    public static void main(String[] args) throws Exception {
        Map<String, String> tickets = new HashMap<String, String>() {{
            put("Chennai","Bangalore");
            put("Goa","Chennai");
            put("Mumbai","Delhi");
            put("Delhi","Goa");
        }};
        Set<String> destinationCities = new HashSet<>(tickets.values());
        String source = null;
        for(String key : tickets.keySet()) {
            if (!destinationCities.contains(key)) {
                source = key;
                break;
            }
        }
        findItinerary(tickets, source);
    }
}
