package pl.investadvisor.historicalpricescraper.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@DynamoDBTable(tableName = "PolishHistoricalPrice")
@NoArgsConstructor
public class PolishStockHistoricalPrice {

    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey(attributeName = "polishHistoricalPriceId")
    private String polishHistoricalPriceId;

    @NonNull
    private Date date;

    @NonNull
    private String name;

    private double openPrice;
    private double maxPrice;
    private double minPrice;
    private double closePrice;

    @NonNull
    private Integer volume;

}
