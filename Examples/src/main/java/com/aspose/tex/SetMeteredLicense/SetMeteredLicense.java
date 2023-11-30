package com.aspose.tex.SetMeteredLicense;

public class SetMeteredLicense {
	public static void main(String[] args) throws Exception {
		// ExStart:SetMeteredLicense
		// Set metered public and private keys.
        new com.aspose.tex.Metered().setMeteredKey(
            "<type public key here>",
            "<type private key here>");
        // ExEnd:SetMeteredLicense
	}
}