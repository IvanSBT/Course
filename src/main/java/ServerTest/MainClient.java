package ServerTest;

import java.io.*;
import java.net.Socket;

public class MainClient {
//    static BufferedWriter out;
//    static BufferedReader in;
    static StringBuilder fileStr = new StringBuilder();

    public static void main(String[] args) {

        try  {

            //1. Считываем файл
            BufferedReader br = new BufferedReader(new FileReader("Save/test.txt"));
            String s;
            while((s=br.readLine())!=null){
                fileStr.append(s + "\n");
            }
            fileStr.append('-');
            String outStr = fileStr.substring(0,fileStr.length()-1);
            br.close();

            //2. Открываем соединение
            Socket socket = new Socket( "localhost",9000);
            System.out.println("Client connected...");

            //3. Отправляем содержимое файла
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(outStr);
            out.flush();

/*            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write("Текст"+"\n");
            out.flush();*/

            System.out.println("Файл отправлен");

            //4. Читаем ответ

            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Ждем ответа...");
            String inStr=null;
            inStr= in.readLine();
            System.out.println(inStr);

            //5. Закрываем соединение
            System.out.println("Close connection");
            socket.close();
            in.close();

            System.out.println("finish");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
