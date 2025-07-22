package com.example.salonmanager.service.workdone;

import com.example.salonmanager.entity.Employee;
import com.example.salonmanager.entity.Orders;
import com.example.salonmanager.entity.WorkDone;
import com.example.salonmanager.exception.LoginException;
import com.example.salonmanager.repository.OrderRepo;
import com.example.salonmanager.repository.WorkDoneRepo;
import com.example.salonmanager.request.AddWorkDoneInOrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class WorkDoneServiceImpl implements WorkDoneService{
    private final WorkDoneRepo workDoneRepo;
    private final OrderRepo orderRepo;

    @Override
    public String addWorkDoneInOrder(AddWorkDoneInOrderRequest request) throws LoginException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            try {
                Employee employee = (Employee) authentication.getPrincipal();
                Orders orders = orderRepo.findOrderByOrderId(request.getOrderId()).orElseThrow();

                StringBuilder services = new StringBuilder();

                for (String s : request.getService()) {
                    services.append(s).append(", ");
                }

                WorkDone workDone = WorkDone.builder()
                        .services(services.toString())
                        .employee(employee)
                        .orders(orders)
                        .totalPrice(request.getTotalPrice())
                        .build();

                workDoneRepo.save(workDone);

                return "Thêm công việc đã làm thành công";
            } catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new LoginException("Bạn Chưa Đăng Nhập");
        }
    }
}
