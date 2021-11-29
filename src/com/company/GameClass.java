package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


class GameClass {

    private Player p;
    private ArrayList<Tile> tiles = new ArrayList<>();
    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    public Player getP() {
        return p;
    }
    Scanner scn = new Scanner(System.in);
    GameClass(){
        Scanner scn = new Scanner(System.in);
        this.p=new Player();
        for(int i =0;i<20;i++){
            tiles.add(new Tile());
        }
        tiles.get(0).getT().setName("Goku");
        tiles.get(1).getT().setName("Donald Duck");
        tiles.get(2).getT().setName("Tom");
        tiles.get(3).getT().setName("Mickey Mouse");
        tiles.get(4).getT().setName("Jerry");
        tiles.get(5).getT().setName("Doraemon");
        tiles.get(6).getT().setName("Nobita");
        tiles.get(7).getT().setName("Vegeta");
        tiles.get(8).getT().setName("Mogli");
        tiles.get(9).getT().setName("Cat");
        tiles.get(10).getT().setName("Dog");
        tiles.get(11).getT().setName("Cinderella");
        tiles.get(12).getT().setName("Ninja Hatori");
        tiles.get(13).getT().setName("Naruto");
        tiles.get(14).getT().setName("Sasuke Uchiha");
        tiles.get(15).getT().setName("Itachi Uchiha");
        tiles.get(16).getT().setName("Sakura");
        tiles.get(17).getT().setName("Kakashi");
        tiles.get(18).getT().setName("Madara Uchiha");
        tiles.get(19).getT().setName("Eren Yeager");
    }
    public void format(){
        boolean flag2 = false;
        while(!flag2){
            if (p.getChancesLeft()==5){
            System.out.println("Hit Enter for your first hop");

        }
        else if (p.getChancesLeft()==4){
            System.out.println("Hit Enter for your second hop");

        }
        else if (p.getChancesLeft()==3){
            System.out.println("Hit Enter for your third hop");

        }
        else if(p.getChancesLeft()==2){
            System.out.println("Hit Enter for your fourth hop");

        }
        else if (p.getChancesLeft()==1){
            System.out.println("Hit Enter for your fifth hop");

        }
        else {
            System.out.println("No chances left");

        }
            try{
                String space = scn.nextLine();
                if(space.equals("")){
                    flag2=true;
                }
                else {
                    throw new NoEnterException("Wrong Input.");

                }

            }
            catch(NoEnterException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public  String getString(int n)
    {
        String alphabeticString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(alphabeticString.length() * Math.random());
            sb.append(alphabeticString.charAt(index));
        }
        return sb.toString();
    }
    public static int getRandomNumber(final int digCount, Random rnd){
        final char[] ch = new char[digCount];
        for(int i = 0; i < digCount; i++){
            ch[i] =
                    (char) ('0' + (i == 0 ? rnd.nextInt(9) + 1 : rnd.nextInt(10)));
        }
        return  Integer.parseInt(new BigInteger(new String(ch)).toString());
    }

    public Boolean verifyInteger(){

        Random r = new Random();
        int n1 = getRandomNumber(4,r);
        int n2 = getRandomNumber(3,r);

        System.out.println("Calculate the result of "+n1+" divided by "+n2);


        boolean f = false;
        while(!f){
            try{
                int b= scn.nextInt();
                String i = scn.nextLine();
                f=true;
                GenericCalculator<Integer,Integer> obj = new GenericCalculator<Integer,Integer>(n1,n2);
                if(b==Integer.parseInt(obj.verify(n1,n2))){
                    System.out.println("Correct answer");
                    return true;
                }
                else {
                    System.out.println("Incorrect answer");
                    System.out.println("The answer is : "+ obj.verify(n1,n2));
                    return false;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Only Integers are allowed");
                System.out.println("Calculate the result of "+n1+" divided by "+n2);

                scn.next();
            }
        }
        return false;
    }
    public Boolean verifyString(){

        String s1 = getString(4);
        String s2 = getString(4);
        System.out.println("Calculate the concatenation of strings "+s1+" and "+s2);
        String s = scn.nextLine();
        GenericCalculator<String,String> obj = new GenericCalculator<String,String>(s1,s2);
        if(s.equals(obj.verify(s1,s2))){
            System.out.println("Correct answer");
            return true;
        }
        else {
            System.out.println("Incorrect answer");
            return false;
        }
    }
    public void endGame(){
        System.out.println("Game Over");
        System.out.println("Soft toys won by you are: ");
        for(int i =0;i<p.getBucket().size();i++){
            System.out.print(p.getBucket().get(i).getName());
            if(i<p.getBucket().size()-1){
                System.out.print(", ");
            }
        }
    }


}
