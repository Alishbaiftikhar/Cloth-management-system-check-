package Server;

import model.Design;

import java.io.*;
import java.util.ArrayList;

public abstract class Files implements Serializable {
    Files(){

    }

    public static void  writeToFile(Design d,String File_1){
        try {
            ArrayList<Design> list=readFromFile(File_1);
            list.add(d);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(File_1));
            output.writeObject(list);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    public static ArrayList<Design> readFromFile(String File_1){
        ArrayList<Design> list=new ArrayList<Design>();
        boolean endoffile=false;
        try{
            ObjectInputStream input=new ObjectInputStream(new FileInputStream(File_1));

            list =(ArrayList<Design>) input.readObject();
        }
        catch(EOFException e){
            endoffile=true;
        }
        catch (ClassCastException e){

        }
        catch (IOException e){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("in");
        return list;
    }
}
