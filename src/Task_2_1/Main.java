package Task_2_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    //    Формат данных - C(CODE_CAR)_гос номер-Пробег-(доп. параметр)
/*    static String[] inputStr  = {
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
    };*/


    public static void main(String[] args) {

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println(formatForDateNow.format(dateNow));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = "";

        while (!readLine.equals("Start"))
        {
            System.out.println("Наберите Start для начала");
            try {
                readLine = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String resultString="";

        readLine = "";
        System.out.println("Введите данные об авто в формате C(CODE_CAR)_гос номер-Пробег-(доп. параметр). Пример C100_1-100. Для окончания введите END");
        while (!readLine.equals("END"))
        {
            try {
                readLine = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (readLine.equals("END")) System.out.println("Ввод данных окончен");

            else if (readLine.matches("C[1,2,3,4]00_[0-9]-[0-9]{1,6}(-[0-9]{1,4})*")){
                if (resultString.equals("")) {
                    resultString=readLine;
                } else resultString+=","+readLine ;
                System.out.println("Запись добавлена");
            } else System.out.println("Некорретный формат");
        }

        System.out.println(resultString);

//        Создаем файл
        String fileName = formatForDateNow.format(dateNow)+".txt";
        String filePathStr = "Save";
        String fullFilePath = filePathStr+"/"+fileName;

        File filePath = new File(filePathStr);
        filePath.mkdir();
        File file = new File(fullFilePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Читаем файл
        String contents="";
        try {
            contents = readFile(fullFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!contents.equals("")) {
            resultString=contents + "," + resultString;
        }

//        Записываем в файл
        try {
            FileWriter writer = new FileWriter(fullFilePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(resultString);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }

        String[] inputStr = resultString.split(",");

        System.out.println(resultString);
        runCalc(inputStr);

    }

    public static void runCalc(String[] inputStr){
        //Заполняем массив авто
        int i = 0;
        Car [] cars = new Car [inputStr.length];
        for (String str: inputStr) {
            String carType = getCarTypeNo(str);
            switch (carType){
                case "100" :
                    cars[i++]=new Auto(str);
                    break;
                case "200" :
                    cars[i++]=new Truck(str);
                    break;
                case "300" :
                    cars[i++]=new PassengerCar(str);
                    break;
                case "400" :
                    cars[i++]=new SpechTech(str);
                    break;
            }
        }

        PrintInfo.help();
//        PrintInfo.ShowSummPerAutoType();
//        PrintInfo.ShowSummShare();
//        PrintInfo.ShowMinSumm("Min");
//        PrintInfo.ShowMinSumm("Max");
//        PrintInfo.ShowInfoType(cars,"ЛЕГКОВОЙ АВТО");
//        PrintInfo.ShowInfoType(cars,"ГРУЗОВОЙ АВТО");
//        PrintInfo.ShowInfoType(cars,"ПАССАЖИРСКИЙ ТРАНСПОРТ");
//        PrintInfo.ShowInfoType(cars,"ТЯЖЕЛАЯ ТЕХНИКА(КРАНЫ)");

    }

    //*******Парсим входящую строку
    //Тип авто
    public static String getCarTypeNo (String str1) {
        return str1.split("-")[0].split("_")[0].substring(1);
    }

    // читаем файл в строку с помощью класса Files
    private static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
