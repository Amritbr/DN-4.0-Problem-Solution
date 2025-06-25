// Design Patterns and Principles
// Exercise 1: Implementing the Factory Method Pattern

// Interface for all Documents
interface Document {
    void open();
}

// Word Document
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document...");
    }
}

// PDF Document
class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }
}

// Excel Document
class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document...");
    }
}

// Abstract Factory
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Word Document Factory
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

// PDF Document Factory
class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

// Excel Document Factory
class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Test class
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Word Document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // PDF Document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Excel Document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
