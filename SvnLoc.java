import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.*;

class SvnLoc {

    public static void main(String[] args) throws Exception {
        var svn = new ProcessBuilder()
                .command(List.of("svn", "info", "--show-item", "relative-url"))
                .redirectErrorStream(true)
                .start();
        String relativeUrl;
        try (var bs = new BufferedReader(new InputStreamReader(svn.getInputStream()))) {
            relativeUrl = bs.lines().collect(joining(System.lineSeparator()));
        }

        var exitCode = svn.waitFor();
        if (exitCode == 0) {
            String output;
            var parts = relativeUrl.split("/");
            if (parts.length > 2 && "branches".equals(parts[1])) {
                output = parts[2];
            } else {
                output = parts[1];
            }
            System.out.println(" \u001B[38;05;81m(" + output + ")\u001B[0m");
        }
    }

}
