package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static final Integer LOCALHOST_PORT = 8082;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(LOCALHOST_PORT)) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            System.out.println("Server is start");
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            //отправить
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            //принять
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");

            out.write("Write your name:" + "\n");
            out.flush(); // выталкиваем все из буфера
            //ждем сообщения от клиента

            String message = in.readLine();

            out.write("Are you child? (yes/no) " + "\n");
            out.flush(); // выталкиваем все из буфера
            //ждем сообщения от клиента
            String child = in.readLine();

            if (child.equals("yes")) {
                //отправляем ответ клиенту
                out.write(String.format("Welcome to the kids area, %s Let's play!", message) + "\n");
                out.flush(); // выталкиваем все из буфера
            } else if (child.equals("no")) {
                out.write(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", message) + "\n");
                out.flush(); // выталкиваем все из буфера
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
