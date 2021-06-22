import com.sun.xml.internal.bind.v2.model.core.ID;

public class Alumnos {
    private int Id,Carne;
    private String Nombre,FechaNacimiento,Genero;

    public Alumnos(int id, int carne, String nombre, String fechaNacimiento, String genero) {
        Id = id;
        Carne = carne;
        Nombre = nombre;
        FechaNacimiento = fechaNacimiento;
        Genero = genero;
    }
    public String Mostrar(){
        return "ID:\t"+getId()+".\tCarne:\t"+getCarne()+".\tNombre:\t"+getNombre()+".\tFecha de nacimiento:\t"+getFechaNacimiento()+".\tGenero:\t"+Genero;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCarne() {
        return Carne;
    }

    public void setCarne(int carne) {
        Carne = carne;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }
}
