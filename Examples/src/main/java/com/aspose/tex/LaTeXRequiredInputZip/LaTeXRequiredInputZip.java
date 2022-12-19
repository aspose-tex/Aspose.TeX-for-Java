package com.aspose.tex.LaTeXRequiredInputZip;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.tex.InputZipDirectory;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.ImageDevice;
import com.aspose.tex.rendering.PngSaveOptions;

import util.Utils;

class LaTeXRequiredInputZip {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
        // ExStart:Conversion-RequiredInput-Zip
        // Create conversion options for Object LaTeX format upon Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Initialize the options for saving in PNG format.
        options.setSaveOptions(new PngSaveOptions());
        // Create a file stream for the ZIP archive containing the required package.
        // The ZIP archive may be located anywhere.
        final InputStream stream = new FileInputStream(Utils.getInputDirectory() + "packages\\pgfplots.zip");
        try {
	        // Specify a ZIP working directory for the required input.
	        options.setRequiredInputDirectory(new InputZipDirectory(stream, ""));
	        
	        // Run LaTeX to PNG conversion.
	        new TeXJob(Utils.getInputDirectory() + "required-input-zip.tex", new ImageDevice(), options).run();
        } finally {
        	if (stream != null)
        		stream.close();
        }
        // ExEnd:Conversion-RequiredInput-Zip
    }
}
