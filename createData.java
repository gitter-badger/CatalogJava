import java.io.File;
import java.io.FilenameFilter;

public class CreateData {

    private   String downloads        = "";
    protected String[] files;
    protected String path;
    private   String[] archives       = new String[] {".gzip", ".zip", ".rar", ".tar.gz", ".7z", ".tgz", ".tar.xz"};
    private   String[] music          = new String[] {".mp3", ".waw"};
    private   String[] android        = new String[] {".apk"};
    private   String[] web            = new String[] {".php", ".js", ".html", ".phtml", ".htm", ".json"};
    private   String[] images         = new String[] {".ico", ".jpg", ".png"};

    CreateData (String pathDownload) {
        this.downloads = pathDownload;
    }

    private void moveFile (final String[] nameType, String path) {
        File folder = new File(this.downloads);
        this.files = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File folder, String name) {
                for (String format : nameType) if (name.endsWith(format)) return true;
                return false;
            }
        });

        if (files.length != 0) {
            for ( String fileName : this.files) {
                File oldFile    = new File(this.downloads + fileName);
                File newFile    = new File(path + fileName);
                if (!newFile.exists()) System.out.println("Путь " + newFile.getPath() + " не существует");

                if (oldFile.renameTo(newFile)) {
                    System.out.print("Move file: " + fileName + "\n");
                } else System.out.print("Error: " + newFile.getPath() +"\n");
            }
        } System.out.println("Файлов с вашим расширением больше нет");

    }

    protected void createData (int param) {

        switch (param) {
            case 1:
                path = "/home/jashka/Загрузки/Archive/";
                this.moveFile(archives, path);
                break;
            case 2:
                path = "/home/jashka/Загрузки/Music/";
                this.moveFile(music, path);
                break;
            case 3:
                path = "/home/jashka/Загрузки/Android/";
                this.moveFile(android, path);
                break;
            case 4:
                path = "/home/jashka/Загрузки/Web/";
                this.moveFile(web, path);
                break;
            case 5:
                path = "/home/jashka/Загрузки/Images/";
                this.moveFile(images, path);
                break;
            default:
                System.out.println("Неправильный ввод: " + param);
                break;
        }

    }

}
