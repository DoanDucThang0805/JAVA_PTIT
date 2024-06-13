import java.util.ArrayList;
import java.util.Scanner;


public class INHERITANCE007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number_question = sc.nextInt();
        System.out.println(number_question);
        sc.nextLine();
        for(int ques = 0; ques < number_question; ques++){
            String question_type = sc.nextLine();
            System.out.println(question_type);
            if(question_type.equals("m")){
                int choices_numbers = sc.nextInt();
                sc.nextLine();
                String question = sc.nextLine();
                MultiChoice multiChoice = new MultiChoice(choices_numbers);
                multiChoice.readQuestion(question);
                for(int num = 0; num < choices_numbers; num++){
                    String choice = sc.nextLine();
                    multiChoice.choices.add(choice);
                }
                System.out.println(multiChoice);
            }else{
                int line = sc.nextInt();
                sc.nextLine();
                Essay essay = new Essay(line);
                String question = sc.nextLine();
                essay.readQuestion(question);
                System.out.println(essay);
            }
        }
        sc.close();
    }
}


abstract class TestQuestion{
    protected String question;

    protected abstract void readQuestion(String question);
}


class Essay extends TestQuestion{
    int line;


    public Essay(int line){
        this.line = line;
    }


    @Override
    protected void readQuestion(String question){
        this.question = question;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.line);
        sb.append("\n");
        sb.append(this.question);
        return sb.toString();
    }
}


class MultiChoice extends TestQuestion{
    int choices_numbers;
    ArrayList<String> choices = new ArrayList<>();


    public MultiChoice(int choices_numbers){
        this.choices_numbers = choices_numbers;
    }


    @Override
    protected void readQuestion(String question){
        this.question = question;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(choices_numbers);
        sb.append("\n");
        sb.append(question);
        for(String choice : choices){
            sb.append("\n");
            sb.append(choice);
        }
        return sb.toString();
    }
}