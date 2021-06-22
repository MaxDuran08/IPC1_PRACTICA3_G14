import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Ventana extends JFrame implements ActionListener {
    public JPanel PanelGeneral;
    public JButton CargarArchivos;
    public JTextField DireccionCarpeta;
    public JLabel CarpetaNoExiste,CampoVacio,FaltaArchivo;
//Ventana
    public Ventana() {
        setSize(840, 600);
        setTitle("Practica 3");
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        Componentes();
        setIconImage(getIconImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//Componentes
    public void Componentes(){
//        PanelGeneral
        PanelGeneral = new JPanel();
        PanelGeneral.setBounds(0,0,840,600);
        PanelGeneral.setBackground(Color.YELLOW);
        PanelGeneral.setLayout(null);
        this.getContentPane().add(PanelGeneral);

//        Cajas para las direcciones
        DireccionCarpeta = new JTextField();
        DireccionCarpeta.setBounds(400,50,400,20);
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
//        Boton para cargar archivos
        CargarArchivos = new JButton("Cargar Archivos");
        CargarArchivos.setBounds(670,70,130,20);
        PanelGeneral.add(CargarArchivos);
        CargarArchivos.addActionListener(this);
    }

    @Override
//Icono
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
        }
    }
}
