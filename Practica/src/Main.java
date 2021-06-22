public class Main {
    static Alumnos[] Alumnos = new Alumnos[10000000];
    static int AlumnosCargados=0;
    static Cursos[] Cursos = new Cursos[10000000];
    static int CursosCargados=0;
    static Asignaciones[] Asignaciones = new Asignaciones[10000000];
    static int AsignacionesCargadas=0;
    public static void main (String[] args){
        Ventana V = new Ventana();
        V.setVisible(true);
    }

    public static void CargarAlumnos(String direccion){
        Archivos A = new Archivos();
        ReiniciarAlumnos();
        try{
            String[] contenido = A.leerArchivo(direccion).split("#&");
            int Id,Carne;
            String Nombre,FechaNacimiento,Genero;
            AlumnosCargados=0;
            for (int i = 0; i < contenido.length; i++) {
                String[] temp =contenido[i].split(",");
                try {
                    Id = Integer.parseInt(temp[0].replaceAll(" ", ""));
                    Carne=Integer.parseInt(temp[1].replaceAll(" ",""));
                    Nombre=temp[2];
                    FechaNacimiento=temp[3].replaceAll(" ","");
                    Genero=temp[4].replaceAll(" ","");
                    if ((Genero.equals("M"))||(Genero.equals("F"))){
                        int repeticionesId=0,repeticionesCarne=0;
                        for (int j = 0; j < AlumnosCargados; j++) {
                            if (Carne==Alumnos[j].getCarne()){
                                repeticionesCarne++;
                            }
                        }
                        for (int j = 0; j < AlumnosCargados; j++) {
                            if(Id==Alumnos[j].getId()){
                                repeticionesId++;
                            }
                        }
                        if((repeticionesCarne<1)&&(repeticionesId<1)) {
                            try {
                                Alumnos Alumno = new Alumnos(Id,Carne,Nombre,FechaNacimiento,Genero);
                                Alumnos[AlumnosCargados]=Alumno;
                                AlumnosCargados++;
                            } catch (Exception e) {
                                //Produce un error al guardar el dato
                            }
                        }
                    }else{
                        //Produce error al obtener un genero que no es valido
//                        System.out.println("Error de genero");
                    }
                }catch(Exception e){
                    //Se pruce error si al ingresar algun entero esta es una cadena de caracter o caracter
//                    System.out.println("Error de eneteros");
                }
            }
        }catch(Exception e){
            //Produce error si el archivo no se encontro o genero algun error.
//            System.out.println("Error del archivo");
        }
        MostrarAlumnos();
    }
    public static void MostrarAlumnos(){
        for (int i = 0; i < AlumnosCargados; i++) {
            System.out.println(Alumnos[i].Mostrar());
        }
    }
    public static void ReiniciarAlumnos(){
        for (int i = 0; i < Alumnos.length; i++) {
            Alumnos[i]=null;
        }
    }

    public static void CargarCursos(String direccion){
    ReiniciarCursos();
    Archivos A = new Archivos();
    try {
        String[] contenido = A.leerArchivo(direccion).split("#&");
        int Id,Codigo;
        String Nombre;
        CursosCargados=0;
        for (int i = 0; i < contenido.length; i++) {
            String[] temp = contenido[i].split(",");
            try{
                Id=Integer.parseInt(temp[0].replaceAll(" ",""));
                Codigo=Integer.parseInt(temp[1].replaceAll(" ",""));
                Nombre=temp[2];
                try {
                    int repeticioneId = 0, repeticionesCodigo = 0;
                    for (int j = 0; j < CursosCargados; j++) {
                        if (Id == Cursos[j].getId()) {
                            repeticioneId++;
                        }
                    }
                    for (int j = 0; j < CursosCargados; j++) {
                        if (Codigo == Cursos[j].getCodigo()) {
                            repeticionesCodigo++;
                        }
                    }
//                    System.out.println("Intenta cargar:");
//                    System.out.println("ID: " + Id + ", Codigo:" + Codigo + ", Nombre:" + Nombre);
                    if ((repeticioneId < 1) && (repeticionesCodigo < 1)) {
                        try {
                            Cursos Curso = new Cursos(Id, Codigo, Nombre);
                            Cursos[CursosCargados] = Curso;
                            CursosCargados++;
//                            System.out.println("Se cargo:");
//                            System.out.println("ID: " + Id + ", Codigo:" + Codigo + ", Nombre:" + Nombre);
                        } catch (Exception e) {
                            //Error al cargar el dato
//                            System.out.println("Error al cargar el objeto");
                        }
                    }else{
//                        System.out.println("El id se repite:"+repeticioneId+" y el codigo: "+repeticionesCodigo);
                    }
                }catch (Exception e){
                    //eror
                }

            }catch (Exception e){
                //Error de id o carne en int
//                System.out.println("Error int");
            }
        }
    }catch (Exception e){
        //Error en el archivo
//        System.out.println("Error en el archivo");
    }
    MostrarCursos();
    }
    public static void ReiniciarCursos(){
        for (int i = 0; i < Cursos.length; i++) {
            Cursos[i]=null;
        }
    }
    public static void MostrarCursos(){
        for (int i = 0; i < CursosCargados; i++) {
            System.out.println(Cursos[i].Mostrar());
        }
    }

    public static void CargarAsignaciones(String direccion){
        Archivos A = new Archivos();
        ReiniciarAsignaciones();
        try {
            String[] contenido = A.leerArchivo(direccion).split("#&");
            int idCurso,idAlumno,CarneA=0,CodigoC=0;
            Float Nota;
            String NombreA="",FechaNacimiento="",Genero="",NombreC="";
            Boolean keyCurso=false,keyAlumno=false;
            AsignacionesCargadas=0;
            for (int i = 0; i < contenido.length; i++) {
                String[] temp=contenido[i].split(",");
                try {
                    idAlumno=Integer.parseInt(temp[0].replaceAll(" ",""));
                    idCurso=Integer.parseInt(temp[1].replaceAll(" ",""));
                    Nota=Float.valueOf(temp[2].replaceAll(" ",""));
                    for (int j = 0; j < AlumnosCargados; j++) {
                        if(idAlumno==Alumnos[j].getId()){
                            idAlumno=Alumnos[j].getId();
                            NombreA=Alumnos[j].getNombre();
                            FechaNacimiento=Alumnos[j].getFechaNacimiento();
                            CarneA=Alumnos[j].getCarne();
                            Genero=Alumnos[j].getGenero();
                            keyAlumno=true;
                            break;
                        }else{
                            keyAlumno=false;
                        }
                    }
                    for (int j = 0; j < CursosCargados; j++) {
                        if(idCurso==Cursos[j].getId()){
                            idCurso=Cursos[j].getId();
                            CodigoC=Cursos[j].getCodigo();
                            NombreC=Cursos[j].getNombre();
                            keyCurso=true;
                            break;
                        }else{
                            keyCurso=false;
                        }
                    }
                    int repeticionesCursos=0;
                    for (int j = 0; j < AsignacionesCargadas; j++) {
                        if (idAlumno==Asignaciones[j].getIdAlumno()){
                            if (idCurso==Asignaciones[j].getIdCurso()){
                                repeticionesCursos++;
                            }
                        }
                    }
                    if ((repeticionesCursos<1)&&keyCurso&&keyAlumno){
                        Asignaciones Asignacion = new Asignaciones(idCurso,idAlumno,CarneA,CodigoC,Nota,NombreA,FechaNacimiento,Genero,NombreC);
                        Asignaciones[AsignacionesCargadas]=Asignacion;
                        AsignacionesCargadas++;
                    }
                }catch (Exception e){
                    //errores en la carga de los id por no ser enteros
                }
            }
        }catch (Exception e){
            //Error del archivo
        }
        MostrarAsignaciones();
    }
    public static void MostrarAsignaciones(){
        for (int i = 0; i < AsignacionesCargadas; i++) {
            Asignaciones[i].Mostrar();
        }
    }
    public static void ReiniciarAsignaciones(){
        for (int i = 0; i < Asignaciones.length; i++) {
            Asignaciones[i]=null;
        }
    }
}
