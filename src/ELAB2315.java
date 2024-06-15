import java.util.ArrayList;
import java.util.Scanner;


public class ELAB2315 {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<Account> accounts = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String name_account = sc.nextLine();
                Account account = new Account(name_account);
                accounts.add(account);
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String [] inputs = line.split(" ", 4);
                if(inputs[1].equals("Add")){
                    int id = Integer.parseInt(inputs[0]);
                    String date = inputs[2];
                    String content = inputs[3];
                    Note note = new Note(content, date);
                    accounts.get(id - 1).addNote(note);
                }else if(inputs[1].equals("share")){
                    int id_master = Integer.parseInt(inputs[0]);
                    id_master--;
                    int id_slave = Integer.parseInt(inputs[2]);
                    id_slave--;
                    int id_note = Integer.parseInt(inputs[3]);
                    id_note--;
                    accounts.get(id_master).shareNote(accounts.get(id_slave), accounts.get(id_master).list_note.get(id_note));
                }else{
                    throw new Exception();
                }
            }
            for(Account account : accounts){
                System.out.println("Account: " + account.name_account);
                for(Note note : account.list_note){
                    System.out.println(note.toString());
                }

            }
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }
}


class Account{
    String name_account;
    ArrayList<Note> list_note;


    public Account(String name_account){
        this.name_account = name_account;
        list_note = new ArrayList<>();
    }


    public void addNote(Note note){
        this.list_note.add(note);
    }


    public void shareNote(Account other_account, Note note){
        other_account.addNote(note);
    }
}


class Note{
    String content;
    String date;


    public Note(String content, String date){
        this.content = content;
        this.date = date;
    }


    public String note_output(String date){
        String month = date.substring(0, 3);
        String day = date.substring(3, 5);
        String year = date.substring(5);
        return day + " " + month + " " +year;
    }

    @Override
    public String toString(){
        return note_output(this.date) + " | " + this.content;
    }
}