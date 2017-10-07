/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becario;

/**
 *
 * @author chinflon
 */
public class GestorDeVentanas {
    

    
     Ventana_linea ventana_linea = new Ventana_linea();
     Ventana_general ventana_general = new Ventana_general();
     Ventana_equipo ventana_equipo = new Ventana_equipo();
     Ventana_principal ventana_principal = new Ventana_principal();
    
     
         //FUNCIONES DE VISTA
    
    public  void abreLaVentana(String origen, String destino){
    
         cierraLaVentana(origen);
         
         switch (destino) {
           
                     case "GENERAL":
                        ventana_general.setVisible(true);
                     break;
                     case "LINEA":
                        ventana_linea.setVisible(true);
                     break;
                     case "EQUIPO":
                        ventana_equipo.setVisible(true);
                     break;
                     case "PRINCIPAL":
                        ventana_principal.setVisible(true);
                     break;

         }
    } 
    
    public  void abreLaVentana(String destino){
      System.out.println("Entra");
      System.out.println(destino);
 
      switch (destino) {
           
                     case "GENERAL":
                        ventana_general.setVisible(true);
                     break;
                     case "LINEA":
                        ventana_linea.setVisible(true);
                     break;
                     case "EQUIPO":
                        ventana_equipo.setVisible(true);
                     break;
                     case "PRINCIPAL":
                         System.out.println("Vuelve a entrar");
                        ventana_principal.setVisible(true);
                     break;
                     default:
                         System.out.println("Hay algun problema al abrir la ventana principal");

         }
      
    } 

    public  void cierraLaVentana(String ventana){
    
         switch (ventana) {
           
                     case "GENERAL":
                        ventana_general.setVisible(false);
                     break;
                     case "LINEA":
                        ventana_linea.setVisible(false);
                     break;
                     case "RANGOS":
                        ventana_general.setVisible(false);
                     break;
                     case "PROCESO":
                        ventana_general.setVisible(false);
                     break;
         }
    }
}
