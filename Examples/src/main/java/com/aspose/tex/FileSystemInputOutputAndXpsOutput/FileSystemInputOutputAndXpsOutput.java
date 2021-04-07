package com.aspose.tex.FileSystemInputOutputAndXpsOutput;

import java.io.IOException;

import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputConsoleTerminal;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeX;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.XpsDevice;

import util.Utils;

public class FileSystemInputOutputAndXpsOutput {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:TakeInputFromFileSystem-WriteOutputToFileSystem-WriteTerminalOutputToConsole
        // Create typesetting options for default ObjectTeX format on ObjectTeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
        // Specify a file system working directory for input.
        options.setInputWorkingDirectory(new InputFileSystemDirectory(Utils.getInputDirectory()));
        // Specify a file system working directory for output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Specify console as output terminal.
        options.setTerminalOut(new OutputConsoleTerminal()); // Default. No need to specify.
        // Specify memory stream as output terminal, if you don't terminal output to be written to console.
        //options.setTerminalOut(new OutputMemoryTerminal());
        // Run typesetting.
        TeX.typeset("hello-world", new XpsDevice(), options);

        // For further output to look write.
        options.getTerminalOut().getWriter().newLine(); // The same as System.out.println();
        // ExEnd:TakeInputFromFileSystem-WriteOutputToFileSystem-WriteTerminalOutputToConsole
	}
}