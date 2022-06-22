package rs.ac.ni.pmf.oop3.vezbe.vezba03;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import org.apache.commons.cli.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Downloader
{
	public static void main(String[] args)
	{
		final CommandLineParser commandLineParser = new DefaultParser();
		final Options options = defineOptions();

		try
		{
			final CommandLine commandLine = commandLineParser.parse(options, args);

			if (commandLine.hasOption("v"))
			{
				System.out.println("Option 'verbose' is turned on");
			}

			if (commandLine.hasOption('a'))
			{
				String[] allowedTypes = commandLine.getOptionValue('a').split(",");
				for (final String allowedType : allowedTypes)
				{
					if (allowedType.contains("|"))
					{
						throw new ParseException("Type '" + allowedType + "' contains some illegal characters");
					}
					System.out.println(allowedType);
				}
			}
		}
		catch (ParseException e)
		{
			log.error("Failed to parse options. Error: {}", e.getMessage());

			final HelpFormatter helpFormatter = new HelpFormatter();
			helpFormatter.printHelp("java Downloader [<option>] \nAvailable options:", options);
			return;
		}
	}

	private static Options defineOptions()
	{
		final Options options = new Options();

		options.addOption("v", "verbose", false, "If turned on, download progress will be shown");
		options.addOption(Option.builder("f")
			.longOpt("force-save")
			.desc("Force file overwrite")
			.hasArg(false)
			.build());
		options.addOption("a", "allowed-types", true, "Comma separated lise of allowed file types");
		options.addOption("h", "help", false, "Show help");

		return options;
	}

	public static void main1(String[] args) throws IOException
	{
		final FileDownloader fileDownloader = new FileDownloader();

		//		final List<String> lines = fileDownloader
		//			.readLines("F:\\JavaProjects\\2022\\Vezbe01\\src\\main\\resources\\log4j.properties");
		//			.readLines("c:\\letters.txt");
		//			.readLines("/brojevi.txt");

/*		final List<String> lines = fileDownloader.readLines("links.txt");
		final List<URL> urls = fileDownloader.getLinks(lines);

		for (final URL url : urls)
		{
			System.out.println(url);
		}*/

		fileDownloader.readLines("links.txt").stream()
			.map(fileDownloader::getLink)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.forEach(fileDownloader::downloadFile);
	}

	private static void printFileSize(FileDownloader fileDownloader, URL url)
	{
		try
		{
			System.out.println(fileDownloader.getFileSize(url));
		}
		catch (IOException e)
		{
			log.error("File '" + url.getFile() + "' cannot be downloaded");
		}
	}
}
