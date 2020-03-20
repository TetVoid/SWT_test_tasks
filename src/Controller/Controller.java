package Controller;

import model.PatientReport;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import parser.SAXPars;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    private List<PatientReport> table=new ArrayList<>(0);

    public List<PatientReport> findNoteByPatientSurname(String patientSurname, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientSurname.equals(findingVector.get(i).getPatientSurname()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByPatientName(String patientSurname, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientSurname.equals(findingVector.get(i).getPatientName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByPatientMiddleName(String patientSurname, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientSurname.equals(findingVector.get(i).getPatientMiddleName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByAddress(String patientAddress, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientAddress.equals(findingVector.get(i).getAddress()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByDate(Date date, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(date.equals(findingVector.get(i).getDate()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;

    }

    public List<PatientReport> findNoteByDoctorName(String doctorName, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorName.equals(findingVector.get(i).getDoctorName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByDoctorSurname(String doctorSurname, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorSurname.equals(findingVector.get(i).getDoctorSurname()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public List<PatientReport> findNoteByDoctorMiddleName(String doctorMiddleName, List<PatientReport> findingVector)
    {
        List<PatientReport> needToFind=new ArrayList<>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorMiddleName.equals(findingVector.get(i).getDoctorMiddleName()))
                needToFind.add(findingVector.get(i));
        }
        return needToFind;
    }

    public void deleteElementsOfBase(List<PatientReport> needDeleteElements)
    {
        for(int i=0;i<needDeleteElements.size();i++)
            table.remove(needDeleteElements.get(i));
    }

    public void save(String nameOfFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = builder.newDocument();
        Element root = document.createElement("base");
        document.appendChild(root);
        for (int i = 0; i < table.size(); i++) {
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


            Text patientName = document.createTextNode(table.get(i).getPatientName());
            Text patientSurname = document.createTextNode(table.get(i).getPatientSurname());
            Text patientMiddleName = document.createTextNode(table.get(i).getPatientMiddleName());
            Text doctorName = document.createTextNode(table.get(i).getDoctorName());
            Text doctorSurname = document.createTextNode(table.get(i).getDoctorSurname());
            Text doctorMiddleName = document.createTextNode(table.get(i).getDoctorMiddleName());
            Text address = document.createTextNode(table.get(i).getAddress());
            Text report = document.createTextNode(table.get(i).getReport());

            DateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
            String dateString = formater.format(table.get(i).getDate());
            Text date = document.createTextNode(dateString);


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
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        try {
            transformer.transform(new DOMSource(document),new StreamResult(new FileOutputStream(nameOfFile)));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void load(String nameOfFile)
    {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser = null;
        try
        {
            parser = factory.newSAXParser();
            SAXPars saxp=new SAXPars();

            parser.parse(new File(nameOfFile),saxp);
            table= saxp.getResult();
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void setItemOfTable(PatientReport item)
    {
        table.add(item);
    }

    public List<PatientReport> getTable()
    {
        return table;
    }
}
