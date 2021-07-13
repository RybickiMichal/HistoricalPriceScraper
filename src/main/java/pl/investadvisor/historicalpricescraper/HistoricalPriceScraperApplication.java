package pl.investadvisor.historicalpricescraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HistoricalPriceScraperApplication {

    public static void main(String[] args) {
        SpringApplication.run(HistoricalPriceScraperApplication.class, args);
    }

}
