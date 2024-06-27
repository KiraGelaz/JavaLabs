public class Hero {
    public Hero()
    {
        setStrategy(new Run());
    }
    public void setStrategy(Move moveStrategy){
        this.moveStrategy = moveStrategy;
    }
    public void move(int x, int y)
    {
        this.moveStrategy.move(x, y);
    }
    private Move moveStrategy;
}
