public class DragonFly implements Move {
    @Override
    public void move(int x, int y) {
        System.out.printf("Hero is flying by dragon from point " + x + " to " + y + "\n");
    }
}
