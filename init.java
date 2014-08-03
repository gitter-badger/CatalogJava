import java.io.IOException;
import java.util.Scanner;

public  class init  {

    public static void main (String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        CreateData data = new CreateData();

        System.out.println("1. Archive type \t(.iso, .gzip, .zip, .rar, .tar.gz, .7z, .tgz)");
        System.out.println("2. Music type \t\t(.mp3, .wav)");
        System.out.println("3. Android type \t(.apk)");
        System.out.println("4. Web type \t\t(.php, .js, .css .html, .htm, .phtml, .json)");
        System.out.println("5. Images type \t\t(.ico, .jpg, .png)");
        System.out.println("6. Office type\t\t(.doc, .docx, .txt, .djvu, .xls)");
        System.out.println("7. Exe type\t\t(.exe, .dll)");
        System.out.println("8. Deb type\t\t(.deb)");
        System.out.println("9. DevDesktop type\t(.cpp, .c, .java, .class, .py)");
        System.out.println("10.Torrent type\t\t(.torrent)");
        System.out.print("\nEnter the number: ");

        int s = scan.nextInt();
        data.createData(s);

    }

}
