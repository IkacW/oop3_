package rs.ac.ni.pmf.oop3.vezbe.vezba03;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileDownloader
{
	private static final int MAX_BUFFER_SIZE = 128 * 1024;

	private final Set<String> allowedFileTypes = Set.of("pdf", "txt", "doc", "docx");

	public List<String> readLines(final String filePath) throws IOException
	{
		Path path = Paths.get(filePath);
		boolean found = true;

		if (!Files.exists(path))
		{
			path = path.getFileName();
			log.debug("File not found using given path, checking current dir for file {}", path);
			if (!Files.exists(path))
			{
				log.debug("File not found in current dir, checking within resources");
				found = false;
			}
		}

		final InputStream inputStream =
			found ? new FileInputStream(path.toFile()) : FileDownloader.class.getResourceAsStream(filePath);

		if (inputStream == null)
		{
			throw new FileNotFoundException("File " + filePath + " cannot be found");
		}

		final List<String> result = new ArrayList<>();

		try (final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
		{
			String line;

			while ((line = reader.readLine()) != null)
			{
				if (!"".equals(line.trim()))
				{
					result.add(line.trim());
				}
			}
		}

		inputStream.close();

		return result;
	}

	public Optional<URL> getLink(final String entry)
	{
		try
		{
			final URL url = new URL(entry);
			return Optional.of(url);
		}
		catch (MalformedURLException e)
		{
			log.debug("Entry '{}' is not a valid URL, ignoring it", entry);
		}

		return Optional.empty();
	}

	public List<URL> getLinks(List<String> entries)
	{
		return entries.stream()
			.map(this::getLink)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.toList());

/*		final List<URL> links = new ArrayList<>();

		for (final String entry : entries)
		{
			final Optional<URL> optionalURL = getLink(entry);

			if (optionalURL.isPresent())
			{
				links.add(optionalURL.get());
			}
		}

		return links;
 */
	}

	public String checkFileType(final URL url) throws UnsupportedFileTypeException
	{
		final Path path = Paths.get(url.getFile());
		final String filename = path.getFileName().toString();

		final int dotPosition = filename.lastIndexOf('.');
		if (dotPosition == -1)
		{
			throw new UnsupportedFileTypeException();
		}

		final String type = filename.substring(dotPosition + 1).toLowerCase(Locale.ROOT);

		if (!allowedFileTypes.contains(type))
		{
			throw new UnsupportedFileTypeException(type);
		}

		return filename;
	}

	public int getFileSize(final URL url) throws IOException
	{
		HttpURLConnection connection = null;

		try
		{
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.getInputStream();
			return connection.getContentLength();
		}
		finally
		{
			if (connection != null)
			{
				connection.disconnect();
			}
		}
	}

	public void downloadFile(final URL url)
	{
		final int fileSize;
		final String filename;

		try
		{
			filename = checkFileType(url);
		}
		catch (UnsupportedFileTypeException e)
		{
			log.error(e.getMessage());
			return;
		}

		int counter = 0;
		String reslolvedFileName = filename;
		while (Files.exists(Paths.get(reslolvedFileName)))
		{
			counter++;
			reslolvedFileName = filename + "_" + counter;
		}

		try
		{
			fileSize = getFileSize(url);
		}
		catch (final IOException e)
		{
			log.error("Cannot download from '{}'", url);
			return;
		}

		try (final InputStream inputStream = new BufferedInputStream(url.openStream());
			final BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(reslolvedFileName)))
		{
			final byte[] buffer = new byte[MAX_BUFFER_SIZE];
			int bytesRead;
			int totalDownloaded = 0;

			while ((bytesRead = inputStream.read(buffer, 0, MAX_BUFFER_SIZE)) != -1)
			{
				outputStream.write(buffer, 0, bytesRead);

				totalDownloaded += bytesRead;
				log.info("Link {}: downloaded so far {} / {} bytes", url, totalDownloaded, fileSize);
			}
		}
		catch (IOException e)
		{
			log.error("Failed to download file '{}'", url);
		}
	}
}
