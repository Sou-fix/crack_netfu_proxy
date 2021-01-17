package org.theanarch.openproxy.Proxy;

public interface Commons {
	//v1
    byte getCommand();
    void connect();
    void bind()throws Exception;
}
