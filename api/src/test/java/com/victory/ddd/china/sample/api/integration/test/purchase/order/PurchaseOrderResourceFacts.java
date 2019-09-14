package com.victory.ddd.china.sample.api.integration.test.purchase.order;

import com.victory.ddd.china.sample.application.dto.PurchaseOrderPlaceInfoDto;
import com.victory.ddd.china.sample.api.integration.test.BaseApiFacts;
import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import com.victory.ddd.china.sample.domain.order.PurchaseOrderRepo;
import com.victory.ddd.china.sample.infrastructure.dao.PurchaseOrderInMemoryDao;
import lombok.val;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootApplication(scanBasePackages = "com.victory.ddd.china.sample")
class PurchaseOrderResourceFacts extends BaseApiFacts {

    @Inject
    private PurchaseOrderRepo purchaseOrderRepo;

    @Inject
    private PurchaseOrderInMemoryDao purchaseOrderInMemoryDao;

    @BeforeEach
    void clearDb() {
        purchaseOrderInMemoryDao.clear();
    }

    @Nested
    class GetPurchaseOrderList {
        @Test
        void should_get_the_default_purchase_order() {
            val order = new PurchaseOrder("purchase-order");
            purchaseOrderRepo.save(order);

            given()
                    .get("api/purchase-orders")
                    .then()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .body("$", Matchers.hasSize(1))
                    .body("[0].code", equalTo("purchase-order"));
        }
    }

    @Nested
    class CreatePurchaseOrder {
        @Test
        void should_create_by_given_info() {
            val object = new PurchaseOrderPlaceInfoDto();
            object.setCode("1");

            val orderIdObj = given().request()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .body(object).log().all()
                    .post("api/purchase-orders")
                    .then()
                    .statusCode(HttpStatus.OK.value())
                    .extract()
                    .path("id");
            assertNotNull(orderIdObj);

            val orderId = Integer.valueOf(orderIdObj.toString());
            val order = purchaseOrderRepo.findById(orderId).get();
            assertEquals(object.getCode(), order.getCode());


        }
    }
}

