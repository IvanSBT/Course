package Task_2_1;

public class Car {

    String carTypeName;
    double fuelPrice;
    double fuelPerKm;
    int additionalParam;


    String govNumber;
    double kilometrage;

    public void setFuelSumm() {
        this.fuelSumm = kilometrage / fuelPerKm *fuelPrice;
    }

    double fuelSumm;

    public Car(String str) {
        govNumber = str.split("_")[1].split("-")[0];
        kilometrage = Double.parseDouble(str.split("-")[1]);

        String[] str1 = str.split("-");
        if (str1.length>2) additionalParam = Integer.parseInt(str1[2]);
    }

    @Override
    public String toString() {
        return "Госномер: "+ govNumber + "; Пробег: " + kilometrage + "; Доп.праметр: " + additionalParam ;
    }
}
