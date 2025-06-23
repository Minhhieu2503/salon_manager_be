package com.example.salonmanager.service.order;

import com.example.salonmanager.dto.OrderDTO;
import com.example.salonmanager.exeption.LoginException;
import com.example.salonmanager.exeption.OrderException;
import com.example.salonmanager.request.ActionOrderByCustomerRequest;
import com.example.salonmanager.request.AllOrderEmployeeAndDateRequest;
import com.example.salonmanager.request.OrderScheduleHaircutRequest;

import java.util.Date;
import java.util.Set;

public interface OrderService {
    String bookingScheduleHaircut(OrderScheduleHaircutRequest request) throws LoginException, OrderException;

    Set<OrderDTO> showOrderByCustomerStatus_0() throws LoginException;

    Set<OrderDTO> showOrderByCustomerStatus_1() throws LoginException;

    Set<OrderDTO> showOrderByCustomerStatus_2() throws LoginException;

    void updateBookingStatus(Integer bookingId, Integer status);

    void cancelBooking(Integer bookingId, Integer status);

    Set<OrderDTO> findAllOrderByEmployeeAndDate(AllOrderEmployeeAndDateRequest request) throws LoginException;

    String ConfirmDoneOrCancelOrderedByCustomer(ActionOrderByCustomerRequest request) throws LoginException;
}
