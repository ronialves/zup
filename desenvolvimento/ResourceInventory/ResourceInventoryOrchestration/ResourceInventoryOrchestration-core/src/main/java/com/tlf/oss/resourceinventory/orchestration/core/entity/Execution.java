package com.tlf.oss.resourceinventory.orchestration.core.entity;

public class Execution {

	private int sequence;
	private String application;
	private String version;
	private ResourceDoUndo doExecution;
	private ResourceDoUndo undoExecution;
	
	public int getSequence() {
		return sequence;
	}
	
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	public String getApplication() {
		return application;
	}
	
	public void setApplication(String application) {
		this.application = application;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public ResourceDoUndo getDoExecution() {
		return doExecution;
	}
	
	public void setDoExecution(ResourceDoUndo doExecution) {
		this.doExecution = doExecution;
	}
	
	public ResourceDoUndo getUndoExecution() {
		return undoExecution;
	}
	
	public void setUndoExecution(ResourceDoUndo undoExecution) {
		this.undoExecution = undoExecution;
	}
	
	public String getLink() {
		return getApplication() + "/" + getVersion() + "/" + getDoExecution().getPath();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doExecution == null) ? 0 : doExecution.hashCode());
		result = prime * result + ((application == null) ? 0 : application.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + sequence;
		result = prime * result + ((undoExecution == null) ? 0 : undoExecution.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Execution other = (Execution) obj;
		
		if (sequence != other.sequence) {
			return false;
		}
		
		if (application == null) {
			if (other.application != null) {
				return false;
			}
		} else if (!application.equals(other.application)) {
			return false;
		}
		
		if (version == null) {
			if (other.version != null) {
				return false;
			}
		} else if (!version.equals(other.version)) {
			return false;
		}
		
		if (doExecution == null) {
			if (other.doExecution != null) {
				return false;
			}
		} else if (!doExecution.equals(other.doExecution)) {
			return false;
		}
		
		if (undoExecution == null) {
			if (other.undoExecution != null) {
				return false;
			}
		} else if (!undoExecution.equals(other.undoExecution)) {
			return false;
		}

		return true;
	}	
}
