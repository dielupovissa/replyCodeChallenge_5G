/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package optmant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Aivar
 * Esta classe modela um objecto da classe prédio
 * com caraterisitcas como @posição, @peso da latencia, @peso da conecção
 * 
 */
public class Building {
    private int[] pos = new int[2]; // Its position on the grid
    
    private int latencyW = 1;       // how important is the latency for the building
    
    private int connectionSpeedW;   //  how important is the connection speed for
                                    //the building
    
    private int ident = -1;
    private static int qtd =-1;
    
    private ArrayList<Antena> antenas = null;
    private ArrayList<Double> dist= null;
    
    private double scoreB;
    private Antena ant = null;
    
    /**
     * Inicializador com os parametros em Strings
     * @param posx
     * @param posy
     * @param latencyW
     * @param connectionSpeedW 
     */
    public Building(String posx, String posy, String latencyW, String connectionSpeedW){
        qtd++;
        this.setterConnectionSpeedW(connectionSpeedW);
        this.setterLatencyW(latencyW);
        this.setterPos(posx, posy);
        ident = qtd;
        
    }
    /**
     * inicializador com os parametros em inteiros
     * @param posx
     * @param posy
     * @param latencyW
     * @param connectionSpeedW 
     */
    public Building(int posx, int posy, int latencyW, int connectionSpeedW){
       qtd++;
       ident = qtd;
        this.setterConnectionSpeedW(connectionSpeedW);
        this.setterLatencyW(latencyW);
        this.setterPos(posx, posy);
        
    }
    /**
     * este inicializador apenas atribui um identificador ao predio em ordem da sua criação
     */
    public Building(){
       qtd++;
       ident = qtd;
    
    }
    
    // getter methods
    
    /**
     * Este método retorna a posição do prédio em um array
     * onde em I=0 tem x e I=1 tem o Y
     * @return pos
     */
    public int[] getterPos(){
        return this.pos;
        
    }
    
    /**
     * 
     * @param xory
     * @return 
     */
    public int getterPos(int xory){
        return this.pos[xory];
    }
    public int getterPosX(){
        return this.pos[0];
    }
    public int getterPosY(){
        return this.pos[1];
    }
    
    
    /**
     * 
     * @return 
     */
    public int getterLatencyW(){
        return this.latencyW;
    }
    
    /**
     * 
     * @return 
     */
    public int getterConnectionSpeedW(){
        return this.connectionSpeedW;
    }
    
    
    /**
     * 
     * @param x
     * @param y 
     */
    public void setterPos(int x, int y){
        this.pos[0] = x;
        this.pos[1] = y;
        
    
    }
    
    /**
     * 
     * @param x
     * @param y 
     */
    public void setterPos(String x, String y){
        setterPos(Integer.parseInt(x), Integer.parseInt(x));
    }
    
    /**
     * 
     * @param latencyW 
     */
    public void setterLatencyW(int latencyW){
        if(latencyW <=100 && latencyW >=0)
            this.latencyW = latencyW;
        
    
    }
    
    /**
     * 
     * @param latencyW 
     */
    public void setterLatencyW(String latencyW){
        setterLatencyW(Integer.parseInt(latencyW));
    }
    
    /**
     * 
     * @param connectionSpeedW 
     */
    public void setterConnectionSpeedW(int connectionSpeedW){
        if(connectionSpeedW <=100 && connectionSpeedW >=0)
            this.connectionSpeedW = connectionSpeedW;
        
    
    }
    
    /**
     * 
     * @param connectionSpeedW 
     */
    public void setterConnectionSpeedW(String connectionSpeedW){
        setterLatencyW(Integer.parseInt(connectionSpeedW));
    }
    
    public void reachableA(List<Antena>lista){
        double dista;
        antenas = new ArrayList<>();
        dist = new ArrayList<>();
        
        
        for(Antena a: lista){
            dista = Math.sqrt((a.getterPosX()-this.getterPosX())^2
                    +(a.getterPosY()-this.getterPosY())^2);
            
            if(dista<=a.getterRange()){
                antenas.add(a);
                dist.add(dista);
                
                
            }         
        }
        
    }
    
    public void scoreB(List<Antena> lista){
        this.reachableA(lista);
        this.scoreB();
        
       
        
    }
    
    public void scoreB(){
       Iterator<Double> itDist = dist.iterator();
       Iterator<Antena> itAnt = antenas.iterator();
       double score = 0;
       double adist = 0;
       Antena a;
       int wcs = this.getterConnectionSpeedW();
       int lw = this.getterLatencyW();
       
       while(itAnt.hasNext()){
           a = itAnt.next();
           adist = (double)itDist.next();
           score = wcs*a.getterConnectionSpeed()- lw*adist;
           if(score >= scoreB){
               scoreB = score;
               ant = a;}
       
       }
        
    }

    public ArrayList<Antena> getAntenas() {
        return antenas;
    }

    public ArrayList<Double> getDist() {
        return dist;
    }

    public double getScoreB() {
        return scoreB;
    }

    public Antena getAnt() {
        return ant;
    }
    
    
    
    
    
}
