public class Main {

    private static LRUCache<String, Integer> cache = new LRUCache<>(1);

    public static void main(String[] args) {

        for(int i = 1; i <= 3; i++) {
            cache = new LRUCache<>(i);

            cache.put("hello", 1);

            assert (cache.get("hello") == 1);
            //System.out.println("'hello': " + cache.get("hello"));

            cache.put("abs", 2);
            cache.put("lol", 3);

            if (i == 1 || i == 2) {
                assert (cache.get("hello") == null);
            } else {
                assert (cache.get("hello") == 1);
            }
            //System.out.println("'hello': " + cache.get("hello"));

            if (i == 1) {
                assert ("CacheList{ lol=3 }".equals(cache.toString()));
            } else if (i == 2) {
                assert ("CacheList{ lol=3 , abs=2 }".equals(cache.toString()));
            } else if (i == 3) {
                assert ("CacheList{ hello=1 , lol=3 , abs=2 }".equals(cache.toString()));
            }
            //System.out.println(cache.toString());

            cache.put("hello", 100);
            cache.put("lol", 100000);

            if (i == 1) {
                assert ("CacheList{ lol=100000 }".equals(cache.toString()));
            } else if (i == 2) {
                assert ("CacheList{ lol=100000 , hello=100 }".equals(cache.toString()));
            } else if (i == 3) {
                assert ("CacheList{ lol=100000 , hello=100 , abs=2 }".equals(cache.toString()));
            }
            //System.out.println(cache.toString());
        }
    }
}
