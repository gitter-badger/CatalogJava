import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class CreateData {

    private   String downloads        = "";
    private   String [] files;
    private   String path;
    private   JSONObject jsonObject    = null;

    private ArrayList<String> archive           = new ArrayList<String>();
    private ArrayList<String> music             = new ArrayList<String>();
    private ArrayList<String> android           = new ArrayList<String>();
    private ArrayList<String> deb               = new ArrayList<String>();
    private ArrayList<String> exe               = new ArrayList<String>();
    private ArrayList<String> web               = new ArrayList<String>();
    private ArrayList<String> desktop           = new ArrayList<String>();
    private ArrayList<String> image             = new ArrayList<String>();
    private ArrayList<String> office            = new ArrayList<String>();
    private ArrayList<String> torrent           = new ArrayList<String>();

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

            JSONArray jsonArchive       = (JSONArray) jsonObject.get("archives");
            JSONArray jsonMusic         = (JSONArray) jsonObject.get("musics");
            JSONArray jsonAndroid       = (JSONArray) jsonObject.get("androids");
            JSONArray jsonWeb           = (JSONArray) jsonObject.get("webs");
            JSONArray jsonImages        = (JSONArray) jsonObject.get("images");
            JSONArray jsonDeb           = (JSONArray) jsonObject.get("debs");
            JSONArray jsonExe           = (JSONArray) jsonObject.get("exes");
            JSONArray jsonDesktop       = (JSONArray) jsonObject.get("desktops");
            JSONArray jsonOffice        = (JSONArray) jsonObject.get("offices");
            JSONArray jsonTorrent       = (JSONArray) jsonObject.get("torrents");

            JSONObject pathFolder       = (JSONObject) jsonObject.get("pathFolder");

            int i;
            for (i = 0; i < jsonArchive.size(); i++) {
                archive.add((String) jsonArchive.get(i));
            }
            for (i = 0; i < jsonMusic.size(); i++ ) {
                music.add((String) jsonMusic.get(i));
            }
            for (i = 0; i < jsonAndroid.size(); i++ ) {
                android.add((String) jsonAndroid.get(i));
            }
            for (i = 0; i < jsonWeb.size(); i++ ) {
                web.add((String) jsonWeb.get(i));
            }
            for (i = 0; i < jsonImages.size(); i++ ) {
                image.add((String) jsonImages.get(i));
            }
            for (i = 0; i < jsonDeb.size(); i++ ) {
                deb.add((String) jsonDeb.get(i));
            }
            for (i = 0; i < jsonExe.size(); i++ ) {
                exe.add((String) jsonExe.get(i));
            }
            for (i = 0; i < jsonDesktop.size(); i++) {
                desktop.add((String) jsonDesktop.get(i));
            }
            for (i = 0; i < jsonOffice.size(); i++) {
                office.add((String) jsonOffice.get(i));
            }
            for (i = 0; i < jsonTorrent.size(); i++) {
                torrent.add((String) jsonTorrent.get(i));
            }

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

    private void moveFile (final ArrayList<String> nameType, String path) throws IOException {
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
                    System.out.print("Move file: " + fileName + " to directory " + path + "\n");
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
