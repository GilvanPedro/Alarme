package br.com;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable{

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner sc;

    AlarmClock(LocalTime alarmTime,  String filePath,  Scanner sc){
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.sc = sc;
    }

    @Override
    public void run(){

        while(LocalTime.now().isBefore(alarmTime)){
            try {
                Thread.sleep(1000);

                LocalTime now = LocalTime.now();

                System.out.printf("\r%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());

            } catch (InterruptedException e) {
                System.out.println("Thread interrompida");
            }
        }

        System.out.println("\nAlarme Acionado PIPIPIPIPIPI");
        playSound(filePath);
    }

    private void playSound(String filePath){

        File audioFile = new File(filePath);

        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.print("Aperte *Enter* para parar o alarme: ");
            sc.nextLine();
            clip.stop();

        }
        catch (UnsupportedAudioFileException e){
            System.out.println("Audio File não suportado");
        }
        catch (LineUnavailableException e){
            System.out.println("Audio não disponível");
        }
        catch (IOException e){
            System.out.println("Erro ao ler o arquivo de áudio");
        }
    }
}
