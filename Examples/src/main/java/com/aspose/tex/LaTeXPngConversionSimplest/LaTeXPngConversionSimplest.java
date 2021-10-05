package com.aspose.tex.LaTeXPngConversionSimplest;

import java.io.IOException;

import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.ImageDevice;
import com.aspose.tex.rendering.PngSaveOptions;

import util.Utils;

public class LaTeXPngConversionSimplest {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
        // ExStart:Conversion-LaTeXToPng-Simplest
        // Create conversion options for Object LaTeX format on Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
        // Specify the file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Initialize the options for saving in PNG format.
        options.setSaveOptions(new PngSaveOptions());

        // ExStart:Aspose.TeX.Examples-Conversion-LaTeXToJpeg
        // Initialize the options for saving in JPEG format.
        //options.setSaveOptions(new JpegSaveOptions());
        // ExEnd:Aspose.TeX.Examples-Conversion-LaTeXToJpeg

        // ExStart:Aspose.TeX.Examples-Conversion-LaTeXToTiff
        // Initialize the options for saving in TIFF format.
        //options.setSaveOptions(new TiffSaveOptions());
        // ExEnd:Aspose.TeX.Examples-Conversion-LaTeXToTiff

        // ExStart:Aspose.TeX.Examples-Conversion-LaTeXToBmp
        // Initialize the options for saving in BMP format.
        //options.setSaveOptions(new BmpSaveOptions());
        // ExEnd:Aspose.TeX.Examples-Conversion-LaTeXToBmp

        // Run LaTeX to PNG conversion.
        new TeXJob(Utils.getInputDirectory() + "hello-world.ltx", new ImageDevice(), options).run();
        // ExEnd:Conversion-LaTeXToPng-Simplest
    }
}
