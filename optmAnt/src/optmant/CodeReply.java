/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package optmant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aivar Dielupovissa Manuel António
 * github username: dielupovissa
 */
public class CodeReply {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Building> buildings;
    private static ArrayList<Antena> antenas;
    private static int width =0;
    private static int height =0;
    private static int nBuilding =0;
    private static int nAntena =0;
    private static int reward = 0;
    private static int scoreTotal=0;
    public static void main(String[] args) {
        buildings = new ArrayList<Building>();
        antenas = new ArrayList<Antena>();
       
        Scanner in;
        
        
        while(true){
           Scanner scan = new Scanner(System.in);
           String str;
           System.out.println("qual é o nome do ficheiro?");
           str = scan.nextLine();
           in = readerF(str);
            if(in != null)
                break;
          
        }
        width = in.nextInt();
        height = in.nextInt();
        nBuilding = in.nextInt();
        nAntena = in.nextInt();
        reward = in.nextInt();
        
        for(int i =0; i<nBuilding; i++)
            buildings.add(new Building(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
        
        
        for(int i = 0; i<nAntena; i++)
            antenas.add(new Antena(in.nextInt(), in.nextInt()));
        
        /*
        System.out.println(width + " " + height);
        System.out.println(nBuilding + " " +nAntena + " " + reward);
        for(int i =0; i<nBuilding; i++)
            out.println(buildings.get(i).getterPosX(0) + " "+buildings.get(i).getterPosX(1)
                +" "+buildings.get(i).getterLatencyW()+" "+buildings.get(i).getterConnectionSpeedW());
        
        for(int i = 0; i<nAntena; i++)
            out.println(antenas.get(i).getterRange() + " "+ antenas.get(i).getterConnectionSpeed());
        */
        
        closeReaderF(in);
              
        
    }
    public static void posAntenas(Antena a){
        ArrayList<Antena> antenaspos = new ArrayList<Antena>();
        int score;
         
        for(int i =0; i<width; i++){
            for(int j =0; j<height; j++){
                a.setterPos(i, j);
                score = scoreA(a);
                if(scoreTotal <score + scoreTotal)
                    scoreTotal = score + scoreTotal;
            
            }
        }
        
        
        
    }
    
    public static float scoreBuilding(Building b){
        return 3;
    }
    
    public static Scanner readerF(String nomeFile){
        Scanner in = null;
         try {
            in = new Scanner( new File("C:\\Users\\Aivar\\OneDrive\\Documentos\\NetBeansProjects\\codeReply\\src\\codereply\\" + nomeFile) );
            
        }
        catch (Exception e) {
            System.out.println("o ficheiro especificado não existe");
        }
        return in;
          
        
    }
    public static PrintWriter writerF(){
        PrintWriter result = null;
        try {
            result = new PrintWriter(new File("result.dat"));
        }
        catch (IOException e) {
            System.out.println("houve um erro ao abrir o ficheiro");

        }
        return result;
    }
    
    public static void closeWriterF(PrintWriter result){
        result.flush();
        result.close();
    }
    public static void closeReaderF(Scanner in){
        in.close();
    }

    private static int scoreA(Antena a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
