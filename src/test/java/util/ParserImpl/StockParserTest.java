package util.ParserImpl;

import habens.parser.ParserImpl.StockParser;
import habens.util.Stock;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StockParserTest {

    @Test
    public void should_get_stock_list_when_given_stand_strings() throws Exception {
        StockParser stockParser = new StockParser();
        List<Stock> stockList = new LinkedList<Stock>();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001:40").thenReturn(null);

        stockList = stockParser.parseFromBuffer(reader);

        assertEquals(stockList.get(0).getItem().getID(), "ITEM000001");
        assertEquals(stockList.get(0).getItem().getPrice(), 40, 0.01);
        verify(reader, times(2)).readLine();
    }
}