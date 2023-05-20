package org.acme.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.acme.entities.Product;
import org.acme.repositories.ProductRepository;

import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class ProductResource {

    //http://localhost:8080/q/swagger-ui/
    //http://localhost:8080/q/swagger
    private final ProductRepository repository;

    public ProductResource(ProductRepository repository) {
        this.repository = repository;
    }

    @GET
    public List<Product> getAll() {
        List<Product> products = repository.listProduct();
        return products;
    }

    @POST
    public Response create(Product p) {
        log.info("Guardando...");
        repository.createProduct(p);
        return Response.ok("OK").build();
    }

    @DELETE
    public Response delete(Product p) {
        repository.deleteProduct(p);
        return Response.noContent().build();
    }
}
