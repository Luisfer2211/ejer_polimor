import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private String país;
    private int errores;
    private int aces;
    private int servicios;

    public Jugador(String nombre, String país, int errores, int aces, int servicios) {
        this.nombre = nombre;
        this.país = país;
        this.errores = errores;
        this.aces = aces;
        this.servicios = servicios;
    }

    public double calcularEfectividad() {
        double efectividad = 0.0;
        
        if (servicios != 0) {
            efectividad = (double)((aces * 100) / servicios);
        }
        
        return efectividad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getPaís() {
        return país;
    }

    public int getErrores() {
        return errores;
    }

    public int getAces() {
        return aces;
    }

    public int getServicios() {
        return servicios;
    }

    // Setters (si es necesario)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public void setServicios(int servicios) {
        this.servicios = servicios;
    }

    public static ArrayList<Jugador> cargarJugadoresDesdeCSV(String archivoCSV) {
        ArrayList<Jugador> jugadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String nombre = datos[0];
                    String país = datos[1];
                    int errores = Integer.parseInt(datos[2]);
                    int aces = Integer.parseInt(datos[3]);
                    int servicios = Integer.parseInt(datos[4]);
                    Jugador jugador = new Jugador(nombre, país, errores, aces, servicios);
                    jugadores.add(jugador);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jugadores;
    }
}
