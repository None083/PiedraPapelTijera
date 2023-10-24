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

        final int NUMERO_RONDAS = 5;
        String opcionModo;
        String nombreJugador1;
        String nombreJugador2;
        int parseOpcionModo = 0;
        boolean errorNumberFormat = false;
        int randomJugador;
        int contadorJugador1 = 0;
        int contadorJugador2 = 0;
        int contadorMaquina = 0;

        Random random = new Random();
        Scanner teclado = new Scanner(System.in);

        do {
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

                    parseOpcionModo = Integer.parseInt(opcionModo);

                } catch (NumberFormatException nfe) {
                    teclado.nextLine();
                    JOptionPane.showMessageDialog(null,
                            "Eso no es un NÚMERO");
                    errorNumberFormat = true;
                }

            } while (errorNumberFormat);

        } while (!(parseOpcionModo >= 1 && parseOpcionModo <= 3));

        switch (parseOpcionModo) {
            case 1 -> {
                nombreJugador1 = JOptionPane.showInputDialog(
                        "Introduce el nombre del jugador 1");
                nombreJugador2 = JOptionPane.showInputDialog(
                        "Introduce el nombre del jugador 2");
                randomJugador = random.nextInt(1, 3);

                for (int i = 0; i < NUMERO_RONDAS; i++) {
                    System.out.println("""
                                          ESCRIBA UNA OPCIÓN
                                     ----------------------------
                                     
                                             - Piedra
                                             - Papel
                                             - Tijera
                                     
                                     ----------------------------
                                     """);

                    String opcionJugador1;
                    String opcionJugador2;

                    System.out.println("Ronda " + (i + 1));

                    if (randomJugador == 1) {
                        do {
                            System.out.println("Comienza " + nombreJugador1 + ":");
                            opcionJugador1 = teclado.nextLine();

                            if (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                    || opcionJugador1.equalsIgnoreCase("Papel")
                                    || opcionJugador1.equalsIgnoreCase("Tijera"))) {
                                System.out.println("Esa opción no es válida, escribe una de la lista");
                            }
                        } while (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                || opcionJugador1.equalsIgnoreCase("Papel")
                                || opcionJugador1.equalsIgnoreCase("Tijera")));

                        do {
                            System.out.println("Escoje " + nombreJugador2 + ":");
                            opcionJugador2 = teclado.nextLine();

                            if (!(opcionJugador2.equalsIgnoreCase("Piedra")
                                    || opcionJugador2.equalsIgnoreCase("Papel")
                                    || opcionJugador2.equalsIgnoreCase("Tijera"))) {
                                System.out.println("Esa opción no es válida, escribe una de la lista");
                            }
                        } while (!(opcionJugador2.equalsIgnoreCase("Piedra")
                                || opcionJugador2.equalsIgnoreCase("Papel")
                                || opcionJugador2.equalsIgnoreCase("Tijera")));

                    } else {
                        do {
                            System.out.println("Comienza " + nombreJugador2 + ":");
                            opcionJugador2 = teclado.nextLine();

                            if (!(opcionJugador2.equalsIgnoreCase("Piedra")
                                    || opcionJugador2.equalsIgnoreCase("Papel")
                                    || opcionJugador2.equalsIgnoreCase("Tijera"))) {
                                System.out.println("Esa opción no es válida, escribe una de la lista");
                            }
                        } while (!(opcionJugador2.equalsIgnoreCase("Piedra")
                                || opcionJugador2.equalsIgnoreCase("Papel")
                                || opcionJugador2.equalsIgnoreCase("Tijera")));

                        do {
                            System.out.println("Escoje " + nombreJugador1 + ":");
                            opcionJugador1 = teclado.nextLine();

                            if (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                    || opcionJugador1.equalsIgnoreCase("Papel")
                                    || opcionJugador1.equalsIgnoreCase("Tijera"))) {
                                System.out.println("Esa opción no es válida, escribe una de la lista");
                            }
                        } while (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                || opcionJugador1.equalsIgnoreCase("Papel")
                                || opcionJugador1.equalsIgnoreCase("Tijera")));

                    }
                    if ((opcionJugador1.equalsIgnoreCase("Papel")
                            && opcionJugador2.equalsIgnoreCase("Piedra"))
                            || (opcionJugador1.equalsIgnoreCase("Piedra")
                            && opcionJugador2.equalsIgnoreCase("Tijera"))
                            || (opcionJugador1.equalsIgnoreCase("Tijera")
                            && opcionJugador2.equalsIgnoreCase("Papel"))) {

                        contadorJugador1++;
                        System.out.println("""
                                       
                                       %s ha sacado: %s
                                       %s ha sacado: %s
                                       Punto para: %s
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                nombreJugador2, opcionJugador2,
                                nombreJugador1));
                    } else {
                        contadorJugador2++;
                        System.out.println("""
                                       
                                       %s ha sacado: %s
                                       %s ha sacado: %s
                                       Punto para: %s
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                nombreJugador2, opcionJugador2,
                                nombreJugador2));
                    }
                    if (contadorJugador1 == 3 || contadorJugador2 == 3) {
                        break;
                    }
                }

                if (contadorJugador1 > contadorJugador2) {
                    System.out.println("Ha ganado: " + nombreJugador1 + ", ¡¡ENHORABUENA!!");
                } else {
                    System.out.println("Ha ganado: " + nombreJugador2 + ", ¡¡ENHORABUENA!!");
                }

            }
            case 2 -> {
                nombreJugador1 = JOptionPane.showInputDialog(
                        "Introduce el nombre del jugador 1");
                randomJugador = random.nextInt(1, 3);

                for (int i = 0; i < NUMERO_RONDAS; i++) {
                    System.out.println("""
                                          ESCRIBA UNA OPCIÓN
                                     ----------------------------
                                     
                                             - Piedra
                                             - Papel
                                             - Tijera
                                     
                                     ----------------------------
                                     """);

                    String opcionJugador1;
                    String opcionMaquina = "";
                    int randomMaquina = random.nextInt(1, 4);

                    System.out.println("Ronda " + (i + 1));

                    if (randomJugador == 1) {
                        do {
                            System.out.println("Comienza " + nombreJugador1 + ":");
                            opcionJugador1 = teclado.nextLine();

                            if (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                    || opcionJugador1.equalsIgnoreCase("Papel")
                                    || opcionJugador1.equalsIgnoreCase("Tijera"))) {
                                System.out.println("Esa opción no es válida, escribe una de la lista");
                            }
                        } while (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                || opcionJugador1.equalsIgnoreCase("Papel")
                                || opcionJugador1.equalsIgnoreCase("Tijera")));

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
                        System.out.println("La Máquina ha escogido");
                    } else {
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
                        System.out.println("La Máquina ha escogido");

                        do {
                            System.out.println("Escoge " + nombreJugador1 + ":");
                            opcionJugador1 = teclado.nextLine();

                            if (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                    || opcionJugador1.equalsIgnoreCase("Papel")
                                    || opcionJugador1.equalsIgnoreCase("Tijera"))) {
                                System.out.println("Esa opción no es válida, escribe una de la lista");
                            }
                        } while (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                || opcionJugador1.equalsIgnoreCase("Papel")
                                || opcionJugador1.equalsIgnoreCase("Tijera")));
                    }

                    if ((opcionJugador1.equalsIgnoreCase("Papel")
                            && opcionMaquina.equalsIgnoreCase("Piedra"))
                            || (opcionJugador1.equalsIgnoreCase("Piedra")
                            && opcionMaquina.equalsIgnoreCase("Tijera"))
                            || (opcionJugador1.equalsIgnoreCase("Tijera")
                            && opcionMaquina.equalsIgnoreCase("Papel"))) {

                        contadorJugador1++;
                        System.out.println("""
                                       
                                       %s ha sacado: %s
                                       La máquina ha sacado: %s
                                       Punto para: %s
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                opcionMaquina, nombreJugador1));
                    } else {
                        contadorMaquina++;
                        System.out.println("""
                                       
                                       %s ha sacado: %s
                                       La Máquina ha sacado: %s
                                       Punto para: La Máquina
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                opcionMaquina));
                    }
                    if (contadorJugador1 == 3 || contadorMaquina == 3) {
                        break;
                    }

                    if (contadorJugador1 > contadorJugador2) {
                        System.out.println("Ha ganado: " + nombreJugador1 + ". ¡¡ENHORABUENA!!");
                    } else {
                        System.out.println("Ha ganado: La Máquina. La vida es dura");
                    }
                }
            }
            case 3 -> {
                System.out.println("Chao pescao");
                break;
            }
        }

    }
}
