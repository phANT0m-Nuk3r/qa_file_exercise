package starter;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class FileUtils {

    public static String lastLineInFile(@NotNull String inputFile) throws IOException {
        return "";
    }

    // This method should create a new file (outputFile) and copy the
    // input file (inputFile) to this new file, but convert the
    // content of the file to lower case.
    // If the original file exists it should be overwritten.
    public static void convertFileToLowerCase(@NotNull String inputFile,
                                              @NotNull String outputFile) throws IOException {

    }

    // This method should create a new file (outputFile) and copy the
    // input file (inputFile) to this new file,
    // but convert the content to upper case.

    public static void convertFileToUpperCase(@NotNull String inputFile,
                                              @NotNull String outputFile) throws IOException {

    }

    // This method should return an integer representing the number
    // of lines that start with the specified String (in the parameter match).
    // The file to be searched is the input file.
    // The search should be case sensitive.
    public static int linesThatStartWith(@NotNull String inputFile,
                                         @NotNull String match) throws IOException {

        return 0;
    }

    // This method should return an integer representing the number
    // of lines that start with the specified String (in the parameter match).
    // The file to be searched is the input file.
    // The search should ignore case.
    public static int linesThatStartWithCaseInsensitive(@NotNull String inputFile,
                                                        @NotNull String match) throws IOException {

        return 0;
    }

    // This method should return an integer representing the number of lines
    // that contain the specified String (in the parameter match).
    // The file to be searched is the input file.
    // The search should ignore case.
    public static int linesThatContainCaseInsensitive(@NotNull String inputFile,
                                                      @NotNull String match) throws IOException {

        return 0;
    }
}
