package org.event.modal;

import java.util.HashMap;

public final class Player1 extends Player {
    public Player1(String name) {
        super(name);
    }

    @Override
    public HashMap<String, Integer> nextHoleIndexes(int row, int col) {
        HashMap<String, Integer> nextHole = new HashMap<>();

        if ((row == 0 && col == 0) || (row == 1 && col == 3)) {
            row = switchRow(row);
        }
        nextHole.put("next_row", row);

        int newCol = (row == 1) ? col + 1 : col - 1;
        nextHole.put("next_col", newCol);

        return nextHole;
    }

}
