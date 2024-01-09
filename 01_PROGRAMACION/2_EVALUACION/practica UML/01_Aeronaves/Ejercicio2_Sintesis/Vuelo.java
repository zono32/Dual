package Ejercicio2_Sintesis;

public class Vuelo {
    private Aeropuerto origen;
    private Aeropuerto destino;
    private Aeronave aeronave;

    public Vuelo(Aeropuerto origen, Aeropuerto destino, Aeronave aeronave) {
        this.origen = origen;
        this.destino = destino;
        this.aeronave = aeronave;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }
}
