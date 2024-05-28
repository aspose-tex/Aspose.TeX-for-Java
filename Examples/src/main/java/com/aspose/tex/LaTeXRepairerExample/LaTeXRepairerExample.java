package com.aspose.tex.LaTeXRepairerExample;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.features.IGuessPackageCallback;
import com.aspose.tex.features.LaTeXRepairer;
import com.aspose.tex.features.LaTeXRepairerOptions;

import util.Utils;

public class LaTeXRepairerExample {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:Features-LaTeXRepairer
        // Create conversion options for Object LaTeX format upon Object TeX engine extension.
        LaTeXRepairerOptions options = new LaTeXRepairerOptions();
        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Specify a file system working directory for the required input.
        // The directory containing packages may be located anywhere.
        options.setRequiredInputDirectory(new InputFileSystemDirectory(Utils.getInputDirectory() + "packages"));
        // Specify the callback class to externally guess packages required for undefined commands or environments.
        options.setGuessPackageCallback(new PackageGuesser());
        // Run LaTeX to PNG conversion.
        new LaTeXRepairer(Utils.getInputDirectory() + "invalid-latex.tex", options).run();
        // ExEnd:Features-LaTeXRepairer
	}
	
	// ExStart:Features-LaTeXRepairer-PackageGuessingCallback
	// The callback class to externally guess packages required for undefined commands or environments.
    public static class PackageGuesser implements IGuessPackageCallback
    {
        private Map<String, String> _map = new HashMap<String, String>();

        public PackageGuesser()
        {
            _map.put("lhead", "fancyhdr"); // Defines the mapping between the \lhead command and the fancyhdr package.
        }

        public String guessPackage(String commandName, boolean isEnvironment)
        {
            if (!isEnvironment)
            {
            	String packageName = _map.get(commandName);
                return packageName != null ? packageName : ""; // It's better to return an empty stream to avoid consequent calls for the same command name.
            }

            // Some code for environments
            // ...

            return "";
        }
    }
    // ExEnd:Features-LaTeXRepairer-PackageGuessingCallback
}
