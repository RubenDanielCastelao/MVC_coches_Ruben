public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();
    public static void main(String[] args) {
        //Se añade un Observer para los cambios de velocidad
        ClaseObserver oVelocidad = new ClaseObserver();
        miModelo.addObserver(oVelocidad);
        //Se añade un observer en caso de superar la velocidad limite
        ObsExceso oLimiteVelocidad = new ObsExceso();
        miModelo.addObserver(oLimiteVelocidad);
        IU.crearVentana();
    }

    /**
     * @param modelo
     * @param matricula
     */
    public static void crearCoche(String modelo, String matricula){
        Coche aux = miModelo.crearCoche(modelo,matricula);
        if(aux!=null){
            miVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    /**
     * @param matricula
     */
    public static void bajarVelocidad(String matricula){
        miModelo.bajarVelocidad(matricula);
    }

    /**
     * @param matricula
     */
    public static void aumentarVelocidad(String matricula){
        miModelo.subirVelocidad(matricula);
    }

    /**
     *
     * @param matricula Del coche a buscar
     */
    public static void buscarCoche(String matricula){
        //Usamos coche auxiliar para guardar el coche obtenido en la busqueda
        Coche aux = miModelo.getCoche(matricula);
        if(aux != null){
            miVista.mostrarCoche(aux);
        }
    }

}