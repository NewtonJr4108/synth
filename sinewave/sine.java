import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;
import java.lang.Math;
import java.util.Scanner;


public class sine{

  public static void main(String[] args){

    


    while (true){

      Scanner scob = new Scanner(System.in);
    
      System.out.println("Input frequency in hertz \n");
      double h = scob.nextDouble();

      //scob.close();

      //plays major seventh chord based on input frequency

      double third = h* (5.0 / 4.0 );

      double fifth = h*(3.0 / 2.0);

      double seventh = h*(15.0 / 8.0);

      double octave = h*(2.0 / 1.0);

      try {

        //System.out.println("1: %.5f, 3: %.5f, 5: %.5f \n" , h, third, fifth);
        //System.out.print(third);

        //while (true){

        sine.createTone(h, 100);
        sine.createTone(third, 100);
        sine.createTone(fifth, 100);
        sine.createTone(seventh, 100);
        sine.createTone(octave, 100);


       // }
        
          



    }  

    catch (LineUnavailableException lue) {
        System.out.println(lue);


    }

    //scob.close();
      
  


    }
  

    
  }

  public static void createTone(double Hertz, int volume)
    throws LineUnavailableException {

    float rate = 41000;
    byte[] buf;
    AudioFormat audioF;

    buf = new byte[1];
    audioF = new AudioFormat(rate,8,1,true,false);

    SourceDataLine sourceDL = AudioSystem.getSourceDataLine(audioF);
    sourceDL = AudioSystem.getSourceDataLine(audioF);
    sourceDL.open(audioF);
    sourceDL.start();

    for(int i=0; i<rate; i++){
      double angle = (i/rate)*Hertz*2.0*Math.PI;
      buf[0]=(byte)(Math.sin(angle)*volume);
      sourceDL.write(buf,0,1);
    }

    
    sourceDL.close();
  }

  

}