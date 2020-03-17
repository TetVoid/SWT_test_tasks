import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Model {
    private Vector <itemOfBase> table=new Vector<itemOfBase>(0);

    public Vector<itemOfBase> findNoteByPatientSurname(String patientSurname,Vector<itemOfBase> findingVector)
    {
        Vector<itemOfBase> needToFind=new Vector<itemOfBase>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientSurname.equals(findingVector.elementAt(i).getPatientSurname()))
                needToFind.addElement(findingVector.elementAt(i));
        }
        return needToFind;
    }

    public Vector<itemOfBase> findNoteByAddress(String patientAddress,Vector<itemOfBase> findingVector)
    {
        Vector<itemOfBase> needToFind=new Vector<itemOfBase>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(patientAddress.equals(findingVector.elementAt(i).getAddress()))
                needToFind.addElement(findingVector.elementAt(i));
        }
        return needToFind;
    }

    public Vector<itemOfBase> findNoteByDate(String date,Vector<itemOfBase> findingVector)
    {
        Vector<itemOfBase> needToFind=new Vector<itemOfBase>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(date.equals(findingVector.elementAt(i).getDate()))
                needToFind.addElement(findingVector.elementAt(i));
        }
        return needToFind;

    }

    public Vector<itemOfBase> findNoteByDoctorName(String doctorName,Vector<itemOfBase> findingVector)
    {
        Vector<itemOfBase> needToFind=new Vector<itemOfBase>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorName.equals(findingVector.elementAt(i).getDoctorName()))
                needToFind.addElement(findingVector.elementAt(i));
        }
        return needToFind;
    }

    public Vector<itemOfBase> findNoteByDoctorSurname(String doctorSurname,Vector<itemOfBase> findingVector)
    {
        Vector<itemOfBase> needToFind=new Vector<itemOfBase>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorSurname.equals(findingVector.elementAt(i).getDoctorSurname()))
                needToFind.addElement(findingVector.elementAt(i));
        }
        return needToFind;
    }

    public Vector<itemOfBase> findNoteByDoctorMiddleName(String doctorMiddleName,Vector<itemOfBase> findingVector)
    {
        Vector<itemOfBase> needToFind=new Vector<itemOfBase>(0);

        for(int i=0;i<findingVector.size();i++)
        {
            if(doctorMiddleName.equals(findingVector.elementAt(i).getDoctorMiddleName()))
                needToFind.addElement(findingVector.elementAt(i));
        }
        return needToFind;
    }

    public void deleteElementsOfBase(Vector<itemOfBase> needDeleteElements)
    {
        for(int i=0;i<needDeleteElements.size();i++)
            table.remove(needDeleteElements.elementAt(i));
    }

    public void save(String nameOfFile)
    {

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

    public void setItemOfTable(itemOfBase item)
    {
        table.addElement(item);
    }
}
