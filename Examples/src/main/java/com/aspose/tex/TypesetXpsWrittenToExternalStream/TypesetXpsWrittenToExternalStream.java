package com.aspose.tex.TypesetXpsWrittenToExternalStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.OutputFileTerminal;
import com.aspose.tex.TeX;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.XpsDevice;

import util.Utils;

public class TypesetXpsWrittenToExternalStream {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:WriteOutputXpsToExternalStream
        // Create typesetting options for default ObjectTeX format on ObjectTeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
        // Specify a job name.
        options.setJobName("external-file-stream");
        // Specify a file system working directory for input.
        options.setInputWorkingDirectory(new InputFileSystemDirectory(Utils.getInputDirectory()));
        // Specify a file system working directory for output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Specify that the terminal output must be written to a file in the output working directory.
        // The file name is <job_name>.trm.
        options.setTerminalOut(new OutputFileTerminal(options.getOutputWorkingDirectory()));

        // Open a stream to write typeset XPS document. File name not necessarily the same as the job name.
        final OutputStream stream = new FileOutputStream(Utils.getOutputDirectory() + options.getJobName() + ".xps");
        try {
            // Run typesetting.
            TeX.typeset("hello-world", new XpsDevice(stream), options);
        }
        finally {
        	stream.close();
        }
        // ExEnd:WriteOutputXpsToExternalStream
	}
}