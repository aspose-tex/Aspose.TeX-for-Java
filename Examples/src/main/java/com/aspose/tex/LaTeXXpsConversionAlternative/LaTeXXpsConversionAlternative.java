package com.aspose.tex.LaTeXXpsConversionAlternative;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.XpsDevice;
import com.aspose.tex.rendering.XpsSaveOptions;

import util.Utils;

public class LaTeXXpsConversionAlternative {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
        // ExStart:Conversion-LaTeXToXps-Alternative
        // Create the stream to write the XPS file to.
        final OutputStream xpsStream = new FileOutputStream(Utils.getOutputDirectory() + "any-name.xps");
        try {
            // Create conversion options for Object LaTeX format on Object TeX engine extension.
            TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
            // Specify the file system working directory for the output.
            options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
            // Initialize the options for saving in XPS format.
            options.setSaveOptions(new XpsSaveOptions()); // Default value.
            // Run LaTeX to XPS conversion.
            new TeXJob(Utils.getInputDirectory() + "hello-world.ltx", new XpsDevice(xpsStream), options).run();
        } finally {
        	if (xpsStream != null)
        		xpsStream.close();
        }
        // ExEnd:Conversion-LaTeXToXps-Alternative
    }
}
