import org.jfree.chart.plot.ThermometerPlot;

import javax.swing.*;

public class Cronometro extends Thread{
    JLabel label;
    public Cronometro(JLabel label){
        this.label=label;
    }

    @Override
    public void run() {
        try{
            Ventana.Horas=0;
            Ventana.Segundos=0;
            Ventana.MilesimasSegundo=0;
            Ventana.Minutos=0;
            int x=0;
            while(Ventana.IniciaCrono){
                Thread.sleep(1);
                EjecucarMiliSegundo();
                x++;
            }
        }catch (Exception e){

        }
    }

    private void EjecucarMiliSegundo() {
        Ventana.MilesimasSegundo++;
        if(Ventana.MilesimasSegundo>999){
            Ventana.MilesimasSegundo=0;
            Ventana.Segundos++;
            if(Ventana.Segundos>59){
                Ventana.Segundos=0;
                Ventana.Minutos++;
                if(Ventana.Minutos>59){
                    Ventana.Minutos=0;
                    Ventana.Horas++;
                }
            }
        }
        String Mseg="",Seg="",Min="",Hora="";
        if(Ventana.MilesimasSegundo<10){
            Mseg="00"+Ventana.MilesimasSegundo;
        }else if (Ventana.MilesimasSegundo<100){
            Mseg="0"+Ventana.MilesimasSegundo;
        }else{
            Mseg=""+Ventana.MilesimasSegundo;
        }
        if (Ventana.Segundos<10){
            Seg="0"+Ventana.Segundos;
        }else{
            Seg=""+Ventana.Segundos;
        }
        if (Ventana.Horas<10){
            Hora="0"+Ventana.Horas;
        }else{
            Hora=""+Ventana.Horas;
        }
        if (Ventana.Minutos<10){
            Min="0"+Ventana.Minutos;
        }else{
            Min=""+Ventana.Minutos;
        }

//        Mseg+=Ventana.MilesimasSegundo;
//        Seg+=Ventana.Segundos;
//        Min+=Ventana.Minutos;
//        Hora+=Ventana.Horas;
        String Reloj =Hora+":"+Min+":"+Seg+":"+Mseg;
        label.setText(Reloj);
    }
}
