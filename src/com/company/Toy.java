package com.company;

class Toy implements Cloneable{
   private  String name;
   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }

   @Override
   public Toy clone(){
      try {
         Toy copy = (Toy) super.clone();
         return copy;
      }
      catch(CloneNotSupportedException e){
         return null;
      }
   }

}
