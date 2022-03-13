package Assignment2.Exception;

import java.io.File;
import java.io.IOException;

public class EmptyFolderException extends IOException
{
    private File file;

    public EmptyFolderException()
    {
        super("Error: Input file cannot be found.");
    }

    public EmptyFolderException(String message)
    {
        super(message);
    }

    public EmptyFolderException(File file)
    {
        super(String.format("Error: Input file named %s cannot be found", file.getName()));
        this.file = file;
    }

    public File getFile()
    {
        return file;
    }
}
