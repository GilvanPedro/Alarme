package br.com;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "【MV】Rainy-Day-Apricot-ft.-Zentreya【COVER】.wav";

        while(alarmTime == null){
            try {
                System.out.print("Digite a hora do alarme (HH:mm:ss): ");
                String inputTime = sc.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarme definido para: "+ alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println("Formato Inválido. Use (HH:mm:ss)");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, sc);
        Thread alarmTread = new Thread(alarmClock);
        alarmTread.start();

    }
}