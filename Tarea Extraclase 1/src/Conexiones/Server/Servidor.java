package Conexiones.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        final ServerSocket serverSocket;// Se necesita para enviar y recibir información del cliente
        final Socket clienteSocket;// Se necesita para eviar y recibir información del cliente
        final BufferedReader dentro;// Se utiliza para leer la información que llega del cliente
        final PrintWriter fuera;//Se utiliza para escribir información que se le envia al cliente
        final Scanner sc = new Scanner(System.in);
        try {
            serverSocket = new ServerSocket(5000);//Puerto al cual se conecta el socket
            clienteSocket = serverSocket.accept();
            fuera = new PrintWriter(clienteSocket.getOutputStream());
            dentro = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            Thread emisor = new Thread(new Runnable() {
                String msg;

                @Override
                public void run() {
                    while (true) {
                        msg = sc.nextLine();
                        fuera.println(msg);
                        fuera.flush();
                    }
                }
            });
            emisor.start();

            Thread receptor = new Thread(new Runnable() {
                String msg;

                @Override
                public void run() {
                    try {
                        msg = dentro.readLine();
                        while (msg != null) {
                            System.out.println("Cliente:" + msg);
                            msg = dentro.readLine();

                        }
                        System.out.println("Cliente desconectado");
                        fuera.close();
                        clienteSocket.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receptor.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}