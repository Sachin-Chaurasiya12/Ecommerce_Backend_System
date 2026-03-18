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
package com.example.EcommBackend.dto;

import java.time.LocalDateTime;

import com.example.EcommBackend.model.Category;
import com.example.EcommBackend.model.Product;

public class ProductDTO {
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Category category;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    public ProductDTO(){}

    public ProductDTO(Long id,String name,String description,
        Double price,Category category, LocalDateTime CreatedAt, LocalDateTime UpdatedAt){
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.category = category;
            this.CreatedAt = CreatedAt;
            this.UpdatedAt = UpdatedAt;
        }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
    public Category getCatogary() {
        return category;
    }
    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }
    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }
}
