package view;

import model.PatientReport;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class SeeTable
{
    public void seeTable(Table workSpace, int pageControl, List<PatientReport> controller, Label pagesLabel)
    {
        int maxPage=0;
        String pages;
        if(controller.size()%10==0)
            maxPage=controller.size()/10;
        else
            maxPage=controller.size()/10+1;
        int temp =pageControl+1;
        pages=""+temp+"/"+maxPage;
        pagesLabel.setText(pages);

        TableItem[] arrayOfItems = workSpace.getItems();
        for (int i = 0; i < 10; i++) {
            if (controller.size() - 10 * pageControl > i) {
                arrayOfItems[i].setText(0, controller.get(i + pageControl*10).getPatientName());
                arrayOfItems[i].setText(1, controller.get(i + pageControl*10).getPatientSurname());
                arrayOfItems[i].setText(2, controller.get(i + pageControl*10).getPatientMiddleName());
                arrayOfItems[i].setText(3, controller.get(i + pageControl*10).getDoctorName());
                arrayOfItems[i].setText(4, controller.get(i + pageControl*10).getDoctorSurname());
                arrayOfItems[i].setText(5, controller.get(i + pageControl*10).getDoctorMiddleName());

                DateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
                String stringDate = formater.format(controller.get(i + pageControl*10).getDate());
                arrayOfItems[i].setText(6, stringDate);

                arrayOfItems[i].setText(7, controller.get(i + pageControl*10).getAddress());
                arrayOfItems[i].setText(8, controller.get(i + pageControl*10).getReport());
            } else {
                arrayOfItems[i].setText(0, "");
                arrayOfItems[i].setText(1, "");
                arrayOfItems[i].setText(2, "");
                arrayOfItems[i].setText(3, "");
                arrayOfItems[i].setText(4, "");
                arrayOfItems[i].setText(5, "");
                arrayOfItems[i].setText(6, "");
                arrayOfItems[i].setText(7, "");
                arrayOfItems[i].setText(8, "");
            }

        }
    }
}
