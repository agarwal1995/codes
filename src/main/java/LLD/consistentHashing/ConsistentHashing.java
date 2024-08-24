package LLD.consistentHashing;

/**
 * @author raag
 */
public class ConsistentHashing {

    public static void main(String[] args) throws Exception {
        ConsistentHashingFacade consistentHashingFacade = new ConsistentHashingFacade();
        consistentHashingFacade.addServer("Server1", 1);
        consistentHashingFacade.addServer("Server2", 1);
        consistentHashingFacade.addServer("Server3", 3);


        System.out.println(consistentHashingFacade.getServer("key1"));
        System.out.println(consistentHashingFacade.getServer("key2"));
        System.out.println(consistentHashingFacade.getServer("key4"));
        System.out.println(consistentHashingFacade.getServer("key2"));
        System.out.println(consistentHashingFacade.getServer("key5"));
        System.out.println(consistentHashingFacade.getServer("key7"));
        System.out.println(consistentHashingFacade.getServer("key8"));
        System.out.println(consistentHashingFacade.getServer("key9"));
        System.out.println(consistentHashingFacade.getServer("key510"));
    }
}
