package LLD.consistentHashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author raag
 */
public class ConsistentHashingFacade {

    private final MessageDigest md;

    private final IConsistentHashingDao consistentHashingDao;

    public ConsistentHashingFacade() throws NoSuchAlgorithmException {
        this.md = MessageDigest.getInstance("MD5");
        consistentHashingDao = ConsistentHashingDao.getInstance();
    }

    public void addServer(String serverId, int replica) {
        for (int i=0;i<replica;i++) {
            long hash = generateHash(serverId + i);
            consistentHashingDao.addServer(hash, serverId);
        }
    }

    public String getServer(String key) {
        return consistentHashingDao.getServer(generateHash(key));
    }

    public void removeServer(String serverId, int replica) {
        List<Long> hashes = IntStream.range(0, replica)
                .mapToLong(x-> generateHash(serverId+x))
                .boxed()
                .collect(Collectors.toList());
        consistentHashingDao.removeServer(hashes);
    }


    private Long generateHash(String key) {
        md.reset();
        md.update(key.getBytes());
        byte[] digest = md.digest();
        return ((long) (digest[3] & 0xFF) << 24) |
                ((long) (digest[2] & 0xFF) << 16) |
                ((long) (digest[1] & 0xFF) << 8) |
                ((long) (digest[0] & 0xFF));
    }

}
