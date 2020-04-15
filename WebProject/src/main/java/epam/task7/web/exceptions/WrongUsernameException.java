package epam.task7.web.exceptions;

public class WrongUsernameException extends Exception
{
    public WrongUsernameException()
    {
        super();
    }

    public WrongUsernameException(String message)
    {
        super(message);
    }

    public WrongUsernameException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public WrongUsernameException(Throwable cause)
    {
        super(cause);
    }

    protected WrongUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
