import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void segregate(ArrayList<? extends Mammals> srcColl, List<? super Hadgehogs> coll1,
                                 List<? super Manul> coll2, List<? super Lynx> coll3) {
        int size1 = coll1.size();
        int size2 = coll2.size();
        int size3 = coll3.size();
        for (var animal : srcColl) {
            if (animal instanceof Hadgehogs) {
                coll1.add((Hadgehogs) animal);
            }
            if (animal instanceof Manul) {
                coll2.add((Manul) animal);
            }
            if (animal instanceof Lynx) {
                coll3.add((Lynx) animal);
            }
        }
        System.out.println("Hadgehogs " + (coll1.size() - size1));
        System.out.println("Manul " + (coll2.size() - size2));
        System.out.println("Lynx " + (coll3.size() - size3) + "\n");
    }
    public static void main(String[] args) {

        ArrayList< Mammals > list_ = new ArrayList<>();
        ArrayList< Predatory > list1_ = new ArrayList<>();
        ArrayList< Erinaceidae > list2_ = new ArrayList<>();
        list_.add(new Manul());
        list_.add(new Lynx());
        list_.add(new Hadgehogs());
        list_.add(new Manul());
        list_.add(new Lynx());
        list_.add(new Hadgehogs());

        list1_.add(new Manul());
        list1_.add(new Lynx());

        list2_.add(new Hadgehogs());
        list2_.add(new Hadgehogs());

        List<Erinaceidae> col_1 = new ArrayList<>();
        List<Feline> col_2 = new ArrayList<>();
        List<Predatory> col_3 = new ArrayList<>();
        List<Chordates> col_4 = new ArrayList<>();
        List<Manul> col_5 = new ArrayList<>();
        List<Insectivores> col_6 = new ArrayList<>();

        segregate(list_, col_1, col_2, col_3);
        segregate(list1_, col_4, col_5, col_2);
        segregate(list2_, col_6, col_3, col_3);
    }
}