package com.aspose.tex.TypesetWithCustomTeXFormat;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.aspose.tex.FormatProvider;
import com.aspose.tex.IInputWorkingDirectory;
import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeX;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.XpsDevice;

import util.Utils;

public class TypesetWithCustomTeXFormat {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:TypesetWithCustomTeXFormat
        // Create a file system input working directory.
        IInputWorkingDirectory wd = new InputFileSystemDirectory(Utils.getOutputDirectory());
        // Create a format provider.
        final FormatProvider formatProvider = new FormatProvider(wd, "customtex");
        try {
            // Create typesetting options for a custom format on ObjectTeX engine extension.
            TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX(formatProvider));
            options.setJobName("typeset-with-custom-format");
            // Specify the input working directory.
            options.setInputWorkingDirectory(wd);
            // Specify a file system working directory for output.
            options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));

            // Run typesetting.
            TeX.typeset(new ByteArrayInputStream(
                    "Congratulations! You have successfully typeset this text with your own TeX format!\\end".getBytes("ASCII")), new XpsDevice(), options);

            // For further output to look write.
            options.getTerminalOut().getWriter().newLine();
        } finally {
        	formatProvider.close();
        }
        // ExEnd:TypesetWithCustomTeXFormat
	}
}