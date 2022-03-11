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
        final Socket clienteSocket;//Se utiliza para enviar y recibir los datos del servidor
        final BufferedReader dentro;//Lee los datos que entran del socket
        final PrintWriter fuera;//Escribe los datos que salen del socket
        final Scanner sc = new Scanner(System.in);// permite el ingreso de datos por parte del teclado de la computadora
        try{
            clienteSocket = new Socket("127.0.0.1",5000);// son los parametros utilizados para poder establecer conexión entre el servidor y el cliente
            fuera = new PrintWriter(clienteSocket.getOutputStream());
            dentro = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));


            Thread emisor = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while(true){// Mientras esto corra se escribiran y enviarán los mensajes al servidor
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
                        while(msg != null){//Mientras eto corra se recibiran e imprimiran en pantalla los mensajes recibidos por parte del servidor
                            System.out.println("Server: " +msg);
                            msg = dentro.readLine();
                        }
                        System.out.println("Servidor fuera de servicio");
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
