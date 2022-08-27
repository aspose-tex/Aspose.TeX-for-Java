package com.aspose.tex.TypesetWithCustomTeXFormat;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.aspose.tex.FormatProvider;
import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.XpsDevice;

import util.Utils;

public class TypesetWithCustomTeXFormat {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:TypesetWithCustomTeXFormat
        // Create the format provider using the file system input working directory.
        // We use the project output directory as our custom format file is supposed to be located there.
        final FormatProvider formatProvider = new FormatProvider(
        		new InputFileSystemDirectory(Utils.getOutputDirectory()), "customtex");
        try {
            // Create conversion options for a custom format upon ObjectTeX engine extension.
            TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX(formatProvider));
            options.setJobName("typeset-with-custom-format");
            // Specify the input working directory. This is not required here as we are providing the main input as a stream.
            // But it is required when the main input has dependencies (e.g. images).
            options.setInputWorkingDirectory(new InputFileSystemDirectory(Utils.getInputDirectory()));
            // Specify a file system working directory for the output.
            options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));

            // Run teh job.
            new TeXJob(new ByteArrayInputStream(
                    "Congratulations! You have successfully typeset this text with your own TeX format!\\end".getBytes("ASCII")),
            		new XpsDevice(), options).run();
            

            // For further output to look write.
            options.getTerminalOut().getWriter().newLine();
        } finally {
        	formatProvider.close();
        }
        // ExEnd:TypesetWithCustomTeXFormat
	}
}