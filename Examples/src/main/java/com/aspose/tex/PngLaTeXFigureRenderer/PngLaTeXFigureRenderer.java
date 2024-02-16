package com.aspose.tex.PngLaTeXFigureRenderer;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.tex.PngFigureRenderer;
import com.aspose.tex.PngFigureRendererOptions;

import util.Utils;

public class PngLaTeXFigureRenderer {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:Features-PngLaTeXFigureRendering
        // Create rendering options setting the image resolution to 150 dpi.
        PngFigureRendererOptions options = new PngFigureRendererOptions();
        // Specify the resolution.
        options.setResolution(150);
        // Specify the preamble.
        options.setPreamble("\\usepackage{pict2e}");
        // Specify the scaling factor 300%.
        options.setScale(3000);
        // Specify the background color.
        options.setBackgroundColor(Color.WHITE);
        // Specify the output stream for the log file.
        options.setLogStream(new ByteArrayOutputStream());
        // Specify whether to show the terminal output on the console or not.
        options.showTerminal(true);

        // Create the output stream for the figure image.
        final OutputStream stream = new FileOutputStream(Utils.getOutputDirectory() + "text-and-formula.png");
        try {
            // Run rendering.
        	com.aspose.tex.Size2D size = new PngFigureRenderer().render("\\setlength{\\unitlength}{0.8cm}\r\n" +
"\\begin{picture}(6,5)\r\n" +
"\\thicklines\r\n" +
"\\put(1,0.5){\\line(2,1){3}} \\put(4,2){\\line(-2,1){2}} \\put(2,3){\\line(-2,-5){1}} \\put(0.7,0.3){$A$} \\put(4.05,1.9){$B$} \\put(1.7,2.95){$C$}\r\n" +
"\\put(3.1,2.5){$a$} \\put(1.3,1.7){$b$} \\put(2.5,1.05){$c$} \\put(0.3,4){$F=\\sqrt{s(s-a)(s-b)(s-c)}$} \\put(3.5,0.4){$\\displaystyle s:=\\frac{a+b+c}{2}$}\r\n" +
"\\end{picture}", stream, options);
        	
        	// Show other results.
            System.out.println(options.getErrorReport());
            System.out.println();
            System.out.println("Size: " + size.getWidth() + "x" + size.getHeight()); // Dimensions of the resulting image.
        } finally {
        	if (stream != null)
        		stream.close();
        }
        // ExEnd:Features-PngLaTeXFigureRendering
	}
}
