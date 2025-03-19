package org.event.modal;

import org.event.Enum.SowingDirection;

import java.util.HashMap;

public abstract sealed  class Player permits Player1,Player2 {
    String name;
    int score;
    Player opponent;
    Hole[][] board;
    SowingDirection sowingDirection;

    public Player(String name){
        this.name=name;
        this.score=0;
        initializePlayerHoles();
    }
    public void setOpponent(Player opponent){
        this.opponent=opponent;
    }
    private void initializePlayerHoles(){
        board=new Hole[2][4];
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                Hole hole=new Hole(2);
                board[i][j]=hole;
            }
        }
    }


    public void sow(int row,int col) {
        Hole choosenHole=board[row][col];
        int numberOfSeeds=choosenHole.getSeedsNumber();
        if(numberOfSeeds==0){
            return;
        }
        choosenHole.clearHole();
        int currentRow=row;
        int currentCol=col;
        for(int i=0;i<numberOfSeeds;i++){

            HashMap<String ,Integer > currentIndexes=nextHoleIndexes(currentRow, currentCol);
            currentRow=currentIndexes.get("next_row");
            currentCol=currentIndexes.get("next_col");
            if(i==numberOfSeeds-1){
                if(board[currentRow][currentCol].getSeedsNumber()>1){
                    captureSeeds(currentRow,currentCol);
                    sow(currentRow,currentCol);

                }
                else if(board[currentRow][currentCol].getSeedsNumber()==1){
                    //todo: change the turn
                    return;
                }

            }

        }
    }
    public abstract HashMap<String,Integer> nextHoleIndexes(int row,int col);
    public void printBoard() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + board[i][j].getSeedsNumber() + "] ");
            }
            System.out.println();
        }
    }
    protected abstract void captureSeeds(int row,int col);/*{
        int opponentRow=switchRow(row);
        int opponentSeeds=opponent.board[opponentRow][col].getSeedsNumber();
        if(opponentSeeds>0){
            opponent.board[opponentRow][col].clearHole();
            this.board[row][col].addSeeds(opponentSeeds);
        }
    }*/
    protected int switchRow(int row){
        if(row==0){
            row=1;
        }
        else {
            row=0;
        }
        return row;
    }



}
