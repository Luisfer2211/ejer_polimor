import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;


public class Torneo {
    private ArrayList<Jugador> jugadores;

    public Torneo() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void mostrarJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " - " + jugador.calcularEfectividad());
        }
    }

    public void mejoresLiberos() {
        jugadores.sort((jugador1, jugador2) -> Double.compare(jugador2.calcularEfectividad(), jugador1.calcularEfectividad()));

        System.out.println("Los 3 mejores líberos:");
        for (int i = 0; i < 3 && i < jugadores.size(); i++) {
            System.out.println(jugadores.get(i).getNombre() + " - " + jugadores.get(i).calcularEfectividad());
        }
    }

    public int contarPasadoresEfectivos() {
        int pasadoresEfectivos = 0;
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Pasador) {
                Pasador pasador = (Pasador) jugador;
                if (pasador.calcularEfectividad() > 80.0) {
                    pasadoresEfectivos++;
                }
            }
        }
        return pasadoresEfectivos;
    }

    public void guardarCatalogoCSV(String archivoCSV) {
        try (FileWriter writer = new FileWriter(archivoCSV)) {
            for (Jugador jugador : jugadores) {
                String linea = jugador.getNombre() + "," + jugador.getPaís() + "," + jugador.getErrores() + "," + jugador.getAces() + "," + jugador.getServicios();
                writer.write(linea + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarCatalogoCSV(String archivoCSV) {
        jugadores.clear();

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

                    Pasador pasador = new Pasador(nombre, país, errores, aces, servicios, 0, 0);
                    jugadores.add(pasador);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
