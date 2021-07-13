package pl.investadvisor.historicalpricescraper;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.investadvisor.historicalpricescraper.service.GpwExcelReadService;

@AllArgsConstructor
@Component
class PriceCommandLineRunner implements CommandLineRunner {

    private GpwExcelReadService gpwExcelReadService;

    @Override
    public void run(String... args) throws Exception {
        gpwExcelReadService.getPolishStockHistoricalPrices("./_2021-07-12_akcje.xls")
                .forEach(System.out::println);
        System.exit(0);
    }
}
