package Task_2_1;

public class Truck extends Car {

    static double fuelTypeSumm;

    public Truck(String str) {
        super(str);
        carTypeName="грузовой авто";//200
        fuelPrice=48.90d;
        fuelPerKm =12;
        setFuelSumm();
        fuelTypeSumm+=this.fuelSumm;
    }
}
