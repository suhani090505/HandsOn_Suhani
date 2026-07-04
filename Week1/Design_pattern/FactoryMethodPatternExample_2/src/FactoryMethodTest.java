public class FactoryMethodTest {

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}