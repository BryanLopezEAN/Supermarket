/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.Scanner;

/**
 *
 * @author Bryan Lopez Avila
 */
public class Supermercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ventas venta = new Ventas();
        System.out.println("Numero de ventas: ");
        int ventas = sc.nextInt();
        
        for (int i = 0; i < ventas; i++) {
            System.out.println("Ingrese el valor de la venta: ");
            float total = sc.nextFloat();

            System.out.println("Ingrese el tipo venta[1 = Contado, 2 = Crédito, 3 = Coutas]: ");
            int type = sc.nextInt();
            if (type > 0 && type <= 3) {
                venta.addCustom(total, type);
                venta.results();
            }else{
                System.out.println("El tipo de venta no existe");
                return;
            }
        }
        venta.result();
    }
    
}
