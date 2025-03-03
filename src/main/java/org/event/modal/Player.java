package org.event.modal;

import org.event.Enum.SowingDirection;

public class Player {
    Player opponent;
    Hole[][] board;
    SowingDirection sowingDirection;

    public void sow(int row,int col) {
        Hole choosenHole=board[row][col];
        int numberOfSeeds=choosenHole.getSeedsNumber();
        if(numberOfSeeds==0){
            return;
        }
        choosenHole.clearHole();
        int currentRow=row;
        for(int i=0;i<numberOfSeeds;i++){
            if(i==0 || i>board[0].length-1){
                currentRow=switchRow(currentRow);
            }
            if(currentRow==1){
                board[currentRow][col-1].incrementSeed();
            } else if (currentRow==0) {
                board[currentRow][col+1].incrementSeed();
            }
            if(i>=numberOfSeeds-1){
                if(board[currentRow][i].getSeedsNumber()>1){
                    captureSeeds(currentRow,i);
                    sow(currentRow,i);

                }
                else if(board[currentRow][i].getSeedsNumber()==1){
                    //todo: change the turn
                    return;
                }

            }

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
