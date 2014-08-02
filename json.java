import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public  class init  {

    protected void json () throws IOException{
        try {
        JSONParser jsonParser = new JSONParser();
        File files = new File("settings.json");

            Object object = jsonParser.parse(new FileReader(files));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }

    public static void main (String[] args) throws IOException {


        /*Scanner scan = new Scanner(System.in);

        System.out.print("Enter the path folder Downloads: ");
        String pathDownload = scan.nextLine();

        CreateData data = new CreateData(pathDownload);

        System.out.println("1. Archive type \t(.gzip, .zip, .rar, .tar.gz, .7z, .tgz)");
        System.out.println("2. Music type \t\t(.mp3, .waw)");
        System.out.println("3. Android type \t(.apk)");
        System.out.println("4. Web type \t\t(.php, .js, .html, .htm, .phtml, .json)");
        System.out.println("5. Images type \t\t(.ico, .jpg, .png)");
        System.out.print("\nEnter the number: ");

        int s = scan.nextInt();

        data.createData(s);*/

    }

}
