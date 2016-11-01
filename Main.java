package Dos;

public class Main {

    public static void main(String[] args) {

        Option.readContents();
        Option.showOptions();
        Option.getOption();

        ICMP_Flood.attack();

    }
}