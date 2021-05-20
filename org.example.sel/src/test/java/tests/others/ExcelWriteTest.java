/**
 * @shyamhushangabadkar
 */
package tests.others;

import org.testng.annotations.Test;
import selenium_base.TestBase;
import utils.WriteToExcel;
import java.io.IOException;

public class ExcelWriteTest extends TestBase {

    @Test
    public void test1() throws IOException {

        WriteToExcel wte = new WriteToExcel();

        t1(wte);

        wte.resetIterationRow();

        t2(wte);

    }

    public static void t1(WriteToExcel wte) throws IOException {

        // Core portal docs
        String[] data = new String[]{"Iteration-1", "LN:12345", "CorePrtDocs", "file1", "file2", "file3", "file4"};
        wte.writeExcel2("data2.xls", "Sheet1", data);
        data = new String[]{"Iteration-1", "LN:12345", "AIQPrtDocs", "file1", "file2", "file3", "file4"};
        wte.writeExcel2("data2.xls", "Sheet1", data);
        data = new String[]{"Iteration-1", "LN:12345", "LPPrtDocs", "file1", "file2", "file3", "file4"};
        wte.writeExcel2("data2.xls", "Sheet1", data);


        String[] data2 = new String[]{"Iteration-2", "LN:12345", "CorePrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3"};
        wte.writeExcel2("data2.xls", "Sheet1", data2);
        data2 = new String[]{"Iteration-2", "LN:12345", "AIQPrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3"};
        wte.writeExcel2("data2.xls", "Sheet1", data2);
        data2 = new String[]{"Iteration-2", "LN:12345", "LPPrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3"};
        wte.writeExcel2("data2.xls", "Sheet1", data2);



        String[] data3 = new String[]{"Iteration-3", "LN:12345", "CorePrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3", "file1", "file2"};
        wte.writeExcel2("data2.xls", "Sheet1", data3);
        data3 = new String[]{"Iteration-3", "LN:12345", "AIQPrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3", "file1", "file2"};
        wte.writeExcel2("data2.xls", "Sheet1", data3);
        data3 = new String[]{"Iteration-3", "LN:12345", "LPPrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3", "file1", "file2"};
        wte.writeExcel2("data2.xls", "Sheet1", data3);
    }

    public static void t2(WriteToExcel wte) throws IOException {

        // Core portal docs
        String[] data = new String[]{"Iteration-1", "LN:12345", "CorePrtDocs", "file1", "file2", "file3", "file4"};
        wte.writeExcel2("data2.xls", "Sheet1", data);
        data = new String[]{"Iteration-1", "LN:12345", "AIQPrtDocs", "file1", "file2", "file3", "file4"};
        wte.writeExcel2("data2.xls", "Sheet1", data);
        data = new String[]{"Iteration-1", "LN:12345", "LPPrtDocs", "file1", "file2", "file3", "file4"};
        wte.writeExcel2("data2.xls", "Sheet1", data);


        String[] data2 = new String[]{"Iteration-2", "LN:12345", "CorePrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3"};
        wte.writeExcel2("data2.xls", "Sheet1", data2);
        data2 = new String[]{"Iteration-2", "LN:12345", "AIQPrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3"};
        wte.writeExcel2("data2.xls", "Sheet1", data2);
        data2 = new String[]{"Iteration-2", "LN:12345", "LPPrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3"};
        wte.writeExcel2("data2.xls", "Sheet1", data2);



        String[] data3 = new String[]{"Iteration-3", "LN:12345", "CorePrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3", "file1", "file2"};
        wte.writeExcel2("data2.xls", "Sheet1", data3);
        data3 = new String[]{"Iteration-3", "LN:12345", "AIQPrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3", "file1", "file2"};
        wte.writeExcel2("data2.xls", "Sheet1", data3);
        data3 = new String[]{"Iteration-3", "LN:12345", "LPPrtDocs", "file1", "file2", "file3", "file4",
                "file1", "file2", "file3", "file1", "file2"};
        wte.writeExcel2("data2.xls", "Sheet1", data3);
    }

}
