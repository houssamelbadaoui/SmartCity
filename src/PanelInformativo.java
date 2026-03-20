public class PanelInformativo extends DispositivoIoT
implements ControlableRemotamente{

    // Attribute extra
    private String textoMostrado;

    public PanelInformativo(String id, String ubicacion, String textoMostrado){
        super(id, ubicacion);
        this.textoMostrado = textoMostrado;
    }

    @Override
    public void procesarDatos() {
        System.out.println("Panel en " + getUbicacion() + " mustra " + textoMostrado);
    }

    @Override
    public boolean conectarWifi() {
        System.out.println("Panel connectado al wiFi");
        return true;
    }

    @Override
    public void reiniciarDispositivo() {
        System.out.println("Panel reiniciado");
    }
}
