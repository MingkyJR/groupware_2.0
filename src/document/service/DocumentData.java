package document.service;

import document.model.Document;
import document.model.DocumentContent;

public class DocumentData {
	private Document document;
	private DocumentContent content;
	
	public DocumentData(Document document, DocumentContent content) {
		this.document = document;
		this.content = content;
	}

	public Document getDocument() {
		return document;
	}

	public DocumentContent getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "DocumentData [document=" + document + ", content=" + content + "]";
	}
	
}







