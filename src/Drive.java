public class Drive implements Move {
    @Override
    public void move(int x, int y) {
        System.out.printf("Hero is driving by car from point " + x + " to " + y + "\n");
    }
}