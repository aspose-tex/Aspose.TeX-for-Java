package com.aspose.tex.LaTeXEmbeddedBase64EncodedImage;

import java.io.IOException;

import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.ShellMode;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.PdfDevice;
import com.aspose.tex.rendering.PdfSaveOptions;

import util.Utils;

class LaTeXEmbeddedBase64EncodedImage {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:Conversion-EmbeddedBase64EncodedImage
        // Create conversion options for Object LaTeX format upon Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Initialize the options for saving in PDF format.
        options.setSaveOptions(new PdfSaveOptions());
        // Enable the shell command execution.
        options.setShellMode(ShellMode.ShellRestricted);
        // Run LaTeX to PDF conversion.
        new TeXJob(Utils.getInputDirectory() + "embedded-base64-image.tex", new PdfDevice(), options).run();
        // ExEnd:Conversion-EmbeddedBase64EncodedImage
    }
}
