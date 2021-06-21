import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    public JPanel Panel;
    public JButton CargarArchivos;
    public JTextField DireccionAlumnos,DireccionCursos,DireccionAsignaciones;
    public JLabel FaltanDirecciones;

    public Ventana() {
        setSize(800, 600);
        setTitle("Practica 3");
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        Componentes();
        setIconImage(getIconImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void Componentes(){
//        Panel
        Panel = new JPanel();
        Panel.setBounds(0,0,800,600);
        Panel.setBackground(Color.GRAY);
        Panel.setLayout(null);
        this.getContentPane().add(Panel);

//        Cajas para las direcciones
        DireccionAlumnos = new JTextField();
        DireccionAlumnos.setBounds(320,50,400,20);
        Panel.add(DireccionAlumnos);
        DireccionCursos = new JTextField();
        DireccionCursos.setBounds(320,80,400,20);
        Panel.add(DireccionCursos);
        DireccionAsignaciones = new JTextField();
        DireccionAsignaciones.setBounds(320,110,400,20);
        Panel.add(DireccionAsignaciones);
//        Label para decir que campo es cada uno
        JLabel etiquet1 = new JLabel("A continuación ingrese las siguientes direcciones.");
        etiquet1.setBounds(20,20,300,20);
        Panel. add(etiquet1);
        FaltanDirecciones = new JLabel("Faltan campos por ingresar.");
        FaltanDirecciones.setBounds(320,140,300,20);
        FaltanDirecciones.setForeground(Color.RED);
        FaltanDirecciones.setVisible(false);
        Panel.add(FaltanDirecciones);

        JLabel DAlumnos = new JLabel("Dirección del archivo alumnos.csv :");
        DAlumnos.setBounds(20,50,300,20);
        Panel.add(DAlumnos);
        JLabel DCursos = new JLabel("Dirección del archivo cursos.csv");
        DCursos.setBounds(20,80,300,20);
        Panel.add(DCursos);
        JLabel DAsignaciones = new JLabel("Dirección del archivo asignaciones.csv");
        DAsignaciones.setBounds(20,110,300,20);
        Panel.add(DAsignaciones);
//        Boton para cargar archivos
        CargarArchivos = new JButton("Cargar Archivos");
        CargarArchivos.setBounds(590,140,130,20);
        Panel.add(CargarArchivos);
        CargarArchivos.addActionListener(this);
    }


    @Override
//      icono
    public Image getIconImage(){
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/escudo10.png"));
    }
//    eventos
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()  == CargarArchivos){
            if ((!DireccionAlumnos.getText().equals(""))&&(!DireccionCursos.getText().equals(""))&&(!DireccionAsignaciones.getText().equals(""))){
                FaltanDirecciones.setVisible(false);
                System.out.println("Hay datos");
            }else {
                FaltanDirecciones.setVisible(true);
                System.out.println("No hay datos");
            }
        }
    }
}
