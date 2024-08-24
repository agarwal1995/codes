package LLD.consistentHashing;

import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author raag
 */

public class ConsistentHashingDao implements IConsistentHashingDao {

    private static ConsistentHashingDao dao = null;

    private static NavigableMap<Long, String> servers;

    private ConsistentHashingDao() {}

    public static ConsistentHashingDao getInstance() {
        if(dao==null) {
            synchronized (ConsistentHashingDao.class) {
                if (dao==null) {
                    servers = new TreeMap<>();
                    dao = new ConsistentHashingDao();
                }
            }
        }
        return dao;
    }

    @Override
    public void addServer(long serverId, String server) {
        servers.put(serverId, server);
        System.out.println("ADD" + servers);
    }

    @Override
    public String getServer(long hash) {
        System.out.println("GET" + servers + " " + hash);
        if (servers.isEmpty()) {
            return null;
        }
        if (servers.containsKey(hash)) {
            return servers.get(hash);
        }

        Map.Entry<Long, String> entry = servers.higherEntry(hash);

        if (entry!=null) {
            return entry.getValue();
        }
        return servers.firstEntry().getValue();
    }

    public void removeServer(List<Long> hashes) {
        for (Long hash: hashes) {
            servers.remove(hash);
        }
    }
}
