import java.util.Observable;
import java.util.Observer;

public class ObsExceso implements Observer{
    View miVista = new View();
    @Override
    public void update(Observable o, Object arg) {
        //Precisamos castear el objeto a Coche
        Coche obxC = (Coche) arg;
        //Comprobamos si el coche a excedido el limite de velocidad
        if(obxC.velocidad == 120) {
            miVista.limiteVelocidad(obxC.velocidad);
        }
    }
}
