import javax.swing.*;
import java.awt.*;

public class Dialog extends JDialog{
    private JPanel panel1;
    private JLabel eVelocidad;

    public Dialog(){
        setContentPane(panel1);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     *
     * @param mensajito Mensaje a mostrar en el dialogo
     */
    public static void vDialogo(String mensajito){
        Dialog dialogo = new Dialog();
        dialogo.pack();
        dialogo.eVelocidad.setText(mensajito);
        dialogo.setVisible(true);
    }

    /**
     *
     * @param mensajito Mensaje a mostrar en el dialogo de alerta
     */
    public static void alertaDialogo(String mensajito){
        Dialog dialogo = new Dialog();
        dialogo.pack();
        dialogo.eVelocidad.setText(mensajito);
        dialogo.panel1.setBackground(Color.red);
        dialogo.setVisible(true);
    }
}
