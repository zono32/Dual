package Hospital;

public class Area {
    private int id;
    private String nombreEspecialidad;

    public Area(int id, String nombreEspecialidad) {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
    }
    public Area() {
        this.id = 0;
        this.nombreEspecialidad = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", nombreEspecialidad='" + nombreEspecialidad + '\'' +
                '}';
    }
}
