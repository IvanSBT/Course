package Task_2_1;

import java.util.HashMap;
import java.util.Map;

public class PrintInfo {

    public static void help(){
        System.out.println("Достпны команд:");
        System.out.println("sort[параметр]");
        System.out.println("history[дата]");
    }

    public static void ShowSummPerAutoType(){
        System.out.println("-----------------СУММА ТОПЛИВА В РАЗРЕВЕ ПО ТИПУ АВТО---------------");
        System.out.println("Cумма по АВТО = " + Auto.fuelTypeSumm);
        System.out.println("Сумма по грузовикам = " + Truck.fuelTypeSumm);
        System.out.println("Сумма по пассажирским = " + PassengerCar.fuelTypeSumm);
        System.out.println("Сумма по спецтехнике = " + SpechTech.fuelTypeSumm);
    }

    public static void ShowSummShare(){
        double SummShare = Auto.fuelTypeSumm + Truck.fuelTypeSumm + PassengerCar.fuelTypeSumm+ SpechTech.fuelTypeSumm;
        System.out.println("-----------------СУММА ТОПЛИВА ОБЩАЯ---------------");
        System.out.println("Общая сумма(fuelSummAll) = " + SummShare);
    }

    public static void ShowMinSumm(String Type){
        HashMap<String, Double> MinSummMap = new HashMap<String, Double>();
        MinSummMap.put("легковое авто",Auto.fuelTypeSumm);
        MinSummMap.put("грузовое авто",Truck.fuelTypeSumm);
        MinSummMap.put("пассажирское авто",PassengerCar.fuelTypeSumm);
        MinSummMap.put("спецтехника",SpechTech.fuelTypeSumm);

        String name="";
        Double summ=0d;

        if (Type == "Min") {
            for (Map.Entry<String, Double> entry : MinSummMap.entrySet()) {
                if (summ == 0d || summ > entry.getValue()) {
                    summ = entry.getValue();
                    name = entry.getKey();
                }
            }
            System.out.println("-----------------Тип авто с наименьшими затратами---------------");
            System.out.println(name + " = " + summ);
        } else if (Type == "Max"){
            for (Map.Entry<String, Double> entry : MinSummMap.entrySet()) {
                if (summ == 0d || summ < entry.getValue()) {
                    summ = entry.getValue();
                    name = entry.getKey();
                }
            }
            System.out.println("-----------------Тип авто с наибольшими затратами---------------");
            System.out.println(name + " = " + summ);
        }
    }

    public static void ShowInfoType( Car[] cars,String Type){
        System.out.println("-----------------"+Type+"---------------");
        for (Car car: cars) {
            if (Type == "ЛЕГКОВОЙ АВТО" && car instanceof Auto ){
                System.out.println(car);
            }
            if (Type == "ГРУЗОВОЙ АВТО" && car instanceof Truck ){
                System.out.println(car);
            }
            if (Type == "ПАССАЖИРСКИЙ ТРАНСПОРТ" && car instanceof PassengerCar ){
                System.out.println(car);
            }
            if (Type == "ТЯЖЕЛАЯ ТЕХНИКА(КРАНЫ)" && car instanceof SpechTech ){
                System.out.println(car);
            }

        }
    }

}
