package ru.netology;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("netology.homework", Server.LOCALHOST_PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader_2 = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String serverAns = reader.readLine(); // ждём, что скажет сервер
            System.out.println(serverAns); // получив - выводим на экран
            String Ans = reader_2.readLine(); // ждём пока клиент что-нибудь
            // не напишет в консоль
            writer.write(Ans + "\n"); // отправляем сообщение на сервер
            writer.flush();


            String serverAns2 = reader.readLine(); // ждём, что скажет сервер
            System.out.println(serverAns2); // получив - выводим на экран
            String word = reader_2.readLine(); // ждём пока клиент что-нибудь
            // не напишет в консоль
            writer.write(word + "\n"); // отправляем сообщение на сервер
            writer.flush();
            String serverWord = reader.readLine(); // ждём, что скажет сервер
            System.out.println(serverWord); // получив - выводим на экран


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
