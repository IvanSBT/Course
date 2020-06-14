package Task1;
public class Task_1 {

    //Исходные данные
//    Формат данных - C(CODE_CAR)_гос номер-Пробег-(доп. параметр)

    static String[] inputStr  = {
                                  "C100_1-100"
                                , "C200_1-120-1200"
                                , "C300_1-120-30"
                                , "C400_1-80-20"
                                , "C100_2-50"
                                , "C200_2-40-1000"
                                , "C300_2-200-45"
                                , "C400_2-10-20"
                                , "C100_3-10"
                                , "C200_3-170-1100"
                                , "C300_3-150-29"
                                , "C400_3-100-28"
                                , "C100_1-300"
                                , "C200_1-100-750"
                                , "C300_1-32-15"
                                };

    //Справочник авто
    static String[][] cartype = {
            {"100","легковой авто"}
            , {"200","грузовой авто"}
            , {"300","пассажирский транспорт"}
            , {"400","тяжелая техника(краны)"}
    };

    static String[][] fuelPrice = {
              {"100","46.10"}
            , {"300","47.50"}
            , {"200","48.90"}
            , {"400","48.90"}
    };

    static String[][] fuleCons = {
            {"100","12.5"}
            , {"300","12"}
            , {"200","11.5"}
            , {"400","20"}
    };

    public static void main(String[] args) {

        //Заполняем массив со списком типов авто
        int cnt = 0;
        String carListAll[] = new String[inputStr.length];
        for (String car: inputStr) {
            boolean unq=true;
            String carTypeNo = getCarTypeNo(car);
            for (String icar : carListAll) {
                if(icar!=null&&icar.equals(carTypeNo)){
                    unq=false;
                }
            }
            if(unq) carListAll[cnt++]=carTypeNo;

        }
        //Заполняем массив только с уникальным списком авто
        String carList[] = new String[cnt];
        for (int i = 0; i < carList.length; i++) {
            carList[i]=carListAll[i];
        }


        //Заполняем топливо в разрезе типа авто
        double[] arrFuelCons = new double[cnt];
        double fuelSummAll=0d;//Общая сумма;
        for (String car: inputStr) {
            String  carType = getCarTypeNo(car);
//            if(carType.equals("100")) {
                int id = getArrId(carList, carType);
                double cons = getCarCons(car);//пробег
                double fuelCons = getfuleCons(carType);//расход
                double fuelPrce = getPrice(carType);//цена бензина
                double summ = cons / fuelCons * fuelPrce;
                summ = summ*100;
                summ=Math.round(summ);
                summ=summ/100;
                arrFuelCons[id] += summ;
                fuelSummAll += summ;

//                System.out.println(cons);
//                System.out.println(fuelCons);
//                System.out.println(fuelPrce);
//                System.out.println(summ);
//                System.out.println("");
//            }

        }

        int minSummCarId=0;
        int maxSummCarId=0;
        //Выврдим по кажому типу авто
        System.out.println("-----------------СУММА ТОПЛИВА В РАЗРЕВЕ ПО ТИПУ АВТО---------------");
        for (int i = 0; i < carList.length; i++) {
            System.out.println(getTypeName(carList[i]) + " = " + arrFuelCons[i]);
            minSummCarId=arrFuelCons[minSummCarId]<arrFuelCons[i] ? minSummCarId : i;//определяем авто с наименьшим расходом
            maxSummCarId=arrFuelCons[maxSummCarId]>arrFuelCons[i] ? maxSummCarId : i;//определяем авто с наибольшим расходом
        }

        //Общая сумма
        System.out.println("-----------------СУММА ТОПЛИВА ОБЩАЯ---------------");
        System.out.println("Общая сумма(fuelSummAll) = " + fuelSummAll);

        //Авто с наименьшими затратами затратами
        System.out.println("-----------------Тип авто с наименьшими затратами---------------");
        System.out.println(getTypeName(carList[minSummCarId]));

        //Авто с наибольшими затратами
        System.out.println("-----------------Тип авто с наибольшими затратами---------------");
        System.out.println(getTypeName(carList[maxSummCarId]));

        //ВЫВОД ИНФЫ ПО КАЖЛОМУ ТРАНСПОРТУ
        System.out.println("-----------------Информация по каждому транспорту---------------");
        for (int i = 0; i < carList.length ; i++) {
            String carTypeNo = carList[i];
            getInfo(carTypeNo);
        }

    }

    private static void getInfo(String carTypeNo) {
        System.out.println(getTypeName(carTypeNo).toUpperCase());
        int arrSize=0;
        for (String car: inputStr){
            String rowCarTypeNo = getCarTypeNo(car);
            if (carTypeNo.equals(rowCarTypeNo)){
                arrSize++;
            }
        }
        String arrThisCarType [] = new String[arrSize];
        int ii=0;
        for (String car: inputStr){
            String rowCarTypeNo = getCarTypeNo(car);
            if (carTypeNo.equals(rowCarTypeNo)){
                arrThisCarType[ii++]=car;
            }
        }

        sortThisCarType(arrThisCarType);//сортируем

        for (String c : arrThisCarType) {
            System.out.println("Госномер: " + getGovNumber(c) + "; Пробег: " + getCarCons(c) + "; Доп.праметр: "  +getAddInfo(c));
        }
    }

    private static void sortThisCarType(String[] arrThisCarType) {
        boolean isSorted = false;
        String buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrThisCarType.length-1; i++) {
                if(Integer.parseInt(arrThisCarType[i].split("-")[1]) > Integer.parseInt(arrThisCarType[i+1].split("-")[1])){
                    isSorted = false;
                    buf = arrThisCarType[i];
                    arrThisCarType[i] = arrThisCarType[i+1];
                    arrThisCarType[i+1] = buf;
                }
            }
        }
    }



    //Получить имя по номеру
    public static String getTypeName (String carTypeNo) {
        for (String[] i: cartype) {
            if(carTypeNo.equals(i[0])){
                return (i[1]);
            }
        }
        return "";
    }

    //Получить цену топлива по номеру
    public static double getPrice (String carTypeNo) {
        for (String[] i: fuelPrice) {
            if(carTypeNo.equals(i[0])){
                return (Double.parseDouble(i[1]));
            }
        }
        return 0;
    }

    //Получить расход по номеру
    public static double getfuleCons (String carTypeNo) {
        for (String[] i: fuleCons) {
            if(carTypeNo.equals(i[0]) ){
//                System.out.println("Цена топлива"+i[1]);
                return (Double.parseDouble(i[1]));

            }
        }
        return 0;
    }

    //*******Парсим входящую строку
    //Тип авто
    public static String getCarTypeNo (String str1) {
        return str1.split("-")[0].split("_")[0].substring(1);
    }
    //Пробег
    public static double getCarCons (String str1) {
        return Double.parseDouble((str1.split("-")[1]));
    }
    //Гос.номер
    public static String getGovNumber (String str1) {
        return str1.split("_")[1].split("-")[0];
    }
    //Доп.параметр
    public static String getAddInfo (String str1) {
        String[] str = str1.split("-");
        if (str.length>2){
            return str[2];
        } else return "Нет";
//        return str1.split("_")[1].split("-")[0];
    }


    //Прочее
    public static int getArrId (String[] carList, String carTypeNo) {
        for (int i = 0; i < carList.length; i++) {
            if(carList[i].equals(carTypeNo)) return i;
        }
        return -1;
    }


}
