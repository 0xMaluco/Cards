package br.gm325.cards.model;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {
   private ArrayList <Carta> cartas = new ArrayList<Carta>();
   private ArrayList <Carta> cartasShuffle = new ArrayList<Carta>();
   private boolean shuffled = false;
   
   private int dificuldade = 0;

    public boolean isShuffled() {
        return shuffled;
    }


    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void add(String pergunta, String resposta){
        Carta carta = new Carta(pergunta, resposta);
        cartas.add(carta);
    }
    public void add(Carta carta){
        cartas.add(carta);
    }

    public void remove(Carta carta){
        cartas.remove(carta);
    }

    public void remove(int index){
        cartas.remove(index);
    }
    
    public void removeAll(){
        cartas.removeAll(cartas);
    }
    
    
    public int getIndex(Carta carta){
        return cartas.indexOf(carta);
    }

    public int size(){
        return cartas.size();
    }

    
    public void shuffle(){
       cartasShuffle = (ArrayList<Carta>) cartas.clone();
       Collections.shuffle(cartasShuffle);
       shuffled = true;
       
    }
    
    public void shuffleClear(){
        if(cartasShuffle.size() > cartas.size()){
   
        for(int i = cartasShuffle.size(); i > cartas.size(); i++){
            cartasShuffle.remove(i);
            }
        }
        
        shuffled = false;
    }
    
    public void clearShuffled(){
        cartasShuffle.clear();
        shuffled = false;
    }
    
    public String getPergunta(int index){
        
        if(shuffled){
            return cartasShuffle.get(index).getPergunta();
        } else {
            return cartas.get(index).getPergunta();
        }
      
    }
    
    public String getResposta(int index){
        
        if(shuffled){
            return cartasShuffle.get(index).getPergunta();
        } else {
            return cartas.get(index).getResposta();
        }
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Original Deck{");
        for (int i = 0; i < cartas.size(); i++) {
            sb.append(cartas.get(i).toString(i));
            if (i < cartas.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(", dificuldade=").append(dificuldade).append('}');
        sb.append("Shuffled Deck{");
        for (int i = 0; i < cartasShuffle.size(); i++) {
            sb.append(cartasShuffle.get(i).toString(i));
            if (i < cartasShuffle.size() - 1) {
                sb.append(", ");
            }
        }
          sb.append(", dificuldade=").append(dificuldade).append('}');
        return sb.toString();
    }

    
    
    
}
