package com.company;

class GenericCalculator <T1, T2>{
    private T1 type1;
    private T2 type2;

    GenericCalculator(T1 field1,T2 field2){
        this.type1=field1;
        this.type2=field2;

    }
    public String verify(T1 type1, T2 type2 ) {
        if(type1.getClass().toString().substring(16,type1.getClass().toString().length()).equals("Integer") && type2.getClass().toString().substring(16,type2.getClass().toString().length()).equals("Integer")){

            return String.valueOf(Integer.parseInt(type1.toString())/Integer.parseInt(type2.toString()));
        }
        else if (type1.getClass().toString().substring(16,type1.getClass().toString().length()).equals("String") && type2.getClass().toString().substring(16,type2.getClass().toString().length()).equals("String")){
            return type1.toString()+type2.toString();
        }
        else {
            System.out.println("Wrong Input.");
            return null;
        }
    }


//    public int veriyInteger(T1 type1, T2 type2){
//
//    }



}
