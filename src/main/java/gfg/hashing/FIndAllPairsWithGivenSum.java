package gfg.hashing;

import interviewBit.graph.helpers.Pair;

import java.util.*;

/**
 * @author raag
 */
public class FIndAllPairsWithGivenSum {
    class pair  {
        long first, second;
        public pair(long first, long second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

    }

    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        Long[] a = Arrays.stream(A).boxed().toArray(Long[]::new);
        Set<Long> setA = new HashSet<Long>(new ArrayList<>(Arrays.asList(a)));

        List<pair> pairs = new ArrayList<>();
        for(long x: B) {
            if(setA.contains(X-x)) {
                pairs.add(new pair(X-x, x));
            }
        }

        pairs.sort(new Comparator<pair>() {
            @Override
            public int compare(pair pair, pair t1) {
                if(pair.first <= t1.first) {
                    return 0;
                }
                return -1;
            }
        });
        pair[] res = new pair[pairs.size()];
        res = pairs.stream().map(x-> new pair(x.first, x.second)).toArray(pair[]::new);
        return res;
    }
}
