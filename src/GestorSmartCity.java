import java.util.Scanner;
import java.util.ArrayList;


public class GestorSmartCity {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        ArrayList<DispositivoIoT> red = new ArrayList<>();

        int opcion;
        do{
            System.out.println("\n Menu:");
            System.out.println("1. Añadir dispositivo");
            System.out.println("2. Mostrar estado");
            System.out.println("3. Mantenimiento global");
            System.out.println("4. Reincido remoto");
            System.out.println("6. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Tipo (1-Semaforo, 2-Sensor, 3-Panel): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("ID: ");
                    String id = scanner.nextLine();

                    System.out.println("Ubicacion: ");
                    String ubicacion = scanner.nextLine();

                    if(tipo == 1) {
                        System.out.println("Estado (Rojo/Ambar/Verde): ");
                        String estado = scanner.nextLine();
                        red.add(new SemaforoInteligente(id, ubicacion, estado));
                        System.out.println("Semaforo creado");
                    } else if (tipo == 2) {
                        System.out.println("Nivel CO2: ");
                        double co2 = scanner.nextDouble();
                        red.add(new SensorContaminacion(id, ubicacion, co2));
                        System.out.println("Sensor creado");
                    } else if (tipo == 3) {
                        System.out.println("Texto: ");
                        String texto = scanner.nextLine();
                        red.add(new PanelInformativo(id, ubicacion, texto));
                        System.out.println("Panel creado");

                    }
                    break;
                case 2:
                    for(DispositivoIoT d : red){
                        d.procesarDatos();
                    }
                    break;
                case 3:
                    double total = 0;

                    for(DispositivoIoT d : red){
                        if(d instanceof Mantenible){
                            Mantenible m = (Mantenible) d;
                            m.realizarMantenimiento();
                            total += m.calcularCosteMantenimiento();
                        }
                    }
                    System.out.println("Coste total: " + total + "$");
                    break;
                case 4:
                    for(DispositivoIoT d : red){
                        if(d instanceof ControlableRemotamente){
                            ControlableRemotamente c = (ControlableRemotamente) d;
                            if(c.conectarWifi()){
                                c.reiniciarDispositivo();
                            }
                        }
                    }
                    break;
            }
        } while (opcion != 6);
    }
}
