package org.event.modal;

public  class Hole  {
    private int seedsNumber;
    public void incrementSeed(){
        seedsNumber++;
    }
    public  void decrementSeed(){
        seedsNumber--;
    }
    public int getSeedsNumber(){
        return seedsNumber;
    }
}
