public class Líbero extends Jugador {
    private int recibosEfectivos;

    public Líbero(String nombre, String país, int errores, int aces, int servicios, int recibosEfectivos) {
        super(nombre, país, errores, aces, servicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    @Override
    public double calcularEfectividad() {
        double efectividad = 0.0;

        if (getServicios() != 0) {
            efectividad = ((double) (recibosEfectivos - getErrores()) * 100) / (recibosEfectivos + getErrores());
            efectividad += (getAces() * 100) / getServicios();
        }

        return efectividad;
    }
}

