package com.example.kumar1;

import com.banking.repository.CustomerInfoRepository;
import com.banking.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.banking.model.CustomerInfo;
import com.banking.entity.CustomerInfoEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerserviceTest {

    @Mock
    private CustomerInfoRepository customerInfoRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetAllCustomers() {
        List<CustomerInfoEntity> customerInfoList = new ArrayList<>();
        CustomerInfoEntity customerInfo1 = new CustomerInfoEntity();
        customerInfo1.setId(1L);
        customerInfo1.setAccountId("81275");
        customerInfo1.setCustomerName("John Doe");
        customerInfo1.setActiveInd(true);
        customerInfoList.add(customerInfo1);
        when(customerInfoRepository.findAll()).thenReturn(customerInfoList);
        List<CustomerInfo> result = customerService.getAllCustomerInfo();

        assertNotNull(result);
        assertEquals(1,result.size());
        assertEquals(1L, result.get(0).getId());
    }
}


