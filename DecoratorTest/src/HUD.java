public class HUD extends CarDecorator{
    public HUD(Car decoratedCar){
        super(decoratedCar);
    }

    public int cost(){
        return super.cost() + 500000;
    }


}
