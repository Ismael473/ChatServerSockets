package Conexiones.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.RuleBasedCollator;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        final Socket clienteSocket;
        final BufferedReader dentro;
        final PrintWriter fuera;
        final Scanner sc = new Scanner(System.in);
        try{
            clienteSocket = new Socket("127.0.0.1",5000);
            fuera = new PrintWriter(clienteSocket.getOutputStream());
            dentro = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));


            Thread emisor = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while(true){
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
                    try{
                        msg = dentro.readLine();
                        while(msg != null){
                            System.out.println("Server: " +msg);
                            msg = dentro.readLine();
                        }
                        System.out.println("Server fuera de servicio");
                        fuera.close();
                        clienteSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receptor.start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
