public class Run implements Move {
    @Override
    public void move(int x, int y) {
        System.out.printf("Hero is running from point " + x + " to " + y + "\n");
    }
}