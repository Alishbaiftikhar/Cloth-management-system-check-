package Server;

import model.Design;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class server {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9877);
        DatagramPacket sendPacket;
        byte[] receiveData = new byte[1824];
        byte[] sendData = new byte[1824];

//        ByteArrayInputStream stream;
//        ObjectInputStream object;
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        // InetAddress IPAddress=receivePacket.getAddress();
        // int port= receivePacket.getPort();
        while (true) {
            System.out.println("received");
            // receivePacket= new DatagramPacket (receiveData,receiveData.length);
            System.out.println("waitnig for data");
            serverSocket.receive(receivePacket);
            System.out.println("line 29 "+receivePacket.getData());
            String get_data = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
            System.out.println("line31 " + get_data);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println(get_data.getClass());
         //   sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
      //      serverSocket.send(sendPacket);
            switch (get_data) {
                case "1": {
                    System.out.println("enter");
                    serverSocket.receive(receivePacket);
                    System.out.println("line 41 something recieved");

                    System.out.println(receivePacket.getData().getClass());
                    //System.out.println(receivePacket);
                    byte[] data = receivePacket.getData();
                    ByteArrayInputStream stream = new ByteArrayInputStream(data);
                    ObjectInputStream object = new ObjectInputStream(stream);
                    Design design = (Design) object.readObject();

                  //  Design design=(Design)(ByteConverter.deserialize(receivePacket.getData()));
                    System.out.println("My object" + design);
                    String message = "value added";
                    sendData = message.getBytes();
                    sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    serverSocket.send(sendPacket);

                }
                break;
        }
    }
}}
