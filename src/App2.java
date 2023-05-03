import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JFrame;


public class App2 extends JFrame implements MouseListener, KeyListener { // agrego el mouse listener
    Container contenedor;
    int x1 = -1; 
    int y1 = -1;
    int x2 = -1; 
    int y2 = -1; // creo las coordenadas y asigno un valor de -1, el cual indica que no se ha presionado el click

    public App2() {
        contenedor = getContentPane();
       
        

        addMouseListener(this); // agrego la escuha del mouse a toda la ventana
        addKeyListener(this); // agrego la escucha de tecldo

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }


    public void paint(Graphics g) {
        // g es el objeto al cual se le agrega todo
        g.setColor(Color.red); // selecciono el color
        // las coordenadas de los pixeles comienzan en 0,0 desde la esquina superior izquierda, pero esta esquina es la parte del menu
        g.drawLine(50, 50, 100, 100);  // creo una linea desde un punto x y a otro punto x y
        g.setColor(Color.blue); 
        g.drawRect(250, 250, 100, 75);
        g.setColor(Color.black);
        g.drawOval(300, 300, 75, 50);
        g.setColor(Color.green);
        g.fillRect(100, 100, 75, 75); // rectangulo relleno
        g.fillOval(300, 400, 75, 50); // ovalo relleno
        g.setColor(new Color(255,100,50)); // creo un color nuevo con rgb
        g.drawString("asdf", 450, 450); // puedo dibujar string

        if (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1) {
            g.setColor(Color.red);
            x1 = x2 = y2 = y1 = -1;
            g.drawLine(x1, y1, x2, y2);
    
            
            
        }
    }

    public static void main(String[] args) {
        App2 app = new App2();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // con el mouse podemos capturar las coordenadas en las que se da click
        // JOptionPane.showMessageDialog(null, e.getX() + "," + e.getY());

        // if (x1 == -1 || y1 == -1){
        //     x1 = e.getX();
        //     y1 = e.getY();

        // }else{
        //     x2 = e.getX();
        //     y2 = e.getY();
        //     repaint(); // vuelve al metodo paint y re dibuja todo lo que esta en ese lugar
        // }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO arreglar errores
        System.out.println(e.isMetaDown());
        if (x1 == -1 || y1 == -1){
            x1 = e.getX();
            y1 = e.getY();

        }else{
            x2 = e.getX();
            y2 = e.getY();
            repaint(); // vuelve al metodo paint y re dibuja todo lo que esta en ese lugar
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        //contenedor.setBackground(Color.red);
    }


    @Override
    public void mouseExited(MouseEvent e) {
        //contenedor.setBackground(Color.blue);
    }



    // Teclado
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }


    @Override
    public void keyPressed(KeyEvent e) {
       System.out.println(e.getKeyCode());
       System.out.println(e.getKeyChar());
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
