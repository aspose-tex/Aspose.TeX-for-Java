package com.aspose.tex.LaTeXXpsConversionSimplest;

import java.io.IOException;

import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.XpsDevice;
import com.aspose.tex.rendering.XpsSaveOptions;

import util.Utils;

public class LaTeXXpsConversionSimplest {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
        // ExStart:Conversion-LaTeXToXps-Simplest
        // Create conversion options for Object LaTeX format on Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());

        // ExStart:Aspose.TeX.Examples-Conversion-InteractionMode
        // Set interaction mode.
        //options.setInteraction(Interaction.NonstopMode);
        // ExEnd:Aspose.TeX.Examples-Conversion-InteractionMode

        // ExStart:Aspose.TeX.Examples-Conversion-JobName
        // Set the job name.
        //options.setJobName("my-job-name");
        // ExEnd:Aspose.TeX.Examples-Conversion-JobName

        // Specify the file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));

        // ExStart:Aspose.TeX.Examples-Conversion-Repeat
        // Ask the engine to repeat the job.
        //options.repeat(true);
        // Exend:Aspose.TeX.Examples-Conversion-Repeat

        // Initialize the options for saving in XPS format.
        options.setSaveOptions(new XpsSaveOptions()); // Default value.
        // Run LaTeX to XPS conversion.
        new TeXJob(Utils.getInputDirectory() + "hello-world.ltx", new XpsDevice(), options).run();

        // ExStart:Aspose.TeX.Examples-Conversion-InputStream
        // Run LaTeX to XPS conversion.
        //new TeXJob(new ByteArrayInputStream(
        //		"\\documentclass{article} \\begin{document} Hello, World! \\end{document}".getBytes("ASCII")),
        //		new XpsDevice(), options).run();
        // ExEnd:Aspose.TeX.Examples-Conversion-InputStream

        // ExStart:Aspose.TeX.Examples-Conversion-MainInputTerminal
        // Run LaTeX to XPS conversion.
        //new TeXJob(new XpsDevice(), options).run();
        // ExEnd:Aspose.TeX.Examples-Conversion-MainInputTerminal

        // ExEnd:Conversion-LaTeXToXps-Simplest
    }
}
