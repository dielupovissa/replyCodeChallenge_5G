/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package optmant;

/**
 *
 * @author Aivar
 */
public class Antena {
    
    private int range;           //the distance that the antenna signal can reach
    private int connectionSpeed; //the connection speed provided to the building connected to it
    private int ident = -1;
    private int[] pos;
    private static int qtd =-1;
    
    /**
     * 
     * @param range
     * @param connectionSpeed 
     */
    public Antena(String range, String connectionSpeed){
        this.setterConnectionSpeed(connectionSpeed);
        this.setterRange(range);
        qtd++;
        ident = qtd;
       
        
    }
    
    /**
     * 
     * @param range
     * @param connectionSpeed 
     */
    public Antena(int range, int connectionSpeed){
        this.setterConnectionSpeed(connectionSpeed);
        this.setterRange(range);
        qtd++;
        ident = qtd;
      
        
    }
    
    /**
     * 
     */
    public Antena(){
        qtd++;
        ident = qtd;
        
    }
    
    /**
     * 
     * @param x coordenada da antena x
     * @param y coordenada da antena y
     */
    public void setterPos(int x, int y){
        this.pos[0] = x;
        this.pos[1] = y;
        
    }
    public void setterPosX(int x){
        this.pos[0] = x;
       
        
    }
    public void setterPosY(int y){
     
        this.pos[1] = y;
        
    }
    
    /**
     * 
     * @param x coordenada da antena x
     * @param y coordenada da antena y
     */
    public void setterPos(String x, String y){
        setterPos(Integer.parseInt(x), Integer.parseInt(y));
        
    }
    
    /**
     * 
     * @return pos
     */
    public int[] getterPos(){
        return this.pos;
    }
    
    /**
     * 
     * @param ident index +1 
     */
    public void setterIdent(int ident){
        this.ident = ident;
    }
    
    /**
     * 
     * @param ident 
     */
    public void setterIdent(String ident){
        setterIdent(Integer.parseInt(ident));
    }
    
    /**
     * 
     * @param range the range of antenna
     */
    public void setterRange(int range){
        if(range >=0 && range<=100)
            this.range = range;
        
    }
    
    /**
     * 
     * @param range 
     */
    public void setterRange(String range){
        setterRange(Integer.parseInt(range));
    }
    
    /**
     * 
     * @param connectionSpeed 
     */
    public void setterConnectionSpeed(int connectionSpeed){
        if(connectionSpeed >=1 && connectionSpeed <=10000)
        this.connectionSpeed = connectionSpeed;
    }
    
    /**
     * 
     * @param connectionSpeed 
     */
    public void setterConnectionSpeed(String connectionSpeed){
        setterConnectionSpeed(Integer.parseInt(connectionSpeed));
    }
    
    // getters methods
    
    /**
     * 
     * @return ident
     */
    public int getterIdent(){
        return this.ident;
    }
    
    /**
     * 
     * @return range
     */
    public int getterRange(){
        return this.range;
    }
    
    /**
     * 
     * @return connection Speed
     */
    public int getterConnectionSpeed(){
        return this.connectionSpeed;
    }
    public int getterPosX(){
        return pos[0];
    }
    public int getterPosY(){
        return pos[1];
    }
    
}
