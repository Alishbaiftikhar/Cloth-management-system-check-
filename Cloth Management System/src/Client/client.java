package Client;

import model.Design;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class client {


    public static void main(String args[]) throws  Exception{
        String[] Pattern={"Jacquard","BlockPrint","Digital Print","Embroided"};
        String[] colours={"Red","Blue","Green","Purple","White","Black"};
        int port = 9877;
        byte[] sendData=new byte[1824];
        byte[] receieveData=new byte[1024];
        String pattern=null;
        String designcode;
        List<String> color=new ArrayList<>();
        BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket=new DatagramSocket();
        InetAddress IPAdress=InetAddress.getByName("DESKTOP-IOJAO06");
        DatagramPacket receivePacket;
        DatagramPacket sendPacket;
        final ByteArrayOutputStream designdata = new ByteArrayOutputStream(6400);
        ObjectOutputStream data;
        String input="yes";
        Scanner s=new Scanner(System.in);
//        String input= s.next();
        while (input=="yes"){
            System.out.println("Choose option from below:");
            System.out.println("1: Add Design");
            System.out.println("2: Search Design ");
            System.out.println("3: View Design");
            String choice= inFromUser.readLine();
            sendData=choice.getBytes();
            sendPacket=new DatagramPacket(sendData,sendData.length,IPAdress,port);
            System.out.println(",,");
            clientSocket.send(sendPacket);
            System.out.println("..");
        //    receivePacket=new DatagramPacket(receieveData,receieveData.length);
         //   clientSocket.receive(receivePacket);
            System.out.println("..");
            System.out.println("choice is "+choice.getClass());
            if(choice.equals("1")){
                for(int i=0;i<Pattern.length;i++) {
                    System.out.println("Choose the pattern number");
                    System.out.println(i+1 + ":" + Pattern[i]);
                }
            int value= s.nextInt();
//            if(value==1){
//                pattern="Jacquard";
//            }
//            else if(value==2){
//                pattern="BlockPrint";
//            }
//            else if(value==3){
//                pattern="Digital Print";
//            }
//            else if (value==4){
//                pattern="Embroided";
//            }
                pattern = Pattern[value+1];
            String ans ="yes";
            while (ans == "yes") {
                for(int i=0;i<colours.length;i++) {
                    System.out.println("Choose the pattern number");
                    System.out.println(i + 1 + ":" + colours[i]);
                }
                value=s.nextInt();
                if(value==1){
                  color.add(colours[0]);
                }
                else if(value==2){
                    color.add(colours[1]);
                }
                else if(value==3){
                    color.add(colours[2]);
                }
                else if (value==4){
                    color.add(colours[3]);;
                }
                else if (value==5){
                    color.add(colours[4]);;
                }
                else if (value==4){
                    color.add(colours[5]);;
                }

            System.out.println("Do you want to add more colour");
            ans=s.nextLine();
                }
            System.out.println("Enter the Design code for your pattern");
            designcode=s.nextLine();
            Design designobject=new Design(pattern,designcode,color);
            ByteArrayOutputStream in=new ByteArrayOutputStream();
            data=new ObjectOutputStream(in);
            data.writeObject(designobject);
            sendData=designdata.toByteArray();
            sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, port);
            clientSocket.send(sendPacket);
            receivePacket=new DatagramPacket(receieveData,receieveData.length);
            clientSocket.receive(receivePacket);
            System.out.println("Do you want to continue");
            input=s.nextLine();

            }


            }



        }
    }

