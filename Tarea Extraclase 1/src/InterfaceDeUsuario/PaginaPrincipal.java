package InterfaceDeUsuario;

import javax.swing.*;


public class PaginaPrincipal {

    public static void main(String[] args) {
        JFrame pant = new JFrame();

        JButton botEnv = new JButton("Enviar");// Boton para enviar
        botEnv.setBounds(450,450,100,40);

        JButton botSal = new JButton("Salir");
        botSal.setBounds(450,500,100,40);// Boton para salir

        JTextField mensajeAEnviar = new JTextField();// Espacio en el cual escribir el mensaje
        mensajeAEnviar.setBounds(0,500, 400,20);

        JLabel mensaje = new JLabel("Mensajes ...");//Label que proyectará los mensajes del Servidor y del cliente
        mensaje.setBounds(0,100,40,20);

        mensajeAEnviar.setVisible(true);//Se hace visible el campo para enviar mensaje
        mensaje.setVisible(true);//Se hace visible el mensaje envia o recibido
        botEnv.setVisible(true);//Se hace visible el boton de enviar
        botSal.setVisible(true);//Se hace visible el boton de salir
        pant.add(mensaje);// Se añade el mensaje enviado o recibido a la pantalla
        pant.add(mensajeAEnviar);// se añade el campo para escribir mensajes a la pantalla
        pant.add(botEnv);// Se añade el boton de enviar
        pant.add(botSal);// Se añade el boton de salir
        pant.setSize(600,600);// Se establece el tamaño de la pantalla
        pant.setResizable(false);// Se declara que no puede cambiarse el tamaño de pantalla por parte del usuario
        pant.setLayout(null);// Se declara que la pantalla carece de layout
        pant.setVisible(true);// Se hace visible la pantalla

    }
}
