/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conmetodos;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author noelia
 */
public class UtilidadesPPT {

    public static int opcionMenuJuego() {
        Scanner teclado = new Scanner(System.in);
        String opcionModo;
        int parseOpcionModo = 0;
        boolean errorNumberFormat = false;
        do {
            try {
                opcionModo = JOptionPane.showInputDialog("""
                                                        
                              ESCOJA UN MODO DE JUEGO
                    --------------------------------------------------------
                                                          
                                1 - Juego de dos jugadores                                
                                2 - Juegador vs Máquina                              
                                3 - Salir
                    
                    --------------------------------------------------------
                                                        
                                    """);
                //Parseo el string del joption a int
                parseOpcionModo = Integer.parseInt(opcionModo);

            } catch (NumberFormatException nfe) {
                teclado.nextLine();
                JOptionPane.showMessageDialog(null,
                        "Eso no es un NÚMERO");
                errorNumberFormat = true;
            }

        } while (errorNumberFormat);

        return parseOpcionModo;
    }

    public static void introducirNombre(String jugador1, String jugador2) {
        jugador1 = JOptionPane.showInputDialog(
                "Introduce el nombre del jugador 1");
        jugador2 = JOptionPane.showInputDialog(
                "Introduce el nombre del jugador 2");
    }

    public static int quienEmpieza(int numJugadores) {
        Random random = new Random();
        return random.nextInt(1, (numJugadores + 1));
    }

    public static String escogeMaquina() {
        Random random = new Random();
        int randomMaquina = random.nextInt(1, 4);
        String opcionMaquina = "";
        switch (randomMaquina) {
            case 1 -> {
                opcionMaquina = "Piedra";
            }
            case 2 -> {
                opcionMaquina = "Papel";
            }
            case 3 -> {
                opcionMaquina = "Tijera";
            }
        }
        return opcionMaquina;
    }

}
