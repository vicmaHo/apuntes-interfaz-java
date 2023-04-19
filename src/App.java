import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;

// Zona gris: Lugar donde se encuentran los elementos de la ventana

public class App extends JFrame implements ActionListener{ // Acttion listener, escucha de botones o de entenders en los fields

    //  los objetos de la interfaz grafica se definen en la parte superior, fuera del App
    // Container no hace parte de las librerias nuevas de java, por tanto se tiene que importar manualmente

    //? el contenedor puede ser estatico para agregar el pane de ejemplo
    Container contenedor; // El contaniner sirve para asigna la zona gris y los elementos de el

    FlowLayout flowLayout; // El flowLayout es el modelo para organizar los elemtos en la ventana

    // Etiquetas 
    JLabel etiquta1, etiqueta2;

    // El contendor es capaz de recibir un layout a la vez
    // el flowLayout ...

    JTextField campo; // Campo de texto para cosas puntuales, es decir una sola linea

    JTextArea area; // Area de texto, es mas grande que el TextField
    JScrollPane scroll; // el scrollBar sirve para areas izquierda derecha, el Pane para las dos dimensiones

    JPasswordField password; // Oculta lo que se escribe, la misma configuarcion de un textfield

    JButton boton, boton2; // Boton
    // Los listeners seran las escuchcas encargadas de estar atentos a los diferentes, el boton es uno de esos mecanismos

    
    /*? agregar explicacion Checkbox: requiere otrotipo de escucha  (ItemListener),
    radio button son iguales a los checkbox, pero podemos usar un boton de grupos para que solo se pueda hacer chek
    a un solo radiobox*/





    public App(){
        setTitle("Fundamento de eventos"); // Texto que aparece en la parte superior de la aplicación
        // Establecemos la zona gris 
        contenedor = getContentPane();

        flowLayout = new FlowLayout();
        // Indico que la forma de agregar componenetes a la zona gris
        contenedor.setLayout(flowLayout);

        // Elementos
        etiquta1 = new JLabel("Notas del curso");
        contenedor.add(etiquta1); // Agrego la etiqueta a la zona gris

        etiqueta2 = new JLabel("Hola");
        //etiqueta2.setIcon(new ImageIcon("WW.png")); // Agrego imagenes en la etiqueta a la zona gris
        contenedor.add(etiqueta2); 


        campo = new JTextField(10); // Creo el campo de texto y le agrego un tamaño de 10, parametro  tamaño horizozntal
        contenedor.add(campo); // Agregro el campo a la zona gris

        area = new JTextArea(10,5);
        scroll = new JScrollPane(area);  // Pongo el area dentro del scroll para añadir un scroll para

        contenedor.add(scroll); 

        password = new JPasswordField(10);
        contenedor.add(password);

        boton = new JButton("Aceptar");
        // El botton por si solo no funciona, es necesario añadir una clase que haga de listener
        boton.addActionListener(this); // la propia clase es la que contiene el actionListener
        contenedor.add(boton);

        boton2 = new JButton("Borrar");
        boton2.addActionListener(this);
        contenedor.add(boton2);


        // Las siguientes instrucciones se dejan al final de la funcion
        setSize(500, 300); // set the size of the window
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default close operation
    }

    public static void main(String[] args) throws Exception  {
        System.out.println("Hello, World!");
        App app = new App();

        // Ahora a los Joptionpane podemos agregarlos a una ventan
        // JOptionPane.showMessageDialog(contenedor, "Hola"); //
        
    }

    // El metodo a impelmentar de la interface impelmentada. 
    @Override
    public void actionPerformed(ActionEvent e) {
        // el actionevent brinda informacion de quien acciono el evento

        //* tambien se puede añadir esto dentro de addActionListener pero no es recomendable */
        if (e.getSource() == boton){
            String nombre = campo.getText(); // Con esto camputro el texto de algun campo haciendo uso de un boton
            JOptionPane.showMessageDialog(contenedor, nombre);
        }
        else if (e.getSource() == boton2){
            System.out.println("Hoola boton2");
        }
        
    }
}
