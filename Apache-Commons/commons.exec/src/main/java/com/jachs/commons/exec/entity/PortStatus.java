package com.jachs.commons.exec.entity;

/****
 * 
 * @author zhanchaohan
 */
public class PortStatus {
	private String type;
	private String local;
	private String remote;
	private String status;
	private Long pid;
	
	public PortStatus() {
		super();
	}
	public PortStatus(String type, String local, String remote, String status, Long pid) {
		super();
		this.type = type;
		this.local = local;
		this.remote = remote;
		this.status = status;
		this.pid = pid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getRemote() {
		return remote;
	}
	public void setRemote(String remote) {
		this.remote = remote;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
}
