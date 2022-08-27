package com.aspose.tex.LaTeXPngConversionAlternative;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.ImageDevice;
import com.aspose.tex.rendering.PngSaveOptions;

import util.Utils;

public class LaTeXPngConversionAlternative {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
        // ExStart:Conversion-LaTeXToPng-Alternative
        // Create conversion options for Object LaTeX format upon Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Initialize the options for saving in PNG format.
        PngSaveOptions saveOptions = new PngSaveOptions();
        // Set this property to instruct the device not to output images as you will access them alternatively.
        saveOptions.deviceWritesImages(false);
        options.setSaveOptions(saveOptions);
        // Run LaTeX to PNG conversion.
        ImageDevice device = new ImageDevice();
        new TeXJob(Utils.getInputDirectory() + "hello-world.ltx", device, options).run();

        // Save pages file by file.
        for (int i = 0; i < device.getResult().length; i++)
        {
            final OutputStream fs = new FileOutputStream(Utils.getOutputDirectory() + "page-" + (i + 1) + ".png");
            try {
                fs.write(device.getResult()[i], 0, device.getResult()[i].length);
            } finally {
            	if (fs != null)
            		fs.close();
            }
        }
        // ExEnd:Conversion-LaTeXToPng-Alternative
    }
}
