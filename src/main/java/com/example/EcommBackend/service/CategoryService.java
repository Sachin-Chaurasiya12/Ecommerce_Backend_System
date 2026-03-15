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
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.Exceptions.ResourceNotFoundException;
import com.example.EcommBackend.dto.CategoryDTO;
import com.example.EcommBackend.dto.RequestCategory;
import com.example.EcommBackend.model.Category;
import com.example.EcommBackend.repository.CategoryRepo;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepo repo;

    public List<CategoryDTO> getCategories(){
        List<Category> category = repo.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();

        for(Category c : category){

            CategoryDTO dto = new CategoryDTO();

            dto.setId(c.getId());
            dto.setName(c.getName());
            dto.setDescription(c.getDescription());

            categoryDTOs.add(dto);
        
        }
        return categoryDTOs;
    }
    public Category addCategory(RequestCategory category){
        Category cat = new Category();
        cat.setName(category.getName());
        cat.setDescription(category.getDescription());
        return repo.save(cat);
    }

    public CategoryDTO getCategorybyid(Long id){
        Category cat = repo.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return new CategoryDTO(cat.getId(),cat.getName(),cat.getDescription());
    }

    public ResponseEntity<String> deleteCategories(Long id){
        Category category = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        repo.delete(category);
        return ResponseEntity.ok("Category deleted Successfully");
    }
    public CategoryDTO updateCategories(Long id,RequestCategory request) {
        Category existing = repo.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        
        existing.setName(request.getName());
        existing.setDescription(request.getDescription());

        Category updated = repo.save(existing);

        return new CategoryDTO(id, updated.getName(), updated.getDescription());

    }
}
