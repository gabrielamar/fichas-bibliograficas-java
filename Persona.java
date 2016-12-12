/*********************************************
 * Gabriela Martín                           *
 *                Curso de Programación Java *
 * Capitulo06/biografias.java                *
 *********************************************/

 
/*En esta clase definimos el objeto Persona*/

class Persona {

    /* Variables o campos de objeto */
    private int        diaNac;
    private int        mesNac;
    private int        añoNac;
    private int        diaDef;
    private int        mesDef;
    private int        añoDef;
    private Persona    sigPersona;
    private String     nombre;
    private String     area;
    private static Persona personaInicial = null;
 

 
 /* Métodos constructores */
    public Persona(String nom, String ar, int diaN, int mesN, int añoN, 
             int diaD, int mesD, int añoD) {
    //    this();
        this.nombre   = nom;
        this.area = ar;
        this.diaNac = diaN;
        this.mesNac  = mesN;
        this.añoNac  = añoN;
        this.diaDef = diaD;
        this.mesDef  = mesD;
        this.añoDef  = añoD;
      if (personaInicial == null)
         personaInicial = this;
      else {
         Persona personaAux = personaInicial;
         while (personaAux.sigPersona != null)
            personaAux = personaAux.sigPersona;
         personaAux.sigPersona = this;        

    }

}


/*Metodos de manipulación de fichas */

public static Persona buscarPersona(String per) {

      Persona personaAux = personaInicial; 
      
      while ((personaAux != null) && (!(per.equals(personaAux.nombre)))) {       
      personaAux = personaAux.sigPersona; 
    }
       if (per.equals(personaAux.nombre)){
       return personaAux;
        }     
       else {return null;}
       
      
    }      
    
  
    public static void borraFicha() {
          
      String bnombre = Terminal.leeCadena("NOMBRE ?: ");

      if (bnombre.equals(personaInicial.nombre)) {
         personaInicial = personaInicial.sigPersona;
      } 
      else {
         Persona personaAux = personaInicial;
         while (personaAux != null) {
            if (bnombre.equals(personaAux.sigPersona.nombre) ) {
               personaAux.sigPersona =
                            personaAux.sigPersona.sigPersona;
               break;
            }
            personaAux = personaAux.sigPersona;
         }
        }    
    }
   
        


    public String toString() {
        return "[nombre: " + nombre + ", area: " + area + 
            ", fecha de nacimiento: " + diaNac+"-"+ mesNac+ "-" + añoNac+ 
            ", fecha de defunción: " + diaDef+"-"+ mesDef+ "-" +añoDef+"]";
    }


   public static void listarPersonas() {
      System.out.println("LISTADO DE PERSONAS");
      Persona personaAux = personaInicial;

      while (personaAux != null) {
         System.out.println(personaAux);
         personaAux = personaAux.sigPersona;
      }
   }
   

     
         public static void listaCoet() { 
      
      String per = Terminal.leeCadena("PERSONA ?: ");
      System.out.println("LISTA DE COETÁNEOS");
      Persona coet = buscarPersona(per);
      Persona personaAux = personaInicial;

      while ((personaAux != null)&&(coet != null)) {
          if ((coet.añoDef == 0)&&(personaAux.añoDef == 0)){
          System.out.println(personaAux);  
          }
          else if ((coet.añoDef != 0)&&(personaAux.añoDef == 0)
                            &&(personaAux.añoNac < coet.añoDef)){
            System.out.println(personaAux);
            }
          
          else if((coet != personaAux) &&
                        (coet.añoNac < personaAux.añoDef)){ 
         System.out.println(personaAux);
        }
         personaAux = personaAux.sigPersona;
      }
   }
   
      public static void listarPersonasArea() {
      
      String ar = Terminal.leeCadena("ÁREA ?: ");
      System.out.println("LISTADO DE PERSONAS POR ÁREA");
      Persona personaAux = personaInicial;

      while (personaAux != null) {
          if(ar.equals(personaAux.area)){ 
         System.out.println(personaAux);
        }
         personaAux = personaAux.sigPersona;
      }
   }
  

    

}
