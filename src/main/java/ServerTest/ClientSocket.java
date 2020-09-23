package ServerTest;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ClientSocket implements Runnable{

    private Socket socket;


    private StringBuilder fileStr  = new StringBuilder();

    public ClientSocket(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client connected...");

            BufferedReader in;
            BufferedWriter out;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //Читаем файл
//            так не работает
//            String s;
//            while((s=in.readLine())!=null){
//                System.out.println("Считали строку");
//                fileStr.append(s + "\n");
////                break;
//            }
            fileStr.append(in.readLine());
            System.out.println("Закончили чтение файла");

            String inStr = fileStr.substring(0,fileStr.length()-1);

            //Пишем в файл
            String fileName = String.valueOf(UUID.randomUUID()) + ".txt";
            BufferedWriter writter = new BufferedWriter(new FileWriter("Save/" + fileName));
            writter.write(inStr);
            writter.close();
            System.out.println("Записан файл " + fileName);

            //Отвечаем
            out.write("Создан файл " + fileName + "\n");
//            out.write("Привет, это Сервер! Подтверждаю, вы написали : " + "asd" + "\n");
            out.flush(); // выталкиваем все из буфера


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
