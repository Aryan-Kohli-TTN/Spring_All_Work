package com.demo.service;

import com.sun.org.apache.xpath.internal.objects.XStringForChars;
import org.junit.After;
import org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.demo.domain.Order;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @InjectMocks
    OrderService orderService;
    @Mock
    EmailService emailService;

    @Test
    public void test_placeOrder_Without_cc() {
        // Given
        Order order = new Order(12, "Mobile Phone", 10000);
        doThrow(RuntimeException.class).when(emailService).sendEmail(order);

        // When
        try {
            orderService.placeOrder(order);
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException ex) {
            assertFalse(order.isCustomerNotified());
            verify(emailService).sendEmail(order);
        }
    }

    @Test
    public void test_placeOrder_With_cc() {
        // Given
        Order order = new Order(12, "Mobile Phone", 10000);
        when(emailService.sendEmail(order, "CC MSG")).thenReturn(true);

        // When
        boolean result = orderService.placeOrder(order, "CC MSG");

        // Then
        assertEquals(12000, order.getPriceWithTax(), 0.001);
        assertTrue(order.isCustomerNotified());
        assertTrue(result);
        verify(emailService).sendEmail(order, "CC MSG");
    }
}