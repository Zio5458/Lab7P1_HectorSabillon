/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_hectorsabillon;
import java.util.Scanner;
import java.util.Random;

public class Lab7P1_HectorSabillon {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();
    
    public static int menu(int opcion){
        System.out.println("1 <- Portrait");
        System.out.println("2 <- Numero magico");
        System.out.println("3 <- Subsecuencia");
        System.out.println("4 <- Salida");
        System.out.println("Ingrese el ejercicio a visualizar: ");
        opcion = leer.nextInt();
        return opcion;
    }
    
    public static int[][] lectura1(int fila, int columna){
        
        int[][] numeros = new int[fila][columna];
        for (int i = 0; i < fila; i++){
            for (int j = 0; j < columna; j++){
                numeros[i][j] = random.nextInt(9);
            }
        }
        return numeros;
    }
    
    public static String imprimir1(int[][] numeros){
        String cadena = "";       
        for (int i = 0; i < numeros.length; i++){
            for (int j = 0; j < numeros[i].length; j++){
                cadena += numeros[i][j] + " ";
            }
            cadena += "\n";
        }
        return cadena;
    }
    
    public static int[][] rotacion(int [][] numeros){
        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < numeros.length; i++){
            cont2 = 0;
            for (int j = 0; j < numeros[i].length; j++){
                cont2++;
            }
            cont1++;
        }
        int[][] temp = new int[cont2][cont1];
        for (int i = 0; i < temp.length; i++){
            for (int j = 0; j < temp[i].length; j++){
                temp[i][j] = numeros[temp[i].length - (1 + j)][i];
            }
        }
        return temp;
    }
    
    public static int multiplicacion(int[][] numeros2){
        int acumsuma = 0;
        int acummult = 1;
        int[][] cero = new int[numeros2.length][numeros2[0].length];
        int dig = numeros2.length - 1;
        for (int i = 0; i < numeros2.length; i++) {
            for (int j = 0; j < numeros2[i].length; j++) {
                if (i == dig || i == 0 || j == 0 || j == numeros2[i].length - 1) {
                    acumsuma += numeros2[i][j];
                } else {
                    acummult *= numeros2[i][j];
                }
            }      
     }
        int total = acumsuma + acummult;
        return total;
    }
    
    public static int subsecuencia(String cadena1, String cadena2){
        String temp1 = "-" + cadena1;
        String temp2 = "-" + cadena2;
        int[][] sub = new int[temp1.length()][temp2.length()];
        for (int i = 0; i < sub.length; i++){
            for (int j = 0; j < sub[i].length; j++){
                if (temp1.charAt(i) == '-' || temp2.charAt(j) == '-'){
                    sub[i][j] = 0;
                } else if (temp1.charAt(i) == temp2.charAt(j)){
                        sub[i][j] = 1 + sub[i-1][j-1];
                    } else {
                     sub[i][j] = Math.max(sub[i][j-1], sub[i-1][j]);

                    }
                }
            
        }
        int respuesta = sub[sub.length-1][sub[0].length-1];
        System.out.println(imprimir1(sub));
        return respuesta;
    }
    
    public static void main(String[] args) {
        int opcion = 0;
        int fila, columna;
        int resp = menu(opcion);
        do{
            switch (resp){
                case 1:
                        System.out.println("Ingrese la cantidad de filas: ");
                        fila = leer.nextInt();
                        System.out.println("Ingrese la cantidad de columnas: ");
                        columna = leer.nextInt();
                        if (fila == columna){
                            System.out.println("Las dimensiones de la matriz no pueden ser iguales");
                        } else {
                            int[][] numeros = lectura1(fila, columna);
                            System.out.println(imprimir1(numeros));
                            System.out.print(imprimir1(rotacion(numeros)));
                        }
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad de filas: ");
                    fila = leer.nextInt();
                    System.out.println("Ingrese la cantidad de columnas: ");
                    columna = leer.nextInt();
                    int[][] numeros2 = lectura1(fila, columna);
                    System.out.println(imprimir1(numeros2));
                    System.out.println(multiplicacion(numeros2));
                    break;
                case 3:
                    System.out.println("Ingrese la primera cadena: ");
                    String cadena1 = leer.next().toUpperCase();
                    System.out.println("Ingrese la segunda cadena: ");
                    String cadena2 = leer.next().toUpperCase();
                    System.out.println(subsecuencia(cadena1, cadena2));
                    break;
            }
            break;
        } while (resp != 4);
    }
    
}
