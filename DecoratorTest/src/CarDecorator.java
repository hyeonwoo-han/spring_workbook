public abstract class CarDecorator extends Car{
    private Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    public int cost(){
        return decoratedCar.cost();
    }

}
