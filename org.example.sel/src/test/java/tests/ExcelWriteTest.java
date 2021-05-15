package tests;

import org.testng.annotations.Test;
import selenium_base.TestBase;

import java.io.IOException;
import utils.WriteToExcel;

public class ExcelWriteTest extends TestBase {

    @Test
    public void test1() throws IOException {

        WriteToExcel wte = new WriteToExcel();

        wte.writeExcel2("data.xls", "Sheet1",
                new String[]{"Iteration-1", "LN:12345", "file1", "file2", "file3", "file4"});

        wte.writeExcel2("data.xls", "Sheet1",
                new String[]{"Iteration-2", "LN:12345","file1", "file2", "file3", "file4",
                        "file1", "file2", "file3"});

        wte.writeExcel2("data.xls", "Sheet1",
                new String[]{"Iteration-3", "LN:12345", "file1", "file2", "file3", "file4",
                        "file1", "file2", "file3", "file1", "file2"});
    }

}
