package view.listeners;

import controller.Controller;
import controller.PageController;
import view.SeeTable;
import model.PatientReport;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddButtonListener extends SelectionAdapter
{
    PageController pageControl=null;
    Table tableView= null;
    Controller controller= null;
    Label pagesLabel=null;
    Text[] arrayOfText=new Text[9];
    public AddButtonListener(Table table, PageController tempValue, Controller tempController, Label tempLabel, Text[] tempArrayOfText)
    {
        tableView=table;
        controller=tempController;
        pagesLabel=tempLabel;
        pageControl=tempValue;
        arrayOfText=tempArrayOfText;
    }

    public void widgetSelected(SelectionEvent event1) {
        PatientReport newItem = new PatientReport();
        newItem.setPatientName(arrayOfText[0].getText());
        newItem.setPatientSurname(arrayOfText[1].getText());
        newItem.setPatientMiddleName(arrayOfText[2].getText());
        newItem.setDoctorName(arrayOfText[3].getText());
        newItem.setDoctorSurname(arrayOfText[4].getText());
        newItem.setDoctorMiddleName(arrayOfText[5].getText());

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date date = null;
        try {
            date = format.parse(arrayOfText[6].getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newItem.setDate(date);

        newItem.setAddress(arrayOfText[7].getText());
        newItem.setReport(arrayOfText[8].getText());

        controller.setItemOfTable(newItem);

        SeeTable view = new SeeTable();
        view.seeTable(tableView, pageControl.getPage(), controller.getTable(),pagesLabel);
    }
}
