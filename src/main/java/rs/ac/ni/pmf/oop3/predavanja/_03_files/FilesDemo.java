package rs.ac.ni.pmf.oop3.predavanja._03_files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FilesDemo
{
	public static void main(String[] args) throws IOException
	{
		final Path filePath = Paths.get("letters.txt");
		final Path secondPath = Paths.get("temp", "..", "letters.txt");
		final Path dirPath = Paths.get("src", "main");
		final Path badFilePath = Paths.get("temp", "letters.txt");

//		if (Files.exists(filePath))
//		{
//			System.out.println("File " + filePath + " exists");
//		}
//
//		if (Files.notExists(badFilePath))
//		{
//			System.out.println("File " + badFilePath + " does not exist");
//		}
//
//		System.out.println(Files.isRegularFile(filePath));
//		System.out.println(Files.isRegularFile(dirPath));
//
//		System.out.println(Files.isDirectory(filePath));
//		System.out.println(Files.isDirectory(dirPath));
//
//		System.out.println(Files.isSameFile(filePath, dirPath));
//		System.out.println(Files.isSameFile(filePath, secondPath));

//		Path fileCopy = Paths.get("letters-copy.txt");
//
//		System.out.println("Copying file...");
//		Files.copy(filePath, fileCopy, StandardCopyOption.REPLACE_EXISTING);
//		System.out.println("File copied. Deleting it now...");
//		Files.delete(fileCopy);
//		System.out.println("File deleted");

		String tempDir = System.getProperty("user.home");
		Path tempPath = Files.createTempFile(Paths.get(tempDir), "temp_file_", ".tmp");
		System.out.println(tempPath);
		tempPath.toFile().deleteOnExit();

		try (BufferedWriter out = Files.newBufferedWriter(tempPath, StandardCharsets.UTF_8))
		{
			out.write("Temporary file content.");
			out.newLine();
		}

		List<String> lines = Files.readAllLines(tempPath, StandardCharsets.UTF_8);

		for (String line : lines)
		{
			System.out.println(line);
		}
	}
}
