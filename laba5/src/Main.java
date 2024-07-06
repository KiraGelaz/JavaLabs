import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //1)average
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println("1)Average of list: " + getAverage(list1));

        //2)"string" to uppercase + "_new_"
        List<String> list2 = new ArrayList<>(List.of("aboba", "bobba", "aobab"));
        System.out.println("2)\"String\" to uppercase + \"_new_\":");
        changeString(list2);

        //3)get list of squares from distinct elements
        List<Integer> list3 = new ArrayList<>(List.of(1, 2, 2, 3, 4, 4, 5));
        System.out.println("3)Get list of squares from distinct elements: " + getSquaresFromDistincts(list3));

        //4)get Sorted Strings By First Char
        Collection<String> collection1 = new ArrayList<>(List.of("abcd", "bcde", "acbd", "bcad"));
        System.out.println("4)Sorted strings by first char: " + getSortedStringsByFirstChar(collection1, 'b'));

        //5)get last or throw if empty
        //Collection<String> collection2 = new ArrayList<>();
        System.out.println("5)Last el: " + getLastOrThrowExceptionIfEmpty(collection1));

        //6)Get sum of even
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("6)Sum of even: " + getSumOfEven(array));

        //7)Get Map<Character, String> from list
        List<String> list4 = new ArrayList<>(List.of("aboba", "aobba", "cobab"));
        System.out.println("7)Map from list: " +getMapFromList(list4));
    }

    public static double getAverage(List<Integer> list){
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public static void changeString(List<String> list){
        list.stream()
                .map(String::toUpperCase)
                .map(x -> "_new_".concat(x))
                .forEach(System.out::println);
    }

    public static List<Integer> getSquaresFromDistincts(List<Integer> list){
        return list.stream()
                .filter(x -> Collections.frequency(list, x) == 1)
                .map(x -> x * x).toList();
    }

    public static List<String> getSortedStringsByFirstChar(Collection<String> collection, char firstLetter){
        return collection.stream()
                .filter(string -> string.charAt(0) == firstLetter)
                .sorted()
                .toList();
    }

    public static <T> T getLastOrThrowExceptionIfEmpty(Collection<T> collection){
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NullPointerException());
    }

    public static int getSumOfEven(int[] array){
        return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .sum();
    }

    public static Map<Character, String> getMapFromList(List<String> list){
        return list.stream()
                .collect(Collectors.toMap(c -> c.charAt(0), c -> c.substring(1), (first, second) -> first + second));
    }
}