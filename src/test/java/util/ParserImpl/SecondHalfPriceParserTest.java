package util.ParserImpl;

import habens.util.ParserImpl.SecondHalfPriceParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SecondHalfPriceParserTest {

    @Test
    public void should_get_second_half_price_item_id_list_when_given_stand_strings() throws Exception {
        SecondHalfPriceParser secondHalfPriceParser = new SecondHalfPriceParser();
        List<String> secondHalfPriceItemIDList = new LinkedList<String>();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001").thenReturn(null);

        secondHalfPriceItemIDList = secondHalfPriceParser.parseFromBuffer(reader);

        assertEquals(secondHalfPriceItemIDList.get(0), "ITEM000001");
        verify(reader, times(2)).readLine();
    }
}