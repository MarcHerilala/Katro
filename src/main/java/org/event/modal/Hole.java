package org.event.modal;

public  class Hole  {
    public Hole(int seedsNumber){
        this.seedsNumber=seedsNumber;
    }
    private int seedsNumber;
    public void incrementSeed(){
        seedsNumber++;
    }
    public  void decrementSeed(){
        seedsNumber--;
    }
    public void addSeeds(int seedsNumber){
        this.seedsNumber=seedsNumber;
    }
    public  void clearHole(){
        this.seedsNumber=0;
    }
    public int getSeedsNumber(){
        return seedsNumber;
    }
}
