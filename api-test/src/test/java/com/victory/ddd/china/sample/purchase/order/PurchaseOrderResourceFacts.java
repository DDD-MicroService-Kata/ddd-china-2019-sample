package com.victory.ddd.china.sample.purchase.order;

import com.victory.ddd.china.sample.api.test.BaseApiFacts;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.restassured.RestAssured.given;

@SpringBootApplication(scanBasePackages = "com.victory.ddd.china.sample")
class PurchaseOrderResourceFacts extends BaseApiFacts {
    @Nested
    class getPurchaseOrderList {
        @Test
        void should_get_the_default_purchase_order() {
            given()
                    .get("/purchase-orders")
                    .then().header("Content-Type", "application/vnd.collection+json")
                    .body("$", Matchers.hasItems("purchase-order"));
        }
    }
}

