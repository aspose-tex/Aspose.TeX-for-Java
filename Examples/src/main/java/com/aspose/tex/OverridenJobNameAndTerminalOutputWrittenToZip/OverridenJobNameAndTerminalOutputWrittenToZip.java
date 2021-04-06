package com.aspose.tex.OverridenJobNameAndTerminalOutputWrittenToZip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.aspose.tex.InputZipDirectory;
import com.aspose.tex.OutputFileTerminal;
import com.aspose.tex.OutputZipDirectory;
import com.aspose.tex.TeX;
import com.aspose.tex.TeXConfig;
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
	            // Create typesetting options for default ObjectTeX format on ObjectTeX engine extension.
	            TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
	            // Specify the job name.
	            options.setJobName("terminal-output-to-zip");
	            // Specify a ZIP archive working directory for input.
	            options.setInputWorkingDirectory(new InputZipDirectory(inZipStream, "in"));
	            // Specify a ZIP archive working directory for output.
	            options.setOutputWorkingDirectory(new OutputZipDirectory(outZipStream));
	            // Specify that the terminal output must be written to a file in the output working directory.
	            // The file name is <job_name>.trm.
	            options.setTerminalOut(new OutputFileTerminal(options.getOutputWorkingDirectory()));
	
	            // Create and specify saving options.
	            options.setSaveOptions(new PdfSaveOptions());
	            // Run typesetting.
	            TeX.typeset("hello-world", new PdfDevice(), options);
	
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