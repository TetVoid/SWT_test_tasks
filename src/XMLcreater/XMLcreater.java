package XMLcreater;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class XMLcreater {
    public void create() {
        String[] names = {"Никита", "Ольга", "Владимир", "Глеб", "Аастасия", "Кагуар"};
        String[] surnames = {"Снежко", "Филиппов", "Лапка", "Голенков", "Спиридонов", "Семашко"};
        String[] middleName = {"Юрьевич", "Алексеевич", "Владимирович", "Павловна", "Францевна", "Артёмович"};
        String[] dates = {"15.10.2000", "06.03.2001", "27.07.2001", "00.00.0000", "01.01.1939", "12.04.1961"};
        String[] reports = {"Влюблюность", "Шизофриния", "Маразм", "Смерть", "ОКР", "Передозировка"};
        String[] addres = {"Гикало 9", "Семашко 17", "Ад", "Платонава 14", "Заславль", "Опытный"};
        String[] fileNames = {"test1.xml", "test2.xml", "test3.xml"};
        for (int j = 0; j < 3; j++) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;


            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            }

            Document document = builder.newDocument();
            Element root = document.createElement("base");
            document.appendChild(root);

            for (int i = 0; i < 50; i++) {
                Element note = document.createElement("note");

                Element patientNameEl = document.createElement("patientName");
                Element patientSurnameEl = document.createElement("patientSurname");
                Element patientMiddleNameEl = document.createElement("patientMiddleName");
                Element doctorNameEl = document.createElement("docName");
                Element doctorSurnameEl = document.createElement("docSurname");
                Element doctorMiddleNameEl = document.createElement("docMiddleName");
                Element addressEl = document.createElement("address");
                Element reportEl = document.createElement("report");
                Element dateEl = document.createElement("date");

                Random random = new Random();
                int[] index =new int[9];
                for(int k=0;k<9;k++)
                    index[k]=random.nextInt(5);

                Text patientName = document.createTextNode(names[index[0]]);
                Text patientSurname = document.createTextNode(surnames[index[1]]);
                Text patientMiddleName = document.createTextNode(middleName[index[2]]);
                Text doctorName = document.createTextNode(names[index[3]]);
                Text doctorSurname = document.createTextNode(surnames[index[4]]);
                Text doctorMiddleName = document.createTextNode(middleName[index[5]]);
                Text address = document.createTextNode(addres[index[6]]);
                Text report = document.createTextNode(reports[index[7]]);
                Text date = document.createTextNode(dates[index[8]]);


                note.appendChild(patientNameEl);
                note.appendChild(patientSurnameEl);
                note.appendChild(patientMiddleNameEl);
                note.appendChild(doctorNameEl);
                note.appendChild(doctorSurnameEl);
                note.appendChild(doctorMiddleNameEl);
                note.appendChild(addressEl);
                note.appendChild(reportEl);
                note.appendChild(dateEl);

                patientNameEl.appendChild(patientName);
                patientSurnameEl.appendChild(patientSurname);
                patientMiddleNameEl.appendChild(patientMiddleName);
                doctorNameEl.appendChild(doctorName);
                doctorSurnameEl.appendChild(doctorSurname);
                doctorMiddleNameEl.appendChild(doctorMiddleName);
                addressEl.appendChild(address);
                reportEl.appendChild(report);
                dateEl.appendChild(date);

                root.appendChild(note);
            }
            Transformer transformer = null;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
            } catch (
                    TransformerConfigurationException e) {
                e.printStackTrace();
            }
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            try {
                transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(fileNames[j])));
            } catch (
                    TransformerException e) {
                e.printStackTrace();
            } catch (
                    FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
