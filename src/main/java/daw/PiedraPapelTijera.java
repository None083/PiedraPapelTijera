/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author noelia
 */
public class PiedraPapelTijera {

    public static void main(String[] args) {

        String opcionModo;
        String jugador1;
        String jugador2;
        int parseOpcionModo = 0;
        boolean errorNumberFormat = false;
        int randomJugador;
        
        Random random = new Random();
        Scanner teclado = new Scanner(System.in);
        
        do {
            do {
                try {
                    opcionModo = JOptionPane.showInputDialog("""
                                                        
                             ESCOJA UN MODO DE JUEGO
                    ----------------------------------------
                                                        
                        1 - Juego de dos jugadores
                                                        
                        2 - Juegador vs Máquina
                                                        
                        3 - Salir
                    
                    ----------------------------------------
                                                        
                                    """);

                    parseOpcionModo = Integer.parseInt(opcionModo);

                } catch (NumberFormatException nfe) {
                    System.out.println("Eso no es un NÚMERO");
                    errorNumberFormat = true;
                }

            } while (errorNumberFormat);

        } while (!(parseOpcionModo >= 1 && parseOpcionModo <= 3));

        switch (parseOpcionModo) {
            case 1 -> {
                jugador1 = JOptionPane.showInputDialog("Introduce el nombre del jugador 1");
                jugador2 = JOptionPane.showInputDialog("Introduce el nombre del jugador 2");
                randomJugador = random.nextInt(1, 3);
                
                String opcionesPPT = """
                                          ESCOJA UNA OPCIÓN
                                     ---------------------------
                                     
                                            - Piedra
                                     
                                            - Papel
                                     
                                            - Tijera
                                     
                                     ---------------------------
                                     """;
                
                if(randomJugador == 1){
                    System.out.println("Comienza " + jugador1 + ":");
                    String opcionJugador1 = teclado.nextLine();
                    System.out.println("Escoje " + jugador2 + ":");
                    String opcionJugador2 = teclado.nextLine();
                }
                
            }
        }

    }
}
