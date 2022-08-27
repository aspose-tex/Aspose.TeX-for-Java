package com.aspose.tex.LaTeXSvgConversionSimplest;

import java.io.IOException;

import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.SvgDevice;
import com.aspose.tex.rendering.SvgSaveOptions;

import util.Utils;

public class LaTeXSvgConversionSimplest {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:Conversion-LaTeXToSvg-Simplest
        // Create conversion options for Object LaTeX format upon Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Initialize the options for saving in SVG format.
        options.setSaveOptions(new SvgSaveOptions());
        // Run LaTeX to SVG conversion.
        new TeXJob(Utils.getInputDirectory() + "hello-world.ltx", new SvgDevice(), options).run();
        // ExEnd:Conversion-LaTeXToSvg-Simplest
    }
}
