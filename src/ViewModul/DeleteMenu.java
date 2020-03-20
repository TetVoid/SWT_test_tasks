package ViewModul;

import Controller.Controller;
import model.PatientReport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeleteMenu {
    List<PatientReport> vectorOfAnswers=new ArrayList<>(0);
    List<PatientReport> findVector=null;

    public void setWorkSpace(List<PatientReport> base, Controller mainController)
    {
        Controller findController=new Controller();
        findVector=base;

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


        Label answer=new Label(shell,SWT.NONE);
        RowData size=new RowData();
        size.height=30;
        size.width=250;
        answer.setLayoutData(size);

        Button deleteButton =new Button(shell,SWT.NONE);
        deleteButton.setText("Delete");
        deleteButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                findVector=base;
                if (!arrayOfText[0].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByPatientName(arrayOfText[0].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[1].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByPatientSurname(arrayOfText[1].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[2].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByPatientMiddleName(arrayOfText[2].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[3].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByDoctorName(arrayOfText[3].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[4].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByDoctorSurname(arrayOfText[4].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[5].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByDoctorMiddleName(arrayOfText[5].getText(), findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[6].getText().isEmpty()) {
                    SimpleDateFormat format = new SimpleDateFormat();
                    format.applyPattern("dd.MM.yyyy");

                    Date date = null;
                    try {
                        date = format.parse(arrayOfText[6].getText());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    vectorOfAnswers = findController.findNoteByDate(date, findVector);
                    findVector = vectorOfAnswers;
                }

                if (!arrayOfText[7].getText().isEmpty()) {
                    vectorOfAnswers = findController.findNoteByAddress(arrayOfText[7].getText(), findVector);
                    findVector = vectorOfAnswers;
                }
                if(vectorOfAnswers.size()==0)
                    answer.setText("noting to delete");
                else
                    answer.setText(vectorOfAnswers.size()+" elements of base has deleted");
                    mainController.deleteElementsOfBase(vectorOfAnswers);

            }
        });

        shell.pack();
        shell.open();
    }
}
