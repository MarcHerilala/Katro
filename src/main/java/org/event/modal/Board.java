package org.event.modal;

public class Board {
    Player player1;
    Player player2;
    Player currentPlayer;
    public Board(Player player1,Player player2){
        this.player1=player1;
        this.player2=player2;
        this.currentPlayer=player1;
    }

    public void switchTurn(){
        if(currentPlayer==player1){
            currentPlayer=player2;
        }
        else {
            currentPlayer=player1;
        }
    }
    public void makeSow(int row,int column){
        currentPlayer.sow(row,column);
        switchTurn();
    }


}
