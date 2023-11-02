/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package conmetodos;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author noelia
 */
public class PiedraPapelTijera {

    public static void main(String[] args) {

        //Constantes
        final int numJugadores = 2;
        
        //Variables
        int opcionJuego;
        int contadorRonda = 0;
        String nombreJugador1="";
        String nombreJugador2="";
        int contadorJugador1 = 0;
        int contadorJugador2 = 0;
        int contadorMaquina = 0;

        Scanner teclado = new Scanner(System.in);
        do {
            opcionJuego = UtilidadesPPT.opcionMenuJuego();

            //En este switch están las tres opciones del menú
            switch (opcionJuego) {
                case 1 -> {
                    UtilidadesPPT.introducirNombre(nombreJugador1, nombreJugador2);
                    int empiezaPor = UtilidadesPPT.quienEmpieza(numJugadores);

                    //Do-while para la condición de fin de partida
                    //Más abajo lo explico (donde está la condición)
                    do {
                        contadorRonda++;
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

                        System.out.println("Ronda " + contadorRonda);

                        //Si el random saca 1, empieza eligiendo el jugador1
                        //todas las rondas de la partida
                        //Si saca 2, empezará el jugador2
                        if (empiezaPor == 1) {
                            //Do-while para repetir el menú de escoger objeto 
                            //si no introduces piedra, papel o tijera
                            do {
                                System.out.println("Comienza " + nombreJugador1 + ":");
                                opcionJugador1 = teclado.nextLine();

                                //Do-while para un mensaje si no escribes una opción correcta
                                if (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                        || opcionJugador1.equalsIgnoreCase("Papel")
                                        || opcionJugador1.equalsIgnoreCase("Tijera"))) {
                                    System.out.println("Esa opción no es válida, escribe una de la lista");
                                }
                            } while (!(opcionJugador1.equalsIgnoreCase("Piedra")
                                    || opcionJugador1.equalsIgnoreCase("Papel")
                                    || opcionJugador1.equalsIgnoreCase("Tijera")));

                            do {
                                System.out.println("Escoge " + nombreJugador2 + ":");
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
                        //En este ii/else-if/else se comparan los objetos del juego 
                        //para ver quién se lleva el punto
                        //si escogen el mismo ninguno se lleva punto
                        //aunque cuenta como ronda
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
                                       %s %d - %s %d
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                    nombreJugador2, opcionJugador2, nombreJugador1,
                                    nombreJugador1, contadorJugador1,
                                    nombreJugador2, contadorJugador2));
                        } else if (opcionJugador1.equalsIgnoreCase(opcionJugador2)) {
                            System.out.println("""
                                       
                                       %s ha sacado: %s
                                       %s ha sacado: %s
                                       Ha habido empate, nadie recibe punto
                                       %s %d - %s %d
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                    nombreJugador2, opcionJugador2, nombreJugador1,
                                    contadorJugador1, nombreJugador2, contadorJugador2));
                        } else {
                            contadorJugador2++;
                            System.out.println("""
                                       
                                       %s ha sacado: %s
                                       %s ha sacado: %s
                                       Punto para: %s
                                       %s %d - %s %d
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                    nombreJugador2, opcionJugador2, nombreJugador2,
                                    nombreJugador1, contadorJugador1,
                                    nombreJugador2, contadorJugador2));
                        }
                        //La partida acaba si pasa una de estas tres opciones:
                        //1.Si la partida ya lleva 5 rondas y alguno de los dos jugadores tiene más puntos que el otro
                        //2.Si uno de los dos llega a 3 puntos antes de las 5 rondas
                        //3.En el caso de que haya muchos empates(cuentan como ronda)
                        //se seguirá jugando hasta que uno llegue a 3 puntos
                        //Ya sé que podría haber puesto que no cuente la ronda por empate y
                        //que gane el que llegue a tres, pero me aburría, yo que sé
                    } while (!((contadorRonda >= 5 && (contadorJugador1 > contadorJugador2
                            || contadorJugador2 > contadorJugador1))
                            || (contadorJugador1 == 3 || contadorJugador2 == 3)));

                    //Aunucia el ganador según quién tenga más puntos
                    if (contadorJugador1 > contadorJugador2) {
                        System.out.println("Ha ganado: " + nombreJugador1 + ", ¡¡ENHORABUENA!!");
                    } else {
                        System.out.println("Ha ganado: " + nombreJugador2 + ", ¡¡ENHORABUENA!!");
                    }

                }
                case 2 -> {
                    nombreJugador1 = JOptionPane.showInputDialog(
                            "Introduce el nombre del jugador 1");
                    int empiezaPor = UtilidadesPPT.quienEmpieza(numJugadores);

                    do {
                        contadorRonda++;
                        System.out.println("""
                                          ESCRIBA UNA OPCIÓN
                                     ----------------------------
                                     
                                             - Piedra
                                             - Papel
                                             - Tijera
                                     
                                     ----------------------------
                                     """);

                        String opcionJugador1;
                        String opcionMaquina = UtilidadesPPT.escogeMaquina();


                        System.out.println("Ronda " + contadorRonda);

                        if (empiezaPor == 1) {
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

                            System.out.println("La Máquina ha escogido");
                            
                        } else {
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
                                       %s %d - La Máquina %d
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                    opcionMaquina, nombreJugador1, nombreJugador1,
                                    contadorJugador1, contadorMaquina));
                        } else if (opcionJugador1.equalsIgnoreCase(opcionMaquina)) {
                            System.out.println("""
                                       
                                       %s ha sacado: %s
                                       La máquina ha sacado: %s
                                       Ha habido empate, nadie recibe punto
                                       %s %d - La Máquina %d
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                    opcionMaquina, nombreJugador1,
                                    contadorJugador1, contadorMaquina));
                        } else {
                            contadorMaquina++;
                            System.out.println("""
                                       
                                       %s ha sacado: %s
                                       La Máquina ha sacado: %s
                                       Punto para: La Máquina
                                       %s %d - La Máquina %d
                                       
                                       """.formatted(nombreJugador1, opcionJugador1,
                                    opcionMaquina, nombreJugador1,
                                    contadorJugador1, contadorMaquina));
                        }
                    } while (!((contadorRonda >= 5 && (contadorJugador1 > contadorMaquina
                            || contadorMaquina > contadorJugador1))
                            || (contadorJugador1 == 3 || contadorMaquina == 3)));

                    if (contadorJugador1 > contadorMaquina) {
                        System.out.println("Ha ganado: " + nombreJugador1 + ". ¡¡ENHORABUENA!!");
                    } else {
                        System.out.println("Ha ganado: La Máquina. La vida es dura");
                    }
                }
                case 3 -> {
                    System.out.println("Chao pescao");
                }
            }
            //Muestra un mensaje si no eliges una opción de la lista
            if (!(opcionJuego >= 1 && opcionJuego <= 3)) {
                JOptionPane.showMessageDialog(null, "Elige un número de la lista");
            }
        } while (!(opcionJuego == 3));

    }
}
