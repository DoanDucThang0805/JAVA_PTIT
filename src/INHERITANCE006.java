public class INHERITANCE006 {
    public static void main(String[] args) {
        Fish fish = new Fish(0);
        fish.play();
        fish.walk();
        Cat cat = new Cat(4);
        cat.setName("Fluffy");
        cat.play();
        cat.eat();
        Spider spider = new Spider(8);
        spider.eat();
        cat.walk();
        System.out.println();
        spider.walk();

    }
}


abstract class Animal{
    public int legs;


    public Animal(int legs){
        this.legs = legs;
    }


    public abstract void eat();


    public void walk(){
        System.out.print("This animal walks on " + this.legs + " legs.");
    }
}


interface Pet{
    public String getName();

    public void setName(String name);

    public void play();
}


class Spider extends Animal{
    public Spider(int legs){
        super(legs);
    }


    @Override
    public void eat(){
        System.out.println("The spider eats a fly.");
    }


    @Override
    public void walk(){
        super.walk();
    }
}


class Fish extends Animal implements Pet{
    private String name;


    public Fish(int legs){
        super(legs);
    }


    @Override
    public void setName(String name){
        this.name = name;
    }


    @Override
    public String getName(){
        return name;
    }


    @Override
    public void play(){
        System.out.println("Fish swim in their tanks all day.");
    }


    @Override
    public void walk(){
        super.walk();
        System.out.println();
        System.out.println("Fish, of course, can't walk; they swim.");
    }


    @Override
    public void eat(){
        System.out.println("Fish eat pond scum.");
    }
}


class Cat extends Animal implements Pet{
    private String name;


    public Cat(int legs){
        super(legs);
    }


    @Override
    public void setName(String name){
        this.name = name;
    }


    @Override
    public String getName(){
        return this.name;
    }


    @Override
    public void play(){
        System.out.println(this.name + " likes to play with string.");
    }


    @Override
    public void eat(){
        System.out.println("Cats like to eat spiders and mice.");
    }
}