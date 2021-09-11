import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridDemo extends JFrame {

    private JButton botones [];
    private final String nombres[] = {"uno", "dos", "tres",
                                    "cuatro","cinco", "seis"};
    private boolean alternar = true;
    private Container contenedor;
    private GridLayout cuadricula1, cuadricula2;

    public GridDemo() {
        setTitle("Demo grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cuadricula1 = new GridLayout(2, 3);
        cuadricula2 = new GridLayout(3, 2);
        contenedor = getContentPane();
        contenedor.setLayout(cuadricula1);
        botones = new JButton[nombres.length];
        for (int cuenta = 0; cuenta < nombres.length; cuenta++) {
            botones[cuenta] = new JButton(nombres[cuenta]);
            botones[cuenta].addActionListener(new ListenerParaBotones());
            botones[cuenta].setToolTipText("cambia esquema GridLayout:" + nombres[cuenta]);
            contenedor.add(botones[cuenta]);
        }
        //pack();
        setSize(300, 300);
        setVisible(true);

    }
    public static void infoBox(String infoMessage, String titleBar)
    {
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox:" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        GridDemo miejemplo = new GridDemo();
    }

    private class ListenerParaBotones implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){ //action performed es para saber que boton seleccinó
            if(alternar){
                contenedor.setLayout(cuadricula2);
                infoBox("Cambio de cuadricula", "informacion");
            }
            else{
                contenedor.setLayout(cuadricula1);
            }
            alternar = !alternar; //establecer alternar en el valor opuesto
            contenedor.validate();//esto aplica el cambio en el layout
        }
    }
}

