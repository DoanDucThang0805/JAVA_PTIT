public class INTERFACE002 {
    public static void main(String[] args) {
        TripleTacoBox tripleTacoBox = new TripleTacoBox();
        tripleTacoBox.eat();
        tripleTacoBox.eat();
        System.out.println("Triple taco boxes left: " + tripleTacoBox.tacoRemaining());
        CustomTacoBox customTacoBox = new CustomTacoBox(8);
        customTacoBox.eat();
        System.out.println("Custom taco boxes left: " + customTacoBox.tacoRemaining());
    }
}

interface TacoBox{
    public int tacoRemaining();
    public void eat();
}


class TripleTacoBox implements TacoBox{
    private int tacos;


    public TripleTacoBox(){
        this.tacos = 3;
    }


    public int getTacos() {
        return tacos;
    }


    @Override
    public int tacoRemaining() {
        return this.getTacos();
    }


    @Override
    public void eat() {
        this.tacos -= 1;
    }
}


class CustomTacoBox implements TacoBox{
    private int tacos;


    public CustomTacoBox(int initialTaco){
        this.tacos = initialTaco;
    }


    public int getTacos() {
        return tacos;
    }


    @Override
    public int tacoRemaining() {
        return this.getTacos();
    }


    @Override
    public void eat() {
        this.tacos -= 1;
    }
}
