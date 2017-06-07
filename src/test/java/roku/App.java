package roku;

/**
 * Created by anilaselwyn on 1/31/17.
 */
public class App {

    public static void main (String[] args){
        String info = "";

        info += "My name is Bob. ";
        info += " ";
        info += "I'm a builder. ";

        System.out.println(info);

        StringBuilder sb = new StringBuilder(" ");

        sb.append("My name is Sue.");
        sb.append(" ");
        sb.append("I'm a lion tamer.");

        System.out.println(sb.toString());


        StringBuilder s = new StringBuilder();
        s.append("My name is Roger.")
                .append(" ")
                .append("I'm a SkyDiver");

        System.out.println(s.toString());

        System.out.print("Here is some text. \tThat was a tab. \nThat's a new line");
        System.out.println(" More Text");
        System.out.printf("Total cost of %d, quantity is %d", 5, 120);


    }
}
