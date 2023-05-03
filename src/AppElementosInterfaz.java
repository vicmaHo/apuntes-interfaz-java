import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.PasswordAuthentication;

// Zona gris: Lugar donde se encuentran los elementos de la ventana

public class AppElementosInterfaz extends JFrame implements ActionListener, ItemListener, ListSelectionListener{ // Acttion listener, escucha de botones o de entenders en los fields
    // el item listener los usamos para los combobox y los radiobutton
    // los objetos de la interfaz grafica se definen en la parte superior, fuera del App
    // el list selection listener los usamos como listener de las JList

    //? el contenedor puede ser estatico para agregar el pane de ejemplo
    Container contenedor; // El contenedor es el elemento que contiene a otros compoenentes de la interfaz grafica, los organiza dependiendo
    // el layout que le sea asignado

    FlowLayout flowLayout; // El flowLayout es el modelo para organizar los elemtos en la ventana, el flowlayout los organiza respetando el orden
    // en el que fueron añadidos, por filas de derecha a izquierda, cuando se acaba la fila, pasa a la siguiente.

    //*  Compoenentes de la interfaz grafica

    // Etiquetas 
    JLabel etiquta1, etiqueta2;

    // Campos de texto
    JTextField campo; // Campo de texto para cosas puntuales, es decir una sola linea
    JTextArea area; // Area de texto, es mas grande que el TextField
    JScrollPane scroll; // el scrollBar sirve para areas izquierda derecha, el Pane para las dos dimensiones
    JPasswordField password; // Oculta lo que se escribe, la misma configuarcion de un textfield

    // Botones
    JButton boton1, boton2; // Boton
    // Los listeners seran las escuchcas encargadas de estar atentos a los diferentes mecanismos
    // para ser activados, el boton es uno de esos mecanismos


    // CheckBoxes
    JCheckBox box1, box2; 
    // los checkboxes y raddioButton requieren otro tipo de escucha, el ItemListener, ya que a estos se les detectara su cambio de estao

    // Radio buttons y Button groups
    JRadioButton radio1, radio2, radio3;
    ButtonGroup grupo;

    JComboBox <String> combo; // combo box - seleccion de diferentes items establecidos
    JList <String> listaColores;






    public AppElementosInterfaz(){
        setTitle("Fundamento de eventos"); // Texto que aparece en la parte superior de la aplicación, titulo de la app

        // Establecemos la zona gris 
        contenedor = getContentPane();

        flowLayout = new FlowLayout();
        // Indico que la forma de agregar componenetes a la zona gris, es decir el layout
        contenedor.setLayout(flowLayout);

        // Creo los componentes anteriormente declarados y los agrego al contenedor. Cada elementos cuenta con ciertos
        // parametros a la hora de ser creado

        // Elementos
        etiquta1 = new JLabel("Prueba de interfaz");
        contenedor.add(etiquta1); // Agrego la etiqueta a la zona gris

        etiqueta2 = new JLabel();
        etiqueta2.setIcon(new ImageIcon("java.png")); // Agrego imagenes en la etiqueta a la zona gris
        contenedor.add(etiqueta2); 


        campo = new JTextField("Ingrese su nombre",10); // Creo el campo de texto y le agrego un tamaño de 10, parametro  tamaño horizozntal
        campo.addActionListener(this);
        contenedor.add(campo); // Agregro el campo a la zona gris

        area = new JTextArea(3,7);
        scroll = new JScrollPane(area);  // pongo el text area dentro de un scroll
        contenedor.add(scroll); // añado el scroll con el text area en su interior

        password = new JPasswordField(10);
        contenedor.add(password);

        boton1 = new JButton("Aceptar");
        // El botton por si solo no funciona, es necesario añadir una clase que haga de listener
        boton1.addActionListener(this); // la propia clase es la que contiene el actionListener, por eso se agrega el this
        contenedor.add(boton1);

        boton2 = new JButton("Borrar");
        boton2.addActionListener(this);
        contenedor.add(boton2);


        box1 = new JCheckBox("checkBox 1"); 
        box1.addItemListener(this); 
        contenedor.add(box1);

        box2 = new JCheckBox("checkBox 2");
        box2.addItemListener(this);
        contenedor.add(box2);


        // creo el grupo de botones
        grupo = new ButtonGroup();

        // creo los botones y los agrego al grupo de botones, a todos les agrego el itemListener
        radio1 = new JRadioButton("Primero");
        radio1.addItemListener(this);
        grupo.add(radio1);
        contenedor.add(radio1);
        radio2 = new JRadioButton("Segundo");
        radio2.addItemListener(this);
        grupo.add(radio2);
        contenedor.add(radio2);
        radio3 = new JRadioButton("Tercero");
        radio3.addItemListener(this);
        grupo.add(radio3);
        contenedor.add(radio3);





        // Lista de elementos que formaran parte de los comboBox y las lJlist
        String lista[] = {"rojo", "azul", "blanco", "violeta", "amarillo"};

        // Combobox
        combo = new JComboBox<>(lista); // al combobox le proporicono la lista con los elementos que cree anteiormente
        combo.addActionListener(this); // puedo hacer uso del actionListener o del itemListener
        combo.addItemListener(this);
        contenedor.add(combo);

        // Lista
        listaColores = new JList<>(lista);// al List le proporicono la lista con los elementos que cree anteiormente
        listaColores.addListSelectionListener(this);
        contenedor.add(listaColores);




        // Las siguientes instrucciones se dejan al final de la funcion
        setSize(700, 400); // set the size of the window
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default close operation
        setLocationRelativeTo(null); // cambio la localizacion, aparece en el centro de nuestra pantalla
    }

    public static void main(String[] args) throws Exception  {
        System.out.println("Hello, World!");
        AppElementosInterfaz app = new AppElementosInterfaz();

        // TODO agregar apuntes sobre generics

    }



    // Metodo de la interface ActionListener
    // el actionPerformed sirve para detectar cuando se produce una accion en algun componenente, como por ejemplo
    // hacer click en un boton
    @Override
    public void actionPerformed(ActionEvent e) {
        // el ActionEvent brinda informacion sobre el componente que desencadeno la accion 

        //* tambien se puede añadir esto dentro de addActionListener pero no es recomendable */
        if (e.getSource() == boton1){ // si la fuente de la activacion fue el boton1, se ejecutan las acciones..
            String nombre = campo.getText(); // Extraigo el texto en el campo, y lo almaceno en la variable nombre
            JOptionPane.showMessageDialog(contenedor, "Su nombre es: " + nombre); //  un mensaje de dialogo, aliniado con la ventana, me mostrara la variable nombre
            // en otras palabras, el texto que habia sido escrito en campo

            // comprobare que un checkbox este seleccionado para realizar una accion al presionar un boton
            if (box1.isSelected()){
                campo.setEnabled(false);
                JOptionPane.showMessageDialog(contenedor, "Campo desactivado");
            }
        }
        else if (e.getSource() == boton2){ // si la fuente de la activacion fue el boton2 entonces...
            System.out.println("Boton 'Borrar' presionado"); // imprimo en consola el texto
            boton1.setEnabled(false); // al presionar el boton2  se desactivara el boton1
            radio1.setEnabled(true);
            radio2.setEnabled(true);

            radio1.setVisible(true); // activo la visibildiad del radio buttton
            radio3.setVisible(true); 


            // revierto los cambios realzados cuanddo el box1 esta activado
            if (box1.isSelected()){
                campo.setEnabled(true);
                JOptionPane.showMessageDialog(contenedor, "Campo Activado");
            }
            
        }
        else if (e.getSource() == campo){ // si la fuente de la activacion fue presionar enter mientras se estaba en el campo entonces...
            JOptionPane.showMessageDialog(contenedor, campo.getText()); // mostrara la informacion del campo en un mensaje
            System.out.println("Se presiono enter mientras se estaba en el campo"); // imprimo en consola un texto de comprobacion
            System.out.println(String.valueOf(password.getPassword())); // imprimo la contraseña en consola
         }
         // compruebo cual es la opcion seleccionada del comboBox
         else if(e.getSource() == combo){
            String opcionSeleccionada = (String) combo.getSelectedItem();
            System.out.println("La opcion seleccionada en el comboBox es: " + opcionSeleccionada);
         }

        
    }

    // Metodo de la interface ItemListener
    // el itemStateChaged sirve para detectar el estado de cambio de alguno de los compoenentes que estan enalazados
    // a este listener, se usa en checkbox, radioButtion, comoBoxes y listas
    @Override
    public void itemStateChanged(ItemEvent e) {
        // se activa con las checkboxes siempre que se presione, sea para marcarla o desmarcarla
        if (e.getSource() == box1){ 
            System.out.println("el checkbox 1 se acciono");
            System.out.println(e.getStateChange()); // Indica con un entero si esta seleccionada o deseleccionada
            // 1 para seleecionada, 2 para deseleccionada
            String estado = (e.getStateChange() == 1)?"Seleccionada": "Desleccionada";
            System.out.println(estado);
        } else if(e.getSource() == box2){
            System.out.println("El checkbox 2 se acciono");
            String estado = (e.getStateChange() == 1)?"Seleccionada": "Desleccionada"; // indica si esta seleccionada o deseleccionada haciendo uso del operador ternario 
            // y el getStateChange
            System.out.println(estado);
            box2.setEnabled(false); // puedo desactivar el checkbox


        // Comprobacion para los RadioButtons
        // a diferencia de los checkbox, en los radio buttons solo podemos tener un elemento seleccionado a a la vez, por esto
        // cuando previamente existe uno seleccionado y seleccionamos otro, el que teniamos en seleccion cambiara de estado y activara
        // el itemlistener  
        } else if (e.getSource() == radio1){
            System.out.print("Radio 1: "); 
            System.out.println((e.getStateChange() == 1)?"Seleccionado":"Desleccionado"); // metodo mas abreviado para comprobar el estado
        } else if (e.getSource() == radio2){
            System.out.print("Radio 2: ");
            System.out.println((e.getStateChange() == 1)?"Seleccionado":"Desleccionado");
            // oculare los otros radio buttons
            if (e.getStateChange() == 1){ // compruebo que solo se desactiven cuando el estado es seleccioando 
                radio1.setVisible(false); // desactivo la visibilidad del radio button
                radio3.setVisible(false);
                // con el boton borrar revierto estos cambios

            }
        } else  if (e.getSource() == radio3){
            System.out.print("Radio 3: ");
            System.out.println((e.getStateChange() == 1)?"Seleccionado":"Desleccionado");
            // probando desactivar otros radio buttons
            if (e.getStateChange() == 1){ // compruebo que solo se desactiven cuando el estado es seleccioando 
                radio1.setEnabled(false);
                radio2.setEnabled(false);
            // con el boton borrar los activo de nuevo
            }
            

        // aca compruebo la opcion seleccionada del combobox, pero recordemos que el itemStateChanged actua cuando el componente 
        // cambia de estado, por lo tanto entrara dos veces, se puede manejar mejor con el actionEvent o podemos usar un getstate    
        } else if(e.getSource() == combo){
            if (e.getStateChange() == 1){
                String opcionSeleccionada = (String) combo.getSelectedItem();
                System.out.println("La opcion seleccionada del combobox es: " + opcionSeleccionada);
            }
           
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       if (e.getSource() == listaColores) {
            System.out.println("Se ha seleccionado: " + listaColores.getSelectedValue());
       }
    }


}
