package becario;


public class GestorDeVentanas {
     

     public  Ventana_linea ventana_linea = new Ventana_linea();
    public  Ventana_general ventana_general = new Ventana_general();
    public  Ventana_equipo ventana_equipo = new Ventana_equipo();
    public static Ventana_principal ventana_principal = new Ventana_principal();

     
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

      try{
      switch (destino) {
           
                     case 0:
                        ventana_principal.setVisible(true);
                     break;
                     case 1:
                        ventana_general.setVisible(true);
                     break;
                     case 2:
                        ventana_linea.setVisible(true);
                     break;
                     case 3:
                        ventana_equipo.setVisible(true);
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
                        ventana_principal.setVisible(false);
                     break;
                     case 1:
                        ventana_general.setVisible(false);
                     break;
                     case 2:
                        ventana_linea.setVisible(false);
                     break;
                     case 3:
                        ventana_equipo.setVisible(false);
                     break;
         }
    }
    
}
