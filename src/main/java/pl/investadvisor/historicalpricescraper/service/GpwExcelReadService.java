package pl.investadvisor.historicalpricescraper.service;

import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import pl.investadvisor.historicalpricescraper.model.PolishStockHistoricalPrice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static java.time.ZoneId.systemDefault;

@AllArgsConstructor
@Service
public class GpwExcelReadService {

    public List<PolishStockHistoricalPrice> getPolishStockHistoricalPrices(String filePath) throws IOException {
        FileInputStream excelFile = new FileInputStream(filePath);
        Workbook workbook = new HSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        return readPricesFromExcel(iterator);
    }

    private List<PolishStockHistoricalPrice> readPricesFromExcel(Iterator<Row> iterator) {
        List<PolishStockHistoricalPrice> prices = new ArrayList();
        iterator.next();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            LocalDate date = LocalDate.parse(currentRow.getCell(0).getStringCellValue());

            PolishStockHistoricalPrice price = PolishStockHistoricalPrice.builder()
                    .date(Date.from(date.atStartOfDay(systemDefault()).toInstant()))
                    .name(currentRow.getCell(1).getStringCellValue())
                    .openPrice(currentRow.getCell(4).getNumericCellValue())
                    .maxPrice(currentRow.getCell(5).getNumericCellValue())
                    .minPrice(currentRow.getCell(6).getNumericCellValue())
                    .closePrice(currentRow.getCell(7).getNumericCellValue())
                    .volume((int) currentRow.getCell(9).getNumericCellValue())
                    .build();
            prices.add(price);
        }
        return prices;
    }

}
