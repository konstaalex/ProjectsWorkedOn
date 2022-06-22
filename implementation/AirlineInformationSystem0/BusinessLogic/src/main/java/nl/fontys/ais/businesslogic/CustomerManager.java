package nl.fontys.ais.businesslogic;


import java.util.ArrayList;
import java.util.List;

/*
 * Copyright 2022 alex.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 * @author alex
 */
public class CustomerManager {

    Customer customer;
    List<Customer> customers = new ArrayList<>();

    public CustomerManager() {
        this.customer = new Customer();

    }

    public void addCustomers(Customer c) {
        customers.add(c);
    }
    
    public List<Customer> getCustomers(){
        System.out.println("The list of customers registered is:\n"+ customers.toString());
       
            return customers;
        
        
    }

}
