package Assignment2.Exception;

import java.io.File;
import java.io.IOException;

public class InvalidFileException extends IOException
{
    private File file;

    public InvalidFileException()
    {
        super("Error: Input file cannot be found.");
    }

    public InvalidFileException(String message)
    {
        super(message);
    }

    public InvalidFileException(File file)
    {
        super(String.format("Error: Input file named %s cannot be found", file.getName()));
        this.file = file;
    }

    public File getFile()
    {
        return file;
    }

}
