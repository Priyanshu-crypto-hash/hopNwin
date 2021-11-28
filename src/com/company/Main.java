package com.company;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
//        GenericCalculator<String,String> a = new GenericCalculator<String,String>("a","b");
//        System.out.println( a.verify("Priyanshu","kumar"));
//        a.printer();
        Scanner scn = new Scanner(System.in);
        Random ra = new Random();

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
                    throw new InputMismatchException();
                }
            }
            catch(InputMismatchException e){
                System.out.println("Wrong Input.\nHit Enter to initialize the game");
            }
        }
        GameClass g = new GameClass();
        System.out.println(g.getP().hop());
//        System.out.println(g.getTiles().size());
        System.out.println("Game is ready");
        for(int i=0;i<5;i++){
            g.format();
            int r = g.getP().hop();

            if ((r+1)>19){
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
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
                String sp = scn.nextLine();
                while(!flag){
                    try{

                        if (sp.toLowerCase().equals("integer") || sp.toLowerCase().equals("string")){
                            flag=true;
                        }
                        else {
                            throw new InputMismatchException();
                        }
                    }
                    catch(InputMismatchException e){
                        System.out.println("Wrong Input.\nQuestion answer round. Integer or string?");
                    }
                }
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
                    Boolean a = g.verifyInteger();
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

        }
        g.endGame();

    }
}
