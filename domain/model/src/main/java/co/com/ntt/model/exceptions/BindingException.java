package co.com.ntt.model.exceptions;

public class BindingException extends Exception {
    public BindingException(String message){
        super(message);
    }

    public BindingException(){
        super("El método no contiene el Binding en los argumentos");
    }
}
