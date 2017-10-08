/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package becario;


public class GestorDeVentanas {
     

     

     
         //FUNCIONES DE VISTA
    
    public  void abreLaVentana(int origen, int destino){
    
         cierraLaVentana(origen);

         switch (destino) {
           
                     case 1:
                        ventana_general.setVisible(true);
                     break;
                     case 2:
                        ventana_linea.setVisible(true);
                     break;
                     case 3:
                        ventana_equipo.setVisible(true);
                     break;
                     case 0:
                        ventana_principal.setVisible(true);
                     break;

         
         }
    }
    
    
    public  void abreLaVentana(int destino){
      System.out.println("Entra");
      System.out.println(destino);
      try{
      switch (destino) {
           
                     case 0:
                        ventana_general.setVisible(true);
                     break;
                     case 1:
                        ventana_linea.setVisible(true);
                     break;
                     case 2:
                        ventana_equipo.setVisible(true);
                     break;
                     case 3:
                         System.out.println("Vuelve a entrar");
                        ventana_principal.setVisible(true);
                     break;
                     default:
                         System.out.println("Hay algun problema al abrir la ventana principal");

         }
      }catch (Exception Ex) {
            System.out.println("Ha saltado una excepcion: "+Ex.getMessage());
        }
      }
 
      
    

    public  void cierraLaVentana(int ventana){

         switch (ventana) {
           
                     case 0:
                        ventana_general.setVisible(false);
                     break;
                     case 1:
                        ventana_linea.setVisible(false);
                     break;
                     case 2:
                        ventana_general.setVisible(false);
                     break;
                     case 3:
                        ventana_general.setVisible(false);
                     break;
         }
    }
    
}
*/