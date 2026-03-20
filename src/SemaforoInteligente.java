public class SemaforoInteligente extends DispositivoIoT
implements Mantenible, ControlableRemotamente{

    // Attributo extra
    private String estadoActual;

    public SemaforoInteligente(String id, String ubicacion, String estadoActual){
        super(id, ubicacion);
        this.estadoActual = estadoActual;
    }

    @Override
    public void procesarDatos(){
        System.out.println("Semaforo en " + getUbicacion() + " esta en estado: " + estadoActual);
    }

    // Mantenible
    @Override
    public double calcularCosteMantenimiento() {
        return 150;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento realizado al semaforo " + getId());
    }

    //  ControlableRemotamente
    @Override
    public boolean conectarWifi() {
        System.out.println("Semaforo connectado al wifi");
        return true;
    }

    @Override
    public void reiniciarDispositivo() {
        System.out.println("Semaforo reiniciado");
    }
}
