public class ADAS extends CarDecorator{
    public ADAS(Car decoratedCar){
        super(decoratedCar);
    }

    public int cost(){
        return super.cost() + 10000000;
    }


}
