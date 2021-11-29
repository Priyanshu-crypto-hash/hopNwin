package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        GenericCalculator<String,String> a = new GenericCalculator<String,String>("a","b");
//        System.out.println( a.verify("Priyanshu","kumar"));
//        a.printer();
        Scanner scn = new Scanner(System.in);
//        Random ra = new Random();

//        System.out.println(getRandomNumber(4,ra));
//        getRandomString();
        System.out.println("Hit enter to initialize the game");
        boolean flag = false;
        while(!flag){
            try{
                String sp = scn.nextLine();
                if (sp.equals("")){
                    flag=true;
                }
                else {
                    throw new NoEnterException("Wrong Input.\nHit Enter to initialize the game");
                }
            }
            catch(NoEnterException e){
                System.out.println(e.getMessage());
            }
        }
        GameClass g = new GameClass();
//        System.out.println(g.getP().hop());
//        System.out.println(g.getTiles().size());
        System.out.println("Game is ready");
        for(int i=0;i<5;i++){
            g.format();
            int r = g.getP().hop();

            if ((r+1)>20){
                try{
                    throw new OutOfTileCarpetException("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
                }
                catch(OutOfTileCarpetException e){
                    System.out.println(e.getMessage());
                }
//                System.out.println("You landed on tile "+(r+1));
                g.getP().setChancesLeft(g.getP().getChancesLeft()-1);
            }
            else if ((r+1)%2==0){
                System.out.println("You landed on tile "+(r+1));


                g.getP().setBucket(g.getTiles().get(r).getT().clone());
                g.getP().setChancesLeft(g.getP().getChancesLeft()-1);
                System.out.println("You won a "+g.getTiles().get(r).getT().getName()+" soft toy");
            }
            else if ((r+1)%2==1){
                System.out.println("You landed on tile "+(r+1));
                boolean flag1 = false;
                System.out.println("Question answer round. Integer or string?");

                while(!flag1){
                    try{
                        String sp = scn.nextLine();
                        if (sp.toLowerCase().equals("integer") || sp.toLowerCase().equals("string")){
                            flag1=true;
                            if(sp.toLowerCase().equals("integer")){
                                Boolean a = g.verifyInteger();
                                if(a){
                                    g.getP().setBucket(g.getTiles().get(r).getT().clone());
                                    System.out.println("You won a "+g.getTiles().get(r).getT().getName()+" soft toy");
                                }
                                else {
                                    System.out.println("You did not win any soft toy");

                                }
                            }
                            else if (sp.toLowerCase().equals("string")){
                                Boolean a = g.verifyString();
                                if(a){
                                    g.getP().setBucket(g.getTiles().get(r).getT().clone());
                                    System.out.println("You won a "+g.getTiles().get(r).getT().getName()+" soft toy");
                                }
                                else {
                                    System.out.println("You did not win any soft toy");

                                }
                            }

                            g.getP().setChancesLeft(g.getP().getChancesLeft()-1);
                        }
                        else {
                            throw new WrongInputException("Wrong Input.\nQuestion answer round. Integer or string?");
                        }
                    }
                    catch(WrongInputException e){
                        System.out.println(e.getMessage());
                    }
                }

            }

        }
        g.endGame();

    }
}
