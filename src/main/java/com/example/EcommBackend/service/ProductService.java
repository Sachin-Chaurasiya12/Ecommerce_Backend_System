/*
 Ecommerce Backend System Copyright (C) 2026 Sachin Chaurasiya
    This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
    This is free software, and you are welcome to redistribute it
    under certain conditions; type `show c' for details.

The hypothetical commands `show w' and `show c' should show the appropriate
parts of the General Public License.  Of course, your program's commands
might be different; for a GUI interface, you would use an "about box".

  You should also get your employer (if you work as a programmer) or school,
if any, to sign a "copyright disclaimer" for the program, if necessary.
For more information on this, and how to apply and follow the GNU GPL, see
<https://www.gnu.org/licenses/>.

  The GNU General Public License does not permit incorporating your program
into proprietary programs.  If your program is a subroutine library, you
may consider it more useful to permit linking proprietary applications with
the library.  If this is what you want to do, use the GNU Lesser General
Public License instead of this License.  But first, please read
<https://www.gnu.org/licenses/why-not-lgpl.html>.
*/
package com.example.EcommBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.Exceptions.ResourceNotFoundException;
import com.example.EcommBackend.dto.ProductDTO;
import com.example.EcommBackend.dto.ProductRequest;
import com.example.EcommBackend.model.Category;
import com.example.EcommBackend.model.Product;
import com.example.EcommBackend.repository.CategoryRepo;
import com.example.EcommBackend.repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepo repo;

    @Autowired
    private CategoryRepo repo2;

    public Page<ProductDTO> getProducts(int page,int size,Long CategoryId) {

    Pageable pageable = PageRequest.of(page, size,Sort.by("price").ascending());
    Page<Product> products;

    if(CategoryId != null){
        products = repo.findByCategoryId(CategoryId, pageable);
    }else{
        products = repo.findAll(pageable);
    }
    
    // 1. Check if the list is empty and throw your custom exception
    if (products.isEmpty()) {
        throw new ResourceNotFoundException("No products found");
    }
    return products.map(product -> new ProductDTO(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getCategory(),
        product.getCreatedAt(),
        product.getUpdatedAt()
    ));
}

   public Product addProduct(ProductRequest request) {
    Product product = new Product();
    product.setName(request.getName());
    product.setPrice(request.getPrice());
    product.setDescription(request.getDescription());

    Category foundCategory = repo2.findById(request.getCategoryId())
        .orElseThrow(() -> new RuntimeException("Category not found with ID: " + request.getCategoryId()));

    product.setCategory(foundCategory); 

    return repo.save(product);
}

    public ProductDTO getProductbyid(Long id) {
         Product cat = repo.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("Product Not found"));

         return new ProductDTO(cat.getId(),cat.getName(),cat.getDescription(),cat.getPrice(),
         cat.getCategory(),cat.getCreatedAt(),cat.getUpdatedAt());
    }

    public ResponseEntity<String> deleteproduct(Long id) {
        Product product = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        repo.delete(product);

        return ResponseEntity.ok("Product Deleted successfully");

    }

    public ProductDTO updateProduct(Long id, ProductRequest request) {
        Product existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Category category = repo2.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setCategory(category);

        Product updated = repo.save(existing);
        return new ProductDTO(
            updated.getId(),
            updated.getName(),
            updated.getDescription(),
            updated.getPrice(),
            updated.getCategory(),
            updated.getCreatedAt(),
            updated.getUpdatedAt()
        );
    }
}
