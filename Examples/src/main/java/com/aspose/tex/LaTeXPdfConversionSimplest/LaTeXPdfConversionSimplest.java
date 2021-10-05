package com.aspose.tex.LaTeXPdfConversionSimplest;

import java.io.IOException;

import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.PdfDevice;
import com.aspose.tex.rendering.PdfSaveOptions;

import util.Utils;

public class LaTeXPdfConversionSimplest {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
        // ExStart:Conversion-LaTeXToPdf-Simplest
        // Create conversion options for Object LaTeX format on Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
        // Specify the file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Initialize the options for saving in PDF format.
        options.setSaveOptions(new PdfSaveOptions());
        // Run LaTeX to PDF conversion.
        new TeXJob(Utils.getInputDirectory() +  "hello-world.ltx", new PdfDevice(), options).run();
        // ExEnd:Conversion-LaTeXToPdf-Simplest
    }
}
