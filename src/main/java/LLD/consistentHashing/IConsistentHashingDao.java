package LLD.consistentHashing;

import java.util.List;

/**
 * @author raag
 */
public interface IConsistentHashingDao {

    void addServer(long serverId, String server);

    String getServer(long serverId);

    void removeServer(List<Long> hashes);
}
