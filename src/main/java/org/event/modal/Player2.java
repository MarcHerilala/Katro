package org.event.modal;

import java.util.HashMap;

public final class Player2 extends Player {
    public Player2(String name) {
        super(name);
    }

    @Override
    public HashMap<String, Integer> nextHoleIndexes(int row, int col) {
        HashMap<String, Integer> nextHole = new HashMap<>();

        if ((row == 1 && col == 0) || (row == 0 && col == 3)) {
            row = switchRow(row);
        }
        nextHole.put("next_row", row);

        int newCol = (row == 1) ? col - 1 : col + 1;
        nextHole.put("next_col", newCol);

        return nextHole;
    }

    @Override
    protected void captureSeeds(int row, int col) {
        //todo
    }
}
