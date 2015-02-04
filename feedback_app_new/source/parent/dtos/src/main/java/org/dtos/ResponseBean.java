package org.dtos;
/**
 * @author nalin.sharma
 */
public class ResponseBean<T> {
private String message="";
private boolean status=false;
T data;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}

}
