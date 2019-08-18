package main.java;

public class Poker implements Comparable<Poker>{

    private int number;
    private String color;
    private int count;


    public Poker(String number, String color) {
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

    public Poker() {
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
    public int compareTo(Poker poker) {
        return Integer.compare(number, poker.getNumber());
    }
}
