import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class View {
    static Shell shell;
    static Controller controller = new Controller();
    static int pageControl = 0;

    public static void main(String[] args) {

        Display display = new Display();
        shell = new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Composite menuGroup = new Composite(shell, SWT.NONE);
        Composite controlButtons = new Composite(shell, SWT.NONE);

        Button openFile = new Button(menuGroup, SWT.NONE);
        Button saveFile = new Button(menuGroup, SWT.NONE);
        Button addNewNote = new Button(menuGroup, SWT.NONE);
        Button findNote = new Button(menuGroup, SWT.NONE);
        Button deleteNote = new Button(menuGroup, SWT.NONE);

        openFile.setText("open file");
        saveFile.setText("save file");
        addNewNote.setText("add new note");
        findNote.setText("find note");
        deleteNote.setText("delete note");


        Composite group0 = new Composite(shell, SWT.NONE);

        Composite group1 = new Composite(group0, SWT.NONE);
        Composite group2 = new Composite(group0, SWT.NONE);
        Composite group3 = new Composite(group0, SWT.NONE);
        Composite group4 = new Composite(group0, SWT.NONE);
        Composite group5 = new Composite(group0, SWT.NONE);
        Composite group6 = new Composite(group0, SWT.NONE);
        Composite group7 = new Composite(group0, SWT.NONE);
        Composite group8 = new Composite(group0, SWT.NONE);
        Composite group9 = new Composite(group0, SWT.NONE);

        group0.setLayout(new RowLayout(SWT.HORIZONTAL));
        group1.setLayout(new RowLayout(SWT.VERTICAL));
        group2.setLayout(new RowLayout(SWT.VERTICAL));
        group3.setLayout(new RowLayout(SWT.VERTICAL));
        group4.setLayout(new RowLayout(SWT.VERTICAL));
        group5.setLayout(new RowLayout(SWT.VERTICAL));
        group6.setLayout(new RowLayout(SWT.VERTICAL));
        group7.setLayout(new RowLayout(SWT.VERTICAL));
        group8.setLayout(new RowLayout(SWT.VERTICAL));
        group9.setLayout(new RowLayout(SWT.VERTICAL));
        menuGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        controlButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

        Label label1 = new Label(group1, SWT.NONE);
        Label label2 = new Label(group2, SWT.NONE);
        Label label3 = new Label(group3, SWT.NONE);
        Label label4 = new Label(group4, SWT.NONE);
        Label label5 = new Label(group5, SWT.NONE);
        Label label6 = new Label(group6, SWT.NONE);
        Label label7 = new Label(group7, SWT.NONE);
        Label label8 = new Label(group8, SWT.NONE);
        Label label9 = new Label(group9, SWT.NONE);

        label1.setText("Patient name");
        label2.setText("Patient surname");
        label3.setText("Patient middle name");
        label4.setText("Doctor name");
        label5.setText("Doctor surname");
        label6.setText("Doctor middle name");
        label7.setText("date");
        label8.setText("address");
        label9.setText("report");

        Text text1 = new Text(group1, SWT.NONE);
        Text text2 = new Text(group2, SWT.NONE);
        Text text3 = new Text(group3, SWT.NONE);
        Text text4 = new Text(group4, SWT.NONE);
        Text text5 = new Text(group5, SWT.NONE);
        Text text6 = new Text(group6, SWT.NONE);
        Text text7 = new Text(group7, SWT.NONE);
        Text text8 = new Text(group8, SWT.NONE);
        Text text9 = new Text(group9, SWT.NONE);


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

        for (int i = 0; i < 10; i++) {
            TableItem item = new TableItem(tableView, SWT.NONE);
        }


        Button firstButton = new Button(controlButtons,SWT.NONE);
        Button prevPage = new Button(controlButtons, SWT.NONE);
        Button nextPage = new Button(controlButtons, SWT.NONE);
        Button lastButton = new Button(controlButtons,SWT.NONE);
        Text downloadLoadField=new Text(controlButtons,SWT.NONE);
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

        firstButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                    pageControl=0;
                    SeeTable view = new SeeTable();
                    view.seeTable(tableView, pageControl, controller.getTable(),pagesLabel);


            }
        });

        lastButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                if(controller.getTable().size()%10==0)
                {
                    pageControl = controller.getTable().size() / 10-1;
                    SeeTable view = new SeeTable();
                    view.seeTable(tableView, pageControl, controller.getTable(),pagesLabel);
                }
                else
                {
                    pageControl = controller.getTable().size() / 10;
                    SeeTable view = new SeeTable();
                    view.seeTable(tableView, pageControl, controller.getTable(),pagesLabel);
                }
            }
        });

        nextPage.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                pageControl++;
                SeeTable view=new SeeTable();
                view.seeTable(tableView,pageControl,controller.getTable(),pagesLabel);
            }
        });


        prevPage.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                if (pageControl > 0)
                {
                    pageControl--;
                    SeeTable view = new SeeTable();
                    view.seeTable(tableView, pageControl, controller.getTable(),pagesLabel);
                }

            }
        });


        openFile.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                controller.load(downloadLoadField.getText());
                SeeTable view = new SeeTable();
                view.seeTable(tableView, pageControl, controller.getTable(),pagesLabel);
            }
        });

        saveFile.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                controller.save(downloadLoadField.getText());
            }
        });

        addNewNote.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                itemOfBase newItem = new itemOfBase();
                newItem.setPatientName(text1.getText());
                newItem.setPatientSurname(text2.getText());
                newItem.setPatientMiddleName(text3.getText());
                newItem.setDoctorName(text4.getText());
                newItem.setDoctorSurname(text5.getText());
                newItem.setDoctorMiddleName(text6.getText());

                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("dd.MM.yyyy");
                Date date = null;
                try {
                    date = format.parse(text7.getText());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                newItem.setDate(date);

                newItem.setAddress(text8.getText());
                newItem.setReport(text9.getText());

                controller.setItemOfTable(newItem);

                SeeTable view = new SeeTable();
                view.seeTable(tableView, pageControl, controller.getTable(),pagesLabel);
            }
        });

        findNote.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                FindMenu menu = new FindMenu();
                menu.setWorkSpace(controller.getTable(),display);
            }
        });

        deleteNote.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                DeleteMenu menu = new DeleteMenu();
                menu.setWorkSpace(controller.getTable(),controller);


            }
        });


        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
