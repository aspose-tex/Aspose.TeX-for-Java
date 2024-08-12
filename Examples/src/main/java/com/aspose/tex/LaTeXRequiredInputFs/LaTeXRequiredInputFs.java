package com.aspose.tex.LaTeXRequiredInputFs;

import java.io.IOException;

import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.ImageDevice;
import com.aspose.tex.rendering.PngSaveOptions;

import util.Utils;

class LaTeXRequiredInputFs {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
        // ExStart:Conversion-RequiredInput-FileSystem
        // Create conversion options for Object LaTeX format upon Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Specify a file system working directory for the required input.
        // The directory containing packages may be located anywhere.
        options.setRequiredInputDirectory(new InputFileSystemDirectory(Utils.getInputDirectory() + "packages"));
        // Initialize the options for saving in PNG format.
        options.setSaveOptions(new PngSaveOptions());
        // Run LaTeX to PNG conversion.
        new TeXJob(Utils.getInputDirectory() + "required-input-fs.tex", new ImageDevice(), options).run();
        // ExEnd:Conversion-RequiredInput-FileSystem
    }
}
