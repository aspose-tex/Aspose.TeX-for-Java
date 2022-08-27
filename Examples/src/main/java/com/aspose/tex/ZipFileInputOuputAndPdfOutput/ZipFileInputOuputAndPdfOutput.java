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
        // Open the stream on the ZIP archive that will serve as the input working directory.
        final InputStream inZipStream = new FileInputStream(Utils.getInputDirectory() + "zip-in.zip");
        try {
	        // Open the stream on the ZIP archive that will serve as the output working directory.
	        final OutputStream outZipStream = new FileOutputStream(Utils.getOutputDirectory() + "zip-pdf-out.zip");
	        try {
	            // Create conversion options for default ObjectTeX format upon ObjectTeX engine extension.
	            TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
	            // Specify a ZIP archive working directory for the input. You can also specify a path inside the archive.
	            options.setInputWorkingDirectory(new InputZipDirectory(inZipStream, "in"));
	            // Specify a ZIP archive working directory for the output.
	            options.setOutputWorkingDirectory(new OutputZipDirectory(outZipStream));
	            // Specify the console as the output terminal.
	            options.setTerminalOut(new OutputConsoleTerminal()); // Default value. Arbitrary assignment.
	
	            // Define the saving options.
	            options.setSaveOptions(new PdfSaveOptions());
	            // Run the job.
	            TeXJob job = new TeXJob("hello-world", new PdfDevice(), options);
	            job.run();
	
	            // For further output to look fine. 
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