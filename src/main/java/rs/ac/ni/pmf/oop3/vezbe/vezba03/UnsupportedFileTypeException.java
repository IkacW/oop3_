package rs.ac.ni.pmf.oop3.vezbe.vezba03;

public class UnsupportedFileTypeException extends Exception
{
	public UnsupportedFileTypeException()
	{
		super("There is not file type defined");
	}

	public UnsupportedFileTypeException(final String fileType)
	{
		super("File type '" + fileType + "' is not allowed");
	}
}
