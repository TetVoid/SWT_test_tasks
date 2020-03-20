package ViewModul;

import Controller.Controller;
import Controller.PageController;
import ViewModul.Listeners.FirstButtonListener;
import ViewModul.Listeners.LastButtonListener;
import ViewModul.Listeners.NextButtonListener;
import ViewModul.Listeners.PrevButtonListener;
import model.PatientReport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class FindMenu {
 List<PatientReport> vectorOfAnswers=new ArrayList<>(0);
 List<PatientReport> findVector=null;
  PageController pageControl=new PageController();
    public void setWorkSpace(List<PatientReport> base, Display display)
    {
       Controller findController=new Controller();
       findVector=base;

       Controller controller=new Controller();
        for (int i=0;i<findVector.size();i++)
        {
            controller.setItemOfTable(findVector.get(i));
        }

       Shell shell=new Shell();
       shell.setLayout(new RowLayout(SWT.VERTICAL));

        Composite group0 = new Composite(shell, SWT.NONE);

     String[] arrayOfButtonsNames={"Patient name",
             "Patient surname",
             "Patient middle name",
             "Doctor name",
             "Doctor surname",
             "Doctor middle name",
             "date",
             "address"};

     Composite[] arrayOfComposites=new Composite[9];
     Label[] arrayOfLabels =new Label[9];
     Text[] arrayOfText =new Text[9];

     for(int i=0;i<8;i++)
     {
      arrayOfComposites[i]=new Composite(group0, SWT.NONE);
      arrayOfComposites[i].setLayout(new RowLayout(SWT.VERTICAL));
      arrayOfLabels[i]=new Label(arrayOfComposites[i],SWT.NONE);
      arrayOfLabels[i].setText(arrayOfButtonsNames[i]);
      arrayOfText[i]=new Text(arrayOfComposites[i],SWT.NONE);
     }

        group0.setLayout(new RowLayout(SWT.HORIZONTAL));

        Button startFindButton=new Button(group0,SWT.NONE);
        startFindButton.setText("find note");

        Table tableView = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        tableView.setHeaderVisible(true);

        TableColumn column1 = new TableColumn(tableView, SWT.NONE);
        column1.setText("Name of patient");
        column1.setWidth(140);

        TableColumn column2 = new TableColumn(tableView, SWT.NONE);
        column2.setText("Surname of patient");
        column2.setWidth(140);

        TableColumn column3 = new TableColumn(tableView, SWT.NONE);
        column3.setText("Middle name of patient");
        column3.setWidth(140);

        TableColumn column4 = new TableColumn(tableView, SWT.NONE);
        column4.setText("Name of doctor");
        column4.setWidth(140);

        TableColumn column5 = new TableColumn(tableView, SWT.NONE);
        column5.setText("Surname of doctor");
        column5.setWidth(140);

        TableColumn column6 = new TableColumn(tableView, SWT.NONE);
        column6.setText("Middle name of doctor");
        column6.setWidth(140);

        TableColumn column7 = new TableColumn(tableView, SWT.NONE);
        column7.setText("date of last visit");
        column7.setWidth(80);

        TableColumn column8 = new TableColumn(tableView, SWT.NONE);
        column8.setText("address");
        column8.setWidth(80);

        TableColumn column9 = new TableColumn(tableView, SWT.NONE);
        column9.setText("report");
        column9.setWidth(140);
        for(int i=0;i<10;i++)
        {
           TableItem item = new TableItem(tableView, SWT.NONE);
        }

     Composite controlButtons =new Composite(shell,SWT.NONE);
        controlButtons.setLayout(new RowLayout());

     Button firstButton = new Button(controlButtons,SWT.NONE);
     Button prevPage = new Button(controlButtons, SWT.NONE);
     Button nextPage = new Button(controlButtons, SWT.NONE);
     Button lastButton = new Button(controlButtons,SWT.NONE);
     Label pagesLabel=new Label(controlButtons,SWT.NONE);

     Image image1 = new Image(display,"button1.0.png");
     Image image2 = new Image(display,"button2.0.png");
     Image image3 = new Image(display,"button1.png");
     Image image4 = new Image(display,"button2.png");

     firstButton.setImage(image1);
     lastButton.setImage(image2);
     prevPage.setImage(image3);
     nextPage.setImage(image4);

     pagesLabel.setText("0/0");

     firstButton.addSelectionListener(new FirstButtonListener(tableView,pageControl,controller,pagesLabel));

     firstButton.addSelectionListener( new FirstButtonListener(tableView,pageControl,controller,pagesLabel));

     lastButton.addSelectionListener(new LastButtonListener(tableView,pageControl,controller,pagesLabel) );

     nextPage.addSelectionListener(new NextButtonListener(tableView,pageControl,controller,pagesLabel));

     prevPage.addSelectionListener(new PrevButtonListener(tableView,pageControl,controller,pagesLabel));

     startFindButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event1)
      {
       findVector=base;
       if(!arrayOfText[0].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByPatientName(arrayOfText[0].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[1].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByPatientSurname(arrayOfText[1].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[2].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByPatientMiddleName(arrayOfText[2].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[3].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByDoctorName(arrayOfText[3].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[4].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByDoctorSurname(arrayOfText[4].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[5].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByDoctorMiddleName(arrayOfText[5].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[6].getText().isEmpty())
       {
        SimpleDateFormat format =new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");

        Date date= null;
        try {
         date = format.parse(arrayOfText[6].getText());
        } catch (ParseException e) {
         e.printStackTrace();
        }

           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByDate(date, findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

       if(!arrayOfText[7].getText().isEmpty())
       {
           controller.deleteElementsOfBase(findVector);

        vectorOfAnswers = findController.findNoteByAddress(arrayOfText[7].getText(), findVector);
        findVector=vectorOfAnswers;

           for (int i=0;i<findVector.size();i++)
           {
               controller.setItemOfTable(findVector.get(i));
           }
       }

        SeeTable seeTable=new SeeTable();
       seeTable.seeTable(tableView,pageControl.getPage(),vectorOfAnswers,pagesLabel);
      }
     });

        shell.pack();
        shell.open();
    }
}
