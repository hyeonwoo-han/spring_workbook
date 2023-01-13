public class TPM extends CarDecorator{
    public TPM(Car decoratedCar){
        super(decoratedCar);
    }

    public int cost(){
        return super.cost() + 1000000;
    }
}
