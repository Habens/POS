package util.ParserImpl;

import habens.util.Order;
import habens.util.ParserImpl.CarParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarParserTest  {
    @Test
    public void should_get_order_list_when_given_stand_strings() throws Exception {
        CarParser carParser = new CarParser();
        List<Order> orderList = new LinkedList<Order>();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000001").thenReturn(null);

        orderList = carParser.parseFromBuffer(reader);

        assertEquals(orderList.get(0).getID(), "ITEM000001");
        assertEquals(orderList.get(0).getNumber(), 1);
        verify(reader, times(2)).readLine();
    }


    @Test
    public void should_get_order_list_when_given_stand_strings_contains_dividing_line() throws Exception {
        CarParser carParser = new CarParser();
        List<Order> orderList = new LinkedList<Order>();
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("ITEM000003-2").thenReturn(null);

        orderList = carParser.parseFromBuffer(reader);

        assertEquals(orderList.get(0).getID(), "ITEM000003");
        assertEquals(orderList.get(0).getNumber(), 2);
        verify(reader, times(2)).readLine();
    }
}