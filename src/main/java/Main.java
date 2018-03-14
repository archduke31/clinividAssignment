import com.assignment.clinivid.test.ProfileBuilder;
import org.json.JSONObject;
import java.util.Scanner;
public class Main {
    //Please install maven and download the dependency
    public static void main(String[] args) {
        //profile|73241232|<Aamir><Hussain><Khan>|<Mumbai><<72.872075><19.075606>>|73241232.jpg**followers|54543342|<Anil><><Kapoor>|<Delhi><<23.23><12.07>>|54543342.jpg@@|12311334|<Amit><><Bansal>|<Bangalore><<><>>|12311334.jpg
        //profile|73241234|<Niharika><><Khan>|<Mumbai><<72.872075><19.075606>>|73241234. jpg**followers|54543343|<Amitabh><><>|<Dehradun><<><>>|54543343.jpg@@|22112211 |<Piyush><><>||
        //profile|73241234|<Niharika><><Khan>|<Mumbai><<72.872075><19.075606>>|73241234. jpg
        //profile|73241234|<><><>|<><<><>>|
        //profile||<><><>|<><<><>>|**followers|54543343|<Amitabh><><>|<Dehradun><<><>>|54543343.jpg@@|22112211 |<Piyush><><>||
        //profile|id|<First Name><Middle Name><last Name>|<city Name><<Long><Lat>|image.jpg **followers |id|<First Name><Middle Name><last Name>
        //profile|73241232|<Aamir><Hussain><Khan>|<Mumbai><<72.872075><19.075606>>|73241232.jpg**followers|54543342|<Anil><><Kapoor>|<Delhi><<23.23><12.07>>|54543342.jpg@@|12311334|<Amit><><Bansal>|<Bangalore><<><>>|12311334.jpg@@|54543343|<Amitabh><><>|<Dehradun><<><>>|54543343.jpg@@|22112211 |<Piyush><><>||
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please provide input to convert to json");

        ProfileBuilder profileBuilder=new ProfileBuilder(scanner.nextLine());
        try{
            profileBuilder.parse();
        }catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException(e.getMessage()+"\nSorry, Couldn't process your input, Wrong input foramt maybe?If not please report bugs to shreyasb619@gmail.com ;)");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage()+"\nSorry, Couldn't process your input, Wrong input foramt maybe?If not please report bugs to shreyasb619@gmail.com ;)");
        }
        JSONObject jsonObj = new JSONObject( profileBuilder.getCompleteUserProfile() );
        System.out.print(jsonObj.toString(3));
    }
}
