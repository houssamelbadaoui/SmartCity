public class SensorContaminacion extends DispositivoIoT
implements Mantenible{

    // Attributo extra
    private double nivelCO2;

    // constructor
    public SensorContaminacion(String id, String ubicacion, double nivelCO2){
        super(id, ubicacion);
        this.nivelCO2 = nivelCO2;
    }

    @Override
    public void procesarDatos() {
        System.out.println("Sensor en " + getUbicacion() + " mide CO2: " + nivelCO2);
    }

    @Override
    public double calcularCosteMantenimiento() {
        return 50;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento realizado al sensor " + getId());
    }
}
