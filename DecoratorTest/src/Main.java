public class Main {
    public static void main(String[] args) {
        Car myCar = new Hansung();
        Car myCarWithTpms = new TPM(myCar);
        Car myCarWithTpmsAcc = new ACC(myCarWithTpms);
        System.out.println(myCarWithTpmsAcc.cost());

        System.out.println("-------------------------");
        // same

        Car myCar2 = new ACC(new TPM(new Hansung()));
        System.out.println(myCar2.cost());
    }
}
