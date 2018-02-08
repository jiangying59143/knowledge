package com.my.svn;

import java.io.IOException;

public class TestCmd {
	public static void main(String[] args) throws IOException {
		SvnExport.cmdRun("shutdown -s");
	}
}
