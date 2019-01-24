package TestDataGenerator;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.techtest.model.Price;
import com.zensar.techtest.model.Product;
import com.zensar.techtest.model.ProductList;

import java.io.IOException;

import static org.junit.Assert.fail;

public class TestDataGenerator {

    public static Price createPriceRecordWithStringInPriceNow(){
        ObjectMapper objectMapper = new ObjectMapper();
        String content = "{\"was\":\"\",\"then1\":\"\",\"then2\":\"\",\"now\":\"59.00\",\"uom\":\"\",\"currency\":\"GBP\"}";
        JavaType valueType = objectMapper.constructType(Price.class);
        Price readValue;
        try {
            readValue = objectMapper.readValue(content, valueType);
            return readValue;
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        throw new UnsupportedOperationException("code shouldn't have reached here");
    }

    public static Price createPriceRecordWithObjectInPriceNow(){
        ObjectMapper objectMapper = new ObjectMapper();
        String content = "{\"was\":\"\",\"then1\":\"\",\"then2\":\"\",\"now\":{\"from\":\"55.00\",\"to\":\"100.00\"},\"uom\":\"\",\"currency\":\"GBP\"}";
        JavaType valueType = objectMapper.constructType(Price.class);
        Price readValue;
        try {
            readValue = objectMapper.readValue(content, valueType);
            return readValue;
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        throw new UnsupportedOperationException("code shouldn't have reached here");
    }


    public static Product createProductRecordWithStringInPriceNow(String content){
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType valueType = objectMapper.constructType(Product.class);
        Product readValue;
        try {
            readValue = objectMapper.readValue(content, valueType);
            return readValue;
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        throw new UnsupportedOperationException("code shouldn't have reached here");
    }

    public static Product createProductRecordWithStringInPriceNow(){
        ObjectMapper objectMapper = new ObjectMapper();
        String content2 = "{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"\",\"then1\": \"\",\"then2\": \"\",\"now\": \"55.00\",\"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}";
        JavaType valueType = objectMapper.constructType(Product.class);
        Product readValue;
        try {
            readValue = objectMapper.readValue(content2, valueType);
            return readValue;
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        throw new UnsupportedOperationException("code shouldn't have reached here");
    }

    public static ProductList createProductListRecordWithStringInPriceNow(){
        ObjectMapper objectMapper = new ObjectMapper();
        String content4 = "{\"products\": [{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"\",\"then1\": \"\",\"then2\": \"\", \"now\": \"59.00\", \"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}]}";
        JavaType valueType = objectMapper.constructType(ProductList.class);
        ProductList readValue;
        try {
            return objectMapper.readValue(content4, valueType);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        throw new UnsupportedOperationException("code shouldn't have reached here");
    }

    public static ProductList createProductListRecordWithObjectInPriceNow(){
        ObjectMapper objectMapper = new ObjectMapper();
        String content4 = "{\"products\": [{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"\",\"then1\": \"\",\"then2\": \"\", \"now\": [{\"from\": \"55.00\", \"to\": \"100.00\"}], \"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}]}";
        JavaType valueType = objectMapper.constructType(ProductList.class);
        ProductList readValue;
        try {
            return objectMapper.readValue(content4, valueType);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        throw new UnsupportedOperationException("code shouldn't have reached here");
    }

}
