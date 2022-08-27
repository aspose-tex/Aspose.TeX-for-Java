package com.aspose.tex.OverridenJobNameAndTerminalOutputWrittenToZip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.aspose.tex.InputZipDirectory;
import com.aspose.tex.OutputFileTerminal;
import com.aspose.tex.OutputZipDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.PdfDevice;
import com.aspose.tex.rendering.PdfSaveOptions;

import util.Utils;

public class OverridenJobNameAndTerminalOutputWrittenToZip {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:WriteTerminalOutputToZip
        // Open a stream on a ZIP archive that will serve as the input working directory.
        final InputStream inZipStream = new FileInputStream(Utils.getInputDirectory() + "zip-in.zip");
        try {
	        // Open a stream on a ZIP archive that will serve as the output working directory.
	        final OutputStream outZipStream = new FileOutputStream(Utils.getOutputDirectory() + "terminal-out-to-zip.zip");
	        try {
	            // Create conversion options for default ObjectTeX format upon ObjectTeX engine extension.
	            TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
	            // Specify a job name.
	            options.setJobName("terminal-output-to-zip");
	            // Specify a ZIP archive working directory for the input. You can also specify a path inside the archive.
	            options.setInputWorkingDirectory(new InputZipDirectory(inZipStream, "in"));
	            // Specify a ZIP archive working directory for the output.
	            options.setOutputWorkingDirectory(new OutputZipDirectory(outZipStream));
	            // Specify that the terminal output must be written to a file in the output working directory.
	            // The file name is <job_name>.trm.
	            options.setTerminalOut(new OutputFileTerminal(options.getOutputWorkingDirectory()));
	
	            // Define the saving options.
	            options.setSaveOptions(new PdfSaveOptions());
	            // Run the job.
	            new TeXJob("hello-world", new PdfDevice(), options).run();
	
	            // Finalize output ZIP archive.
	            ((OutputZipDirectory)options.getOutputWorkingDirectory()).finish();
	        }
	        finally {
	        	outZipStream.close();
	        }
        }
        finally {
        	inZipStream.close();
        }
        // ExEnd:WriteTerminalOutputToZip
	}
}