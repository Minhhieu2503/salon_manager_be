package com.example.salonmanager.service.employee;

import com.example.salonmanager.dto.EmployeeDTO;
import com.example.salonmanager.request.TotalPriceByEmployeeAndDayRequest;
import com.example.salonmanager.response.EmployeeAppointmentByHourResponse;
import com.example.salonmanager.response.EmployeeAppointmentNeedsConfirmationResponse;
import com.example.salonmanager.response.EmployeeBookedStaffResponse;
import com.example.salonmanager.response.TotalPriceByEmployeeAndDayResponse;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    void createEmployee(EmployeeDTO employeeDTO);

    Set<EmployeeDTO> showAllEmployee();

    TotalPriceByEmployeeAndDayResponse totalPriceByEmployeeAndDay(TotalPriceByEmployeeAndDayRequest request) throws LoginException;

    EmployeeBookedStaffResponse getEmployeeBookingStats() throws LoginException;

    List<EmployeeAppointmentByHourResponse> getAppointmentsByHour() throws LoginException;

    List<EmployeeAppointmentNeedsConfirmationResponse> getAppointmentsNeedsConfirmation() throws LoginException;

    void updateEmployee(Integer id, EmployeeDTO employeeDTO);
}

