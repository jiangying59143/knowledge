package com.my.svn;

public class SVNVersion {
	
	private String version;
	
	private String name;
	
	private String remarks;

	public SVNVersion(String version, String name, String remarks) {
		super();
		this.version = version;
		this.name = name;
		this.remarks = remarks;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public SVNVersion setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	@Override
	public String toString() {
		return "SVNVersion [version=" + version + ", name=" + name + ", remarks=" + remarks + "]";
	}
	
	
}
