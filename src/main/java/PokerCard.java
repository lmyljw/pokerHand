package main.java;

public class PokerCard implements Comparable<PokerCard>{

    private int number;
    private String color;
    private int count;


    public PokerCard(String number, String color) {
        this.color = color;

        if(number.equals("T")){
            this.number = 10;
        }else if (number.equals("J")){
            this.number = 11;
        }else if (number.equals("Q") ){
            this.number = 12;
        }else if (number.equals("K")){
            this.number = 13;
        }else {
            this.number = Integer.parseInt(number);
        }
    }

    public PokerCard() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(PokerCard pokerCard) {
        return Integer.compare(number, pokerCard.getNumber());
    }
}
