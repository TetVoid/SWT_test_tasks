package parser;

import model.PatientReport;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class SAXPars extends DefaultHandler {
    Vector<PatientReport> array=new Vector<PatientReport>(0);
    PatientReport item = null;
    String thisElement = "";

    public Vector<PatientReport> getResult(){
        return array;
    }


    public void startDocument()  {
        System.out.println("Start parse XML...");
    }


    public void startElement(String namespaceURI, String localName, String qName, Attributes atts)  {

        thisElement = qName;
        if(thisElement.equals("note"))
            item= new PatientReport();
    }


    public void endElement(String namespaceURI, String localName, String qName) {
        if(qName.equals("note"))
            array.addElement(item);
        thisElement = "";
    }


    public void characters(char[] ch, int start, int length) {

        if (thisElement.equals("date"))
        {
            SimpleDateFormat format =new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");

            Date date= null;
            try {
                date = format.parse(new String(ch, start, length));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            item.setDate(date);
        }
        if (thisElement.equals("docName")) {
            item.setDoctorName(new String(ch, start, length));
        }
        if (thisElement.equals("docSurname")) {
            item.setDoctorSurname(new String(ch, start, length));
        }
        if (thisElement.equals("docMiddleName")) {
            item.setDoctorMiddleName(new String(ch, start, length));
        }
        if (thisElement.equals("patientName")) {
            item.setPatientName(new String(ch, start, length));
        }
        if (thisElement.equals("patientSurname")) {
            item.setPatientSurname(new String(ch, start, length));
        }
        if (thisElement.equals("patientMiddleName")) {
            item.setPatientMiddleName(new String(ch, start, length));
        }
        if (thisElement.equals("address")) {
            item.setAddress(new String(ch, start, length));
        }
        if (thisElement.equals("report")) {
            item.setReport(new String(ch, start, length));
        }
    }


    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}

