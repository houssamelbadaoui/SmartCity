public abstract class DispositivoIoT {

    // Attributes
    private String id;
    private String ubicacion;
    private boolean encendido;

    // constructor
    public DispositivoIoT(String id, String ubicacion){
        this.id = id;
        this.ubicacion = ubicacion;
        this.encendido = false;
    }

    // Getters and Setters
    public String getId(){
        return id;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public boolean isEncendido(){
        return encendido;
    }

    public void setEncendido(boolean encendido){
        this.encendido = encendido;
    }

    public void encender(){
        this.encendido = true;
    }

    public void apagar(){
        this.encendido = false;
    }

    // Abstract method
   public abstract void procesarDatos();
}
