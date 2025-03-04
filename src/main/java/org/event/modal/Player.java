package org.event.modal;

import org.event.Enum.SowingDirection;

public class Player {
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
            if(currentCol==0 || currentCol>board[0].length-1){
                currentRow=switchRow(currentRow);
                currentCol=currentRow==0?0:3;
            }
            if(currentRow==1){

                board[currentRow][currentCol].incrementSeed();
                currentCol--;


            } else if (currentRow==0) {

                board[currentRow][currentCol].incrementSeed();
                currentCol++;

            }
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
    public void printBoard() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + board[i][j].getSeedsNumber() + "] ");  // Affiche le nombre de graines dans chaque trou
            }
            System.out.println();  // Sauter à la ligne après chaque rangée
        }
    }
    private void captureSeeds(int row,int col){
        int opponentRow=switchRow(row);
        int opponentSeeds=opponent.board[opponentRow][col].getSeedsNumber();
        if(opponentSeeds>0){
            opponent.board[opponentRow][col].clearHole();
            this.board[row][col].addSeeds(opponentSeeds);
        }
    }
    private int switchRow(int row){
        if(row==0){
            row=1;
        }
        else {
            row=0;
        }
        return row;
    }



}
