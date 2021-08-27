package com.aspose.tex.ZipFileInputOuputAndPdfOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.aspose.tex.InputZipDirectory;
import com.aspose.tex.OutputConsoleTerminal;
import com.aspose.tex.OutputZipDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.PdfDevice;
import com.aspose.tex.rendering.PdfSaveOptions;

import util.Utils;

public class ZipFileInputOuputAndPdfOutput {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:TakeInputFromZip-WriteOutputToZip
        // Open a stream on a ZIP archive that will serve as the input working directory.
        final InputStream inZipStream = new FileInputStream(Utils.getInputDirectory() + "zip-in.zip");
        try {
	        // Open a stream on a ZIP archive that will serve as the output working directory.
	        final OutputStream outZipStream = new FileOutputStream(Utils.getOutputDirectory() + "zip-pdf-out.zip");
	        try {
	            // Create typesetting options for default ObjectTeX format on ObjectTeX engine extension.
	            TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
	            // Specify a ZIP archive working directory for input.
	            options.setInputWorkingDirectory(new InputZipDirectory(inZipStream, "in"));
	            // Specify a ZIP archive working directory for output.
	            options.setOutputWorkingDirectory(new OutputZipDirectory(outZipStream));
	            // Specify console as output terminal.
	            options.setTerminalOut(new OutputConsoleTerminal()); // Default. Not necessary to specify.
	
	            // Create and specify saving options.
	            options.setSaveOptions(new PdfSaveOptions());
	            // Run typesetting.
	            TeXJob job = new TeXJob("hello-world", new PdfDevice(), options);
	            job.run();
	
	            // For consequent output to look write. 
	            options.getTerminalOut().getWriter().newLine();
	
	            // Finalize output ZIP archive.
	            ((OutputZipDirectory)options.getOutputWorkingDirectory()).finish();
	        } finally {
				outZipStream.close();
			}
        } finally {
        	inZipStream.close();
        }
        // ExEnd:TakeInputFromZip-WriteOutputToZip
	}
}