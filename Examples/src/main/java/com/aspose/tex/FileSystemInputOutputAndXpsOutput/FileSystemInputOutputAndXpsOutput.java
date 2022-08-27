package com.aspose.tex.FileSystemInputOutputAndXpsOutput;

import java.io.IOException;

import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputConsoleTerminal;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.XpsDevice;

import util.Utils;

public class FileSystemInputOutputAndXpsOutput {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:TakeInputFromFileSystem-WriteOutputToFileSystem-WriteTerminalOutputToConsole
        // Create conversion options for default ObjectTeX format upon ObjectTeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
        // Specify a file system working directory for the input.
        options.setInputWorkingDirectory(new InputFileSystemDirectory(Utils.getInputDirectory()));
        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Specify the console as the output terminal.
        options.setTerminalOut(new OutputConsoleTerminal()); // Default value. Arbitrary assignment.
        // Specify a memory terminal as output terminal, if you don't want the terminal output to be written to the console.
        // options.setTerminalOut(new OutputMemoryTerminal());
        // Run the job.
        TeXJob job = new TeXJob("hello-world", new XpsDevice(), options);
        job.run();

        // For further output to look fine.
        options.getTerminalOut().getWriter().newLine(); // The same as System.out.println();
        // ExEnd:TakeInputFromFileSystem-WriteOutputToFileSystem-WriteTerminalOutputToConsole
	}
}