package Assignment2;

public class DuplicateRecordException extends Exception
{
    private Object object;

    public DuplicateRecordException()
    {
        super("Duplicate exception thrown!");
    }

    public DuplicateRecordException(String message)
    {
        super(message);
    }

    // a duplicate record be detected, an object from class will be thrown
    public DuplicateRecordException(Object object)
    {
        super("Duplicate exception thrown!");
        this.object = object;
    }

    public Object getObject()
    {
        return object;
    }
}
