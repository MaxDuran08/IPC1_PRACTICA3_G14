public class Cursos {
    private int Id,Codigo;
    private String Nombre;

    public Cursos(int id, int codigo, String nombre) {
        Id = id;
        Codigo = codigo;
        Nombre = nombre;
    }
    public String Mostrar(){
        return "ID:\t"+getId()+".\tCodigo:\t"+getCodigo()+".\tNombre:\t"+getNombre();
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
