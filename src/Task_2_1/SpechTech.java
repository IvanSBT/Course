package Task_2_1;

public class SpechTech extends Car {

    static double fuelTypeSumm;

    public SpechTech(String str) {
        super(str);
        carTypeName="тяжелая техника(краны)";//400
        fuelPrice=48.90d;
        fuelPerKm =20d;
        setFuelSumm();
        fuelTypeSumm+=this.fuelSumm;
    }
}
