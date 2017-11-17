package com.w3c.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class W3CDomParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factory.newDocumentBuilder();
		Document doc = db.parse(new File("G:\\JavaWebDev\\DsvcSecurity\\src\\Emty.xml"));
		Element root = doc.getDocumentElement();
//		System.out.println(root.getNodeName());
		NodeList nodes = root.getChildNodes();
		int length = nodes.getLength();
		for(int i =0;i!=length;i++){
			Node node = nodes.item(i);
			System.out.println("[Node Name:"+node.getNodeName()+"]");
		}
	}

}
