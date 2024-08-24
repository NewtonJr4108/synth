import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;
import java.util.Scanner;
public class ExampleTone1{

  public static void main(String[] args){

    


    while (true){

      Scanner scob = new Scanner(System.in);
    
      System.out.println("Input frequency in hertz \n");
      int h = scob.nextInt();

      //scob.close();

      try {
        ExampleTone1.createTone(h, 100);
    } catch (LineUnavailableException lue) {
        System.out.println(lue);
    }


    }

    
  }

  public static void createTone(int Hertz, int volume)
    throws LineUnavailableException {

    float rate = 44100;
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

    sourceDL.drain();
    sourceDL.stop();
    sourceDL.close();
  }
}