import java.util.*;

class RandomizedCollection {
    HashMap<Integer, Set<Integer>> hm;
    List<Integer> list;
    Random rand;

    public RandomizedCollection() {
        hm = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean contains = hm.containsKey(val);
        if (!contains) {
            hm.put(val, new LinkedHashSet<>());
        }
        hm.get(val).add(list.size());
        list.add(val);
        return !contains;
    }

    public boolean remove(int val) {
        if (!hm.containsKey(val) || hm.get(val).isEmpty()) {
            return false;
        }
        int removeIndex = hm.get(val).iterator().next();
        hm.get(val).remove(removeIndex);
        int lastElement = list.get(list.size() - 1);
        list.set(removeIndex, lastElement);
        hm.get(lastElement).add(removeIndex);
        hm.get(lastElement).remove(list.size() - 1);
        list.remove(list.size() - 1);
        if (hm.get(val).isEmpty()) {
            hm.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
