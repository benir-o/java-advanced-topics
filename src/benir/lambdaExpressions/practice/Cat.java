package benir.lambdaExpressions.practice;

public class Cat implements CatSound{
    @Override
    public void makeSound(String s){
        System.out.println("Meow"+s);
    }
    //This method takes in an object that implements the CatSound interface
    //Instead of having to create a class and implement the method, we could call a function anonymously
    //This is how the use of lambda expressions comes into play
    //
    public static void printable(CatSound ofCat){
        ofCat.makeSound("!");
    }
}
