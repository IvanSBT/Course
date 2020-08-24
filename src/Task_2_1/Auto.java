package Task_2_1;

public class Auto extends Car {

    static double fuelTypeSumm;

    public Auto(String str) {
        super(str);
        carTypeName="легковой авто";//100
        fuelPrice=46.10d;
        fuelPerKm =12.5d;
        setFuelSumm();
        fuelTypeSumm+=this.fuelSumm;
    }

}
