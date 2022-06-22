package rs.ac.ni.pmf.oop3.vezbe.vezba06;

public abstract class Message
{
	public String recipient;
	public abstract void sendMessage();

	public static void main(String[] args)
	{
		Message m = new TextMessage();
		m.recipient = "12345";
		m.sendMessage();
	}

	static class TextMessage extends Message
	{
		@Override
		public final void sendMessage()
		{
			System.out.println("Text message to " + recipient);
		}
	}
}
