package com.aspose.tex.LaTeXPdfConversionAlternative;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.PdfDevice;
import com.aspose.tex.rendering.PdfSaveOptions;

import util.Utils;

public class LaTeXPdfConversionAlternative {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
        // ExStart:Conversion-LaTeXToPdf-Alternative
        // Create the stream to write the PDF file to.
        final OutputStream pdfStream = new FileOutputStream(Utils.getOutputDirectory() + "any-name.pdf");
        try {
            // Create conversion options for Object LaTeX format upon Object TeX engine extension.
            TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
            // Specify a file system working directory for the output.
            options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
            // Initialize the options for saving in PDF format.
            options.setSaveOptions(new PdfSaveOptions());
            // Run LaTeX to PDF conversion.
            new TeXJob(Utils.getInputDirectory() + "hello-world.ltx", new PdfDevice(pdfStream), options).run();
        } finally {
        	if (pdfStream != null)
        		pdfStream.close();
        }
        // ExEnd:Conversion-LaTeXToPdf-Alternative
    }
}
