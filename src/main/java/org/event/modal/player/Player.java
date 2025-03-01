package org.event.modal.player;

import org.event.Enum.SowingDirection;
import org.event.modal.Hole;

import java.util.List;

public abstract sealed class Player permits Player2, Player1 {
    List<Hole> firstRow;
    List<Hole> secondRow;
    SowingDirection sowingDirection;

    public abstract void sow(int holeNumber);
    
}
