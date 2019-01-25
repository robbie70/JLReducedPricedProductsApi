package utils;

import com.zensar.tech.utils.CommonUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonUtilsTest {

    @Test
    public void shouldReturnCorrectRGBColorForGray(){
        assertEquals("808080", CommonUtils.lookupRGBCOlor("gray"));
    }

    @Test
    public void shouldReturnRGBColorNaForNoMatchFound(){
        assertEquals("na", CommonUtils.lookupRGBCOlor("xyz"));
    }

    @Test
    public void shouldReturnRGBColorNaForNull(){
        assertEquals("na", CommonUtils.lookupRGBCOlor(null));
    }

    @Test
    public void shouldReturnRGBColorForBlack(){
        assertEquals("000000", CommonUtils.lookupRGBCOlor("black"));
    }

    @Test
    public void shouldReturnRGBColorForNavy(){
        assertEquals("000080", CommonUtils.lookupRGBCOlor("navy"));
    }

    @Test
    public void shouldReturnCurrencySymbolForPound(){
        assertEquals("£", CommonUtils.lookupCurrencySymbol("GBP"));
    }

    @Test
    public void shouldReturnCurrencySymbolForPoundWhenNoMatchFound(){
        assertEquals("£", CommonUtils.lookupCurrencySymbol("XYZ"));
    }

    @Test
    public void shouldReturnCorrectFormatWhenPriceIntegerAndLessThanTenPounds(){
        assertEquals("2.00", CommonUtils.formatPrice(2D));
    }

    @Test
    public void shouldReturnCorrectFormatWhenPriceIntegerAndGreaterThanOrEqualToTenPounds(){
        assertEquals("10", CommonUtils.formatPrice(10D));
    }

    @Test
    public void shouldReturnCorrectFormatWhenPriceFloatAndLessThanTenPounds(){
        assertEquals("1.75", CommonUtils.formatPrice(1.75D));
    }

    @Test
    public void shouldReturnCorrectFormatWhenPriceFloatGreaterThanTenPounds(){
        assertEquals("10.75", CommonUtils.formatPrice(10.75D));
    }

    @Test
    public void shouldReturnCorrectFormatWhenPriceNull(){
        assertEquals("0.00", CommonUtils.formatPrice(null));
    }


}
