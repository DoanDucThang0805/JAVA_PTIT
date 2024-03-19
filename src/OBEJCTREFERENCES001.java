import java.util.Scanner;

public class OBEJCTREFERENCES001 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        for(int t = 0; t < testcase; t++){
            String [] Song1Info = sc.nextLine().split(" ", 3);
            String [] Song2Info = sc.nextLine().split(" ", 3);
            int s12 = Integer.parseInt(Song1Info[2]);
            int s22 = Integer.parseInt(Song2Info[2]);
            Song song1 = new Song(Song1Info[0], Song1Info[1], s12);
            Song song2 = new Song(Song2Info[0], Song2Info[1], s22);
            if(song1.equal(song2)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}

class Song {
    private final String name;
    private final String author;
    private final int duration;

    public Song(String name, String author, int duration) {
        this.name = name;
        this.author = author;
        this.duration = duration;
    }

    public boolean equal (Song other) {
        return this.name.equals(other.name) && this.author.equals(other.author) && this.duration == other.duration;
    }
}
