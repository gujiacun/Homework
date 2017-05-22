package com._520it.msg.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com._520it.msg.dao.IMessageDAO;
import com._520it.msg.domain.Message;


public class MessageDAOImpl implements IMessageDAO {
	File file = new File("C:/msgs.xml");

	public void add(Message obj) {
		Document doc = this.getDoc();
		Element root = doc.getDocumentElement();

		Element msgEl = doc.createElement("msg");
		msgEl.setAttribute("id", obj.getSn());
		Element titleEl = doc.createElement("title");
		titleEl.setTextContent(obj.getTitle());
		Element contentEl = doc.createElement("content");
		contentEl.setTextContent(obj.getContent());
		msgEl.appendChild(titleEl);
		msgEl.appendChild(contentEl);
		root.appendChild(msgEl);
		this.transform2File(doc);

	}

	private void transform2File(Document doc) throws TransformerFactoryConfigurationError {
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer former = factory.newTransformer();
			Source xmlSource = new DOMSource(doc);
			Result outputTarget = new StreamResult(file);
			former.transform(xmlSource, outputTarget);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Message> getAll() {

		List<Message> ret = new ArrayList<Message>();
		Document doc = getDoc();
		Element rootEl = doc.getDocumentElement();
		NodeList nodeList = rootEl.getElementsByTagName("msg");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element msgEl = (Element) nodeList.item(i);
			Message p = new Message();
			p.setSn(msgEl.getAttribute("id"));
			Element titleEl = (Element) msgEl.getElementsByTagName("title").item(0);
			String title = titleEl.getTextContent();
			p.setTitle(title);
			p.setContent(msgEl.getElementsByTagName("content").item(0).getTextContent());
			ret.add(p);
		}
		return ret;
	}

	private Document getDoc() {
		Document doc;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			if (!file.exists()) {
				doc = builder.newDocument();
				doc.setXmlVersion("1.0");
				doc.setXmlStandalone(false);
				Element root = doc.createElement("msgs");
				doc.appendChild(root);
			} else {
				doc = builder.parse(file);
			}
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
