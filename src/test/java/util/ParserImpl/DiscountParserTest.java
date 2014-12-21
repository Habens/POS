package util.ParserImpl;

import habens.parser.ParserImpl.DiscountParser;
import habens.util.DiscountDetail;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DiscountParserTest {
    @Test
    public void should_get_discount_detail_when_given_stand_strings() throws Exception {
        DiscountParser discountParser = new DiscountParser();
        List<DiscountDetail> discountDetailList = new LinkedList<DiscountDetail>();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001:90").thenReturn(null);

        discountDetailList = discountParser.parseFromBuffer(reader);

        assertEquals(discountDetailList.get(0).getID(), "ITEM000001");
        assertEquals(discountDetailList.get(0).getDiscount(), 90, 0.01);
        verify(reader, times(2)).readLine();
    }
}