package exceptions;

import javax.swing.*;
import java.util.Scanner;

public class AppCliente {
    static void main() {
        String opcao = JOptionPane.showInputDialog(null,
                "Digite o codigo do cliente",
                "", JOptionPane.INFORMATION_MESSAGE);


        try{
            ClienteService.consultarCliente(opcao);
        }catch(ClienteNaoEncontrado2Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "sair", JOptionPane.INFORMATION_MESSAGE);
        }


    }
}
