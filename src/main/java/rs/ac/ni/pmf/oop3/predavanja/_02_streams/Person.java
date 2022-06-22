package rs.ac.ni.pmf.oop3.predavanja._02_streams;

import java.io.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Person implements Externalizable
{
	private int id;
	private String firstName;
	private String lastName;
	private String email;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException
	{
		out.writeInt(id);
		out.writeUTF(firstName);
		out.writeUTF(lastName);
		out.writeUTF(email);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
	{
		id = in.readInt();
		firstName = in.readUTF();
		lastName = in.readUTF();
		email = in.readUTF();
	}
}
