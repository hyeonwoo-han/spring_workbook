public class ACC extends CarDecorator{
    public ACC(Car decoratedCar){
        super(decoratedCar);
    }

    public int cost(){
        return super.cost() + 3000000;
    }

    
}
