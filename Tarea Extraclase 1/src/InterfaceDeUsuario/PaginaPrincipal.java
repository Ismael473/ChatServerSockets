package InterfaceDeUsuario;

import javax.swing.*;


public class PaginaPrincipal {

    public static void main(String[] args) {
        JFrame pant = new JFrame();

        JButton botEnv = new JButton("Enviar");
        botEnv.setBounds(450,450,100,40);

        JButton botSal = new JButton("Salir");
        botSal.setBounds(450,500,100,40);

        JTextField mensaje = new JTextField();
        mensaje.setBounds(0,500, 400,20);

        botEnv.setVisible(true);
        botSal.setVisible(true);
        pant.add(botEnv);
        pant.add(botSal);
        pant.setSize(600,600);
        pant.setResizable(false);
        pant.setLayout(null);
        pant.setVisible(true);

    }
}
