import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpComparator {
    public static void main(String args[]){
        List<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(1);
        al.add(0);
        al.add(3);
        System.out.println("Before Sort: " + al);
        Comparator<Integer> cm = (o1,o2) -> o1<o2 ? -1 : o1>o2 ? 1 : 0;
//        Collections.sort(al,new TestComparator());
        Collections.sort(al,cm);
        System.out.println("After Sort: " + al);

    }
}

class TestComparator implements  Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1<o2 ? -1 : o1>o2 ? 1 : 0;
    }
}
