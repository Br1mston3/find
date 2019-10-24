package finder;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class CommandLineArgument {

    public boolean isKeySubDir() {
        return keySubDir;
    }

    public String getKeyDir() {
        return keyDir;
    }

    public String getName() {
        return name;
    }

    @Option(name = "-r", usage = "subdirectory search required")
    private boolean keySubDir;

    @Option(name = "-d", usage = "search in that directory ")
    private String keyDir;

    @Argument()
    private String name;

    public CommandLineArgument(String[] args) throws CmdLineException {
        CmdLineParser parser = new CmdLineParser(this);
        parser.parseArgument(args);
    }
}


