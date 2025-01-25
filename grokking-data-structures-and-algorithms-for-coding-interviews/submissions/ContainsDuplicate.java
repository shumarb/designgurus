import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<> ();
        for (int x: nums) {
            if (numbers.contains(x)) {
                return true;
            }
            numbers.add(x);
        }
        return false;
    }
}
