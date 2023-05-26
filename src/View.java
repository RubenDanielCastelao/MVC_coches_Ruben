public class View {
    /**
     *
     * @param matricula para mostrar
     * @param v velocidad a mostrar
     */
    void muestraVelocidad(String matricula, Integer v){
        Dialog.vDialogo("El coche " + matricula + " tiene una velocidad de: " + v + "km/h");
    }

    void limiteVelocidad(){
        //Avisamos mediante un Dialog que se ha excedido el limite de velocidad
        Dialog.vDialogo("ALERTA: Velocidad excedida!");
    }

    /**
     *
     * @param aux Objeto del coche que se va a mostrar
     */
    void mostrarCoche(Coche aux){
        //Mostramos todas las caracteristicas del coche que se recibe
        Dialog.vDialogo("El coche con matricula: " + aux.matricula + " es de modelo: " + aux.modelo + " y tiene una velocidad de: " + aux.velocidad + " km/h");
    }
}