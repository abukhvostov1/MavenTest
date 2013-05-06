package pack_utils;

import java.io.Serializable;

public class JString implements Serializable
{
	private static final long serialVersionUID = 1L;
	String jString[];
	public JString(String s[]){this.jString = s;}
	public String[] GetJsonString() {return jString;}
}
