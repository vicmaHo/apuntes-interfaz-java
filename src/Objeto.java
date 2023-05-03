//  Explicacion de generics
public class Objeto <T,Z>{ // se indica que la clase astronauta recibiea un tipo llamaddo T, 
    // T puede ser cualquier tipo, Mientras se averrigua cual es el tipo, nos referimos a el con la letra t
    // Las cosas pasan a ser de tipo T
    // puedo tener mas de un generic

    T edad; 
    Z fechaFabrica;
    public Objeto (T edad, Z fechaFabrica) {
        this.edad = edad;
        this.fechaFabrica = fechaFabrica; 
    }


    public T getEdad() {
        return edad;
    }
    public void setEdad(T edad) {
        this.edad = edad;
    }


    public Z getFechaFabrica() {
        return fechaFabrica;
    }


    public void setFechaFabrica(Z fechaFabrica) {
        this.fechaFabrica = fechaFabrica;
    }    
}


