package com.aspose.tex.OverriddenJobNameAndTerminalOutputWrittenToDisk;

import java.io.IOException;

import com.aspose.tex.InputFileSystemDirectory;
import com.aspose.tex.OutputFileSystemDirectory;
import com.aspose.tex.OutputFileTerminal;
import com.aspose.tex.TeXConfig;
import com.aspose.tex.TeXJob;
import com.aspose.tex.TeXOptions;
import com.aspose.tex.rendering.XpsDevice;

import util.Utils;

public class OverriddenJobNameAndTerminalOutputWrittenToDisk {
	public static void main(String[] args) throws IOException {
		Utils.setLicense();
		
		// ExStart:OverrideJobName-WriteTerminalOutputToFileSystem
        // Create conversion options for default ObjectTeX format upon ObjectTeX engine extension.
        TeXOptions options = TeXOptions.consoleAppOptions(TeXConfig.objectTeX());
        // Specify a job name. Otherwise, the first argument of the TeXJob constructor will be taken as a job name.
        options.setJobName("overridden-job-name");
        // Specify a file system working directory for the input.
        options.setInputWorkingDirectory(new InputFileSystemDirectory(Utils.getInputDirectory()));
        // Specify a file system working directory for the output.
        options.setOutputWorkingDirectory(new OutputFileSystemDirectory(Utils.getOutputDirectory()));
        // Specify that the terminal output must be written to a file in the output working directory.
        // The file name is <job_name>.trm.
        options.setTerminalOut(new OutputFileTerminal(options.getOutputWorkingDirectory()));

        // Run the job.
        TeXJob job = new TeXJob("hello-world", new XpsDevice(), options);
        job.run();
        // ExEnd:OverrideJobName-WriteTerminalOutputToFileSystem
	}
}