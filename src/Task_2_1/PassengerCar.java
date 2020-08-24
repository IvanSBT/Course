package Task_2_1;

public class PassengerCar extends Car {

    static double fuelTypeSumm;

    public PassengerCar(String str) {
        super(str);
        carTypeName="пассажирский транспорт";//300
        fuelPrice=47.50d;
        fuelPerKm =11.5d;
        setFuelSumm();
        fuelTypeSumm+=this.fuelSumm;
    }
}
