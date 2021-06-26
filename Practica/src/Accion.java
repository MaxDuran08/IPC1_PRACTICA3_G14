import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class Accion extends JPanel implements Runnable {
static Cronometro Crono;
Float[][] Datos;
int Codigo;
String Orden,Algoritmo;
int pasos=1;
    public Accion(Float[][] Datos, int Codigo,String Orden,String Algoritmo){
        this.Datos=Datos;
        this.Codigo=Codigo;
        this.Orden=Orden;
        this.Algoritmo=Algoritmo;
    }

    @Override
    public void run() {
        if (Ventana.CorreCrono==false){
            Ventana.IniciaCrono=true;
            Ventana.CorreCrono=true;
            HiloCrono();
        }
        if(Algoritmo.equals("BUBBLE SORT")){
            if (Orden.equals("ASCENDENTE")){
                for (int i = 0; i < Datos.length; i++) {
                    for (int j = i+1; j < Datos.length; j++) {
                        if((Datos[i][1])>Datos[j][1]){
                            Float tempN = Datos[i][1];
                            Float tempId =Datos[i][0];
                            Datos[i][1]=Datos[j][1];
                            Datos[i][0]=Datos[j][0];
                            Datos[j][1]=tempN;
                            Datos[j][0]=tempId;
                            DefaultCategoryDataset dataX = new DefaultCategoryDataset();
                            for (int k = 0; k < Datos.length; k++) {
                                int id=Math.round(Datos[k][0]);
                                dataX.addValue(Datos[k][1],"ALUMNOS",String.valueOf(id));
                            }
                            JFreeChart chartO = ChartFactory.createBarChart3D("GRAFICA "+Orden+" POR NOTAS DEL CURSO: "+Codigo,"ID ALUMNO","NOTA",dataX, PlotOrientation.VERTICAL,true,true,false);
                            ChartPanel CPOrden = new ChartPanel(chartO);
                            this.add(CPOrden, BorderLayout.CENTER);
//                            System.out.println(pasos);
                            Ventana.PasosN.setText("Pasos: "+pasos);
                            pasos++;
                            Ventana.esperar();
                        }
                    }
                }
            }else if(Orden.equals("DESCENDENTE")){
                for (int i = 0; i < Datos.length; i++) {
                    for (int j = i+1; j < Datos.length; j++) {
                        if((Datos[i][1])<Datos[j][1]){
                            Float tempN = Datos[i][1];
                            Float tempId =Datos[i][0];
                            Datos[i][1]=Datos[j][1];
                            Datos[i][0]=Datos[j][0];
                            Datos[j][1]=tempN;
                            Datos[j][0]=tempId;
                            DefaultCategoryDataset dataX = new DefaultCategoryDataset();
                            for (int k = 0; k < Datos.length; k++) {
                                int id=Math.round(Datos[k][0]);
                                dataX.addValue(Datos[k][1],"ALUMNOS",String.valueOf(id));
                            }
                            JFreeChart chartO = ChartFactory.createBarChart3D("GRAFICA "+Orden+" POR NOTAS DEL CURSO: "+Codigo,"ID ALUMNO","NOTA",dataX, PlotOrientation.VERTICAL,true,true,false);
                            ChartPanel CPOrden = new ChartPanel(chartO);
                            this.add(CPOrden, BorderLayout.CENTER);
//                            System.out.println(pasos);
                            Ventana.PasosN.setText("Pasos: "+pasos);
                            pasos++;
                            Ventana.esperar();
                        }
                    }
                }
            }
        }else if(Algoritmo.equals("QUICKSORT")){
            if (Orden.equals("ASCENDENTE")){
//                Codigo para ordenamiento quicksort ascendente
                    quickA(Datos,0, Datos.length-1);
            }else if(Orden.equals("DESCENDENTE")){
                    quickD(Datos, 0, Datos.length-1 );
            }
        }
//        Muestra como quedo el orden
//        for (int i = 0; i < Datos.length; i++) {
//            System.out.println("ID:"+Datos[i][0]+". Nota: "+Datos[i][1]);
//        }
////        Para que no quiebre
//        DefaultCategoryDataset dataXx = new DefaultCategoryDataset();
//        for (int k = 0; k < Datos.length; k++) {
//            int id=Math.round(Datos[k][0]);
//            dataXx.addValue(Datos[k][1],"ALUMNOS",String.valueOf(id));
//        }
//        JFreeChart chartO1 = ChartFactory.createBarChart3D("GRAFICA "+Orden+" POR NOTAS DEL CURSO: "+Codigo,"ID ALUMNO","NOTA",dataXx, PlotOrientation.VERTICAL,true,true,false);
//        ChartPanel CPOrden1 = new ChartPanel(chartO1);
//        this.add(CPOrden1, BorderLayout.CENTER);
        Ventana.IniciaCrono=false;
        Ventana.CorreCrono=false;
    }
    private void HiloCrono() {
        if (Ventana.IniciaCrono==true){
            Crono = new Cronometro(Ventana.CronometroLabel);
            Crono.start();
        }
    }
    public void quickA(Float[][] arreglo,int primero,int ultimo){
        int i,j; float pivote,auxiliar1,auxiliar2;
        i=primero;
        j=ultimo;
        pivote=arreglo[(primero+ultimo)/2][1];
        do {
                while (arreglo[i][1] < pivote) {
                    i++;
                }
                while (arreglo[j][1] > pivote) {
                    j--;
                }
            if(i<=j){
                auxiliar1=arreglo[i][1];
                auxiliar2=arreglo[i][0];
                arreglo[i][1]=arreglo[j][1];
                arreglo[i][0]=arreglo[j][0];
                arreglo[j][1]=auxiliar1;
                arreglo[j][0]=auxiliar2;
//                System.out.println("--------------------------------------------");
                DefaultCategoryDataset dataX = new DefaultCategoryDataset();
                for (int k = 0; k < Datos.length; k++) {
                    int id=Math.round(arreglo[k][0]);
                    dataX.addValue(arreglo[k][1],"ALUMNOS",String.valueOf(id));
                }
                JFreeChart chartO = ChartFactory.createBarChart3D("GRAFICA "+Orden+" POR NOTAS DEL CURSO: "+Codigo,"ID ALUMNO","NOTA",dataX, PlotOrientation.VERTICAL,true,true,false);
                ChartPanel CPOrden = new ChartPanel(chartO);
                this.add(CPOrden, BorderLayout.CENTER);
//                System.out.println(pasos);
                Ventana.PasosN.setText("Pasos: "+pasos);
                pasos++;
                Ventana.esperar();
                i++;
                j--;
            }
        }while (i<=j);
        if(primero<j){
            quickA(arreglo,primero,j);
        }
        if(i<ultimo){
            quickA(arreglo,i,ultimo);
        }
    }
    public void quickD(Float[][] arreglo,int primero,int ultimo){
        int i,j; float pivote,auxiliar1,auxiliar2;
        i=primero;
        j=ultimo;
        pivote=arreglo[(primero+ultimo)/2][1];
        do {
            while (arreglo[i][1] < pivote) {
                i++;
            }
            while (arreglo[j][1] > pivote) {
                j--;
            }
            if(i<=j){
                auxiliar1=arreglo[i][1];
                auxiliar2=arreglo[i][0];
                arreglo[i][1]=arreglo[j][1];
                arreglo[i][0]=arreglo[j][0];
                arreglo[j][1]=auxiliar1;
                arreglo[j][0]=auxiliar2;
                DefaultCategoryDataset dataX = new DefaultCategoryDataset();
                for (int k = 0; k < Datos.length; k++) {
                    int id=Math.round(arreglo[k][0]);
                    dataX.addValue(arreglo[k][1],"ALUMNOS",String.valueOf(id));
                }
                JFreeChart chartO = ChartFactory.createBarChart3D("GRAFICA "+Orden+" POR NOTAS DEL CURSO: "+Codigo,"ID ALUMNO","NOTA",dataX, PlotOrientation.VERTICAL,true,true,false);
                ChartPanel CPOrden = new ChartPanel(chartO);
                this.add(CPOrden, BorderLayout.CENTER);
//                System.out.println(pasos);
                Ventana.PasosN.setText("Pasos: "+pasos);
                pasos++;
                Ventana.esperar();
                i++;
                j--;
            }
        }while (i<=j);
        if(primero<j){
            quickD(arreglo,primero,j);
        }
        if(i<ultimo){
            quickD(arreglo,i,ultimo);
        }
    }

}
