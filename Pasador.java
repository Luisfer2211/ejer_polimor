public class Pasador extends Jugador {
    private int pases;
    private int fintasEfectivas;

    public Pasador(String nombre, String país, int errores, int aces, int servicios, int pases, int fintasEfectivas) {
        super(nombre, país, errores, aces, servicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getFintasEfectivas() {
        return fintasEfectivas;
    }

    public void setFintasEfectivas(int fintasEfectivas) {
        this.fintasEfectivas = fintasEfectivas;
    }

    @Override
    public double calcularEfectividad() {
        double efectividad = 0.0;

        if (getServicios() != 0) {
            efectividad = ((double) (pases + fintasEfectivas - getErrores()) * 100) / (pases + fintasEfectivas + getErrores());
            efectividad += (getAces() * 100) / getServicios();
        }

        return efectividad;
    }
}

