package com.aspose.tex.LaTeXMathRenderer;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.tex.MathRenderer;
import com.aspose.tex.PngMathRendererOptions;

import util.Utils;

public class LaTeXMathRenderer {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:LaTeXMathRenderer
        // Create rendering options specifying the image resolution 150 dpi
        PngMathRendererOptions options = new PngMathRendererOptions();
        options.setResolution(150);
        // Specify the preamble.
        options.setPreamble("\\usepackage{amsmath}\r\n\\usepackage{amsfonts}\r\n\\usepackage{amssymb}\r\n\\usepackage{color}");
        // Specify the scaling factor 300%.
        options.setScale(3000);
        // Specify the foreground color.
        options.setTextColor(Color.BLACK);
        // Specify the background color.
        options.setBackgroundColor(Color.WHITE);
        // Specify the output stream for the log file.
        options.setLogStream(new ByteArrayOutputStream());
        // Specify whether to show the terminal output on the console or not.
        options.showTerminal(true);

        // The variable in which the dimensions of the resulting image will be written.
        com.aspose.tex.Size2D size = new com.aspose.tex.Size2D.Float();
        // Create the output stream for the formula image.
        final OutputStream stream = new FileOutputStream(Utils.getOutputDirectory() + "math-formula.png");
        try {
            // Run rendering.
            MathRenderer.render("\\begin{equation*}\r\n" +
"e^x = x^{\\color{red}0} + x^{\\color{red}1} + \\frac{x^{\\color{red}2}}{2} + \\frac{x^{\\color{red}3}}{6} + \\cdots = \\sum_{n\\geq 0} \\frac{x^{\\color{red}n}}{n!}\r\n" +
"\\end{equation*}", stream, options, size);
        } finally {
        	if (stream != null)
        		stream.close();
        }

        // Show other results.
        System.out.println(options.getErrorReport());
        System.out.println();
        System.out.println("Size: " + size.getWidth() + "x" + size.getHeight());
        // ExEnd:LaTeXMathRenderer
	}
}