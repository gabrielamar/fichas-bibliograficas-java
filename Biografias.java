

 /**
 * Esta clase implementa el sistema de       *
 * control de fichas bibliográficas          *
 * @version 1.00                             *
 * @author Gabriela Martín Torres            */

class Biografias {
  

  public static void main (String args[]) {
    System.out.println
        ("Sistema de Fichas Bibliográficas:");

    System.out.println("OPCIONES:");
    int operacion;
    do {
       System.out.println("[1] Nueva ficha");
       System.out.println("[2] Borrar ficha");
       System.out.println("[3] Listar fichas");
       System.out.println("[4] Listar coetáneos");
       System.out.println("[5] Listar por área");
       System.out.println("[0] Salir");
       do {
          operacion = Terminal.leeEntero
            ("Indique una opción: ");
         } while ((operacion < 0) ||
          (operacion > 5));
         if (operacion == 1)
            creaFicha();
         else if (operacion == 2)
             Persona.borraFicha();
         else if (operacion == 3)
            Persona.listarPersonas(); 
         else if (operacion == 4)
            Persona.listaCoet();
         else if (operacion == 5)
            Persona.listarPersonasArea();   
      } while (operacion != 0);
   }


  private static void creaFicha() {
    System.out.println("NUEVA FICHA:");
    
    String nombre = Terminal.leeCadena("NOMBRE ?: ");
    String area = Terminal.leeCadena("Área ?: ");
    int diaN     = Terminal.leeEntero("Dia de nac. ?: ");
    int mesN     = Terminal.leeEntero("Mes de nac. ?: ");
    int añoN     = Terminal.leeEntero("Año de nac.(----) ?: ");
    int diaD     = Terminal.leeEntero("Si la persona no ha muerto introducir 0 en las siguientes: Dia de def. ?: ");
    int mesD     = Terminal.leeEntero("Mes de def. ?: ");
    int añoD     = Terminal.leeEntero("Año de def.(----)?: ");
    

    new Persona(nombre,area,diaN,mesN,añoN,diaD,mesD,añoD);
  }
  
  
  
   
}

/******** Fin de Biografias.java ****************/
