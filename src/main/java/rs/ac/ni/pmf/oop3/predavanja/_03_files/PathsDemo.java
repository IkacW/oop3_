package rs.ac.ni.pmf.oop3.predavanja._03_files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsDemo
{
	public static void main(String[] args)
	{
		//		Path path = Paths.get("temp", "data", "numbers.txt");
		//
		//		System.out.println(path);
		//		System.out.println(path.toAbsolutePath());
		//		System.out.println(path.getFileName());
		//
		//		System.out.println("---------------------------------------");
		//
		//		final Path absolutePath = path.toAbsolutePath();
		//
		//		System.out.println(absolutePath.getRoot());
		//
		//		for (int i = 0; i < absolutePath.getNameCount(); i++)
		//		{
		//			System.out.println(absolutePath.getName(i));
		//		}

		//		System.out.println("---------------------------------------");
		//
		//		for (final File file : File.listRoots())
		//		{
		//			System.out.println(file);
		//		}

		//		final String homeDir = System.getProperty("user.home");
		//		final Path tempDir = Paths.get(homeDir, "temp");
		//
		//		System.out.println(tempDir);

//		Path path = Paths.get("temp", "data", "numbers.txt").toAbsolutePath();
//		System.out.println(path);
//		System.out.println(path.subpath(1, 2));

//		Path path1 = Paths.get("src", "main", "java").toAbsolutePath();
//		Path path2 = Paths.get("target", "java").toAbsolutePath();
//
//		System.out.println(path1);
//		System.out.println(path2);
//
//		System.out.println(path1.relativize(path2));

//		Path path = Paths.get("test", "..", "..", "data");
//		System.out.println(path);
//		System.out.println(path.normalize());
//		System.out.println(path.toAbsolutePath().normalize());

		Path path1 = Paths.get("brojevi.txt");
		Path path2 = Paths.get("letters.txt");

//		System.out.println(path1.toAbsolutePath());
//		System.out.println(path2.toAbsolutePath());

		try
		{
			System.out.println(path2.toRealPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			System.out.println(path1.toRealPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
