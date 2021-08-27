package com.aspose.tex.StreamInputImageOutputAndTerminalInput;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.aspose.tex.InputConsoleTerminal;
import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputConsoleTerminal;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.ImageDevice;
import com.aspose.tex.rendering.PngSaveOptions;

import util.Utils;

public class StreamInputImageOutputAndTerminalInput {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:TakeMainInputFromStream-AuxFromFileSystem-TakeTerminalInputFromConsole-AlternativeImagesStorage
        // Create typesetting options for default ObjectTeX format on ObjectTeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
        // Specify the job name.
        options.setJobName("stream-in-image-out");
        // Specify a file system working directory for input.
        options.setInputWorkingDirectory(new InputFileSystemDirectory(Utils.getInputDirectory()));
        // Specify a file system working directory for output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Specify console as input terminal.
        options.setTerminalIn(new InputConsoleTerminal());  // Default. No need to specify.
        // Specify console as output terminal.
        options.setTerminalOut(new OutputConsoleTerminal()); // Default. No need to specify.

        // Create and specify saving options.
        PngSaveOptions pngOptions = new PngSaveOptions();
        pngOptions.setResolution(300);
        options.setSaveOptions(pngOptions);
        // Create image device.
        ImageDevice device = new ImageDevice();
        // Run typesetting.
        TeXJob job = new TeXJob(new ByteArrayInputStream(
        		"\\hrule height 10pt width 95pt\\vskip10pt\\hrule height 5pt".getBytes("ASCII")),
                device, options);
        job.run();

        // When console prompts the input, type "ABC", press Enter, then type "\end" and press Enter again.

        // For further output to look write. 
        options.getTerminalOut().getWriter().newLine();

        // You can alternatively get images in form of array of byte arrays.
        // The first index for the page number (0-based, of course).
        byte[][] result = device.getResult();
        // ExEnd:TakeMainInputFromStream-AuxFromFileSystem-TakeTerminalInputFromConsole-AlternativeImagesStorage
	}
}