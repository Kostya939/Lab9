package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product(1, "Test Product", 100, "This is a test product.");
        assertNotNull(product);
        assertEquals(1, product.getId());
        assertEquals("Test Product", product.getTitle());
        assertEquals(100, product.getPrice());
        assertEquals("This is a test product.", product.getDescription());
    }

    @Test
    public void testExportProductsToExcel() throws IOException {
        List<Product> products = List.of(
                new Product(1, "Test Product 1", 100, "Description 1"),
                new Product(2, "Test Product 2", 200, "Description 2")
        );

        String filePath = "test_products.xlsx";
        ProductExcelExporter.exportProductsToExcel(products, filePath);

        File file = new File(filePath);
        assertTrue(file.exists() && !file.isDirectory());

        assertNotEquals(0, Files.size(Paths.get(filePath)));

        Files.deleteIfExists(Paths.get(filePath));
    }

}
