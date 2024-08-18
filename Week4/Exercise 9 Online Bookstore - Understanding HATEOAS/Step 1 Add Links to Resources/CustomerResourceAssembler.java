package com.example.bookstoreapi.assembler;

import com.example.bookstoreapi.controller.CustomerController;
import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.model.Customer;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerResourceAssembler {

    public EntityModel<CustomerDTO> toModel(CustomerDTO customerDTO) {
        EntityModel<CustomerDTO> customerResource = EntityModel.of(customerDTO);

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class)
                .getCustomerById(customerDTO.getId())).withSelfRel();
        Link allCustomersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class)
                .getAllCustomers()).withRel("all-customers");

        customerResource.add(selfLink, allCustomersLink);
        return customerResource;
    }
}
