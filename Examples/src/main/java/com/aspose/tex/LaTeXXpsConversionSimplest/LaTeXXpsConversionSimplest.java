package com.aspose.tex.LaTeXXpsConversionSimplest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.Interaction;
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
        // Create conversion options for Object LaTeX format upon Object TeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectLaTeX());
        options.setInputWorkingDirectory(new InputFileSystemDirectory(Utils.getInputDirectory()));

        // ExStart:Aspose.TeX.Examples-Conversion-InteractionMode
        // Set interaction mode.
         options.setInteraction(Interaction.NonstopMode);
        // ExEnd:Aspose.TeX.Examples-Conversion-InteractionMode

        // ExStart:Aspose.TeX.Examples-Conversion-JobName
        // Set the job name.
        // options.setJobName("my-job-name");
        // ExEnd:Aspose.TeX.Examples-Conversion-JobName
        
        // ExStart:Aspose.TeX.Examples-Conversion-DateTime
        // Force the TeX engine to output the specified date in the title.
        // options.setDateTime(new GregorianCalendar(2022, Calendar.DECEMBER, 18).getTime());
        // ExEnd:Aspose.TeX.Examples-Conversion-DateTime
        
        // ExStart:Aspose.TeX.Examples-Conversion-IgnoreMissingPackages
        // Set to true to make the engine skip missing packages (when your file references one) without errors.
        // options.ignoreMissingPackages(true);
        // ExEnd:Aspose.TeX.Examples-Conversion-IgnoreMissingPackages
        
        // ExStart:Aspose.TeX.Examples-Conversion-NoLigatures
        // Set to true to make the engine not construct ligatures where normally it would.
        // options.noLigatures(true);
        // ExEnd:Aspose.TeX.Examples-Conversion-NoLigatures
        
        // ExStart:Aspose.TeX.Examples-Conversion-Repeat
        // Ask the engine to repeat the job.
        // options.repeat(true);
        // Exend:Aspose.TeX.Examples-Conversion-Repeat

        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));

        // Initialize the options for saving in XPS format.
        options.setSaveOptions(new XpsSaveOptions()); // Default value. Arbitrary assignment.
        
        // ExStart:Aspose.TeX.Examples-Conversion-RasterizeFormulas
        // Set to true if you want math formulas to be converted to raster images.
        // options.getSaveOptions().rasterizeFormulas(true);
        // ExEnd:Aspose.TeX.Examples-Conversion-RasterizeFormulas
        
        // ExStart:Aspose.TeX.Examples-Conversion-RasterizeIncludedGraphics
        // Set to true if you want included graphics (if it contains vector elements) to be converted to raster images.
        // options.getSaveOptions().rasterizeIncludedGraphics(true);
        // ExEnd:Aspose.TeX.Examples-Conversion-RasterizeIncludedGraphics
        
        // ExStart:Aspose.TeX.Examples-Conversion-SubsetFonts
        // Set to true to make the device subset fonts used in the document.
        // options.getSaveOptions().subsetFonts(true);
        // ExEnd:Aspose.TeX.Examples-Conversion-SubsetFonts
        
        // Run LaTeX to XPS conversion.
        new TeXJob(Utils.getInputDirectory() + "sample.ltx", new XpsDevice(), options).run();

        // ExStart:Aspose.TeX.Examples-Conversion-InputStream
        // Run LaTeX to XPS conversion.
        // new TeXJob(new ByteArrayInputStream(
        //		"\\documentclass{article} \\begin{document} Hello, World! \\end{document}".getBytes("ASCII")),
        //		new XpsDevice(), options).run();
        // ExEnd:Aspose.TeX.Examples-Conversion-InputStream

        // ExStart:Aspose.TeX.Examples-Conversion-MainInputTerminal
        // Run LaTeX to XPS conversion.
        // new TeXJob(new XpsDevice(), options).run();
        // ExEnd:Aspose.TeX.Examples-Conversion-MainInputTerminal

        // ExEnd:Conversion-LaTeXToXps-Simplest
    }
}
