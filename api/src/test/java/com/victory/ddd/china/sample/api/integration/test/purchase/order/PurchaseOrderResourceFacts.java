package com.victory.ddd.china.sample.api.integration.test.purchase.order;

import com.victory.ddd.china.sample.api.integration.test.BaseApiFacts;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootApplication(scanBasePackages = "com.victory.ddd.china.sample")
class PurchaseOrderResourceFacts extends BaseApiFacts {
    @Nested
    class GetPurchaseOrderList {
        @Test
        void should_get_the_default_purchase_order() {
            given()
                    .get("api/purchase-orders")
                    .then()
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .body("$", Matchers.hasSize(1))
                    .body("[0].code", equalTo("purchase-order"));
        }
    }
}

