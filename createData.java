import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CreateData {

    private   String downloads        = "";
    private   String [] files;
    private   String path;
    private   JSONObject jsonObject    = null;
    private   String [] archive        = new String [] {".iso", ".gzip", ".zip", ".rar", ".tar.gz", ".7z", ".tgz", ".tar.xz", ".gz", ".jar", ".JAR"};
    private   String [] music          = new String [] {".mp3", ".waw"};
    private   String [] android        = new String [] {".apk"};
    private   String [] deb            = new String [] {".deb"};
    private   String [] exe            = new String [] {".exe", ".dll"};
    private   String [] web            = new String [] {".php", ".js", ".html", ".css", ".phtml", ".htm", ".json"};
    private   String [] desktop        = new String [] {".cpp", ".c", ".java", ".class", ".py"};
    private   String [] image          = new String [] {".ico", ".jpg", ".png"};
    private   String [] office         = new String [] {".txt", ".doc", ".docx", ".pdf", ".md", ".xls", ".djvu"};
    private   String [] torrent        = new String [] {".torrent"};

    private String archives;
    private String musics;
    private String androids;
    private String webs;
    private String images;
    private String offices;
    private String debs;
    private String exes;
    private String desktops;
    private String torrents;

    CreateData () throws  IOException {
        initJson();
    }

    private void initJson () throws IOException {

        try {
            JSONParser jsonParser = new JSONParser();
            File files = new File("/home/jashka/IdeaProjects/Catalog/src/settings.json");
            Object object = jsonParser.parse(new FileReader(files));
            jsonObject = (JSONObject) object;

            JSONArray jsonArchives      = (JSONArray) jsonObject.get("archives");
            JSONObject pathFolder       = (JSONObject) jsonObject.get("pathFolder");

            downloads       = (String) jsonObject.get("pathDownloads");
            archives        = (String) pathFolder.get("archive");
            musics          = (String) pathFolder.get("music");
            androids        = (String) pathFolder.get("android");
            webs            = (String) pathFolder.get("web");
            images          = (String) pathFolder.get("image");
            offices         = (String) pathFolder.get("office");
            debs            = (String) pathFolder.get("deb");
            desktops        = (String) pathFolder.get("desktop");
            exes            = (String) pathFolder.get("exe");
            torrents        = (String) pathFolder.get("torrent");

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }

    private void moveFile (final String[] nameType, String path) throws IOException {

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

                if (oldFile.renameTo(newFile)) {
                    System.out.print("Move file: " + fileName + "\n");
                } else System.out.print("Error: " + newFile.getPath() +"\n");
            }
        } System.out.println("Файлов с вашим расширением больше нет");

    }

    protected void createData (int param) throws IOException{

        switch (param) {
            case 1 :
                path = archives;
                this.moveFile(archive, path);
                break;
            case 2 :
                path = musics;
                this.moveFile(music, path);
                break;
            case 3 :
                path = androids;
                this.moveFile(android, path);
                break;
            case 4 :
                path = webs;
                this.moveFile(web, path);
                break;
            case 5 :
                path = images;
                this.moveFile(image, path);
                break;
            case 6 :
                path = offices;
                this.moveFile(office, path);
                break;
            case 7 :
                path = exes;
                this.moveFile(exe, path);
                break;
            case 8 :
                path = debs;
                this.moveFile(deb, path);
                break;
            case 9 :
                path = desktops;
                this.moveFile(desktop, path);
                break;
            case 10 :
                path = torrents;
                this.moveFile(torrent, path);
                break;
            default:
                System.out.println("Неправильный ввод: " + param);
                break;
        }

    }

}
