public class Asignaciones {
    private int idCurso,idAlumno,CarneA,CodigoC;
    private Float Nota;
    private String NombreA,FechaNacimiento,Genero,NombreC;

    public Asignaciones(int idCurso, int idAlumno, int carneA, int codigoC, Float nota, String nombreA, String fechaNacimiento, String genero, String nombreC) {
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
        CarneA = carneA;
        CodigoC = codigoC;
        Nota = nota;
        NombreA = nombreA;
        FechaNacimiento = fechaNacimiento;
        Genero = genero;
        NombreC = nombreC;
    }
    public void Mostrar(){
        System.out.println("ID:\t"+getIdAlumno()+".\tCarne:\t"+getCarneA()+".\tNombre del alumno:\t"+getNombreA()+".\tGenero:\t"+getGenero()+".\tFecha de nacimiento:\t"+getFechaNacimiento()+".\tID Curso:\t"+getIdCurso()+".\tCodigo:\t"+getCodigoC()+".\tNombre:\t"+getNombreC()+".\tNota:\t"+getNota());
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getCarneA() {
        return CarneA;
    }

    public void setCarneA(int carneA) {
        CarneA = carneA;
    }

    public int getCodigoC() {
        return CodigoC;
    }

    public void setCodigoC(int codigoC) {
        CodigoC = codigoC;
    }

    public Float getNota() {
        return Nota;
    }

    public void setNota(Float nota) {
        Nota = nota;
    }

    public String getNombreA() {
        return NombreA;
    }

    public void setNombreA(String nombreA) {
        NombreA = nombreA;
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

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String nombreC) {
        NombreC = nombreC;
    }
}
