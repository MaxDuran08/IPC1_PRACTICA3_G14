import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Ventana extends JFrame implements ActionListener {
    public static JPanel PanelGeneral,PanelGraficaPorSexo,PanelGraficaPorEdad,PanelGraficaPorNotas,PanelOrdenamiento;
    public JButton CargarArchivos,Ordenar;
    public JTextField DireccionCarpeta,IDCurso;
    public JCheckBox VerificacionGraficaPie,VerificacionGraficaBarrasEdades,VerificacionGraficaBarrasNotas;
    public static JLabel CarpetaNoExiste,CampoVacio,FaltaArchivo,IDString,IDNoExiste,PasosN;
    public JComboBox TipoOrdenamiento,AlgoritmoOrdenamiento;
    public static JSlider Velocidad;
    public int VelocidadEntero;
    public static Float[][] DatosParaOrdenar;
    public static int Codigo;
    public static String OrdenA_O,AlgoritmoUsado;
    public static JLabel CronometroLabel;
    Accion Panel;
    Thread hilo;
    static int Horas=0,Minutos=0,Segundos=0,MilesimasSegundo;
    static Boolean IniciaCrono=true,CorreCrono=false;

//Ventana
    public Ventana() {
        setSize(880, 630);
        setTitle("Practica 3 Grupo #14");
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        Componentes1();
        Componentes2();
        Componentes3();
        Componentes4();
        setIconImage(getIconImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//Componentes
    public void Componentes1(){
//        PanelGeneral
        PanelGeneral = new JPanel();
        PanelGeneral.setBounds(0,0,880,600);
        PanelGeneral.setBackground(Color.LIGHT_GRAY);
        PanelGeneral.setLayout(null);
        this.getContentPane().add(PanelGeneral);

//        Cajas para las direcciones
        DireccionCarpeta = new JTextField();
        DireccionCarpeta.setBounds(400,50,440,20);
        PanelGeneral.add(DireccionCarpeta);
//        Label para decir que campo es cada uno
        JLabel etiquet1 = new JLabel("A continuación ingrese la informacion que se pide.");
        etiquet1.setBounds(20,20,300,20);
        PanelGeneral. add(etiquet1);
        JLabel DCarpeta1 = new JLabel("Ingrese la direccion de la carpeta que contiene los archivos csv:");
        DCarpeta1.setBounds(20,50,450,20);
        PanelGeneral.add(DCarpeta1);
        CarpetaNoExiste = new JLabel("La ruta no existe.");
        CarpetaNoExiste.setForeground(Color.RED);
        CarpetaNoExiste.setBounds(400,70,130,20);
        PanelGeneral.add(CarpetaNoExiste);
        CarpetaNoExiste.setVisible(false);
        CampoVacio = new JLabel("El campo de texto esta vacio.");
        CampoVacio.setForeground(Color.RED);
        CampoVacio.setBounds(400,70,300,20);
        PanelGeneral.add(CampoVacio);
        CampoVacio.setVisible(false);
        FaltaArchivo= new JLabel();
        FaltaArchivo.setBounds(400,30,400,20);
        FaltaArchivo.setForeground(Color.RED);
        FaltaArchivo.setVisible(false);
        PanelGeneral.add(FaltaArchivo);
//        -----------------------------------------------------------
        JLabel PideID = new JLabel("Ingrese el codigo del curso:");
        PideID.setBounds(20,100,200,20);
        PanelGeneral.add(PideID);
        IDCurso = new JTextField();
        IDCurso.setBounds(180,100,120,20);
        PanelGeneral.add(IDCurso);
        IDString = new JLabel("El codigo ingresado es invalido.");
        IDString.setForeground(Color.RED);
        IDString.setBounds(20,120,200,20);
        PanelGeneral.add(IDString);
        IDString.setVisible(false);
        IDNoExiste = new JLabel("El codigo ingresado no existe.");
        IDNoExiste.setForeground(Color.RED);
        IDNoExiste.setBounds(20,120,200,20);
        PanelGeneral.add(IDNoExiste);
        IDNoExiste.setVisible(false);
        VerificacionGraficaPie = new JCheckBox("Gráfica por sexo");
        VerificacionGraficaPie.setBounds(310,100,130,20);
        PanelGeneral.add(VerificacionGraficaPie);
        VerificacionGraficaBarrasEdades = new JCheckBox("Gráfica por edad");
        VerificacionGraficaBarrasEdades.setBounds(460,100,130,20);
        PanelGeneral.add(VerificacionGraficaBarrasEdades);
        VerificacionGraficaBarrasNotas = new JCheckBox("Gráfica por ordenamiento de notas");
        VerificacionGraficaBarrasNotas.setBounds(610,100,230,20);
        PanelGeneral.add(VerificacionGraficaBarrasNotas);
        VerificacionGraficaPie.addActionListener(this);
        VerificacionGraficaBarrasEdades.addActionListener(this);
        VerificacionGraficaBarrasNotas.addActionListener(this);
//        -----------------------------------------------------------
//        Boton para cargar archivos
        CargarArchivos = new JButton("Cargar Archivos");
        CargarArchivos.setBounds(710,70,130,20);
        PanelGeneral.add(CargarArchivos);
        CargarArchivos.addActionListener(this);
        IDCurso.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VerificacionGraficaPie.setSelected(false);
                VerificacionGraficaBarrasNotas.setSelected(false);
                VerificacionGraficaBarrasEdades.setSelected(false);
                IDCurso.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                VerificacionGraficaPie.setSelected(false);
                VerificacionGraficaBarrasNotas.setSelected(false);
                VerificacionGraficaBarrasEdades.setSelected(false);
                IDCurso.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                VerificacionGraficaPie.setSelected(false);
                VerificacionGraficaBarrasNotas.setSelected(false);
                VerificacionGraficaBarrasEdades.setSelected(false);
                IDCurso.setText("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
//        PanelGraficaPie-----------------------------------------------------------------------------------------------
    }
    public void Componentes2(){
        PanelGraficaPorSexo = new JPanel();
        PanelGraficaPorSexo.setBounds(10,140,840,420);
        PanelGraficaPorSexo.setLayout(new java.awt.BorderLayout());
        PanelGeneral.add(PanelGraficaPorSexo);
        PanelGraficaPorSexo.setVisible(false);
    }
    public void Componentes3(){
        PanelGraficaPorEdad = new JPanel();
        PanelGraficaPorEdad.setBounds(10,140,840,420);
        PanelGraficaPorEdad.setLayout(new java.awt.BorderLayout());
        PanelGeneral.add(PanelGraficaPorEdad);
        PanelGraficaPorEdad.setVisible(false);
    }
    public void Componentes4(){
        PanelOrdenamiento = new JPanel();
        PanelOrdenamiento.setBounds(10,220,840,350);
        PanelOrdenamiento.setLayout(new java.awt.BorderLayout());
        PanelGeneral.add(PanelOrdenamiento);
        PanelOrdenamiento.setVisible(false);
        PanelGraficaPorNotas = new JPanel();
        PanelGraficaPorNotas.setBounds(0,140,880,490);
        PanelGraficaPorNotas.setLayout(null);
        PanelGeneral.add(PanelGraficaPorNotas);
        PanelGraficaPorNotas.setVisible(false);
        JLabel Orden = new JLabel("Escoja el orden de ordenamiento:");
        Orden.setBounds(20,0,200,20);
        PanelGraficaPorNotas.add(Orden);
        PasosN = new JLabel("Pasos: 0");
        PasosN.setBounds(20,40,200,20);
        PanelGraficaPorNotas.add(PasosN);
        JLabel Algorit = new JLabel("Escoja el tipo de algoritmo:");
        Algorit.setBounds(250,0,200,20);
        PanelGraficaPorNotas.add(Algorit);
        String[] Ordenamiento = {"ASCENDENTE","DESCENDENTE"};
        String[] Algoritmo = {"BUBBLE SORT","QUICKSORT"};
        TipoOrdenamiento = new JComboBox(Ordenamiento);
        TipoOrdenamiento.setBounds(20,20,200,20);
        PanelGraficaPorNotas.add(TipoOrdenamiento);
        AlgoritmoOrdenamiento = new JComboBox(Algoritmo);
        AlgoritmoOrdenamiento.setBounds(250,20,200,20);
        PanelGraficaPorNotas.add(AlgoritmoOrdenamiento);
        Velocidad = new JSlider(1,5,1);
        Velocidad.setBounds(480,20,220,50);
        Velocidad.setPaintTicks(true);
//        Velocidad.setMinorTickSpacing(0.5);
        Velocidad.setPaintTrack(true);
        Velocidad.setMajorTickSpacing(1);
        Velocidad.setPaintLabels(true);
        PanelGraficaPorNotas.add(Velocidad);
        JLabel V = new JLabel("Escoja la velocidad del ordenamiento: ");
        V.setBounds(480,0,220,20);
        PanelGraficaPorNotas.add(V);
        Ordenar = new JButton("Ordenar");
        Ordenar.setBounds(730,10,110,30);
        PanelGraficaPorNotas.add(Ordenar);
        Ordenar.addActionListener(this);
        JLabel C = new JLabel("Cronometro:");
        C.setBounds(20,60,100,20);
        PanelGraficaPorNotas.add(C);
        CronometroLabel = new JLabel("00:00:00:00");
        CronometroLabel.setBounds(100,60,200,20);
        PanelGraficaPorNotas.add(CronometroLabel);
        Velocidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                VelocidadEntero=Velocidad.getValue();
//                System.out.println("Cambio la velocidad a: "+VelocidadEntero);
            }
        });

    }
    public Boolean ExisteID(){
        Boolean key=false;
        try {
            int id = Integer.parseInt(IDCurso.getText().replaceAll(" ", ""));
            IDString.setVisible(false);
            for (int i = 0; i < Main.AsignacionesCargadas; i++) {
                if (id==Main.Asignaciones[i].getCodigoC()){
                    IDNoExiste.setVisible(false);
                    key=true;
                    break;
                }else{
                    IDNoExiste.setVisible(true);
                    IDString.setVisible(false);
                    PanelOrdenamiento.setVisible(false);
                    PanelGraficaPorEdad.setVisible(false);
                    PanelGraficaPorNotas.setVisible(false);
                    PanelGraficaPorSexo.setVisible(false);
                    try {
                        Panel.setVisible(false);
                        try{
                            hilo.stop();
                            Accion.Crono.stop();
                        }catch (Exception ee){

                        }
                    }catch (Exception ee){

                    }
                    key=false;
                }
            }
        }catch (Exception e){
            //Error al obtener el id
            IDString.setVisible(true);
            IDNoExiste.setVisible(false);
            PanelGraficaPorEdad.setVisible(false);
            PanelGraficaPorNotas.setVisible(false);
            PanelGraficaPorSexo.setVisible(false);
            PanelOrdenamiento.setVisible(false);
            try {
                hilo.stop();
                Accion.Crono.stop();
                try{
                    Panel.setVisible(false);
                }catch (Exception ee){

                }
            }catch (Exception ee){

            }
        }
        return key;
    }
//Graficas
    public void GraficaPorSexo(){
        PanelGraficaPorSexo.removeAll();
        int Codigo = Integer.parseInt(IDCurso.getText().replaceAll(" ",""));
        int SexoM=0,SexoF=0;
        for (int i = 0; i < Main.AsignacionesCargadas; i++) {
            if(Codigo==Main.Asignaciones[i].getCodigoC()){
                if(Main.Asignaciones[i].getGenero().equals("M")){
                    SexoM++;
                }
                if (Main.Asignaciones[i].getGenero().equals("F")){
                    SexoF++;
                }
            }
        }
//        System.out.println("Femenino:"+SexoF+". Masculino:"+SexoM);
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("FEMENINO",SexoF);
        data.setValue("MASCULINO",SexoM);
        JFreeChart chart = ChartFactory.createPieChart("GRÁFICA POR SEXO DEL CURSO: "+Codigo,data,true,true,false);
        ChartPanel CP = new ChartPanel(chart);
        PanelGraficaPorSexo.add(CP,BorderLayout.CENTER);

    }
    public void GraficaPorEdad(){
        PanelGraficaPorEdad.removeAll();
        int Codigo = Integer.parseInt(IDCurso.getText().replaceAll(" ",""));
        String[][] Rangos = new String[10][2];
        String[] R= new String[]{"0-9","10-19","20-29","30-39","40-49","50-59","60-69","70-79","80-89","90-100"};
        for (int i = 0; i < 10; i++) {
            Rangos[i][0]=R[i];
            Rangos[i][1]=String.valueOf(0);
        }
        for (int i = 0; i < Main.AsignacionesCargadas; i++) {
            if (Codigo==Main.Asignaciones[i].getCodigoC()){
                String[] AñoNacimiento =Main.Asignaciones[i].getFechaNacimiento().split("/");
                int añoN=Integer.parseInt(AñoNacimiento[2]);
                int edad = 2021-añoN;
                if((edad<=9)){
                    Rangos[0][1]=String.valueOf(Integer.valueOf(Rangos[0][1])+1);
                }else if(edad>=10&&edad<=19){
                    Rangos[1][1]=String.valueOf(Integer.valueOf(Rangos[1][1])+1);
                }else if(edad>=20&&edad<=29){
                    Rangos[2][1]=String.valueOf(Integer.valueOf(Rangos[2][1])+1);
                }else if(edad>=30&&edad<=39){
                    Rangos[3][1]=String.valueOf(Integer.valueOf(Rangos[3][1])+1);
                }else if(edad>=40&&edad<=49){
                    Rangos[4][1]=String.valueOf(Integer.valueOf(Rangos[4][1])+1);
                }else if(edad>=50&&edad<=59){
                    Rangos[5][1]=String.valueOf(Integer.valueOf(Rangos[5][1])+1);
                }else if(edad>=60&&edad<=69){
                    Rangos[6][1]=String.valueOf(Integer.valueOf(Rangos[6][1])+1);
                }else if(edad>=70&&edad<=79){
                    Rangos[7][1]=String.valueOf(Integer.valueOf(Rangos[7][1])+1);
                }else if(edad>=80&&edad<=89){
                    Rangos[8][1]=String.valueOf(Integer.valueOf(Rangos[8][1])+1);
                }else if(edad>=90&&edad<=100){
                    Rangos[9][1]=String.valueOf(Integer.valueOf(Rangos[9][1])+1);
                }
            }
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 10; i++) {
            if(Integer.parseInt(Rangos[i][1])!=0){
                int cantidad=0;
                cantidad=Integer.valueOf(Rangos[i][1]);
                String rang="";
                rang=Rangos[i][0];
                dataset.addValue(cantidad,"ALUMNOS",rang);
            }
        }
        JFreeChart chart = ChartFactory.createBarChart3D ("GRÁFICA POR EDAD DEL CURSO: "+Codigo,"RANGO DE EDAD", "CANTIDAD", dataset, PlotOrientation.VERTICAL, true,true, false);
        ChartPanel CP = new ChartPanel(chart);
        PanelGraficaPorEdad.add(CP,BorderLayout.CENTER);
    }
    public void GraficaPorNotas(Boolean Orden){
        PanelOrdenamiento.removeAll();
        int tamaño=0;
        int Codigo = Integer.parseInt(IDCurso.getText().replaceAll(" ",""));
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < Main.AsignacionesCargadas; i++) {
            if(Codigo==Main.Asignaciones[i].getCodigoC()){
                dataset.addValue(Main.Asignaciones[i].getNota(),"ALUMNOS",String.valueOf(Main.Asignaciones[i].getIdAlumno()));
                tamaño++;
            }
        }
        Float[][] Datos = new Float[tamaño][2];
        int contador=0;
        for (int i = 0; i < Main.AsignacionesCargadas; i++) {
            if(Codigo==Main.Asignaciones[i].getCodigoC()){
                Datos[contador][0]=Float.parseFloat(String.valueOf(Main.Asignaciones[i].getIdAlumno()));
                Datos[contador][1]=Main.Asignaciones[i].getNota();
                contador++;
//                System.out.println("ID: "+Datos[contador][0]+". Nota: "+Datos[contador][1]);
            }
        }
        JFreeChart chart = ChartFactory.createBarChart3D("GRAFICA POR NOTAS DEL CURSO: "+Codigo,"ID ALUMNO","NOTA",dataset,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel CP = new ChartPanel(chart);
        PanelOrdenamiento.add(CP,BorderLayout.CENTER);
        //Muestra los datos cargados a la grafica
//        for (int i = 0; i < Datos.length; i++) {
//            System.out.println("ID:"+Datos[i][0]+". Nota: "+Datos[i][1]);
//        }
    }
//Obtiene datos para el ordenamiento de graficas
    public void ObtieneDatos(int IdCodigo, String Orden,String Algoritmo){
        OrdenA_O=Orden;
        AlgoritmoUsado=Algoritmo;
        Codigo=IdCodigo;
        Float[][] temp = new Float[1000000][2];
        int contador=0;
        for (int i = 0; i < Main.AsignacionesCargadas; i++) {
            if(IdCodigo==Main.Asignaciones[i].getCodigoC()){
                temp[contador][0]=Float.parseFloat(String.valueOf(Main.Asignaciones[i].getIdAlumno()));
                temp[contador][1]=Main.Asignaciones[i].getNota();
                contador++;
//                System.out.println("ID: "+Datos[contador][0]+". Nota: "+Datos[contador][1]);
            }
        }
        Float[][] temp2= new Float[contador][2];
        for (int i = 0; i < temp2.length; i++) {
            temp2[i][0]=temp[i][0];
            temp2[i][1]=temp[i][1];
        }
        DatosParaOrdenar=temp2;
//        for (int i = 0; i < DatosParaOrdenar.length; i++) {
//            System.out.println("ID:"+DatosParaOrdenar[i][0]+". Nota: "+DatosParaOrdenar[i][1]);
//        }
    }
//Velocidad del ordenamiento de la grafica
    public static void esperar(){
        try {
            Thread.sleep((2/Velocidad.getValue()) * 2000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
//Icono para la ventana
    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/escudo10.png"));
    }
//Eventos
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()  == CargarArchivos){
            if (!DireccionCarpeta.getText().equals("")){
                CampoVacio.setVisible(false);
                CarpetaNoExiste.setVisible(false);
                File Carpeta = new File(DireccionCarpeta.getText());
                if(Carpeta.exists()){
                    CarpetaNoExiste.setVisible(false);
                    File Alumnos = new File(DireccionCarpeta.getText()+"\\alumnos.csv");
                    File Cursos = new File(DireccionCarpeta.getText()+"\\cursos.csv");
                    File Asignaciones = new File(DireccionCarpeta.getText()+"\\asignaciones.csv");
                    Boolean key1=false, key2=false,key3=false;
                    if(Alumnos.exists()){
                        Main.CargarAlumnos(DireccionCarpeta.getText()+"\\alumnos.csv");
                        key1=true;
                    }else{
                        key1=false;
                    }
                    if (Cursos.exists()){
                        Main.CargarCursos(DireccionCarpeta.getText()+"\\cursos.csv");
                        key2=true;
                    }else{
                        key2=false;
                    }
                    if (Asignaciones.exists()){
                        if(key1&&key2) {
                            Main.CargarAsignaciones(DireccionCarpeta.getText() + "\\asignaciones.csv");
                        }
                        key3=true;
                    }else{
                        key3=false;
                    }
                    if (!key1||!key2||!key3){
                        String texto1="Falta el archivo: ";
                        String texto2="Faltan los archivos: ";
                        int cont=0;
                        String[] F = new String[3];
                        if (!key1){
                            F[cont]="alumnos.csv";
                            cont++;
                        }
                        if (!key2){
                            F[cont]="cursos.csv";
                            cont++;
                        }
                        if (!key3){
                            F[cont]="asignaciones.csv";
                            cont++;
                        }
                        if (cont<2){
                            texto1=texto1+F[0]+".";
                            FaltaArchivo.setText(texto1);
                            FaltaArchivo.setVisible(true);
                        }else{
                            for (int i = 0; i < cont; i++) {
                                texto2=texto2+F[i];
                                if (i+1<cont){
                                    texto2=texto2+", ";
                                }else{
                                    texto2=texto2+".";
                                }
                            }
                            FaltaArchivo.setText(texto2);
                            FaltaArchivo.setVisible(true);
                        }
                    }else{
                        FaltaArchivo.setVisible(false);
                    }

                }else{
                    CarpetaNoExiste.setVisible(true);
                    FaltaArchivo.setVisible(false);
                    //Carpeta no existe
                }
            }else {
                CarpetaNoExiste.setVisible(false);
                FaltaArchivo.setVisible(false);
                CampoVacio.setVisible(true);
                //Campo vacio
            }
        }else if(ae.getSource() == VerificacionGraficaPie){
            VerificacionGraficaBarrasNotas.setSelected(false);
            VerificacionGraficaBarrasEdades.setSelected(false);
            if(ExisteID()){
                //panelPie
                VerificacionGraficaPie.setSelected(true);
                GraficaPorSexo();
                PanelGraficaPorSexo.setVisible(true);
                try {
                    Panel.setVisible(false);
                    try{
                        hilo.stop();
                        Accion.Crono.stop();
                    }catch (Exception e){

                    }
                }catch (Exception e){

                }
                PanelGraficaPorEdad.setVisible(false);
                PanelGraficaPorNotas.setVisible(false);
                PanelOrdenamiento.setVisible(false);
            }else{
                PanelGraficaPorSexo.setVisible(false);
                VerificacionGraficaPie.setSelected(false);
                PanelOrdenamiento.setVisible(false);
            }
        }else if(ae.getSource() == VerificacionGraficaBarrasEdades){
            VerificacionGraficaPie.setSelected(false);
            VerificacionGraficaBarrasNotas.setSelected(false);
            if(ExisteID()){
                VerificacionGraficaBarrasEdades.setSelected(true);
                GraficaPorEdad();
                PanelGraficaPorEdad.setVisible(true);
                try {
                    Panel.setVisible(false);
                    try{
                        hilo.stop();
                        Accion.Crono.stop();
                    }catch (Exception e){

                    }
                }catch (Exception e){

                }
                PanelGraficaPorSexo.setVisible(false);
                PanelGraficaPorNotas.setVisible(false);
                PanelOrdenamiento.setVisible(false);
            }else{
                PanelGraficaPorEdad.setVisible(false);
                PanelOrdenamiento.setVisible(false);
                VerificacionGraficaBarrasEdades.setSelected(false);
            }
        }else if(ae.getSource()==VerificacionGraficaBarrasNotas){
            VerificacionGraficaBarrasEdades.setSelected(false);
            VerificacionGraficaPie.setSelected(false);
            PasosN.setText("Pasos: 0");
            if(ExisteID()){
                VerificacionGraficaBarrasNotas.setSelected(true);
                CronometroLabel.setText("00:00:00:00");
                GraficaPorNotas(false);
                PanelOrdenamiento.setVisible(true);
                try {
                    Panel.setVisible(false);
                    try{
                        hilo.stop();
                        Accion.Crono.stop();
                    }catch (Exception e){

                    }
                }catch (Exception e){

                }
                PanelGraficaPorSexo.setVisible(false);
                PanelGraficaPorEdad.setVisible(false);
                PanelGraficaPorNotas.setVisible(true);
            }else{
                PanelOrdenamiento.setVisible(false);
                PanelGraficaPorNotas.setVisible(false);
                VerificacionGraficaBarrasNotas.setSelected(false);
            }
        }else if(ae.getSource()==Ordenar){
            //Boton ordenar
//            GraficaPorNotas(true);
            try{
                hilo.stop();
            }catch (Exception e){

            }
//            if (CorreCrono==false){
//                IniciaCrono=true;
//                CorreCrono=true;
//                HiloCrono();
//            }
            ObtieneDatos(Integer.parseInt(IDCurso.getText()),TipoOrdenamiento.getItemAt(TipoOrdenamiento.getSelectedIndex()).toString(),AlgoritmoOrdenamiento.getItemAt(AlgoritmoOrdenamiento.getSelectedIndex()).toString());
            Panel = new Accion(DatosParaOrdenar,Codigo,OrdenA_O,AlgoritmoUsado);
            Panel.setBounds(10,80,840,350);
            Panel.setLayout(new java.awt.BorderLayout());
            PanelGraficaPorNotas.add(Panel);
            Panel.setVisible(true);
            hilo = new Thread(Panel);
            hilo.start();
//            Elimina basosadas
            PanelOrdenamiento.removeAll();
            PanelGraficaPorSexo.setVisible(false);
            PanelGraficaPorEdad.setVisible(false);
            PanelGraficaPorNotas.setVisible(true);
        }
    }


}
