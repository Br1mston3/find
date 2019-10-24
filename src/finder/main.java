package finder;

import org.kohsuke.args4j.CmdLineException;

import java.io.File;


class main {


    public static void main(String[] args) throws CmdLineException {
        CommandLineArgument values = new CommandLineArgument(args);
        System.out.println("Enter a line: find [-r] [-d directory] filename.txt");
        System.out.println(fileSearch(values.getName(), values.getKeyDir(), values.isKeySubDir()));
    }

    public static String fileSearch(String name, String dir, boolean subDir) {
        String path = "404 File not found";
        if (name == null || dir == null) return path;
        File wantedDir = new File(dir);
        File[] list = wantedDir.listFiles();
        if (list == null) return path;
        if (subDir) {
            for (File f : list) {
                if (f.isFile() && f.getName().equals(name)) {
                    path = f.getPath();
                    break;
                }
                if (f.isDirectory()) {
                    path = fileSearch(name, dir + "/" + f.getName(), true);
                    if (!path.equals("404 File not found")) break;
                }
            }
        } else {
            File[] listOfFiles = wantedDir.listFiles(file -> file.getName().equals(name));
            if (listOfFiles == null) return path;
            for (File t : listOfFiles) {
                path = t.getPath();
            }

        }
        return path;
    }
}

