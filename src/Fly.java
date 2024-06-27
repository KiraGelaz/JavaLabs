public class Fly implements Move {
    @Override
    public void move(int x, int y) {
        System.out.printf("Hero is flying from point " + x + " to " + y + "\n");
    }
}
